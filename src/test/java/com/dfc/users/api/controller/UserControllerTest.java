package com.dfc.users.api.controller;

import com.dfc.users.api.model.User;
import com.dfc.users.api.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    private static final String ENDPOINT = "/TestDevWebService/services/";

    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        given(userRepository.findUserByUsername("test")).willReturn(getUser());
        given(userRepository.findUserByUsername("notFound")).willReturn(null);
    }

    @Test
    public void getByUsername() throws Exception {
        mvc.perform(get(ENDPOINT + "/user/test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getByUsernameNotFound() throws Exception {
        mvc.perform(get(ENDPOINT + "/user/notFound")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private User getUser() {
        final User user = new User();

        user.setIdUser(1L);
        user.setUsername("test");
        return user;
    }
}