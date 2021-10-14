package org.clickMe.Member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.clickMe.Member.model.dao.MemberDAO;
import org.clickMe.Member.model.dto.MemberDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.clickMe.common.Template.getSqlSession;

public class MemberService {

	/* 의존 관계에 있는 객체가 불변을 유지할 수 있도록 final 필드로 선언한다. */
	private final MemberDAO memberDAO;
	
	/* 생성자를 이용하여 객체를 생성하여 필드에 값을 넣는다. */
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	/* 로그인 처리용 메소드 */
	/* loginCheck는 MemberDTO에 requestMember를 요청한다. */
	public MemberDTO loginCheck(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		/* MemberDTO의 loginMember를 null로 초기화 */
		MemberDTO loginMember = null;
		
		/* 암호화된 비밀번호를 조회한다. */
		String encPsw = memberDAO.selectEncryptedPsw(session, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 로그인 요청한 원문 비밀번호화 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. */
		if(passwordEncoder.matches(requestMember.getPsw(), encPsw)) {
		
			/* 비밀번호가 일치하는 경우에만 회원 정보를 MemberDAO에서 조회해온다. */
			loginMember = memberDAO.selectLoginMember(session, requestMember);
		}
		
		session.close();
		
		return loginMember;
		
	}
}
