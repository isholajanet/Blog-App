package com.BlogApp.Blog.data.repository;

import com.BlogApp.Blog.data.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void userCanBeCreated(){
        User user = User.builder().username("janet").password("janet12").build();
        log.info("Before saving -> {}", user);
        assertThat(user.getId()).isNull();
        userRepository.save(user);
        log.info("After saving -> {}", user);
        assertThat(user.getId()).isNotNull();
    }

}