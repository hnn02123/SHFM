package com.bookshop.board.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.bookshop.board.domain.QWebBoard;
import com.bookshop.board.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

//-------------------------------------------------------------------------------------------------
// public interface WebBoardRepository
//-------------------------------------------------------------------------------------------------
public interface WebBoardRepository 
		extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {
	
	//-------------------------------------------------------------------------------------------------
	// 검색에 필요한 타입과 키워드를 이용하여 쿼리를 생성한다.
	//-------------------------------------------------------------------------------------------------
	public default Predicate makePredicate(String type, String keyword) {

		//-------------------------------------------------------------------------------------------------
		// WebBoardRepositoryTests의 searchList1()
		// 검색 조건 없이 처리
		//-------------------------------------------------------------------------------------------------
		 /* 
		BooleanBuilder builder = new BooleanBuilder();
		
		QWebBoard board = QWebBoard.webBoard;
		
		// where bno > 0
		builder.and(board.bno.gt(0));
		
		return builder;
		*/
		
		//-------------------------------------------------------------------------------------------------
		// WebBoardRepositoryTests의 searchList2(), searchList3()
		// 검색 조건을 가지고 처리
		//-------------------------------------------------------------------------------------------------
		BooleanBuilder builder = new BooleanBuilder();
		
		QWebBoard board = QWebBoard.webBoard;
		
		// 조건 : where bno > 0 => bno가 0보다 큰 데이터만 검색한다.
		builder.and(board.bno.gt(0));
		
		if(type == null ) {
			return builder;
		}
		
		switch(type) {
			case "t":	// 제목으로 검색
				builder.and(board.title.like("%" + keyword + "%"));
				break;
				
			case "c":	// 내용으로 검색
				builder.and(board.content.like("%" + keyword + "%"));
				break;
				
			case "w":	// 글작성자로 검색
				builder.and(board.writer.like("%" + keyword + "%"));
				break;
		}
		return builder;
		
	}


} // End - public interface WebBoardRepository
