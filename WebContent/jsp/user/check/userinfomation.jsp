<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
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
  <title>查看用户信息</title>
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
        <div id="here_area" class="fl">当前位置：查看用户信息</div>
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
		<div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">查看用户信息</b></div>
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
               <tr>
                  <td class="td_right">名字：</td>
				  <td >${user.userName}</td>
               </tr>
               
               <tr>
                  <td class="td_right">手机号：</td>
                  <td class="td_left">${user.userMobile}</td>
               </tr> 
                                              
                <tr >
                  <td class="td_right">性别：</td>
                  <td class="td_left">${user.userGender}</td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">用户名：</td>
                  <td class="td_left">${user.userUsername}</td>
               </tr>
               
               <tr>
                  <td class="td_right">密码：</td>
                  <td class="td_left">${user.userPassword}</td>
               </tr>
               
               <tr>
                  <td class="td_right">大学：</td>
                  <td class="td_left">${user.userUniversity}</td>
               </tr> 
               
               <tr >
                  <td class="td_right">年级：</td>
                  <td class="td_left">${user.userGrade}</td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">专业：</td>
                  <td class="td_left">${user.userMajor}</td>
               </tr>
                 
               <tr>
                  <td class="td_right">自我介绍：</td>
                  <td class="td_left">${user.userIntroduction}</td>
               </tr>
               
               <tr>
                  <td class="td_right">参加指导的次数：</td>
                  <td class="td_left">${user.userNumber}</td>
               </tr>
               
               <tr>
                  <td class="td_right">财产：</td>
                  <td class="td_left">${user.userMoney}</td>
               </tr>
               
                 
                     
               </table>
          </div>
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