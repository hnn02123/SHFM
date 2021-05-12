package com.bookshop;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import com.bookshop.board.domain.WebBoard;
import com.bookshop.board.persistence.WebBoardRepository;

import lombok.extern.java.Log;

//-------------------------------------------------------------------------------------------------
// public class WebBoardRepositoryTests
//-------------------------------------------------------------------------------------------------
@SpringBootTest
@Log
@Commit
//@RunWith(JUnitPlatform.class)
public class WebBoardRepositoryTests {

	@Autowired
	WebBoardRepository repo;
	
	//-------------------------------------------------------------------------------------------------
	// Test
	//-------------------------------------------------------------------------------------------------
	@Test
	public void test() {
		log.info("JUnit5 Test.....");
	}
	
	//-------------------------------------------------------------------------------------------------
	// 샘플 데이터 추가 : 테스트 데이터 300건을 생성한다.
	//-------------------------------------------------------------------------------------------------
	@Test
	public void insertBoardDummieData() {
		log.info("insertBoardDummieData 시작.....");
		
		IntStream.range(0,  300).forEach(i -> {
			WebBoard wBoard = new WebBoard();
			
			wBoard.setTitle("Sampe Board Title " + i);
			wBoard.setContent("Content " + i);
			wBoard.setWriter("user0" + (i  % 10));
			log.info("insertBoardDummieData 시작....." + i);
			
			repo.save(wBoard);
		});

	}
	
	//-------------------------------------------------------------------------------------------------
	// 데이터 목록 출력 테스트
	//-------------------------------------------------------------------------------------------------
	@Test
	public void searchList1() {
		log.info("searchList1 시작.....");

		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");

		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), pageable);

		log.info("PAGE: " + result.getPageable());

		log.info("---------------------------------------------------------------------------------");

		result.getContent().forEach(board -> log.info("" + board));
		
	}

	//-------------------------------------------------------------------------------------------------
	// 데이터 목록 출력 테스트
	//-------------------------------------------------------------------------------------------------
	@Test
	public void searchList2() {
		log.info("searchList2 시작.....");

		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");

		Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), pageable);

		log.info("PAGE: " + result.getPageable());

		log.info("---------------------------------------------------------------------------------");

		log.info("PageNumber: " + result.getPageable().getPageNumber());

		log.info("TotalPages " + result.getTotalPages());

		log.info("" + result.getPageable());

		result.getContent().forEach(board -> log.info("" + board));
		
	}

	//-------------------------------------------------------------------------------------------------
	// 검색 조건에 따른 데이터 출력
	//-------------------------------------------------------------------------------------------------
	@Test
	public void searchList3() {
		log.info("searchList3 시작.....");

		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
		
		// 제목에 "10"이라는 문자열이 포함된 데이터를 검색한다.
		Page<WebBoard> result = repo.findAll(repo.makePredicate("t", "10"), pageable);

		log.info("PAGE: " + result.getPageable());

		log.info("---------------------------------------------------------------------------------");
		result.getContent().forEach(board -> log.info("" + board));

	}
	
	//-------------------------------------------------------------------------------------------------
	// 검색 조건에 따른 데이터 출력
	//-------------------------------------------------------------------------------------------------


} // End - public class WebBoardRepositoryTests
