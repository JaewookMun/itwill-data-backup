package xyz.itwill.dto;

//MYCOMMENT 테이블과 MYUSER 테이블의 검색결과를 저장하기 위한 클래스
//=> 1:1 관계의 조인 검색결과를 저장하기 위한 클래스
	// join을 할 때, 두 테이블에서 검색된 행들을 모두 저장하고 싶은 경우가 존재.
	// 이때, 컬럼값을 저장할 수 있는 필드를 따로 생성할 수 있다.
public class MyCommentUser1 {
	// 검색행의 게시글 정보(MYCOMMENT)를 저장하기 위한 필드
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;

	// 검색행의 회원 정보(MYUSER 테이블)를 저장하기 위한 필드
	private String userId;
	private String userName;
	
	public MyCommentUser1() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
