package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class FileDownControler implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		FileDTO dto = BoardService.getInstance().selectFile(bno,fno);
		String path = dto.getPath();
		String fileName = dto.getFileName();
		File file = new File(path);
		
		FileInputStream fis = new FileInputStream(file);
		String encodingName=URLEncoder.encode(path,"utf-8");
		fileName = URLEncoder.encode(fileName,"utf-8");
		fileName = fileName.replace("+", " ");
		response.setHeader("Content-Disposition", "attachement;fileName="+fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int)file.length());
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024*1024];
		
		while(true) {
			int size = fis.read(buffer);
			bos.write(buffer,0,size);
			bos.flush();
			if(size == - 1) break;
		}
		fis.close();
		bos.close();
		return null;
	}

}
