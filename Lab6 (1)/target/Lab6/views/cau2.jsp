<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Câu 2 - Tìm theo Từ Khóa</title>
  <style>body { font-family: Arial; margin: 20px; } table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; border: 1px solid #ddd; }</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<h2>Câu 2: Tìm các video được yêu thích chứa từ khóa tiêu đề</h2>
<form action="${pageContext.request.contextPath}/bai2/cau2" method="get">
  Nhập từ khóa tiêu đề: <input type="text" name="keyword" value="${param.keyword}"/>
  <button type="submit">Tìm</button>
</form>
<hr>
<table>
  <tr style="background: #e6f7ff;"><th>Mã Video</th><th>Tiêu đề</th><th>Lượt xem</th><th>Trạng thái</th></tr>
  <c:forEach var="v" items="${videos}">
    <tr><td>${v.id}</td><td>${v.title}</td><td>${v.views}</td><td>${v.active ? 'Hoạt động' : 'Khóa'}</td></tr>
  </c:forEach>
</table>
</body>
</html>