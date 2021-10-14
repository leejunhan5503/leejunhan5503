package org.clickMe.Member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.clickMe.Member.model.dto.MemberDTO;
import org.clickMe.Member.model.service.MemberService;

/* Controller의 역할을 한다. */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("id");
		String userPsw = request.getParameter("psw");
		
		System.out.println("id : " + userId);
		System.out.println("psw : " + userPsw);
	
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(userId);
		requestMember.setPsw(userPsw);
		
		/* MemberService 객체 생성 */
		MemberService memberService = new MemberService();
		/* 앞으로 loginMember는 memberService에 있는 loginCheck메소드를 실행시키는 역할을 할 것. */
		MemberDTO loginMember = memberService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			/* 처리 후 조건이 맞을 때 지정한 페이지로 이동하고 싶은 경우 */
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}		
	}

}
