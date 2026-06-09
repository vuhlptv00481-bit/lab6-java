<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Câu 4 - Trạng thái Yêu thích</title>
  <style>body { font-family: Arial; margin: 20px; } table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; border: 1px solid #ddd; }</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<h2>Câu 4: Hiển thị các video theo trạng thái yêu thích</h2>
<a href="${pageContext.request.contextPath}/bai2/cau4?favorite=true">[ Xem video đã người thích ]</a> |
<a href="${pageContext.request.contextPath}/bai2/cau4?favorite=false">[ Xem video chưa có người thích ]</a>
<hr>
<h3>Danh sách kết quả (Trạng thái lựa chọn: ${param.favorite == 'true' ? 'Đã thích' : 'Chưa thích'}):</h3>
<table>
  <tr style="background: #fff7e6;"><th>Mã Video</th><th>Tiêu đề</th><th>Số lượt xem</th></tr>
  <c:forEach var="v" items="${videos}">
    <tr><td>${v.id}</td><td>${v.title}</td><td>${v.views}</td></tr>
  </c:forEach>
</table>
</body>
</html>