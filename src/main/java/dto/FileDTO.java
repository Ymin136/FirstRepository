package dto;

import java.io.File;

public class FileDTO {
	private String path;
	private String fileName;
	private String type;
	private int bno;
	private int order;
	
	public FileDTO(String path, String fileName, String type, int bno, int order) {
		super();
		this.path = path;
		this.fileName = fileName;
		this.type = type;
		this.bno = bno;
		this.order = order;
	}
	
	
	public FileDTO() {
	}
	public FileDTO(File file, int bno, int order) {
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		//파일 확장자 뽑는 부분
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()){
		case "png":
		case "bmp":
		case "gif":
		case "jpg":
			this.type = "image";
			break;
		default:
			this.type="normal";
		}
		this.bno = bno;
		this.order=order;
	}


	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		File file = new File(path);
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		//파일 확장자 뽑는 부분
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()){
		case "png":
		case "bmp":
		case "gif":
		case "jpg":
			this.type = "image";
			break;
		default:
			this.type="normal";
		}
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "FileDTO [path=" + path + ", fileName=" + fileName + ", type=" + type + ", bno=" + bno + ", order="
				+ order + "]";
	}
}
