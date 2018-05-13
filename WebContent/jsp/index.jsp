<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path=request.getContextPath(); %>
<head>
	<meta charset="UTF-8">

    <link rel="stylesheet" href="<%=path%>/css/login.css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用面向大学生的经验技能分享系统
		</div>
		<div id="back">
			<a href="${pageContext.request.contextPath }/user/index.action">返回首页</a>&nbsp;&nbsp; 
			
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form" >
					<div id="login_tip" >
						<a href="${pageContext.request.contextPath }/jsp/user/userlogin.jsp" style="font-size:30px;font-weight: bold;color: #3d96c9;">用户入口</a>
					</div>
					<br><br>
					<div id="login_tip">
						<a href="${pageContext.request.contextPath }/jsp/coach/coachlogin.jsp" style="font-size:30px;font-weight: bold;color: #3d96c9;">行家入口</a>
					</div>
					<br><br>
					<div id="login_tip">
						<a href="${pageContext.request.contextPath }/jsp/administrator/administratorlogin.jsp" style="font-size:30px;font-weight: bold;color: #3d96c9;">管理员入口</a>
					</div>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有
	</div>
</body>
</html>