<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode){
				case "memberLogin" : 
					successMessage = "로그인에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "memmberLogout" : 
					successMessage = "로그아웃에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					break;
				/* case "deleteMember" : 
					successMessage = "회원 탈퇴에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/index.jsp";
					break;
				case "insertNotice" : 
					successMessage = "공지사항 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
				case "insertBoard" : 
					successMessage = "게시판 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/board/list";
					break;
				case "insertThumbnail" : 
					successMessage = "썸네일 게시판 등록에 성공하셨습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/thumbnail/list";
					break; */
			}

			alert(successMessage);
			
			location.replace(movePath);
		})();
	
	</script>
</body>
</html>
