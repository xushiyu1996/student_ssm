<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<% String path=request.getContextPath()+"/source2/"; %>
<% String path2=request.getContextPath(); %>
    
<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">

  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>首页</title>

  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=path%>css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path%>css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path2%>/css/main.css" media="screen" rel="stylesheet" type="text/css">

  <script src="<%=path%>js/jquery-1.7.2.min.js" ></script>
  <script src="<%=path%>js/html5.js" ></script>
  <script src="<%=path%>js/jflow.plus.js" ></script>
  <script src="<%=path%>js/jquery.carouFredSel-5.2.2-packed.js"></script>

  <script>
	$(document).ready(function(){
	    $("#myController").jFlow({
			controller: ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides: "#slider",  // the div where all your sliding divs are nested in
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "984px",  // this is the width for the content-slider
			height: "480px",  // this is the height for the content-slider
			duration: 400,  // time in miliseconds to transition one slide
			prev: ".slidprev", // must be class, use . sign
			next: ".slidnext", // must be class, use . sign
			auto: true
    });
  });
  </script>
  <script>
	$(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>

</head>
<body>
  <div class="container_12">

    <div class="clear"></div>

    <header id="branding">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo" ><img src="<%=path%>/images/logo.png" /></h1>
        </hgroup>
      </div><!-- .grid_3 -->

      <div class="grid_3">
        <form class="" style="display:inline-block;" action="${pageContext.request.contextPath }/user/selectguidebykey.action">
          <input type="text" width="50"  style="display:inline-block;width:120px" class="entry_form" value="" placeholder="请输入关键字"/>
	      <input type="submit" style="display:inline-block;" class="ext_btn ext_btn_success" value="搜索">          
	</form>
      </div>

      <div class="grid_6">
        
        <nav class="private">
          <ul>
            <li><a href="${pageContext.request.contextPath }/jsp/user/userlogin.jsp">用户中心</a></li>
		<li class="separator">|</li>
            <li><a href="${pageContext.request.contextPath }/user/userLogout.action">退出登录</a></li>
		<li class="separator">|</li>
            <li><a href="${pageContext.request.contextPath }/jsp/coach/coachlogin.jsp">行家入口</a></li>
		<li class="separator">|</li>
            <li><a href="${pageContext.request.contextPath }/jsp/administrator/administratorlogin.jsp">管理员入口</a></li>
          </ul>
        </nav><!-- .private -->
      </div><!-- .grid_6 -->
    </header><!-- #branding -->
  </div><!-- .container_12 -->

  <div class="clear"></div>

  <div id="block_nav_primary">
    <div class="container_12">
      <div class="grid_12">
        <nav class="primary">
          <ul>
            <li class="curent"><a href="${pageContext.request.contextPath }/user/index.action">首页</a></li>
            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/专业课辅导.action">专业课辅导</a></li>
            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/业余技能.action">业余技能</a></li>
            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/考研.action">考研</a></li>
            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/出国留学.action">出国留学</a></li>
            
	    <li>
              <a href="#">更多</a>
              <ul class="sub">
                <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/英语学习.action">英语学习</a></li>
	            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/求职辅导.action">求职辅导</a></li>
	            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/考证指导.action">考证指导</a></li>
	            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/学习方法.action">学习方法</a></li>
				<li><a href="${pageContext.request.contextPath }/user/selectguidebytype/其他.action">其他</a></li>
              </ul>
            </li>
          </ul>
        </nav><!-- .primary -->
      </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
  </div><!-- .block_nav_primary -->

  <div class="clear"></div>

  <div class="container_12">
    <div class="grid_12">
        <div class="slidprev"><span>Prev</span></div>
        <div class="slidnext"><span>Next</span></div>
        <div id="slider">
          <div id="slide1">
            <img src="<%=path%>/images/content/slide1.jpg" alt="" title="" />
            <div class="slid_text">
              <h3 class="slid_title"><span>行家指路</span></h3>
              <p><span>这里有来自各个行业的精英人士</span></p>
              <p><span>让作为大学生的你</span></p>
              <p><span>迈向成功的第一步</span></p>
            </div>
          </div>

          <div id="slide2">
            <img src="<%=path%>/images/content/slide2.jpg" alt="" title="" />
            <div class="slid_text">
              <h3 class="slid_title"><span>快捷方便</span></h3>
              <p><span>让接触不到行业精英的大学生们</span></p>
              <p><span>在网上浏览即可查看各种行家</span></p>
            </div>
          </div>

          <div id="slide3">
            <img src="<%=path%>/images/content/slide3.jpg" alt="" title="" />
            <div class="slid_text">
              <h3 class="slid_title"><span>便宜实惠</span></h3>
              <p><span>仅需几百元就可以与行业大咖面对面交流</span></p>
              <p><span>学习他们的独门妙招</span></p>
            </div>
          </div>
        </div><!-- .slider -->
        <div id="myController">
          <div class="control"><span>1</span></div>
          <div class="control"><span>2</span></div>
          <div class="control"><span>3</span></div>
        </div>


    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  <div class="copyrights">Collect from 网站模板</div>
  <div class="clear"></div>

  <section id="main" class="home">
    <div class="container_12">
      <div class="clear"></div>
      <div class="carousel">
        <div class="c_header">
          <div class="grid_10">
            <h2>人气最旺的行家</h2>
          </div><!-- .grid_10 -->

          
        </div><!-- .c_header -->

        <div class="list_carousel">

        <ul id="list_product" class="list_product">
        
        <c:forEach items="${coachlist}" var="coach" varStatus="id">  
        
          <li class="">
            <div class="grid_3 product">
              <div class="prev">
                <a href="${pageContext.request.contextPath }/user/getcoachinfomation.action?coachId=${coach.coachId }"><img width="160" height="180" src="/pic/${coach.coachPic}" alt="" title="" /></a>
              </div>
              <h3 class="title">${coach.coachIdentity }</h3>
              <div class="cart">
                <div class="price" width="200">
                <div class="vert" width="200">
                  <div class="price_new" width="200">指导人数：${coach.coachNumber }</div>
                </div>
                </div>
                <div class="price">
                <div class="vert">
                  <div class="price_new">${coach.coachName }</div>
                </div>
                </div>
              </div><!-- .cart -->
            </div><!-- .grid_3 -->
          </li>
          
          </c:forEach>

        </ul><!-- #list_product -->
        </div><!-- .list_carousel -->
      </div><!-- .carousel -->

      <div class="carousel">
        

        <div class="list_carousel">

        <ul id="list_product" class="list_product">
        
        <c:forEach items="${coachlist2}" var="coach" varStatus="id">  
        
          <li class="">
            <div class="grid_3 product">
              <div class="prev">
                <a href="${pageContext.request.contextPath }/user/getcoachinfomation.action?coachId=${coach.coachId }"><img width="160" height="180" src="/pic/${coach.coachPic}" alt="" title="" /></a>
              </div><!-- .prev -->
              <h3 class="title">${coach.coachIdentity }</h3>
              <div class="cart">
                <div class="price">
                <div class="vert">
                  <div class="price_new">指导人数：${coach.coachNumber }</div>
                </div>
                </div>
                <div class="price">
                <div class="vert">
                  <div class="price_new">${coach.coachName }</div>
                </div>
                </div>
              </div><!-- .cart -->
            </div><!-- .grid_3 -->
          </li>
          
          </c:forEach>

        </ul><!-- #list_product -->
        </div><!-- .list_carousel -->
      </div>
      
      
      

      
      <div class="clear"></div>

    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>

  <footer>

    <div class="f_info">
      <div class="container_12">
        <div class="grid_6">
          <p class="copyright">Copyright &copy; 2018.Company name All rights reserved.</p>
        </div>
        <div class="clear"></div>
      </div><!-- .container_12 -->
    </div><!-- .f_info -->
  </footer>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
