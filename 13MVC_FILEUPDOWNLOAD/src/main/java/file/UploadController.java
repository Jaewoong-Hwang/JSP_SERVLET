package file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Service.FileServiceImpl;

public class UploadController implements SubController{

	private FileServiceImpl fileService;
	
	public UploadController() throws Exception{
		
		fileService = FileServiceImpl.getInstance();
	
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
		
		//get
			if(req.getMethod().equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/file/upload.jsp").forward(req, resp);
				return;
				
			}
			
			
			//파라미터
			
			//유효성
			
			//서비스
			boolean isUpload= fileService.upload(req,resp);
			
			//뷰
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		
	}

}
