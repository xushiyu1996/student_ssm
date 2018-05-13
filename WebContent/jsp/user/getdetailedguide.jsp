<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<% String path=request.getContextPath()+"/source2/"; %>
<% String path2=request.getContextPath(); %>

<!DOCTYPE HTML>
<html>
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">

  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>${guide.guideName}</title>

  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=path%>css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path%>css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <link href="<%=path2%>/css/main.css" media="screen" rel="stylesheet" type="text/css">
 
  <script src="<%=path%>js/jquery-1.7.2.min.js" ></script>
  <script src="<%=path%>js/html5.js" ></script>
  <script src="js/jflow.plus.js" ></script>
  <script src="<%=path%>js/jquery.carouFredSel-5.2.2-packed.js"></script>
  <script src="<%=path%>js/checkbox.js"></script>
  <script src="<%=path%>js/radio.js"></script>
  <script src="<%=path%>js/selectBox.js"></script>

  <script>
	$(document).ready(function() {
		$("select").selectBox();
	});
  </script>

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
	  $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
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
        <form class=""  action="${pageContext.request.contextPath }/user/selectguidebykey.action">
          <input type="text" name="key" style="display:inline-block;width:120px" class="entry_form" value="" placeholder="请输入关键字"/>
	      <input type="submit" style="display:inline-block;" class="ext_btn ext_btn_success" value="搜索">          
	</form>
      </div><!-- .grid_3 -->

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
    </header>
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
  </div>
  
  <div class="clear"></div>
 
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>指导种类</h3>
		     
		     <nav class="left_menu">
			    <ul>
				   <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/专业课辅导.action">专业课辅导</a></li>
			       <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/业余技能.action">业余技能</a></li>
			       <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/考研.action">考研</a></li>
			       <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/出国留学.action">出国留学</a></li>
					<li><a href="${pageContext.request.contextPath }/user/selectguidebytype/英语学习.action">英语学习</a></li>
		            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/求职辅导.action">求职辅导</a></li>
		            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/考证指导.action">考证指导</a></li>
		            <li><a href="${pageContext.request.contextPath }/user/selectguidebytype/学习方法.action">学习方法</a></li>
					<li><a href="${pageContext.request.contextPath }/user/selectguidebytype/其他.action">其他</a></li>
			    </ul>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav -->
	       
       </div><!-- .sidebar -->
      
       <div id="content" class="grid_9">
		<h1 class="page_title">${guide.guideName}</h1>
		
		<div class="product_page">
			<div class="grid_4 img_slid" id="products">
				<img width="320" height="300" class="sale" src="/pic/${coach.coachPic}"/>
				<div class="preview slides_container">
					<div class="prev_bg">
						<!-- <a href="images/produkt_slid.png" class="jqzoom" rel='gal1' title="">
							<img src="images/produkt_slid.png"  title="" alt=""/> -->
						</a>
					</div>
				</div>

			</div>

			<div class="grid_5">
				<div class="entry_content">
					
					<p style="font-size:large;">
					<a href="${pageContext.request.contextPath }/user/getcoachinfomation.action?coachId=${coach.coachId }">${guide.coachName}</a>
					&nbsp&nbsp&nbsp&nbsp&nbsp${guide.guideType}</p>
					<div class="ava_price">
						<div class="availability_sku" >							
							<div class="sku">
								指导时长: <span style="font-size:large;">${guide.guideTimespan}分钟</span>
							</div>
							<div class="sku">
								指导地点: <span style="font-size:large;">${guide.guidePlace}</span>
							</div>
													
						</div>
						<div class="price" >
							<div style="font-size:x-large;" class="price_new">￥${guide.guidePrice}</div>
						</div>
					</div>
				</div>
				
				<div class="block_cart">
							<div   style="float:left;display:inline">
							<div class="sku" >
								指导评分: <span style="font-size:large;">${guide.guideRate}</span>
							</div>
							<div class="sku" >
								参加指导人数: <span style="font-size:large;">${guide.guideNumber}</span>
							</div>
							</div>	

							<div class="cart" style="float:right;display:inline">
								<a  style="font-size:x-large;" class="ext_btn ext_btn_success" href="${pageContext.request.contextPath }/user/check/buyGuide/${guide.guideId }.action" >购买</a>								
							</div>
						<div class="clear"></div>
					</div>
					
			</div>
			<div class="clear"></div>

			<div class="grid_9" >
				<div id="wrapper_tab" class="tab1">
					<a href="#" class="tab1 tab_link">指导介绍</a>
					<div class="clear"></div>
					<div class="tab1 tab_body">
					${guide.guideIntroduction}
					</div>
					
					<div class="clear"></div>
				</div>​<!-- #wrapper_tab -->
				<div class="clear"></div>
			</div><!-- .grid_9 -->

			<div class="clear"></div>

			<div class="related">
				<div class="c_header">
					<div class="grid_7">
						<h2>指导评价</h2>
					</div>

					
				</div>

				<div class="list_carousel">
					<c:forEach items="${paidguidelist}" var="paidguide" varStatus="id">
		
						<article class="post">
							<h2 class="title_article">${paidguide.userName}&nbsp&nbsp&nbsp&nbsp${paidguide.guideRate}分</h2>
							<div class="content_article">
								<p>${paidguide.guideRemark}</p>
							</div>
							
						</article>
						
					</c:forEach>
				
				
				
				</div>
			</div>
		</div>
		
		
		
		
       </div><!-- #content -->
       
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