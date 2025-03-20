<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>AI 가 추천해주는 영화</title>
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/detail.css">
    <link rel="stylesheet" href="../style/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>
<body>
<%@include file="layout/header.jsp"%>
<div class="loginWrap">
    <div class="loginBox" style="padding-bottom: 15px">
        <h2>추천 받고 싶은 영화를 입력하세요</h2>

        <form class="inputWrap" action="/ai" method="post">
            <div class="inputInnerWrap">
                <input placeholder="추천 받고 싶은 영화 컨텐츠" name="text" />
            </div>

            <div class="loginBtnArea">
                <input type="submit" value="추천받기" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
