<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie_Team_5</title>
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/detail.css">
    <link rel="stylesheet" href="../style/login.css">
    <link rel="stylesheet" href="../style/find.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>

</head>
<body>
<%@include file="../layout/header.jsp"%>


<div class="loginWrap">
    <div class="loginBox" style="padding-bottom: 40px; padding-top: 30px;">
        <p class="smalltitletext"> 비밀번호 재설정 </p>
        <hr class="colored-line">
        <br>
        <br>
        <h1 style="font-size: 24px; line-height: 1.5;"> 비밀번호 재설정을 위해 <br>아래 정보를 입력하세요</h1>


        <form class="inputWrap">

            <div class="inputInnerWrap">
                <input placeholder="아이디"/>
                <input placeholder="이름"/>
                <input placeholder="휴대폰번호(번호만 입력)"/>
            </div>

            <div class="okayButtonArea">
                <input type="submit" value="확인" />
            </div>


        </form>
    </div>

</div>

</body>
</html>
