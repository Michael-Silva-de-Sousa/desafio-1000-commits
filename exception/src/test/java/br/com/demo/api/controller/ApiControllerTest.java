package br.com.demo.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Classe teste da ApiController
 *
 * @Author Michael Sousa
 */
@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/demo-exceptions teste do retondo a HandlerException")
    void testaApiController() throws Exception {

        // Executa a request GET
        mockMvc.perform(get("/api/demo-exceptions"))
                // Valida o http status code e a content type retornado.
                .andExpect(status().isOk());
    }
}
