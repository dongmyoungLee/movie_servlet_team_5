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
        <p class="smalltitletext" style="margin-bottom: 0;"> 비밀번호 재설정 </p>
        <br>
        <br>
        <h1 style="font-size: 24px; line-height: 1.5;"> 신규 비밀번호를 <br> 입력하세요</h1>
        <form method="post" action="/setPassword" class="inputWrap">
            <div class="inputInnerWrap">
                <input style="display: none" name="userId" value="${updatePwId}" />
                <input name="newPassword" type="password" placeholder="신규 비밀번호"/>
                <input name="confirmPassword" type="password" placeholder="신규 비밀번호 재입력"/>
            </div>
            <div class="errorblink">
                <% String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) { %>
                <%= errorMessage %>
                <% } %>
            </div>
            <div class="okayButtonArea">
                <input type="submit" value="확인"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>