package file;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.FileServiceImpl;

public class ListController implements SubController{

private FileServiceImpl fileService;
	
	public ListController() throws Exception{
		
		fileService = FileServiceImpl.getInstance();
	
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
		
		//get
//			if(req.getMethod().equals("GET")) {
//				req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
//				return;
//				
//			}
			
			
			//파라미터
			
			//유효성
			
			//서비스
			Map<String,List<File>> map= fileService.getFileList();
			
			//뷰
			req.setAttribute("map", map);
			req.getRequestDispatcher("/WEB-INF/view/file/list.jsp").forward(req, resp);
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		
	}

}
