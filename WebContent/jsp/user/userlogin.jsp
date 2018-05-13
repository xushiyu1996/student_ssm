<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<div id="login_form">
				<form action="${pageContext.request.contextPath }/user/userLogin.action" >
					<div id="login_tip">
						用户登陆&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" class="username" name="userUsername"></div>
					<div><input type="text" class="pwd" name="userPassword"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/jsp/user/userregist.jsp"><span style=" font-weight: bold;color: #3d96c9;">用户注册</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有
	</div>
</body>
</html>