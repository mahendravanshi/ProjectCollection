package com.springAi;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
@Slf4j
public class SongsController {

    private final AiClient aiClient;


    public SongsController(AiClient aiClient){
        this.aiClient = aiClient;
    }

    @GetMapping("/topSongs")
    public String topSong(){

         String prompt = "What is the top song in india in 1980";

         return aiClient.generate(prompt);
    }



//    @GetMapping("/topSongs/{year}")
//    public String topSong(@PathVariable("year") int year){
//
//        String prompt = "What is the top song in India in {year}";
//        PromptTemplate promptTemplate= new PromptTemplate(prompt);
//        promptTemplate.add("year",year);
//        return aiClient.generate(promptTemplate.render());
//
//    }

//    @GetMapping("/topSongs/{year}")
//    public TopSong topSong(@PathVariable("year") int year){
//
//        BeanOutputParser<TopSong> beanOutputParser = new BeanOutputParser<>(TopSong.class);
//        String promptString = """
//                What is the top song in India in {year}
//                {format}
//                """;
//        PromptTemplate promptTemplate= new PromptTemplate(promptString);
//        promptTemplate.add("year",year);
//        promptTemplate.add("format",beanOutputParser.getFormat());
//
//        log.info("beanOutputParser {}",beanOutputParser.getFormat());
//
//        promptTemplate.setOutputParser(beanOutputParser);
//
//        Prompt prompt = promptTemplate.create();
//
//        AiResponse aiResponse = aiClient.generate(prompt);
//
//        String text = aiResponse.getGeneration().getText();
//        return beanOutputParser.parse(text);
//    }
}
