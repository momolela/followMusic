<%@ page language="java" import="java.util.*,com.momolela.util.GetSong" pageEncoding="utf-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String result = (new GetSong()).getSong();
	out.print(result);
	
%>
