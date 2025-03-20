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
        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">ADMIN MENU</h1>
        <div class="menu_item"><a href="/addMovie">메인 슬라이드 영화 추가하기</a></div>
        <div class="menu_item"><a href="/addSubMovie">서브 슬라이드 영화 추가하기</a></div>
        <div class="menu_item"><a href="/addActor">배우 추가하기</a></div>
        <div class="menu_item"><a href="/showMovieList">영화 출연진 추가하기</a></div>
    </div>
</div>
</body>
</html>
