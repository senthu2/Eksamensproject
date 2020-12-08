package com.example.projecteksamen.ControllerTest;


import com.example.projecteksamen.HomeController;
import com.example.projecteksamen.controllers.ProductController;
import com.example.projecteksamen.services.ProductCatService;
import com.example.projecteksamen.services.ProductService;
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
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;



    @Test
    //Tester om der er en forbindelse til controlleren for HomeIndex
    public void testHomeIndexGetMappingResponseNotNull() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertNotNull(result.getResponse());
    }
    @Test
    //Tester om der er en forbindelse til controlleren for Kontaktinfo
    public void testKontaktInfoGetMappingResponseNotNull() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/KontaktInfo");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertNotNull(result.getResponse());
    }
    @Test
    //Tester om der er en forbindelse til controlleren for omOs
    public void testOmOsGetMappingResponseNotNull() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/omOs");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertNotNull(result.getResponse());
    }
}
