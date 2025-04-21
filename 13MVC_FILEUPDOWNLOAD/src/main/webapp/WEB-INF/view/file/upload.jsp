<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Page</title>
</head>
<body>

	<h1>FILE UPLOAD</h1>
	<form action="${pageContext.request.contextPath}/file/upload"
		method="post" enctype="multipart/form-data">
		<!-- method="post" 메소드는 무조건 post  
		     enctype="multipart/form-data"는 파일 업로드 시 필수 설정 -->
		<input type="file" name="files" multiple />
		<!-- multiple 속성으로 여러 개의 파일 업로드 허용 -->
		<button>업로드</button>
	</form>

	<hr>

	<style>
div {
	width: 300px;
	height: 200px;
	border: 1px solid;
}

.drag-block {
	display: flex;
	justify-content: left;
	align-items: center;
	flex-wrap: wrap;
	width: 100%;
	height: 100%;
}

.d4 {
	width: 500px;
	height: 500px;
	padding: 10px;
	border: 5px dashed gray;
	position: relative;
	color: gray;
}

.d4::after {
	content: "+";
	font-size: 7rem;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0;
	width: 100%;
	height: 100%;
	position: relative;
	top: -20px;
}

.preview {
	width: 150px;
	height: 500px;
	border: 1px solid;
	padding: 10px;
	display: flex;
	justify-content: start;
	align-items: center;
	overflow-y: auto;
	overflow-x: hidden;
	gap: 5px;
	flex-direction: column;
}

.preview::-webkit-scrollbar {
	display: none;
}
</style>

	<a href="javascript:void(0)" class="image-upload-btn">업로드</a>
	<div class="drag-block">
		<div class="d4"></div>
		<div class="preview"></div>
	</div>

	<!-- axios CDN -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.8.4/axios.min.js"
		integrity="sha512-2A1+/TAny5loNGk3RBbk11FwoKXYOMfAK6R7r4CpQH7Luz4pezqEGcfphoNzB7SM4dixUoJsKkBsB6kg+dNE2g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script>
	let formData = new FormData(); // 전역 선언
	const maxSize = 1024 * 1024 * 1; // 1MB

	// 유효성 체크
	function isValid(file) {
		if (!file.type.startsWith("image/")) {
			alert("이미지 파일만 업로드 가능합니다.");
			return false;
		}
		if (file.size > maxSize) {
			alert("파일 크기는 1MB 이내여야 합니다.");
			return false;
		}
		return true;
	}

	const d4El = document.querySelector('.d4');
	const previewEl = document.querySelector('.preview');

	d4El.addEventListener('dragenter', e => {
		e.preventDefault();
	});

	d4El.addEventListener('dragover', e => {
		e.preventDefault();
		d4El.style.border = "5px dashed lightgray";
		d4El.style.color = "lightgray";
	});

	d4El.addEventListener('dragleave', e => {
		e.preventDefault();
		d4El.style.border = "5px dashed gray";
		d4El.style.color = "gray";
	});

	d4El.addEventListener('drop', e => {
		e.preventDefault();
		d4El.style.border = "5px dashed gray";
		d4El.style.color = "gray";

		const files = e.dataTransfer.files;

		// formData 초기화
		formData = new FormData();

		// 기존 미리보기 삭제
		previewEl.innerHTML = "";

		for (let i = 0; i < files.length; i++) {
			const file = files[i];

			if (!isValid(file)) continue;

			// FormData에 추가
			formData.append("files", file);

			// 미리보기 생성
			const newImgEl = document.createElement('img');
			newImgEl.src = URL.createObjectURL(file);
			newImgEl.setAttribute('style', 'width:100%;height:100%;object-fit:contain;height:150px;border:1px solid;padding:2px;');
			previewEl.prepend(newImgEl);
		}
	});

	const imageUploadBtnEl = document.querySelector(".image-upload-btn");
	const path = '${pageContext.request.contextPath}';

	imageUploadBtnEl.addEventListener('click', () => {
		console.log("image-upload-btn clicked...");

		if (formData.has("files")) {
			axios.post(path + "/file/upload", formData, {
				headers: {
					'Content-Type': 'multipart/form-data'
				}
			})
			.then(resp => {
				console.log("Upload Success:", resp);
				alert("업로드 성공!");
			})
			.catch(error => {
				console.error("Upload Error:", error);
				alert("업로드 실패");
			});
		} else {
			alert("업로드할 파일을 먼저 선택해주세요.");
		}
	});
	</script>

</body>
</html>
