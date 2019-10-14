package com.mycompany.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.dto.Ch05Board;

@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	@RequestMapping("/getBoardList")
	public String getBoardList(int pageNo, Model model) {
		int startNo = (pageNo-1)*10+1;
		int endNo = pageNo*10;
		List<Ch05Board> boardList = new ArrayList<>();
		for(int i=startNo;i<=endNo; i+=1) {
			Ch05Board board = new Ch05Board();
			board.setBno(i);
			board.setBtitle("성실한 자가 성공한다. ("+i+")");
			board.setBcontent("근데 나는 이따가 껍데기 먹으러 간다. ("+i+")");
			board.setWriter("김상엽");
			board.setDate(new Date());
			board.setHitcount(1);
			boardList.add(board);
		}
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalNo", 100);
		//return "ch05/getBoardList";
		return "ch05/getBoardList";
	}

}
