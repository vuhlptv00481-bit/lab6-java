<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Câu 5 - Báo cáo Thống kê</title>
  <style>body { font-family: Arial; margin: 20px; } table { border-collapse: collapse; width: 100%; } th, td { padding: 8px; border: 1px solid #ddd; text-align: center; }</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<h2>Câu 5: Tổng hợp số lượt thích từng video (Report)</h2>
<hr>
<table>
  <tr style="background: #fff0f6;">
    <th>Tiêu đề Video</th>
    <th>Tổng số lượt thích</th>
    <th>Ngày thích mới nhất</th>
    <th>Ngày thích cũ nhất</th>
  </tr>
  <c:forEach var="rep" items="${reports}">
    <tr>
      <td style="text-align: left;">${rep.group}</td>
      <td><span style="color: blue; font-weight: bold;">${rep.likes}</span></td>
      <td>${rep.newest}</td>
      <td>${rep.oldest}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>