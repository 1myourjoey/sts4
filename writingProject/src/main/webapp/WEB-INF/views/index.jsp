<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    /* 추가적인 스타일링이 필요한 경우 여기에 작성하세요 */
</style>
</head>
<body class="d-flex justify-content-center align-items-center" style="height: 100vh;">
<div class="text-center">
    <h1>FIRST PAGE</h1>
    <form action="/userList" method="get">
        <div class="mb-3">
            <textarea class="form-control" rows="5" readonly>
                <%-- 서버 측 코드를 사용하여 데이터베이스에서 가져온 문단을 표시 --%>
                <c:forEach items="${fairyTaleList}" var="fairyTale">
                    ${fairyTale.title}
                    ${fairyTale.content}
                </c:forEach>
            </textarea>
        </div>
        
        <button type="submit" class="btn btn-primary">유저리스트</button>
    </form>
    
    <!-- recordList.jsp로 이동하는 버튼 추가 -->
    <form action="/recordList" method="get">
        <button type="submit" class="btn btn-secondary mt-3">Record List</button>
    </form>
    <div class="mb-3">
    <form action="/insertRecord" method="post">
        <input type="text" class="form-control" name="secondTextbox" placeholder="두 번째 텍스트 박스">
        <button type="submit" class="btn btn-success mt-2">데이터 삽입</button>
    </form>
</div>
</div>

<!-- 부트스트랩 자바스크립트 및 종속성 -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
