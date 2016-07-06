<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/commons/taglib.jsp" %>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="Author" content="mc&lj">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta name="Keywords" content="follow音乐,mv,音乐资讯">
		<meta name="Description" content="follow音乐网,最全面最华丽的音乐网,好听,好看,尽在follow音乐网.音乐,MV,音乐资讯一手掌握.就来follow音乐网.">
		<title>follow音乐</title>
		
		<style type="text/css">
			body{background:#eee;}
			.s_content{width:1000px;margin:0 auto;background:#FFF;border-left:1px solid #d3d3d3;border-right:1px solid #d3d3d3;}
			.s_content .c_left{width:74%;float:left;border-right:1px solid #d3d3d3;}
			.s_content .c_left .songinfo{width:90%;padding-top:40px;margin:0 auto;}
			.s_content .c_left .songinfo .info_left{width:40%;height:210px;float:left;}
			.s_content .c_left .songinfo .info_left .imgbox{background: url('http://localhost:8080/followMusic/images/musiccomments/musiccommments.png') 0px -986px;width: 210px;height: 180px;}
			.s_content .c_left .songinfo .info_left p{color: #333;width: 210px;text-indent: 30px;margin-top: 10px;text-decoration: underline;}
			.s_content .c_left .songinfo .info_right{width:60%;float:right;}
			.s_content .c_left .songinfo .info_right .sname{margin-top:4px;width:100%;height:26px;}
			.s_content .c_left .songinfo .info_right .sname .s_type{width:80px;float:left;height:26px;}
			.s_content .c_left .songinfo .info_right .sname .s_type .t_tag{display: inline-block;width: 60px;height: 26px;background: #d51c1c;text-align: center;color: #fff;font-weight: bold;font-size: 14px;line-height: 26px;border-radius: 6px 20px 20px 6px;}
			.s_content .c_left .songinfo .info_right .sname .s_name{float:left;height:26px;color:#333;font-size:16px;font-weight:bold;}
			.s_content .c_left .songinfo .info_right .p span{color:#0c73c2;}
			.s_content .c_left .songinfo .info_right .singer{margin-top:20px;}
			.s_content .c_left .songinfo .info_right .album{margin-top:14px;}
			.s_content .c_left .songinfo .info_right .control{width:100%;height:30px;margin-top:20px;}
			.s_content .c_left .songinfo .info_right .control ul li{height:30px;float:left;margin-right:10px;text-align:center;line-height:30px;background:#eee;padding-left:10px;padding-right:10px;color:#333;border-radius:4px;}
			.s_content .c_left .songinfo .info_right .control ul li i{vertical-align:middle;display:inline-block;width:12px;height:15px;background:url('${basePath}/images/musiccomments/music_control.png');margin-right:10px;}
			.s_content .c_left .songinfo .info_right .control ul li i.comments{background-position:-98px -122px;margin-right:4px;}
			.s_content .c_left .songinfo .info_right .control ul li i.like{background-position:-15px -170px;}
			.s_content .c_left .songinfo .info_right .control ul li i.send{background-position:-28px -170px;}
			.s_content .c_left .songinfo .info_right .control ul li i.download{background-position:-58px -170px;}
			.s_content .c_left .songinfo .info_right .lrc{width:100%;color:#666;font-size:14px;margin-top:20px;}
			.s_content .c_left .error{width:90%;font-size:13px;text-align:right;text-decoration:underline;margin: 70px auto 0 auto;}
			.s_content .c_left .comments_list{width:90%;margin:0 auto;padding-top:30px;}
			.s_content .c_left .comments_list .l_title{width:100%;height:50px;border-bottom:2px solid #d51c1c;}
			.s_content .c_left .comments_list .l_title .t_title{display: inline-block;width: 60px;height: 50px;line-height: 50px;font-size: 20px;color: #333;}
			.s_content .c_left .comments_list .l_title .t_count{display: inline-block;width: 100px;height: 50px;line-height: 50px;color:#666;}
			
			/**/
			.qq{width:100%;height:165px;background:#fff;border-radius:4px;position:relative;}
			.qq .q_title{font-size:14px;padding:10px 0 10px 20px;}
			.qq .q_meg{width:602px;height:50px;border:1px solid #ccc;margin:0 auto;padding:10px;}/*太大会往下撑*/
			.qq .q_meg img{margin:3px;}
			.qq .q_face{width:100%;height:40px;}
			.qq .q_face a{float:left;}
			.qq .q_face .f_box{margin:13px 0 0 20px;}
			.qq .q_face .btn{cursor:pointer;height:30px;background:#ff8104;display:block;text-align:center;line-height:30px;text-decoration:none;font-size:14px;font-weight:bold;border-radius:3px;color:#fff;float:right;margin:13px 20px 0 0px;padding:0 10px 0 10px;}
			.qq .q_face .btn:hover{background:#f7671d;}
			.qq .q_wb{width:365px;height:182px;background:#fff;border:1px solid #d0d0d0;box-shadow:1px 1px 8px #d0d0d0;display:none;position:absolute;top:150px;left:20px;z-index:1;}
			.qq .q_wb ul li{list-style:none;float:left;margin:2px;padding:2px;cursor:pointer;}
			
			/**/
			.s_content .c_left .all_comments{width:100%;}
			.s_content .c_left .all_comments .ac_title{width: 624px;height: 30px;line-height: 30px;border-bottom: 1px solid #bbb;margin-left: 20px;}
			.s_content .c_left .all_comments .comments_box .meg_box .m_list{width:590px;height:70px;background:#fff;margin:10px auto;padding:10px;border-bottom:1px dotted #bbb;}
			.s_content .c_left .all_comments .comments_box .meg_box .m_list .m_left{width:70px;height:70px;float:left;}
			.s_content .c_left .all_comments .comments_box .meg_box .m_list .m_left img{border-radius:50%;}
			.s_content .c_left .all_comments .comments_box .meg_box .m_list .m_right{width:470px;height:70px;float:left;margin-left:30px;}
			.s_content .c_left .all_comments .comments_box .meg_box .m_list .m_right .r_info{width: 100%;height: 38px;padding-top: 5px;}
			.s_content .c_left .load{width:92%;height:30px;background:#eee;margin:40px auto 30px auto;border-radius:4px;text-align:center;line-height:30px;color:#333;cursor:pointer;}
			
			.s_content .c_right{width:21%;height:600px;float:right;margin-right:24px;}
			.s_content .c_right .h3{position: relative;height: 23px;border-bottom: 1px solid #ccc;color: #333;margin-bottom: 20px;}
			.s_content .c_right .samelike{width:100%;height:100px;margin-top: 30px;}
			.s_content .c_right .samelike .picul li{float:left;margin-right:12px;}
			.s_content .c_right .containsong{width:100%;height:260px;margin-top: 30px;}
			.s_content .c_right .containsong .yuedanul li{width:100%;height:54px;margin-top:10px;}
			.s_content .c_right .containsong .yuedanul .y_left{float:left;width:30%;}
			.s_content .c_right .containsong .yuedanul .y_right{float:left;width:70%;}
			.s_content .c_right .containsong .yuedanul .y_right .r_title{width:120px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;}
			.s_content .c_right .containsong .yuedanul .y_right .r_title a{color:#333;}
			.s_content .c_right .containsong .yuedanul .y_right .r_user{margin-top:10px;}
			.s_content .c_right .containsong .yuedanul .y_right .r_user a{color:#27d5bf;}
			.s_content .c_right .samesong ul li{width:100%;height:30px;}
			.s_content .c_right .samesong ul li .songname a{color:#333;}
			.s_content .c_right .samesong ul li .singer a{color:#27d5bf;}
		</style>
		<%@include file="/commons/public.jsp" %>
	</head>
<body>
<jsp:include  page="/commons/head.jsp"/>
		<div class="s_content">
		
			<!-- c_left start -->
			<div class="c_left">
				
				<!-- songinfo start -->
				<div class="songinfo">
					
					<!-- info_left start -->
					<div class="info_left">
						<div class="imgbox"><img style="margin:40px 0 0 43px;" src="${basePath }/images/musiccomments/mlogo.png"/></div>
						<p>Follow音乐,极致享受</p>
					</div>
					<!-- end info_left -->
					
					<!-- info_right start -->
					<div class="info_right">
					
						<div class="sname" sid="${song.id }">
							<div class="s_type">
								<span class="t_tag">${songtype.songtype }&nbsp;&nbsp;·</span>
							</div>
							<div class="s_name">${song.songname }</div>
						</div>
						
						<p class="p singer">歌手：<span>${song.singer }</span></p>
						
						<p class="p album">所属专辑：<span>${song.album }</span></p>
						
						<div class="control">
							<ul>
								<li><i class="comments"></i>(<span id="ccount">${count }</span>条评论)</li>
								<li><i class="like"></i>收藏</li>
								<li><i class="send"></i>分享</li>
								<li><i class="download"></i>下载</li>
							</ul>
						</div>
						
						<div class="lrc"></div>
						
					</div>
					<div style="clear: both;"></div>
					<!-- end info_right -->
					
				</div>
				<!-- end songinfo -->
				
				<!-- error start -->
				<div class="error">上传歌词&nbsp;报错</div>
				<!-- end error -->
				
				<!-- comments_list start -->
				<div class="comments_list">
				
					<div class="l_title">
						<span class="t_title">评论</span>
						<span class="t_count">共 <i>${count }</i> 条评论</span>
					</div>
					
					<!-- 发表评论框 start -->
					<div class="qq">
						<p class="q_title">对这首歌,你有什么看法？</p>
						
						<div class="q_meg" contentEditable="true"></div>
						
						<p class="q_face">
							<a onclick="return false" class="f_box">
								<img src="${basePath }/images/musiccomments/face/12.gif" alt="表情" width="22px" height="22px"/>
							</a>
							<a onclick="return false" class="btn">发布评论</a>
						</p>
						
						<div class="q_wb">
							<ul id="q_ul">
								<li><img src="${basePath }/images/musiccomments/face/1.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/2.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/3.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/4.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/5.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/6.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/7.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/8.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/9.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/10.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/11.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/12.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/13.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/14.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/15.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/17.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/18.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/19.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/20.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/21.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/22.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/23.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/24.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/25.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/26.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/28.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/29.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/30.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/31.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/32.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/33.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/34.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/35.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/36.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/37.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/38.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/39.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/40.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/41.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/42.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/43.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/44.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/45.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/46.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/47.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/48.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/49.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/50.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/51.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/52.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/53.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/54.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/55.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/56.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/57.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/58.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/59.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/60.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/61.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/62.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/63.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/64.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/65.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/66.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/67.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/68.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/69.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/70.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/71.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/72.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/73.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/74.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/75.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/76.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/77.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/78.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/79.gif" width="20" height="20"/></li>
								<li><img src="${basePath }/images/musiccomments/face/80.gif" width="20" height="20"/></li>
							</ul>
						</div>
						
					</div>
					<!-- end 发表评论框 -->
					
					<!-- all_comments start -->
					<div class="all_comments">
						<div class="ac_title">
							<span class="t_title">所有评论</span>
						</div>
						
						<div class="comments_box">
							<c:forEach items="${commentsList }" var="item">
								<div class="meg_box">
									<div class='m_list animated tada'>
										<div class="m_left"><a href='#'><img src='${basePath }/${item.userpicurl }' alt='头像' width='70' height='70'/></a></div>
										<div class="m_right">
											<div class="r_info"><a href='#' style='color:#27d5bf;margin-right:4px;'>${item.username }:</a>${item.comments }</div>
											<div class='r_time'>${item.createtime }</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						
					</div>
					<!-- end all_comments -->
					
					<!-- load start -->
					<div class="load">加载评论...</div>
					<!-- end load -->
					
				</div>
				<!-- end comments_list -->
				
			</div>
			<!-- end c_left -->
			
			<!-- c_right start -->
			<div class="c_right">
			
				<!-- sameLike start -->
				<div class="samelike">
					<h3 class="h3">
						<span>喜欢这首歌的人</span>
					</h3>
					<ul class="picul">
						<c:forEach items="${userlist }" var="item">
							<li>
								<a href="" title="${item.username }">
									<img src="${basePath }/${item.userpicurl}" width="40" height="40">
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- end sameLike -->
				
				<!-- containsong start -->
				<div class="containsong">
					<h3 class="h3">
						<span>包含这首歌的歌单</span>
					</h3>
					<ul class="yuedanul">
						<c:forEach items="${sendlist }" var="item">
							<li>
								<div class="y_left">
									<a href="#">
										<img src="${basePath }/${item.picurl}" width="50" height="50">
									</a>
								</div>
								<div class="y_right">
									<p class="r_title">
										<a href="#">${item.title}</a>
									</p>
									<p class="r_user">
										<span class="by">by</span>
										<a href="#">${item.user.username}</a>
									</p>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- end containsong -->
				
				<!-- samesong start -->
				<div class="samesong">
					<h3 class="h3">
						<span>相似的歌曲</span>
					</h3>
					<ul>
						<c:forEach items="${songlist }" var="item"  varStatus="idx">
							<li class="songlist">
								<div class="txt">
									<div class="songname" style="float:left;">
										<span>${idx.count }.</span><a href="#" style="margin-left:12px;">${item.songname }</a>
									</div>
									<div class="singer" style="float:right;"><span><a href="#">${item.singer }</a></span></div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- end samesong -->
				
			</div>
			<!-- end c_right -->
			
			<div style="clear: both;"></div>
		</div>
<jsp:include page="/commons/bottom.jsp"/>
<script type="text/javascript" src="${basePath }/js/head.js"></script>
<script type="text/javascript" src="${basePath }/js/dialog_login.js"></script>

<script type="text/javascript">
	
	// 点开页面就加载是否有歌词
	$(function(){
		var lrc = "${Lrc}";
		// 把时间和歌词分离出来
		if(lrc.trim() == ""){
			$(".lrc").html("<li>暂时没有歌词哦</li>");
		}else{
			var lrcArr = lrc.split("[");
			var htmlLrc = "";
			for(var i = 0; i < lrcArr.length; i++){
				// 第二次分割“]”
				var arr = lrcArr[i].split("]");
				// 取到时间
				var timer = arr[0].split(".");
				// 取到歌词
				var message = arr[1];
				// 取到分钟和秒
				var stime = timer[0].split(":");
				// 转换成秒数 00:18
				var ms = stime[0]*60 + stime[1]*1;
				if(message){
					htmlLrc += "<li id='"+ms+"'>"+message+"</li>";
				}
			}
			// 把解析好的歌词放入div中
			$(".lrc").html(htmlLrc);
		}
	});

	//展开表情图片和关闭
	$(".f_box").click(function(){
		$(".q_wb").toggle("200");//滚动执行
	});
	
	//点击表情图片
	$("#q_ul").find("li").click(function(){
		var img=$(this).find("img").clone();
		$(".q_meg").append(img);
		$(".q_wb").fadeOut();
	});
	
	//点击发布按钮
	$(".btn").click(function(){
		if($(".h-user .u-name b").text() != ""){
			var content=$(".q_meg").html();
			if(content=="")
			{
				$(".q_meg").focus();
				return;
			}else{
				// ajax();
				var sid = $(".sname").attr("sid");
				var comments = $(".qq .q_meg").html();
				var parameter = "sid="+sid+"&comments="+comments;
				sendRequest(basePath+"/user/addComments",parameter,callback_addcomments);
			}
		}else{
			$.dialog({which:"login"});
		}
	});
	
	function ajax(){
		var sid = $(".sname").attr("sid");
		var comments = $(".qq .q_meg").text();
		// ajax请求添加评论
		$.tzAjax.request({url:basePath+"/user/addComments",callback:function(data){
			if(data.result=="success"){
				$(".comments_box").append(html);
			}
		}},{"sid":sid,"comments":comments});
	}
	
	//1.创建XMLHttpRequest
	var xmlHttp;
	function createXMLHttpRequest()
	{
		if(window.XMLHttpRequest)
		{
			xmlHttp = new XMLHttpRequest();
		}
		else if(window.ActiveXObject)
		{
			try {
			xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
		} catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		}
	}

	//2.异步请求的方法
	function sendRequest(url,parameter,callback)
	{
		createXMLHttpRequest();
		//当准备状态发生变化时调用callBack()
		xmlHttp.onreadystatechange=callback;
		xmlHttp.open("POST",url, true);
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttp.send(parameter);
	}
	
	//3.回调方法
	function callback_addcomments()
	{
		if(xmlHttp.readyState==4)
		{
			if(xmlHttp.status==200)
			{
				var data = eval("("+xmlHttp.responseText+")");
				if(data.result=="success")
				{
					//2016-06-16 17:13:47.0
					var oDate = new Date(); //实例一个时间对象；
					var year = oDate.getFullYear();   //获取系统的年；
					var mon = oDate.getMonth()+1;   //获取系统月份，由于月份是从0开始计算，所以要加1
					if(Number(mon)<10){
						mon = "0"+mon;
					}
					var day = oDate.getDate(); // 获取系统日，
					if(Number(day)<10){
						day = "0"+day;
					}
					var h = oDate.getHours(); //获取系统时，
					if(Number(h)<10){
						h = "0"+h;
					}
					var m = oDate.getMinutes(); //分
					if(Number(m)<10){
						m = "0"+m;
					}
					var s = oDate.getSeconds(); //秒
					if(Number(s)<10){
						s = "0"+s;
					}
					var html=$("<div class='meg_box'>"+
								"			<div class='m_list animated tada'>"+
								"				<div class='m_left'><a href='#'><img src='"+basePath+"/${user.userpicurl}' alt='头像' width='70' height='70'/></a></div>"+
								"				<div class='m_right'>"+
								"					<div class='r_info'><a href='#' style='color:#27d5bf;margin-right:4px;'>${user.username}:</a>"+$(".q_meg").html()+"</div>"+
								"					<div class='r_time'>"+year+"-"+mon+"-"+day+" "+h+":"+m+":"+s+".0</div>"+
								"				</div>"+
								"			</div>"+
								"		</div>");
					$(".comments_box").append(html);
					// 弹出loading
					$.dialog({which:"loading",content:"评论成功..."});
					$(".qq .q_meg").text("");
					var count = $(".s_content .c_left .comments_list .l_title .t_count").find("i").text();
					var c = Number(count)+Number(1);
					$(".s_content .c_left .comments_list .l_title .t_count").find("i").text(c);
					$("#ccount").text(c);
				}
			}
		}
	}
	// 定义pn 每次点击加载后都自动加1.
	var pn = 2;
	
	// 点击加载评论
	$(".load").click(function(){
		// alert();
		// ajax异步的调用;
		var sid = $(".sname").attr("sid");
		var parameter = "sid="+sid+"&pn="+pn;
		sendRequest(basePath+"/user/loadComments",parameter,callback_loadcomments);
	});
	
	// 回调函数
	function callback_loadcomments()
	{
		if(xmlHttp.readyState==4)
		{
			if(xmlHttp.status==200)
			{
				var data = eval("("+xmlHttp.responseText+")");
				if(data.result=="success")
				{	var length = data.datamap.commentslist.length;
					for(var i = 0;i<length;i++){
						var html=$("<div class='meg_box'>"+
								"<div class='m_list animated tada'>"+
								"<div class='m_left'><a href='#'><img src='"+basePath+"/"+data.datamap.commentslist[i].userpicurl+"' alt='头像' width='70' height='70'/></a></div>"+
								"<div class='m_right'>"+
								"<div class='r_info'><a href='#' style='color:#27d5bf;margin-right:4px;'>"+data.datamap.commentslist[i].username+":</a>"+data.datamap.commentslist[i].comments+"</div>"+
								"<div class='r_time'>"+data.datamap.commentslist[i].createtime+"</div>"+
								"</div>"+
								"</div>"+
								"</div>");
						$(".comments_box").append(html);
					}
					window.location.hash="#ajaxpn="+pn;
					pn = Number(pn) + Number(1);
				}else{
					$.dialog({which:"loading",content:"数据全部加载完。"});
				}
			}
		}
	}

</script>
</body>