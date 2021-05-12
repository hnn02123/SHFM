package com.bookshop.board.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-------------------------------------------------------------------------------------------------
// public class Board
//-------------------------------------------------------------------------------------------------
@Getter
@Setter
@ToString
public class Board {
	
	private	Long	bno;
	private	String	title;
	private	String	writer;
	private	String	content;
	
	private	Timestamp	regdate;	// LocalDateTime
	private	Timestamp	updatedate;	// LocalDateTime
	

} // End - public class Board
