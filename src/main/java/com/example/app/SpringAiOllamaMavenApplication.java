package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class SpringAiOllamaMavenApplication implements CommandLineRunner {
    @Autowired
    private OllamaChatClient chatClient;
    @Autowired
    PromptToSortList promptToSortList;
    private static Logger log = LoggerFactory.getLogger(SpringAiOllamaMavenApplication.class);

    public static void main(String[] args) {
        log.info("Starting of the application");
        SpringApplication.run(SpringAiOllamaMavenApplication.class, args);
        log.info("Application completed");
    }

    @Override
    public void run(String... args) throws Exception {
        String message = "Hello, my name is {name}. What is your name?";
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("name", "Firoz"));
        log.info(promptTemplate.toString());
        Prompt prompt = promptTemplate.create();
        Generation generation = chatClient.call(prompt).getResult();
        log.info(generation.toString());

        List<String> stringList = new ArrayList<>();
        stringList.add("Sophia");
        stringList.add("Anand");
        stringList.add("Xavier");
        stringList.add("Peter");
        stringList.add("Messi");
        List<String> promptOutput = promptToSortList.sortTheList(stringList);
        log.info(promptOutput.toString());
    }
}
