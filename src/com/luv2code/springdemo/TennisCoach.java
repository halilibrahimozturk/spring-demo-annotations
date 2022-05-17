package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class TennisCoach implements Coach {

    @Autowired

    @Qualifier("fortuneFileService")
    private FortuneService fortuneService;

        //define a default constructor

   public  TennisCoach (){
       System.out.println(">>TennisCoach: inside default constructor");
   }

   //define my init method
    @PostConstruct
    public void doMyStartupStuff(){

        System.out.println(">> TennisCoach: inside of doMyStartupStuff");
    }

   //define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){

        System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//
//        this.fortuneService = fortuneService;
//
//    }


    //define a setter method
//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService){
//        System.out.println(">>TennisCoach: inside doSomeCrazyStuff() method");
//
//        this.fortuneService = fortuneService;
//
//
//    }






    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() throws IOException {
        return fortuneService.getFortune();
    }

}