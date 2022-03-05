package xyz.itwill.util;

//Object 타입의 필드가 선언된 클래스로 인스턴스를 생성하여 사용하는 프로그램
//=> Object 타입의 필드에는 모든 클래스의 인스턴스를 전달하여 저장 가능
//=> Object 타입의 필드에 저장된 인스턴스를 반환받아 사용할 경우 반드시 명시적 객체 형변환 후 사용
	//저장하는것은 편리한데 저장된 인스턴스를 이용하는 것은 불편하다.
	//저장은 편하게 & 반환은 명시적 객체 형변환
public class NonGenericApp {
	public static void main(String[] args) {
		NonGeneric nonGeneric1=new NonGeneric();
		
		//Integer 인스턴스를 매개변수에 전달하여 Object 타입의 필드에 저장.
		//nonGeneric1.setField(Integer.valueOf(100));
		nonGeneric1.setField(100); //오토박싱
		
		//필드값은 무조건 Object 타입의 인스턴스로 반한 - Object 인스턴스의 메소드만 호출 가능
		//=> 명시적 객체 형변환을 이용하여 자식 인스턴스로 변환 - 자식 인스턴스의 메소드 호출
		Integer returnObject1=(Integer)nonGeneric1.getField();
		
		System.out.println("필드값 = "+returnObject1); //오토언박싱
		
		//명시적 객체 형변환을 잘못한 경우 ClassCastException 발생
		//Double doubleValue=(Double)nonGeneric1.getField();
			//명시적 객체형변환을 한다음에 사용
		System.out.println("======================================================================");
		NonGeneric nonGeneric2 = new NonGeneric();
		
		//Double 인스턴스를 매개변수(Object)에 전달하여 Object 타입의 필드에 저장
		nonGeneric2.setField(12.34);
		
		//instanceof 연산자를 이용하여 명시적 객체 형변환 전에 검층
		if(nonGeneric2.getField() instanceof Double) {
			Double returnObject2 = (Double)nonGeneric2.getField();
			System.out.println("필드값 = "+returnObject2.doubleValue());

		}
		System.out.println("======================================================================");
		NonGeneric nonGeneric3 = new NonGeneric();
		
		//String 인스턴스를 매개변수(Object)에 전달하여 Object 타입의 필드에 저장
		nonGeneric3.setField("홍길동");
		
		String returnObject3 = (String)nonGeneric3.getField();
		System.out.println("필드값 = "+returnObject3.trim());
		System.out.println("======================================================================");
		
		
		
		
		
	}
}
