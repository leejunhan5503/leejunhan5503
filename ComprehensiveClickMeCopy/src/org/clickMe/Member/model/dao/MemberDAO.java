package org.clickMe.Member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.clickMe.Member.model.dto.MemberDTO;

public class MemberDAO {

	/* 암호화 처리 된 비밀번호 조회용 메소드(로그인 확인용) */
	public String selectEncryptedPsw(SqlSession session, MemberDTO requestMember) {
	/* 요청받았던 requestMember라는 속성값을 반환한다. */
	return session.selectOne("MemberDAO.selectEncryptedPsw", requestMember);
}

	/* 패스워드 일치 시 회원 정보 조회용 메소드 */
	public MemberDTO selectLoginMember(SqlSession session, MemberDTO requestMember) {
	/* 요청받았던 requestMember라는 속성값을 반환한다. */
	return session.selectOne("MemberDAO.selectLoginMember", requestMember);
	}
}
