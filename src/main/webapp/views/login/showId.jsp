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
  <div class="loginBox" style="padding: 40px 20px 60px 20px">
    <h1> 당신의 아이디 </h1>
    <p class="smalltitletext"; style="color: deepskyblue">${id}</p>
    <br><br>
    <button class="blueboxstyle" onclick="goToLoginPage()"> 로그인하러가기 </button>
    <script>
      function goToLoginPage() {
        window.location.href = "/login";
      }
    </script>
  </div>
</div>
</body>
</html>