package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OllamaChatClientTest {
    @Autowired
    private OllamaChatClient chatClient;

    @Test
    void testCall(){
        String response = chatClient.call("Capital city of India");
        System.out.println(response);
        assertThat(response).isNotBlank().contains("New Delhi");
    }
}
