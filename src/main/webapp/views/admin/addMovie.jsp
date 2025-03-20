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
  <div class="loginBox" style="padding-bottom: 5px">
    <h1>영화 추가</h1>
    <h2>Wavve 영화 추가하기</h2>

    <form action="/addMovie" method="post" class="inputWrap">
      <div class="inputInnerWrap" style="margin-bottom: 25px;">
        <input name="title" placeholder="영화 이름" />
        <input name="release_date" placeholder="영화 개봉일" />
        <input name="duration" placeholder="영화 상영시간" />
        <input name="description" placeholder="영화 설명" />
        <input name="rating" placeholder="영화 나이제한" />
        <input name="genre" placeholder="영화 장르" />
        <input name="director" placeholder="영화 감독" />
        <input name="link" placeholder="영화 링크(youtube)" />
        <input name="poster_image" placeholder="영화 메인 포스터 이미지" />
        <input name="text_image" placeholder="영화 메인 텍스트 이미지" />
        <input name="detail_image" placeholder="영화 디테일 포스터 이미지" />
        <input name="detail_text_image" placeholder="영화 디테일 텍스트 이미지" />
      </div>

      <div class="loginBtnArea">
        <input type="submit" value="추가하기" />
      </div>

    </form>
  </div>
</div>
</body>
</html>
