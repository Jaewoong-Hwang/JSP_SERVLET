<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // 콘솔창에서 사용자에게 행과 열을 입력받음
    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("단 입력: ");
    int dan = sc.nextInt();

    // 구구단 결과를 2차원 배열로 저장
    String[][] tableData = new String[9][1]; // 9행 1열

    for (int i = 0; i < 9; i++) {
        int result = dan * (i + 1);
        tableData[i][0] = dan + " x " + (i + 1) + " = " + result;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>구구단 테이블 출력</title>
    <style>
        table {
            border-collapse: collapse;
            margin-top: 20px;
        }
        td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

<h2><%= dan %>단 출력 결과</h2>

<table>
    <tbody>
    <%
        for (int i = 0; i < 9; i++) {
    %>
        <tr>
            <td><%= tableData[i][0] %></td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>