<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

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
  <c:if test="${allErrors!=null }">
	  <c:forEach items="${allErrors }" var="error">
	  <script type="text/javascript">
				 window.alert(" ${ error.defaultMessage}");
		</script>
	  </c:forEach>
	</c:if>
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
  <title>修改行家信息</title>
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
              <a href="${pageContext.request.contextPath }/coach/coachLogout.action" id="gy">&nbsp;</a>
              <a href="${pageContext.request.contextPath }/user/index.action" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              ${coach.coachName}
              
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：修改行家信息</div>
      </div>
    </div>
    <div class="side">
        <div class="sideMenu" style="margin:0 auto">
          <h3>行家信息管理</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/jsp/coach/coachregist.jsp">行家注册</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/coach/coachlogin.jsp">行家登录</a></li>            
            <li><a href="${pageContext.request.contextPath }/jsp/coach/check/coachinfomation.jsp">查看行家信息</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/coach/check/updatecoachinfomation.jsp">修改行家信息</a></li>
          </ul>
          <h3> 行家业务</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/jsp/coach/check/coachaddguide.jsp">添加指导</a></li>
            <li><a href="${pageContext.request.contextPath }/coach/check/findguidebycoachid.action">查看自己的指导</a></li>
            <li><a href="${pageContext.request.contextPath }/coach/check/findpaidguidebycoachid.action">查看被人购买的指导</a></li>            
          </ul>
           </div>
    </div>
    <div class="main" style=" overflow-y:auto; ">
		<div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">修改行家信息</b></div>
            <div class="box_center">
              <form action="${pageContext.request.contextPath }/coach/check/updatecoachinfomation.action" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
               <input type="hidden" value="${coach.coachId}" name="coachId">
               <tr>
                  <td class="td_right">名字：</td>
                  <td class=""> 
                    <input type="text" name="coachName" value=${coach.coachName} class="input-text lh30" size="40">
                 <span style="color:red">*</span> </td>
               </tr>
               
               <tr>
                  <td class="td_right">手机号：</td>
                  <td class=""> 
                    <input type="text" name="coachMobile" value=${coach.coachMobile} class="input-text lh30" size="40">
                  <span style="color:red">*</span></td>
               </tr> 
                                              
                <tr >
                  <td class="td_right">性别：</td>
                  <td class=""> 
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select name="coachGender" class="select"> 
	                        <option value="男">男</option> 
							<option value="女">女</option> 
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  <span style="color:red">*</span></td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">行家名：</td>
                  <td class=""> 
                    <input type="hidden" value=${coach.coachUsername} name="coachUsername" class="input-text lh30" size="40">
                    ${coach.coachUsername}
                  </td>
               </tr>
               
               <tr>
                  <td class="td_right">密码：</td>
                  <td class=""> 
                    <input type="text" name="coachPassword" value=${coach.coachPassword} class="input-text lh30" size="40">
                    
                  <span style="color:red">*</span></td>
               </tr>
               
               <tr>
                  <td class="td_right">身份：</td>
                  <td class=""> 
                    <input type="text"  value=${coach.coachIdentity} name="coachIdentity" class="input-text lh30" size="40">
                 <span style="color:red">*</span> </td>
               </tr> 
               
               <tr>
                  <td class="td_right">自我介绍：</td>
                  <td class="">
                    <textarea name="coachIntroduction" id="" cols="30" rows="10" class="textarea">
                    ${coach.coachIntroduction}
                    </textarea>
                 <span style="color:red">*</span> </td>
                 </tr>
               <tr>
                  <td class="td_right">回应时间（小时）：</td>
                  <td class=""> 
                    <input type="text" value=${coach.coachTime} name="coachTime" class="input-text lh30" size="40">
                <span style="color:red">*</span>  </td>
               </tr> 
               
                 <tr>                
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="button" class="btn btn82 btn_save2" value="修改"> 
                    <input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
                   </td>
                 </tr>
                     
               </table>
               </form>
            </div>
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