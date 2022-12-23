package org.example.springboot.controller;

import org.example.springboot.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {
    
    @GetMapping("/holidays")
    public String displayHoliday(Model model) {
        List<Holiday> Holiday = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", org.example.springboot.model.Holiday.Type.FESTIVAL),
                new Holiday(" Jan 1 ","New Year's Day", org.example.springboot.model.Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ","Halloween", org.example.springboot.model.Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", org.example.springboot.model.Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", org.example.springboot.model.Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", org.example.springboot.model.Holiday.Type.FEDERAL),
                new Holiday(" July 4 ","Independence Day", org.example.springboot.model.Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ","Labor Day", org.example.springboot.model.Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ","Veterans Day", org.example.springboot.model.Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = org.example.springboot.model.Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (Holiday.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "Holidays.html";
    }
}