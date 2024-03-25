<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person List</title>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
    .button {
        display: inline-block;
        padding: 8px 15px;
        font-size: 14px;
        cursor: pointer;
        text-align: center;
        text-decoration: none;
        outline: none;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        box-shadow: 0 4px #0069d9;
    }

    .button:hover {background-color: #0056b3}

    .button:active {
        background-color: #0056b3;
        box-shadow: 0 2px #0056b3;
        transform: translateY(4px);
    }
</style>
</head>

<body>

    <h1>Add Person</h1>
    <form action="/save" method="post">
        Name: <input type="text" name="name"><br> 
        Age: <input type="text" name="age"><br> 
        Email: <input type="text" name="email"><br> 
        Memo: <textarea name="memo"></textarea><br>
        <input type="submit" value="Submit">
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
                    <td><span class="memo">${member.memo}</span></td> <!-- 이 부분 수정 -->
                    <td>
                        <a href="/edit?id=${member.id}" class="button">Edit</a>
                        <a href="#" class="button delete-button" data-id="${member.id}">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
        
    </table>

    <script>
        $(document).ready(function() {
            // 메모 클릭하여 복사
            $(".memo").click(function() {
                const memoText = $(this).text(); // 메모 내용 가져오기
                const tempInput = $("<textarea>"); // 임시 textarea 요소 생성
                $("body").append(tempInput); // body에 추가
                tempInput.val(memoText).select(); // textarea에 메모 내용 설정 및 선택
                document.execCommand("copy"); // 클립보드에 복사
                tempInput.remove(); // 임시 textarea 요소 제거
                alert("Memo copied to clipboard: " + memoText); // 복사된 메모 내용을 알림으로 표시
            });

            // 회원 삭제 확인 대화상자
            $(".delete-button").click(function() {
                var memberId = $(this).data("id");
                var confirmation = confirm("Are you sure you want to delete this member?");
                if (confirmation) {
                    window.location.href = "/delete?id=" + memberId;
                }
            });
        });
    </script>
</body>
</html>
