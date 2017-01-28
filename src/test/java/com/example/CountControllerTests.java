package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void countShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Count: 1"));
    }

    @Test
    public void countShouldIncrementSessionAttribute() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("count", new Integer(3));

        mockMvc.perform(get("/count").session(session))
                .andDo(print())
                .andExpect(status().isOk());

        Assertions.assertThat((Integer) session.getAttribute("count")).isEqualTo(new Integer(4));
    }

    @Test
    public void countShouldReturnSessionAttributeInMessage() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("count", new Integer(5));

        mockMvc.perform(get("/count").session(session))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Count: 6"));
    }

}
