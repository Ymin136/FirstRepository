package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.BoardDTO;
import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = null;
		String content = null;
		String writer = null;
		int bno = 0;
		String encoding = "utf-8";
		File userRoot = new File("c:\\fileUpload\\");
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
			
			for(FileItem item : list) {
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "title":
						title = item.getString(encoding);
						break;
					case "content":
						content = item.getString(encoding);
						break;
					case "writer":
						writer = item.getString(encoding);
						break;
					}
				}else {
					if(item.getSize()>0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx == -1)
							idx = item.getName().lastIndexOf("/");						
						String fileName = item.getName().substring(idx + 1);
						File uploadFile = new File(userRoot + "\\" + fileName);
						if(!uploadFile.getParentFile().exists())
							uploadFile.getParentFile().mkdirs();
						fList.add(new FileDTO(uploadFile,0,fList.size()));
						item.write(uploadFile);
					}
				}
			}
			bno = BoardService.getInstance().selectBoardNo();
			//게시글 추가
			BoardDTO dto =  new BoardDTO(title,writer,content);
			dto.setBno(bno);
			BoardService.getInstance().insertBoard(dto);
			//파일 테이블에 업로드한 파일 정보를 저장
			for(FileDTO file : fList) {
				file.setBno(bno);
				BoardService.getInstance().insertFile(file);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("boardView.do?bno="+bno, true);
	}

}
