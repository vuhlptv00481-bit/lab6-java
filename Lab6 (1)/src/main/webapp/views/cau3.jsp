<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Câu 3 - Người dùng thích Video</title>
  <style>body { font-family: Arial; margin: 20px; } table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; border: 1px solid #ddd; }</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<h2>Câu 3: Tìm những người sử dụng thích video</h2>
<form action="${pageContext.request.contextPath}/bai2/cau3" method="get">
  Nhập mã Video ID: <input type="text" name="videoId" value="${param.videoId}"/>
  <button type="submit">Xem danh sách</button>
</form>
<hr>
<c:if test="${not empty message}"><p style="color: red;">${message}</p></c:if>
<table>
  <tr style="background: #f6ffed;"><th>Username</th><th>Họ và tên</th><th>Email</th><th>Vai trò</th></tr>
  <c:forEach var="u" items="${users}">
    <tr><td>${u.id}</td><td>${u.fullname}</td><td>${u.email}</td><td>${u.admin ? 'Admin' : 'User'}</td></tr>
  </c:forEach>
</table>
</body>
</html>