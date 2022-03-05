package xyz.itwill.io;

import java.io.Serializable;

//회원정보(아이디,이름,전화번호)를 저장하기 위한 클래스
//=> 객체 단위로 입력 또는 출력 처리되는 클래스는 반드시 객체 직렬화 클래스로 선언
//객체 직렬화(Object Serialization) : 인스턴스를 byte 배열(원시 데이터 모임)로 변환하여
//입력 또는 출력 하는 기능을 제공

//객체 직렬화 클래스로 선언하는 방법
//1. java.io.Serializable 인터페이스를 상속받아 선언
//=> 인스턴스의 모든 필드값을 byte 배열로 변환하여 입력 또는 출력하는 기능 제공
//2. java.io.Externalizable 인터페이스를 상속받아 선언
//=> 인터페이스의 추상 메소드를 오버라이드 선언하여  입력 또는 출력에 대한 필드값 변환 처리
//=> 인스턴스의 특정 필드값을 byte 배열로 변환하여 입력 또는 출력하는 기능 제공

//객체 직렬화 클래스는 클래스를 구분하기 위해 고유값을 부여하는 필드(serialVersionUID)를 선언하는 것을 권장
//=> 이클립스에서는  serialVersionUID 필드값을 자동으로 생성하는 기능 제공
	//기본자료형은 크기가 정해져 있으나 인스턴스는 크기가 정해져 있지 않기 때문에 어디에서 끊어져야하는지 알 수 없다.
	//e.g. 스트림에서 기본형은 int라면 원시 데이터 4개 (4byte)로 나누어 보낼 수 있음.
	//Member는 Member로 만들어진 인스턴스의 바이트 크기가 얼마인지 알 수 없음.
	//몇 Byte짜리 바이트배열로 보낼지 알려주는 작업을 객체 직렬화라고 이야기한다.
	//Serializable를 상속받는 것이 보편적 방법 (Externalizable은 특별한 경우)
	//Externalizable는 원하는 필드만 보내거나 받을 수 있다. - 전달해야하는 값들이 많을 떄(필드가 많을 때)
	//클래스를 구분하면 나중에 형변환할 때 도움
	//serialVersionUID 필드를 안만들어도 에러는 발생하지 않으나 만들어야 입출력 속도 상승.
	//객체단위 입출력 x - defualt
	//객체단위 입출력   - generated serial version ID
public class Member implements Serializable {
	private static final long serialVersionUID = 3461321862275769514L;
	private String id;
	private String name;
	private String phone;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "아이디 = "+id+", 이름 = "+name+", 전화번호 = "+phone;
	}
	
}
