//head.js
var staut1 = 1;//1代表没有，0代表有
var staut2 = 1;//1代表没有，0代表有

//点击展开喜欢的音乐列表
$(".u-name").click(function(e){
	if(e&&e.stopPropagation){e.stopPropagation();}else{window.event.cancelBubble = true;}
	if(staut1 == 1){
		$(this).parent().find("i").css("background-position","-194px -55px");
		$(".h-user .u-xiala").slideDown();
		staut1 = 0;
	}
	else if(staut1 == 0){
		$(this).parent().find("i").css("background-position","-194px -67px");
		$(".h-user .u-xiala").slideUp();
		staut1 = 1;
	}
});

//点击搜索跳转
$(".m-top .t-head .h-search a").click(function(){
	var _texts = document.getElementsByTagName('input');
	var len = _texts.length;
	var _total = '';
	for(var i=0;i<len;i++){
		if(_texts[i].type == 'text'){
    		_total += _texts[i].value;
    	}
	}
	if(_total=="")
	{
		$(".textinput").focus();
		$(".textinput").css("box-shadow","inset 0px 0px 10px rgba(0,0,0,.3)");
		return;
	}
	else
	{
		// 待开发
		// window.location.href="http://www.baidu.com/s?wd="+_total;
	}
});

//点击我的音乐盒
function login(){
	if($(".h-user .u-name b").text() != ""){
		/* var url = "${basePath }/page/musicbox.jsp";
		window.open(url); */
		window.open(basePath+"/to/page/toMusicbox");
	}else{
		$.dialog({which:"login"});
	}
}

//点击登录显示登录页面
$(".l_login").click(function(){
	$.dialog({which:"login"});
});

//点击注册显示登录页面
$(".l_register").click(function(){
	$.dialog({which:"register"});
});

//验证码换图片的函数
function changeCheckCode(){
	var src = basePath+"/checkcode?haha="+Math.random();
	$(".checkcode").find("img").attr("src",src);
}

// 跳转到我的信息页面
function toMyInfo(){
	$(".u-xiala").hide();
	$(".u-name").parent().find("i").css("background-position","-194px -67px");
	staut1 = 1;
	window.location.href=basePath+"/to/page/toUserInfo";
}

// 跳转到我的信息页面
function toMyMusic(){
	$(".u-xiala").hide();
	$(".u-name").parent().find("i").css("background-position","-194px -67px");
	staut1 = 1;
	window.location.href=basePath+"/page/UserMusic.jsp";
}
var dataarray = new Array()
var sidarray = new Array()
// 搜索框，搜索当键盘按下值的时候触发
$(".m-top .t-head .h-search .textinput").keyup(function(){
	$.ajax({
		type:"post",
		url:basePath+"/user/getSong",
		success:function(data){
			var data = eval(data);
			var allsonglist = data.datamap.songlist;
			// alert(allsonglist);
			for(var i=0;i<allsonglist.length;i++)
			{	
				dataarray[i] = allsonglist[i].singer+"-"+allsonglist[i].songname+".mp3";
				sidarray[i] = allsonglist[i].id;
			}
		}
	});
	
	//获取文本框的值
	var value = $(this).val();

	$(".m-top .t-head .h-search .s_xiala").empty();
	$(".m-top .t-head .h-search .s_xiala").show();
	
	
	for(var i=0;i<dataarray.length;i++){
		
		if(dataarray[i].trim().indexOf(value)!=-1){
			//关键词的搜索
			$(".m-top .t-head .h-search .s_xiala").prepend("<div class='s_ul' onclick='toSong(this)' data-sid='"+sidarray[i]+"'>"+dataarray[i]+"</div>");
		}
	}
	
	if(value==""){
		$(".m-top .t-head .h-search .s_xiala").hide();
	}
	
});

function toSong(obj){
	var sid = $(obj).attr("data-sid");
	var url = basePath+"/to/musiccomments?sid="+sid+"&pn=1";
	window.open(url);
	$(".m-top .t-head .h-search .s_xiala").hide();
}