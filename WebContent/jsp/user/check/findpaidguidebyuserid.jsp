<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<% String path=request.getContextPath(); %> 
<% String path2=request.getContextPath()+"/source2/"; %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  
  	  <link href="<%=path2%>css/style2.css"  rel="stylesheet" type="text/css">
	  
  
  <link rel="stylesheet" href="<%=path%>/css/common.css">
  <link rel="stylesheet" href="<%=path%>/css/style.css">
  <link rel="stylesheet" href="<%=path%>/css/main.css">
  
  <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/jquery.SuperSlide.js"></script>
  <script type="text/javascript" src="<%=path%>/js/colResizable-1.3.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/common.js"></script>
  
 
  
  <script type="text/javascript">
  $(function(){
      $(".sideMenu").slide({
         titCell:"h3", 
         targetCell:"ul",
         defaultIndex:0, 
         effect:'slideDown', 
         delayTime:'500' , 
         trigger:'click', 
         triggerTime:'150', 
         defaultPlay:true, 
         returnDefault:false,
         easing:'easeInQuint',
         endFun:function(){
              scrollWW();
         }
       });
      $(window).resize(function() {
          scrollWW();
      });
  });
  function scrollWW(){
    if($(".side").height()<$(".sideMenu").height()){
       $(".scroll").show();
       var pos = $(".sideMenu ul:visible").position().top-38;
       $('.sideMenu').animate({top:-pos});
    }else{
       $(".scroll").hide();
       $('.sideMenu').animate({top:0});
       n=1;
    }
  } 

var n=1;
function menuScroll(num){
  var Scroll = $('.sideMenu');
  var ScrollP = $('.sideMenu').position();
  /*alert(n);
  alert(ScrollP.top);*/
  if(num==1){
     Scroll.animate({top:ScrollP.top-38});
     n = n+1;
  }else{
    if (ScrollP.top > -38 && ScrollP.top != 0) { ScrollP.top = -38; }
    if (ScrollP.top<0) {
      Scroll.animate({top:38+ScrollP.top});
    }else{
      n=1;
    }
    if(n>1){
      n = n-1;
    }
  }
}
  </script>
  <title>查看已购买的指导</title>
</head>
<body>
    <div class="top">
      <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            <a href="#"><img src="<%=path%>/images/a.png" alt="" width="60" height="60"></a>
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="" id="hp">&nbsp;</a>
              <a href="${pageContext.request.contextPath }/user/userLogout.action" id="gy">&nbsp;</a>
              <a href="${pageContext.request.contextPath }/user/index.action" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              ${user.userName}
              
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：查看已购买的指导</div>
      </div>
    </div>
    <div class="side">
        <div class="sideMenu" style="margin:0 auto">
          <h3>用户信息管理</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/jsp/user/userregist.jsp">用户注册</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/user/userlogin.jsp">用户登录</a></li>            
            <li><a href="${pageContext.request.contextPath }/jsp/user/check/userinfomation.jsp">查看用户信息</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/user/check/updateuserinfomation.jsp">修改用户信息</a></li>            
          </ul>
          <h3><a href="${pageContext.request.contextPath }/user/check/findPaidGuideByUserId.action">查看已购买的指导</a></h3>

           </div>
    </div>
    <div class="main" style=" overflow-y:auto; ">
	    <%-- <iframe src="${pageContext.request.contextPath }/jsp/user/check/findpaidguidebyuserid2.jsp"  />	 --%>	
		<div class="listing_product">
		<div class="product_li">
		<c:choose>
			<c:when test="${length==0 }">
			</c:when>
			<c:when test="${length==1 }">
				<div class="grid_3" >
					<div class="prev">
						<img width="200" src="/pic/${coachlist[0].coachPic }" alt="" title="" />
					</div>
				</div>
				
				<div class="grid_4" style="width:320px" >
					<div class="entry_content" >
						<h3 class="title" style="font-size:large">${guidelist[0].coachName } &nbsp;&nbsp;&nbsp;&nbsp; ${guidelist[0].guideName }</h3>						
						<p style="font-size:large">${guidelist[0].guideTimespan }分钟&nbsp;
						|&nbsp;${guidelist[0].guideNumber }人参加过&nbsp;
						|&nbsp;${guidelist[0].guideRate }分
						</p>
						<a style="font-size:large;text-decoration:none;color: #59b7c2;" class="more" href="${pageContext.request.contextPath }/user/getDetailedGuide/${guidelist[0].guideId}.action ">详情</a>
					</div>
				</div>
				
				<div class="grid_2" >
					<div class="cart">
						<div class="price">
							<div class="price_new">${guidelist[0].guidePrice }元</div>
						</div>
						<a href="${pageContext.request.contextPath }/user/check/getpaidguide/${guidelist[0].guideId }.action" class="bay">评价</a>
						
					</div><!-- .cart -->
				</div><!-- .grid_2 -->
				
				<div class="clear"></div>
			</c:when>
			<c:otherwise>
				<c:forEach var="i" begin="0" end="${length-1}">
		
				<div class="grid_3" >
					<div class="prev">
						<img width="200" src="/pic/${coachlist[i].coachPic }" alt="" title="" />
					</div>
				</div>
				
				<div class="grid_4" style="width:320px" >
					<div class="entry_content" >
						<h3 class="title" style="font-size:large">${guidelist[i].coachName } &nbsp;&nbsp;&nbsp;&nbsp; ${guidelist[i].guideName }</h3>						
						<p style="font-size:large">${guidelist[i].guideTimespan }分钟&nbsp;
						|&nbsp;${guidelist[i].guideNumber }人参加过&nbsp;
						|&nbsp;${guidelist[i].guideRate }分
						</p>
						<a style="font-size:large" class="more" href="${pageContext.request.contextPath }/user/getDetailedGuide/${guidelist[i].guideId}.action ">详情</a>
					</div>
				</div>
				
				<div class="grid_2" >
					<div class="cart">
						<div class="price">
							<div class="price_new">${guidelist[i].guidePrice }元</div>
						</div>
						<a href="${pageContext.request.contextPath }/user/check/getpaidguide/${guidelist[i].guideId }.action" class="bay">评价</a>
						
					</div><!-- .cart -->
				</div><!-- .grid_2 -->
				
				<div class="clear"></div>
				</c:forEach>
			
			</c:otherwise>
		
		
		
		
		</c:choose>
		
		
		
		
			</div><!-- .article -->
			</div>
			</div>
		
		
    </div>
    <div class="bottom">
      <div id="bottom_bg">版权</div>
    </div>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>