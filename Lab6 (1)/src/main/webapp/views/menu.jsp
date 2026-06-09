<%@ page pageEncoding="utf-8"%>
<style>
  .nav-menu {
    background-color: #333;
    padding: 10px;
    margin-bottom: 20px;
    font-family: Arial, sans-serif;
  }
  .nav-menu a {
    color: white;
    text-decoration: none;
    padding: 8px 15px;
    margin-right: 5px;
    display: inline-block;
    border-radius: 4px;
  }
  .nav-menu a:hover {
    background-color: #555;
  }
</style>

<div class="nav-menu">
  <a href="${pageContext.request.contextPath}/bai2/cau1">Câu 1: Tìm theo User</a>
  <a href="${pageContext.request.contextPath}/bai2/cau2?keyword=Java">Câu 2: Tìm theo Tiêu đề</a>
  <a href="${pageContext.request.contextPath}/bai2/cau3">Câu 3: Tìm theo Khoảng views</a>
  <a href="${pageContext.request.contextPath}/bai2/cau4?favorite=true">Câu 4: Lọc theo Trạng thái</a>
  <a href="${pageContext.request.contextPath}/bai2/cau5">Câu 5: Báo cáo tổng hợp</a>
</div>