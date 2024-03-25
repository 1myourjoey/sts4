<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Member</title>
</head>
<body>
    <h1>Edit Member</h1>
    
    <%-- 해당 멤버의 정보를 표시하는 부분 --%>
    <form action="/update" method="post">
        <%-- 각 필드의 값을 편집할 수 있는 입력란 --%>
        <input type="hidden" name="id" value="${member.id}">
        Name: <input type="text" name="name" value="${member.name}"><br>
        Age: <input type="text" name="age" value="${member.age}"><br>
        Email: <input type="text" name="email" value="${member.email}"><br>
        Memo: <textarea name="memo">${member.memo}</textarea><br>
        <input type="submit" value="Update">
    </form>
    
    
<hr>

    <h1>Person List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Memo</th>
                <th>Action</th> <!-- 수정 및 삭제 버튼을 위한 열 추가 -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${members}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.age}</td>
                    <td>${member.email}</td>
                    <td>${member.memo}</td>
                    <td>
                        <a href="/edit?id=${member.id}" class="button">Edit</a> <!-- 수정 버튼 -->
                        <a href="/delete?id=${member.id}" class="button">Delete</a> <!-- 삭제 버튼 -->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
