package com.bookshop.board.vo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//-------------------------------------------------------------------------------------------------
// public class PageVO
// PageVo는 브라우저에서 전달되는 값은 페이지 번호(page)와 게시글의 수(size)만을 받도록 설계한다.
// 일정한 값 이상의 값이 들어올 수 없도록 제약을 둔다.
// 정렬방향이나 정렬기준이 되는 속성은 Controller에게 지정한다.
//-------------------------------------------------------------------------------------------------
public class PageVO {

	private	static final int DEFAULT_SIZE		= 10;
	private	static final int DEFAULT_MAX_SIZE	= 50;
	
	private int	page;
	private	int size;
	
	//-------------------------------------------------------------------------------------------------
	// 기본 생성자
	// 객체 생성시 화면에 보여질 페이지와 갯수를 기본 값으로 설정한다.
	//-------------------------------------------------------------------------------------------------
	public PageVO() {
		this.page	= 1;
		this.size	= DEFAULT_SIZE;
	}

	public int getPage() {
		return page;
	}

	//-------------------------------------------------------------------------------------------------
	// 페이지 값이 0이하로 넘어오면, 삼항 연사자를 이용하여 0이하 페이지는 없으므로 1로 설정한다.
	//-------------------------------------------------------------------------------------------------
	public void setPage(int page) {
		// this.page = page;
		this.page = page < 0 ? 1 : page;
	}

	public int getSize() {
		return size;
	}

	//-------------------------------------------------------------------------------------------------
	// 한 화면에 보여줄 글의 수가 보여줄 한계를 벗어나면 기본 글수로 설정한다.
	//-------------------------------------------------------------------------------------------------
	public void setSize(int size) {
		// this.size = size;
		this.size = size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE  ? DEFAULT_SIZE : size;
	}

	//-------------------------------------------------------------------------------------------------
	// 전달받은 파라미터를 이용하여 PageRequest로 Pageable 객체를 만든다.
	//-------------------------------------------------------------------------------------------------
	public Pageable makePageable(int direction, String... props) {
		Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC;
		return PageRequest.of(this.page - 1, this.size, dir, props);
	}
	
	
} // End - public class PageVO
