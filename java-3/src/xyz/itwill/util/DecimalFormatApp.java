package xyz.itwill.util;

import java.text.DecimalFormat;

//java.text.DecimalFormat : 10진수 정수값 관련 패턴정보를 저장하기 위한 클래스
	//쇼핑몰처럼 단위가 화폐일 때 많이 사용
public class DecimalFormatApp {
	public static void main(String[] args) {
		//DecimalFormat(String pattern) : 10 진수 정수값에 대한 패턴정보를 전달받아
		//인스턴스를 생성하기 위한 생성자
		//=> 패턴문자 : #(숫자-공백), 0(숫자-0), $(화폐기호) 등
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
			//굳이 format을 지정하지 않고 getInstance를 통해 세자리마다 콤마를 적용할 수 있음.
		
		long money = 10_000_000_000L;
		
		System.out.println("금액 = "+money+"원");
		
		//DecimalFormat.format(Number o) : 전달받은 숫자값을 DecimalFormat 인스턴스에
		//저장된 패턴정보의 문자열로 변환하여 반환하는 메소드
		System.out.println("금액 = "+decimalFormat.format(money)+"원");

		//DecimalFormat.getInstance() : 기본 패턴정보를 지정한 DecimalFormat 인스턴스를 반환하는 메소드
		System.out.println("금액 = "+DecimalFormat.getInstance().format(money)+"원");
		
		//DecimalFormat.getCurrencyInstance() : 기본 패턴정보를 지정한 DecimalFormat 인스턴스를 반환하는 메소드
		//=> 문자열 앞에 시스템에서 사용되는 화폐단위가 추가되어 변환
		System.out.println("금액 = "+DecimalFormat.getCurrencyInstance().format(money));
		
		
	}
}
