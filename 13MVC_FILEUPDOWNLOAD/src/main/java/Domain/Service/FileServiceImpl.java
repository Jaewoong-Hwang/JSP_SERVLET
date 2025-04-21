package Domain.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import file.Properties;

public class FileServiceImpl {
	// 싱글톤 패턴
	private static FileServiceImpl instance;

	private FileServiceImpl() throws Exception {

		System.out.println("[SERVICE] FileServiceImpl init...");
	};

	public static FileServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new FileServiceImpl();
		return instance;
	}

	public boolean upload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		LocalDateTime now = LocalDateTime.now();
		// yyyyMMdd_HHmmss 폴더명
		String folderName = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		// 업로드 경로 설정
		String UploadPath = Properties.ROOT_PATH + File.separator // '/' 구분자임
				+ Properties.UPLOAD_PATH + File.separator + folderName + File.separator;

		// 디렉토리 생성(c:\\upload\\20250421_102933\\)
		File dir = new File(UploadPath);
		if (!dir.exists()) // 디렉토리가 있는지 확인
			dir.mkdirs(); // mkdirs s를 붙여야 상위폴더

		Collection<Part> parts = req.getParts();

		for (Part part : parts) {
			System.out.println("PART's NAME : " + part.getName());
			System.out.println("PART's SIZE : " + part.getSize());
			String contentDisp = part.getHeader("content-disposition");
			String[] tokens = contentDisp.split(";");
			String filename = tokens[2].trim().substring(10,tokens[2].trim().length()-1); // 공백 없애고, filename=" 다음부터 전체길이의 마지막 -1 까지
			System.out.println("contentDisp : " + contentDisp);
			System.out.println("tokens[2] : " + tokens[2]);
			System.out.println("tokens[2] : " + filename);
			
			part.write(UploadPath+filename); //디렉토리가 만들어지고 그 해당되는 곳에 파일이 들어갈 것임
			//파일 정보는 디렉토리 밖에 꺼내서 관리하는 게 일반적임
		}

		return true;
	}

	public Map<String,List<File>>getFileList() {
		Map<String,List<File>> map = new LinkedHashMap();
		String UploadPath = Properties.ROOT_PATH + File.separator // '/' 구분자임
				+ Properties.UPLOAD_PATH;
		
		File dir = new File(UploadPath);
		if(dir.exists()&&dir.isDirectory()) {
			
			File[]folders=dir.listFiles();//폴더찾기
			//Arrays.stream(folders).forEach(System.out::println); 
			for(File folder : folders) {  // 폴더
				File[] list =folder.listFiles();  //폴더 내 파일
				System.out.println("DIR : " + folder.getName());
				Arrays.stream(list).forEach(System.out::println); 
				map.put(folder.getName(), Arrays.stream(list).collect(Collectors.toList()) ); //뱌열을 리스트형으로 바꿈
				
			}
			
		}
		
		
		return map;
	}
}
