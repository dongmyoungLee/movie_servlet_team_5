<%--
  Created by IntelliJ IDEA.
  User: playdata
  Date: 2023-06-20
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Movie_Team_5</title>
  <link rel="stylesheet" href="../../style/reset.css">
  <link rel="stylesheet" href="../../style/detail.css">
  <link rel="stylesheet" href="../../style/edit.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>
<body>
  <%@include file="../layout/header.jsp"%>
  <!--여기서부터 시작-->
  <div class="edit_layout">
    <div class="info_box">

      <h1>회원 정보 수정 페이지 입니다.</h1>
      <form method="post" action="/edit">
        <table class="info_table">
          <tr>
            <th>이름</th>
            <td><input name="userName" type="text" value="${userName}"></td>
          </tr>
          <tr>
            <th>이메일</th>
            <td><input name="email" type="text" value="${email}"></td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input name="password" type="password" value="${password}"></td>
          </tr>
          <tr>
            <th>생년월일</th>
            <td><input name="birthDay" type="text" placeholder="생년월일" value="${birthday}"></td>
          </tr>
          <tr>
            <th>휴대폰 번호</th>
            <td><input name="phoneNumber" type="text" placeholder="(선택) 안넣어도 됩니다." value="${phoneNumber}"></td>
          </tr>
        </table>

        <div class="btn_box">
          <button> 취소</button>
          <input type="submit" value="수정">
        </div>

      </form>

    </div>
    <div style="text-align: right">
      <a id="edit_leave_txt" >회원탈퇴 ></a>
    </div>

  </div>
</body>
</html>
