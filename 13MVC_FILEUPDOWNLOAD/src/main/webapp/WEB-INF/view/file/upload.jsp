<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>FILE UPLOAD</h1>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">   <!--method="post" 메소드는 무조건 post 
																											enctype="multipart/form-data" 파일 업로드에 필수!!  -->
 <input type="file" name="files" multiple /> <!--multiple 여러개의 파일을 올릴 수 있음  -->
 <button>업로드</button>


</form>

</body>
</html>