<%@ page language="java" import="java.util.*,com.momolela.util.*" pageEncoding="utf-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String lrc = MusicUtil.getLrcByRequest(request);
	out.print(lrc);
	
%>