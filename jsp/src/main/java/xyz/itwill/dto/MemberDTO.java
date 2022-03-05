package xyz.itwill.dto;

/*
이름         널?       유형            
---------- -------- ------------- 
ID         NOT NULL VARCHAR2(20)   - 아이디
PASSWD              VARCHAR2(200)  - 비밀번호
NAME                VARCHAR2(20)   - 이름
EMAIL               VARCHAR2(30)   - 이메일
MOBILE              VARCHAR2(20)   - 전화번호
ZIPCODE             VARCHAR2(10)   - 우편번호
ADDRESS1            VARCHAR2(200)  - 기본주소
ADDRESS2            VARCHAR2(50)   - 상세주소
JOIN_DATE           DATE           - 회원가입날짜
LAST_LOGIN          DATE           - 마지막 로그인 날짜
STATUS              NUMBER(1)      - 회원상태 : 1(일반회원), 9(관리자)
 */
	// 화면에 보이는 내용만이 아니라 기능 구현을 위해 필요한 정보를 저장하는 컬럼 또한 필요 
	// e.g. LAST_LOGIN : 휴면게좌 관리 등의 기능 구현
	// -> 법적으로 쇼핑몰에서는 6개월 이상 사용하지 않으면 휴면계정 처리해야함. (그렇지 않으면 벌금)
	// 언더바('_')를 이용하는 스네이크 표기법을 DB에서 이용했을 때
	// 자바에서는 카멜표기법을 사용하여 컬럼명 표기 가능   e.g. join_date  -> joinDate

public class MemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String mobile;
	private String zipcode;
	private String address1;
	private String address2;
	private String joinDate;
	private String lastLogin;
	private int status;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
