package com.training.quizzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.training.quizzer.model.User;
import com.training.quizzer.repository.UserRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
	
	private static final Logger logger = Logger.getLogger(UserService.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Long id){
		logger.info("Entered method getUserById(id= [" + id + "])");
		return userRepository.findOne(id);
	}
	
	public List<User> findAllUsers(){
		logger.info("Entered method findAllUsers()");
		return userRepository.findAll();
	}
	
	public User findByName(String userName){
		logger.info("Entered method findByName(name= [" + userName + "])");
		Assert.hasText(userName, "The name must must not be empty and must contain at least one non-whitespace character!");
		return userRepository.findByName(userName);
	}
	
	public User findByNameAndPassword(String name, String password){
		logger.info("Entered method findByNameAndPassword(name= [" + name + "], password= [" + password + "])");
		Assert.hasText(name, "The name must must not be empty and must contain at least one non-whitespace character!");
		Assert.hasText(password, "The password must must not be empty and must contain at least one non-whitespace character!");
		return userRepository.findByNameAndPassword(name, password);
	}

	public User saveUser(User user) {
		logger.info("Entered method save(User user)");
		Assert.notNull(user, "The user must not be null");
		logger.info("Saving user: [" + user.toString() + "])");
		
		User savedUser = userRepository.save(user);
		logger.info("Saved user is " + savedUser.toString());
		return savedUser;
	}
	
	/**Activates or inactivates status based on the current status.
	 * @param user
	 * @return
	 */
	public User switchStatus(User user) {
		logger.info("Entered method changeStatus(User userLogged)");
		Assert.notNull(user, "The user must not be null");
		
		User.Status newStatus = User.Status.ACTIVE == user.getStatus() ? User.Status.INACTIVE : User.Status.ACTIVE;
		user.setStatus(newStatus);
		
		logger.info("Saving user after change of status: [" + user.toString() + "])");
		User userWithStatusChanged = saveUser(user);
		
		return userWithStatusChanged;
	}
	
}
