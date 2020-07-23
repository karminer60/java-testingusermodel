package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        List<User> myList = userService.findAll();
        for(User u: myList)
        {
            System.out.println(u.getUserid() + " " + u.getUsername());
        }
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void findUserById()
    {
        assertEquals("admin", userService.findUserById(4).getUsername());
    }

    @Test
    public void findByNameContaining()
    {
        assertEquals(1, userService.findByNameContaining("barn").size());
    }

    @Test
    public void findAll()
    {
        assertEquals(5,userService.findAll().size());
    }

    @Test
    public void delete()
    {
        userService.delete(2);
        assertEquals(4, userService.findAll().size());
    }

    @Test
    public void findByName()
    {
        User user = userService.findByName("test barnbarn");
        assertEquals("test barnbarn", user.getUsername());
    }

    @Test
    public void save()
    {
        User u4 = new User("Test puttat",
                "password",
                "puttat@school.lambda");


        User addUser = userService.save(u4);
        assertNotNull(addUser);
        assertEquals("Test puttat", addUser.getUsername());
    }

    @Test
    public void update()
    {
        User u4 = new User("Test puttat",
                "password",
                "puttat@school.lambda");


        User addUser = userService.update(u4,2);
        assertNotNull(addUser);
        assertEquals("Test puttat", addUser.getUsername());
    }



    @Test
    public void deleteAll()
    {

    }
}