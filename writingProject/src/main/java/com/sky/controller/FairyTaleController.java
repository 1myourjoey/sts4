
package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.Dto.FairyTaleDto;
import com.sky.Service.FairyTaleService;


@Controller
public class FairyTaleController {
	  @Autowired
	    private FairyTaleService fairyTaleService;

	    @GetMapping("/")
	    public String home(Model model) {
	        List<FairyTaleDto> fairyTaleList = fairyTaleService.selectAll();
	        model.addAttribute("fairyTaleList", fairyTaleList);
	        return "index";
	    }
	
	
}
