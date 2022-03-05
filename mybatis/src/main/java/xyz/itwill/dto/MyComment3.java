package xyz.itwill.dto;

// MYCOMMENT 테이블과 MYUSER 테이블의 검색결과를 저장하기 위한 클래스
// => 1:1 관계의 조인 검색결과를 저장하기 위한 클래스
	// MYUSER 테이블에서 필요한 정보만...
	// 일반적인 JOIN은 1:1 관계..
	// mybatis를 사용하는 이유는 JOIN 때문이라고 생각가능
public class MyComment3 {
	private int no;
	private String id;
	private String name;
	private String content;
	private String date;

	public MyComment3() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
