package codegym.controller;

import codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @GetMapping(value = "")
    public String display() {
        return "translate/index";
    }
    @Autowired
    DictionaryService dictionaryService;
    @PostMapping(value = "translate")
    public  String translate(@RequestParam String english, Model model){
        if (dictionaryService.find(english)==null){
            model.addAttribute("mess","No match result");
        }else {
            model.addAttribute("mess","Successful search");
            model.addAttribute("result",dictionaryService.find(english));
        }
        return "translate/index";
    }
}
