package com.example.retake.controller;

import com.example.retake.model.Retake;
import com.example.retake.service.RetakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RetakeController {

    private RetakeService retakeService;

    @Autowired
    public RetakeController(RetakeService retakeService) {
        this.retakeService = retakeService;
    }

    @GetMapping("/retakes")
    public String findAll(Model model){
        List<Retake> retakes = retakeService.findAll();
        model.addAttribute("retakes", retakes);
        return "retake-list";
    }

    @GetMapping("/retake-create")
    public String createRetakeForm(Retake retake){
        return "retake-create";
    }

    @PostMapping("/retake-create")
    public String createUser(Retake retake){
        retakeService.saveRetake(retake);
        return "redirect:/retakes";
    }

    @GetMapping("retake-delete/{id}")
    public String deleteRetake(@PathVariable("id") Long id){
        retakeService.deleteById(id);
        return "redirect:/retakes";
    }

    @GetMapping("retake-update/{id}")
    public String updateRetakeForm(@PathVariable("id") Long id, Model model){
        Retake retake = retakeService.findById(id);
        model.addAttribute("retake", retake);
        return "/retake-update";
    }

    @PostMapping("/retake-update")
    public String updateRetake(Retake retake){
        retakeService.saveRetake(retake);
        return "redirect:/retakes";
    }
}
