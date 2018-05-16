package com.training.quizzer.service;

import com.training.quizzer.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    @Autowired
    private static UserService userService;
    @Mock
    private User testUser;

    private static final long testUserId = 1;

    @Before
    public void setupTestLocation(){
        testUser = new User();
        testUser.setId(testUserId);
    }

    @Test
    public void testSwitchStatus() {
        userService.switchStatus(testUser);
        Mockito.verify(userService).switchStatus(Mockito.anyObject());
    }
}
