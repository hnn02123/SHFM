package com.bookshop.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshop.board.domain.MemberVO;

//-------------------------------------------------------------------------------------------------
// public class SampleController
//-------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/index")
	public void index(Model model) {
		
	}


	
	
} // End - public class SampleController







