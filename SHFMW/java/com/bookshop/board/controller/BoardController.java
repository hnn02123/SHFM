package com.bookshop.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshop.board.domain.WebBoard;
import com.bookshop.board.persistence.WebBoardRepository;
import com.bookshop.board.vo.PageVO;

import lombok.extern.java.Log;

//-------------------------------------------------------------------------------------------------
//public class BoardController
//-------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/board")
@Log
public class BoardController {
	
	@Autowired
	private WebBoardRepository repo;
	
	//-------------------------------------------------------------------------------------------------
	// Thymeleaf Templates 화면
	//-------------------------------------------------------------------------------------------------
	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardController list.....");
		
	}

	//-------------------------------------------------------------------------------------------------
	// Thymeleaf Templates 화면
	//-------------------------------------------------------------------------------------------------
	@GetMapping("/list1")
	public void list1(Model model) {
		log.info("BoardController list1 ==> ");
		
	}

	//-------------------------------------------------------------------------------------------------
	// 검색 조건에 따른 데이터 출력
	// 테스트 : 브라우저에서 http://localhost:8099/board/list2?page=1 로 페이지를 기술한다.
	//-------------------------------------------------------------------------------------------------
	@GetMapping("/list2")
	public void list2(PageVO vo) {
		log.info("BoardController list2 ==> ");

		Pageable page = vo.makePageable(0, "bno");
		
		log.info("BoardController list2 ==> " + page);
		
	}

	//-------------------------------------------------------------------------------------------------
	// 검색 조건에 따른 데이터 출력
	// 테스트 : 브라우저에서 http://localhost:8099/board/list2?page=1 로 페이지를 기술한다.
	//-------------------------------------------------------------------------------------------------
	@GetMapping("/list3")
	public void list3(PageVO vo, Model model) {
		log.info("BoardController list3 ==> ");

		Pageable page = vo.makePageable(0, "bno");
		
		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), page);
		
		log.info("BoardController list2 page ==> " + page);
		log.info("BoardController list2 result ==> " + result);
		
		model.addAttribute("resutl", result);
	}


	
	

} // End - public class BoardController
