<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Câu 1 - Tìm theo User</title>
  <style>body { font-family: Arial; margin: 20px; } table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; border: 1px solid #ddd; text-align: left; }</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<h2>Câu 1: Tìm các video được yêu thích theo người sử dụng</h2>
<form action="${pageContext.request.contextPath}/bai2/cau1" method="get">
  Nhập Username: <input type="text" name="username" value="${param.username}"/>
  <button type="submit">Tìm kiếm</button>
</form>
<hr>
<c:if test="${not empty message}"><p style="color: red;">${message}</p></c:if>
<c:if test="${not empty user}">
  <h3>Kết quả cho tài khoản: ${user.fullname} (${user.email})</h3>
  <table>
    <tr style="background: #f2f2f2;"><th>Mã Video</th><th>Tiêu đề Video</th><th>Ngày thích</th></tr>
    <c:forEach var="fav" items="${favorites}">
      <tr><td>${fav.video.id}</td><td>${fav.video.title}</td><td>${fav.likeDate}</td></tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>