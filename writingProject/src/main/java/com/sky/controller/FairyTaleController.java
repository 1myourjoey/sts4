
package com.sky.controller;

import java.util.List;
import java.util.Random;

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

//	    @GetMapping("/")
//	    public String home(Model model) {
//	        List<FairyTaleDto> fairyTaleList = fairyTaleService.selectAll();
//	        model.addAttribute("fairyTaleList", fairyTaleList);
//	        return "index";
//	    }
//	
	  @GetMapping("/")
	  public String content(Model model) {
	      List<FairyTaleDto> fairyTaleList = fairyTaleService.selectAll();
	      
	      // fairyTaleList가 비어있지 않은 경우에만 랜덤 요소를 선택하고 전달합니다.
	      if (!fairyTaleList.isEmpty()) {
	          Random random = new Random();
	          int randomIndex = random.nextInt(fairyTaleList.size());
	          FairyTaleDto randomFairyTale = fairyTaleList.get(randomIndex);
	          model.addAttribute("randomFairyTale", randomFairyTale); // 랜덤 동화 객체를 모델에 추가합니다.
	          model.addAttribute("fairyTaleList", fairyTaleList); // 전체 동화 목록도 함께 모델에 추가합니다.
	      }

	      return "index";
	  }
	 
}
