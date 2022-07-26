package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "main.do":
			controller = new MainController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "boardWrite.do":
			controller = new BoardWriterController();
			break;
		case "boardView.do":
			controller = new BoardViewController();
			break;
		case "boardDelete.do":
			controller = new BoardDeleteController();
			break;
		case "boardUpdateView.do":
			controller = new BoardUpdateViewController();
			break;
		case "boardUpdate.do":
			controller = new BoardUpdateController();
			break;
		case "boardLike.do":
			controller = new BoardLikeController();
			break;
		case "boardHate.do":
			controller = new BoardHateController();
			break;
		case "commentWrite.do":
			controller = new CommentWriteController();
			break;
		case "commentDelete.do":
			controller = new CommentDeleteController();
			break;
		case "boardCommentLike.do":
			controller = new CommentLikeControler();
			break;
		case "boardCommentHate.do":
			controller = new CommentHateControler();
			break;
		case "fileDown.do":
			controller = new FileDownControler();
			break;
		}
		
		return controller;
	}

}










