package com.example.projecteksamen.ControllerTest;

import com.example.projecteksamen.controllers.GalleryController;

import com.example.projecteksamen.controllers.ReperationController;
import com.example.projecteksamen.services.GalleryService;

import com.example.projecteksamen.services.ReperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;




import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest(ReperationController.class)
public class ReperationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReperationService reperationService;

    @Test
    public void testReperationIndexGetMappingResponseNotNull() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/reperationIndex");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertNotNull(result.getResponse());
    }
}

