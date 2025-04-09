<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
:root {
	
}

html {
	
}

* {
	box-sizing: border-box;
}

body {
	padding: 0;
	margin: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

.wrapper {
	
}

.wrapper>header {
	height: 80px;
}

.wrapper>nav {
	height: 50px;
}

.wrapper>main {
	height: calc(100vh - 80px - 50px - 80px);
	overflow: auto;
}

.wrapper>main h2 {
	text-align: center;
	font-size: 1.8rem;
	font-weight: 400;
}

.wrapper>main table {
	border: 1px solid;
	border-collapse: collapse;
	min-width: 500px;
	min-height: 350px;
	margin: 0 auto;
}

.wrapper>main table th, .wrapper>main table td {
	min-width: 80px !important;
	min-height: 25px !important;
	border: 1px solid;
	text-align: center;
}

.wrapper>main table th {
	background-color: lightgray;
}

.wrapper>footer {
	height: 80px;
}
</style>


</head>
<body>

	<%@page import="Utils.*,java.util.*"%>
	<%
	//모든 회원정보 가져오기
	List<MemberDto> member_list = DBUtils.getInstance().selectAllMember();

	//모든 강사정보 가져오기
	List<TeacherDto> teacher_list = DBUtils.getInstance().selectAllTeacher();
	%>

	<div class="wrapper">
		<!--  -->
		<%@include file="/layouts/Header.jsp"%>

		<!--  -->
		<%@include file="/layouts/Nav.jsp"%>

		<main>

			<h2>수강신청</h2>
			<form action="./create.jsp" name="registForm" onsubmit="return false">
				<table>
					<tr>
						<td>수강월</td>
						<td><input name="regist_month" /></td>
					</tr>
					<tr>
						<td>회원명</td>
						<td><select name="c_name">
								<option value="">회원명</option>
								<%
								for (MemberDto dto : member_list) {
								%>
								<option data-no=<%=dto.getC_no()%> value=<%=dto.getC_name()%>><%=dto.getC_name()%></option>

								<%
								}
								%>
						</select></td>
					</tr>
					<tr>
						<td>회원번호</td>
						<td><input name="c_no" /></td>
					</tr>
					<tr>
						<td>강의장소</td>
						<td><input name="class_area" /></td>
					</tr>
					<tr>
						<td>강의명</td>
						<td><select name="class_name">
								<option>강의선택</option>
								<%
								for (TeacherDto dto : teacher_list) {
								%>
								<option data-teacherCode=<%=dto.getTeacher_code()%> data-price=<%=dto.getClass_price()%>
									value=<%=dto.getClass_name()%>><%=dto.getClass_name()%></option>

								<%
								}
								%>


						</select></td>
					</tr>
					<tr>
						<td>수강료</td>
						<td>
						<input name="tuition" />
						<input type="hidden" name="teacher_code" />
						</td>
					</tr>
					<tr>
						<td colspan=2>
							<button type="submit" onclick="isValid()">수강신청</button>
							<button onclick="resetFunc()">다시쓰기</button>
						</td>
					</tr>
				</table>
			</form>
		</main>

		<!--  -->
		<%@include file="/layouts/Footer.jsp"%>

	</div>

	<script>
		const form = document.registForm;
		//Select onchange Event
		let cno;
		let price;

		form.c_name.addEventListener('change', function(e) {
			const selectEl = e.target;
			const seletedOption = selectEl.options[selectEl.selectedIndex];
			cno = seletedOption.getAttribute("data-no")
			console.log(e.target.value, cno);
			form.c_no.value = cno;

			//회원명을 선택함에 따라 가격도 바뀌게 함
			if (price != null || price != undefined) {
				if (cno < 20000)
					form.tuition.value = price;
				else
					form.tuition.value = (price / 2);
			}
		})

		form.class_name.addEventListener('change', function(e) {
			const selectEl = e.target;
			const seletedOption = selectEl.options[selectEl.selectedIndex];
			price = seletedOption.getAttribute("data-price")
			const teacherCode = seletedOption.getAttribute("data-teacherCode")
			form.teacher_code.value=teacherCode;
			console.log(e.target.value, price, teacherCode);

			if (cno < 20000)
				form.tuition.value = price;
			else
				form.tuition.value = (price / 2);

		

		});

		function isValid() {
			if (form.regist_month.value === "") {
				alert("수강월을 입력하세요 ex)202501")
				form.regist_month.focus();
				return;
			}
			if (form.c_name.value === "") {
				alert("회원명을 선택하세요")
				form.regist_month.focus();
				return;
			}
			
			form.submit();
		}
		

		function resetFunc() {
			alert("다시쓰기 합니다!");
			form.reset();
		}
	</script>

</body>
</html>