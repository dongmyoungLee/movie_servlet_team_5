<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">어떤 영화에 출연진을 추가 하시겠어요 ?</h1>
<%--        <h1 style="text-align: center; color: #fff; font-size: 24px; margin-bottom: 25px">어떤 영화에 출연진을 삭제 하시겠어요 ?</h1>--%>
        <c:forEach items='${mainMovieList}' var="movie">
            <div class="menu_item"><a href="/showActorList?seq=${movie.getMovie_seq()}">${movie.getTitle()}</a></div>
        </c:forEach>
    </div>
</div>
</body>
</html>