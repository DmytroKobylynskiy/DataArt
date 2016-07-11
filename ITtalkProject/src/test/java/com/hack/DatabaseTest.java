package com.hack;

import com.hack.entities.User;
import com.hack.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wollf on 05.07.2016.
 */


@SpringApplicationConfiguration(classes = {ITtalkProjectApplication.class})
@PropertySource("classpath:application.properties")
@WebAppConfiguration
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseTest {

    @Autowired
    private UserRepository userRepo;

    @Before
    public void setUp() throws Exception {
        User newUser = new User();
        newUser.setName("Петрович");
        newUser.setPassword("з0лотыеКупола123");
        userRepo.save(newUser);

        User anotherNewUser = new User();
        anotherNewUser.setName("КиСуЛя");
        anotherNewUser.setPassword("1234");
        userRepo.save(anotherNewUser);
    }

    @Test
    public void пожалуйстаОченьНужноЧитатьВащеВсё(){
        userRepo.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void пожалуйстаОченьНужноЧитатьГрохнутьКисулю(){
        List<User> allUsers = userRepo.findAll();
        allUsers.stream().forEach(System.out::println);
        userRepo.delete(allUsers.stream().filter(el -> el.getId() == 2L).collect(Collectors.toList()).get(0));
        userRepo.findAll().stream().forEach(System.out::println);
    }

}

//User{id=1, name='Петрович', password='з0лотыеКупола123'}
//User{id=2, name='КиСуЛя', password='1234'}