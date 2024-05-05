package com.example.app;

import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class PromptToSortList {
    @Autowired
    private OllamaChatClient chatClient;

    public List<String> sortTheList(List<String> data){
        String message = "Given the {data}, please sort it in alphabetical order";
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("data", data));
        Prompt prompt = promptTemplate.create();
        Generation generation = chatClient.call(prompt).getResult();
        return Collections.singletonList(generation.getOutput().getContent());
    }
}
