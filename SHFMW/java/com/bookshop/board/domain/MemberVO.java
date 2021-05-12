package com.bookshop.board.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

//-------------------------------------------------------------------------------------------------
// public class MemberVO
//-------------------------------------------------------------------------------------------------
@Data //@Getter, @Setter, @ToString 다 포함된것
@AllArgsConstructor // 필드값을 모두 포함한 생성자
public class MemberVO {

	
	private	int			mno;	// 회원번호
	private	String		mid;	// 회원아이디
	private	String		mpw;	// 회원비밀번호
	private	String		mname;	// 회원이름
	private	Timestamp	regdate;// 가입일자

//	MemberVO(int mno, String mid, String mpw, String mname, Timestamp regdate) {
//		this.mno 		= mno;
//		this.mid		= mid;
//		this.mpw		= mpw;
//		this.mname		= mname;
//		this.regdate	= regdate;
//	}
	
} // End - public class MemberVO
