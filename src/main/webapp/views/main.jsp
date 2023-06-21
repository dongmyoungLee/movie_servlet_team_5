<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Movie_Team_5</title>
  <link rel="stylesheet" href="../style/reset.css">
  <link rel="stylesheet" href="../style/main.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>
<body>
<%@include file="layout/header.jsp"%>
<main>
  <div class="swiper">
    <div class="swiper-wrapper">
      <c:forEach items='${movieList}' var="movie">
              <div style="background-image: url(${movie.getPoster_image()})" class="swiper-slide swiper-slide--one">
                <img style="height: 100%" src="${movie.getText_image()}"/>
              </div>
      </c:forEach>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
  </div>
</main>
<section>
  <div class="section_center_wrap">
    <p>오늘은 불 켜고 자야지...☆</p>
    <div class="swiper-container mySwiper">
      <div class="swiper-wrapper">
        <c:forEach items="${horrorList}" var="horror">
          <div style="background-image: url(${horror.getDetail_image()})" class="swiper-slide"></div>
        </c:forEach>
      </div>
      <div class="swiper-pagination"></div>
    </div>
  </div>
</section>

<section>
  <div class="section_center_wrap">
    <p>절대 주인공이 되고 싶지 않은 세계관</p>
    <div class="swiper-container mySwiper">
      <div class="swiper-wrapper">
        <c:forEach items="${actionList}" var="action">
          <div style="background-image: url(${action.getDetail_image()})" class="swiper-slide"></div>
        </c:forEach>
      </div>
      <div class="swiper-pagination"></div>
    </div>
  </div>
</section>


<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="../js/main.js"></script>
</body>
</html>