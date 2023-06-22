<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN PAGE</title>
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/detail.css">
    <link rel="stylesheet" href="../style/login.css">
</head>
<body>
<%@include file="../layout/header.jsp"%>

<div class="loginWrap">
    <div class="loginBox_admin">
<%--        admin으로 로그인하면 ADMIN MENU가 활성화 --%>
        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">ADMIN MENU</h1>
<%--            /addMovie를 실행 => web.xml에 있는 <url-pattern>/addMovie</url-pattern>을 호출하여 AddMainMovieServlet으로 이동 --%>
        <div class="menu_item"><a href="/addMovie">메인 슬라이드 영화 추가하기</a></div>
<%--            /addSubMovie를 실행 --%>
        <div class="menu_item"><a href="/addSubMovie">서브 슬라이드 영화 추가하기</a></div>
<%--            /addActor를 실행 --%>
        <div class="menu_item"><a href="/addActor">배우 추가하기</a></div>
<%--            /showMovieList --%>
        <div class="menu_item"><a href="/showMovieList">영화 출연진 추가하기</a></div>
    </div>
</div>
</body>
</html>
