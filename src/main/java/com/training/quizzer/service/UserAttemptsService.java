package com.training.quizzer.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.training.quizzer.model.User;
import com.training.quizzer.model.UserAttempts;
import com.training.quizzer.repository.UserAttemptsRepository;

@Service
public class UserAttemptsService {
private static final Logger logger = LoggerFactory.getLogger(UserAttemptsService.class);
	
	@Autowired
	private UserAttemptsRepository userAttemptsRepository;
	@Autowired
	UserService userService;
	@Value("${maxAttempts}")
	private String maxAttempts;
	@Value("${intervalForUnlockAccount}")
	private String intervalForUnlockAccount;
	@Value("${intervalToCountFailedAttempts}")
	private String intervalToCountFailedAttempts; 
	
		
	public UserAttempts findOne(Long id) {
		logger.info("Entered method findOne(id: [" + id + "])");
		return userAttemptsRepository.findOne(id);
	}

	public List<UserAttempts> findAll() {
		logger.info("Entered method findAll()");
		return userAttemptsRepository.findAll();
	}
	
	public UserAttempts findByUserId(Long userId) {
		logger.info("Entered method findByUserId(userId: [" + userId + "])");
		return userAttemptsRepository.findByUserId(userId);
	}
	
	public UserAttempts saveUserAttempts(UserAttempts userAttempts) {
		logger.info("Entered method saveUserAttempts(UserAttempts userAttempts)");
		Assert.notNull(userAttempts, "The UserAttempts object must not be null");
		logger.info("Saving user attempts: [" + userAttempts.toString() + "])");
		
		return userAttemptsRepository.save(userAttempts);
	}
	
	public void deleteUserAttempts(UserAttempts userAttempts) {
		logger.info("Entered method deleteUserAttempts(UserAttempts userAttempts)");
		Assert.notNull(userAttempts, "The UserAttempts object must not be null");
		logger.info("Deleting product: [" + userAttempts.toString() + "])");
		
		userAttemptsRepository.delete(userAttempts);
	}
	
	public User resetUserAttemptsAndStatus(User userLogged) {
		UserAttempts userAttempts = findByUserId(userLogged.getId());
		User userWithStatusReset = null;
		if(userAttempts != null && 
				attemptIsOutsideAccInterval(userAttempts.getLastmodified(), LocalDateTime.now(), intervalForUnlockAccount)) {
			deleteUserAttempts(userAttempts);
			userWithStatusReset = userService.switchStatus(userLogged);
		}
		
		return userWithStatusReset;
	}
	
	public void updateFailAttempts(User userFailedAttempter) {
		UserAttempts userAttempts = findByUserId(userFailedAttempter.getId());		
		LocalDateTime localDateTimeNow = LocalDateTime.now(); // The current date and time
		
		if (userAttempts == null || 
				attemptIsOutsideAccInterval(userAttempts.getFirstattempt(), localDateTimeNow, intervalToCountFailedAttempts)
				){
			//attempts are outside the previous attempts series so another one is initialized
			initSerieOfFailedAttempts(userFailedAttempter, localDateTimeNow);
		} else { 
			//attempts are still within interval so either 
			// - the user will be locked due to nr of attemps surpassed
			// - or the nr of attempts will be incremented
			int futureNrOfAttempts = userAttempts.getAttempts() + 1;
			if (futureNrOfAttempts >= Integer.valueOf(maxAttempts)) {				
				userFailedAttempter = userService.switchStatus(userFailedAttempter);					
			} else {
				userAttempts.setAttempts(futureNrOfAttempts);
				userAttempts.setLastmodified(localDateTimeNow);			
				saveUserAttempts(userAttempts);
			}			
		}
	}

	private void initSerieOfFailedAttempts(User userFailedAttempter, LocalDateTime localDateTime) {
		// insert new user into table "user_attempts"
		UserAttempts newUserAttempts = new UserAttempts();
		newUserAttempts.setUserId(userFailedAttempter.getId());
		newUserAttempts.setAttempts(1);
		newUserAttempts.setFirstattempt(localDateTime);
		newUserAttempts.setLastmodified(localDateTime);

		saveUserAttempts(newUserAttempts);
	}	
	
	public boolean attemptIsOutsideAccInterval(LocalDateTime firstattempt, LocalDateTime localDateTimeNow, String maxAcceptedInterval) {
		logger.info("attemptIsOutsideAccInterval("
				+ "firstattempt = [" + firstattempt + "], "
				+ "localDateTimeNow = [" + localDateTimeNow + "], "
				+ "maxAcceptedInterval = [" + maxAcceptedInterval + "]");
		
		boolean isOutsideInterval = false;		
		Long maxAcceptedInteralL = Long.valueOf(maxAcceptedInterval);
		
		// count seconds between dates
		Duration elapsedTime = Duration.between(firstattempt, localDateTimeNow);		
		Long elapsedTimeSeconds = elapsedTime.getSeconds();
		logger.info("elapsedTime.getSeconds() = " + elapsedTimeSeconds + " seconds");	
		
		if(elapsedTimeSeconds > maxAcceptedInteralL)
			isOutsideInterval = true;	
		
		logger.info("attemptIsOutsideAccInterval ? " + isOutsideInterval);
		return isOutsideInterval;
	}
	
}
