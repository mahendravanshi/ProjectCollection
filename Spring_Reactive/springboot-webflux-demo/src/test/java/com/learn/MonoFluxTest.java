package com.learn;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
     public void testMono(){

         Mono<?> mono = Mono.just("learn-reactive")
                         .then(Mono.error(new RuntimeException("error occured"))).log();
         mono.subscribe(System.out::println);
     }


     @Test
     public void testFlux(){
         Flux<String> flux = Flux.just("abc","bcd","cde","def")
                 .concatWith(Flux.error(new RuntimeException("flux with error")))
                 .log();
         flux.subscribe(System.out::println,e-> System.out.println(e.getMessage()));
     }





}
