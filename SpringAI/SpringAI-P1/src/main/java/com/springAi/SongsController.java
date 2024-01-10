package com.springAi;


import org.springframework.ai.client.AiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongsController {

    private final AiClient aiClient;


    public SongsController(AiClient aiClient){
        this.aiClient = aiClient;
    }


    @GetMapping("/topSongs")
    public String topSong(){

         String prompt = "What is the top song in India in 1980";
         return aiClient.generate(prompt);

    }




}
