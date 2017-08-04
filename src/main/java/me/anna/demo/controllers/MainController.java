package me.anna.demo.controllers;

import me.anna.demo.models.User;
import me.anna.demo.repositories.RoboResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Controller
public class MainController {

    @Autowired
    RoboResumeRepository roboResumeRepository;

    @GetMapping("/")
    public String showIndex(Model model)
    {
        String myMessage = "Welcome to the Robo Resume App";
        model.addAttribute("message", myMessage);
        return "index";
    }

    @GetMapping("/enteruser")
    public String addProduct(Model model)
    {

        model.addAttribute("newUser", new User());
        return "enteruser";
    }

    @PostMapping("/enteruser")
    public String postUser(@ModelAttribute("newUser") User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "enteruser";
        }
//
//       if(user.getEndDate() != null)
//       {
//       //     LocalDate today = LocalDate.now();
//          //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
//          //  String formattedString = today.format(formatter);
//          //  System.out.println((today));
//       //     String endDate1 = today.toString();
//       //     user.setEndDate(endDate1);
//       }
//
        user.setEmployedDays(ChronoUnit.DAYS.between(user.getStartDate(), user.getEndDate()));

        roboResumeRepository.save(user);
        return "resultuser";
    }


}
