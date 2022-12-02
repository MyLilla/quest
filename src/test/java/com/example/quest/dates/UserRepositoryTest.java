package com.example.quest.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Spy
    Map<String, User> users;
    @Mock
    Level level;
    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        users = new HashMap<>();
        user = new User();
        user.setLevel(level);
        user.setCountGames(1);
        userRepository = new UserRepository();
    }

    @Test
    @Disabled
    void getActualUser() {
        users.put("name", user);
        assertEquals(user, userRepository.getActualUser("name"));
    }

    @Test
    void resetUserProgress() {
        User user1 = new User();

        userRepository.resetUserProgress(user);

        assertEquals(user1.getLevel(), user.getLevel());
        assertEquals(2, user.getCountGames());
    }
}
