<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglib.jsp" %>
	<!--m-top start-->
	<div class="m-top">
		<div class="t-head">
			<div class="h-logo">
				<a href="${basePath }/page/toIndex"><img src="${basePath }/images/logo1.png" alt="follow音乐网" title="follow音乐网"/></a>
			</div>
			<div class="h-nav">
				<ul>
					<li style="margin-left:130px;"><a class="a" href="${basePath }/page/toIndex">首页</a></li>
					<li>
						<a class="a" href="#">音乐/MV</a>
						<div class="n-xiala1">
							<ul>
								<li><a id="allsend" href="${basePath }/to/sendlistAction.do?pn=1">精品乐单</a></li>
								<li><a id="allmusic" href="${basePath }/to/allMusicAction?pn=1">歌曲广场</a></li>
								<li><a id="allmv" href="${basePath }/page/Allmv.jsp">MV库</a></li>
							</ul>
						</div>
					</li>
					<li><a class="a" href="#">音乐资讯</a></li>
					<li><a id="mymusicbox" class="a" href="javascript:void(0)" onclick="login();" >我的音乐盒</a></li>
					<li><a class="a" href="${basePath }/page/a_about.jsp" target="_blank">关于我们</a></li>
				</ul>
			</div>
			<div class="h-search" style="position:relative;">
				<input type="text" class="textinput" placeholder="搜索歌手，歌曲"><a href="#">搜索</a>
				<div class="s_xiala" style="position:absolute;top:41px;width:100%;background:rgba(0,0,0,.4);z-index:999;display:none;"></div>
			</div>
			<%if (session.getAttribute("user") == null){%>
			<div class="h-login">
				<a class="l_login" href="javascript:void(0)">登录</a><span>|</span><a class="l_register" href="javascript:void(0)">注册</a>
			</div>
			<%}else{%>
			<div class="h-user" style="position:relative;">
				<a class="u-name" href="javascript:void(0)">
					<img src="${basePath }/${user.userpicurl }"/>
					<b>${user.username }</b>
				</a>
				<i class="u-xialaicon"></i>
				<div class="u-xiala">
					<div class="x-href">
						<ul>
							<li><a href="javascript:void(0)" onclick="toMyInfo();" target="_blank">我的信息</a></li>
							<li><a href="javascript:void(0)" onclick="toMyMusic();" target="_blank">我的歌曲</a></li>
							<li><a href="${basePath }/user/logout">退出</a></li>
						</ul>
					</div>
				</div>
			</div>
			<%}%>
		</div>
	</div>
	<!--end m-top-->
	<script src="${basePath }/js/jquery.js"></script>