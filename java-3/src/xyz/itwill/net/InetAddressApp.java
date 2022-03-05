package xyz.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress : 네트워크 정보(IP Address와 HostName)를 저장하기 위한 클래스
	//HostName : IP address대신 사용할 수 있는 컴퓨터 이름(문자열로 구성)
public class InetAddressApp {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress.getLocalHost() : 로컬 컴퓨터의 네트워크 정보를 InetAddress 인스턴스로 반환하는 메소드
		//=> UnknownHostException 발생 : HostName의 컴퓨터를 검색할 수 없는 경우 발생되는 예외
		//=> 현재 컴퓨터에는 [127.0.0.1]의 IP Address와 [localhost]의 HostName이 자동 제공
			//[127.0.0.1] : 루프백 IP주소 라고 불림 (- Q: 로컬컴퓨터의 ip주소를 호출?)
		InetAddress myComputer = InetAddress.getLocalHost();
		//InetAdderess.toString() : InetAddress 인스턴스에 저장된 네트워크 정보를 문자열로
		//변환하여 반환하는 메소드 - 참조변수 출력시 자동 호출되는 메소드
			//IP정보와 호스트네임
		System.out.println("myComputer = "+myComputer);
		
		//InetAddress.getHostName() : InetAddress 인스턴스에 저장된 네트워크 정보 중
		//컴퓨터명을 문자열로 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostName());
		
		//InetAddress.getHostAddress() : InetAddress 인스턴스에 저장된 네트워크 정보 중
		//IP 주소를 문자열로 반환하는 메소드
			//네트워크에서 중요한것은 IP주소가 중요함
			//같은 네트워크 그룹에서는 HostName으로 접속할 수 있지만
			//다른 그룹에서는 HostName으로 접속할 수 없다. 
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("=========================================================");
		//InetAddress.getByName(String host) : 전달받은 컴퓨터이름에 대한 네트워크 정보가
		//저장된 InetAddress 인스턴스를 반환하는 메소드
			//호스트이름을 전달해서 해당 호스트네임(컴퓨터)에 대한 정보를 저장하는 인스턴스를 반환한다.
		InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
			//서버에 접근할 때 IP주소를 통해 접근하는 것을 권장
		System.out.println("[www.itwill.xyz]의 IP주소 = "+itwill.getHostAddress());
		System.out.println("=========================================================");
			//포탈같은 경우 분산처리를 위해 같은 이름의 컴퓨터가 여러대 있다. - 같은이름의 컴퓨터 여러대 존재 가능(분산처리)
			//하나만 받는 것이 아니라 아래처럼 getAllByName을 활용하여 호스트네임에 할당된 IP주소를 얻는다.
		//InetAddress.getAllByName(String host) : 전달받은 컴퓨터명에 대한 모든 네트워크 
		//정보가 저장된 InetAddress 인스턴스 배열로 반환하는 메소드
			//cmd의 nslookup 명령어와 동일
			//Host네임이 같더라도 IP주소는 다르게 설정해야한다. (다수의 컴퓨터를 하나의 컴퓨터처럼 운영할 때)
		InetAddress[] daum=InetAddress.getAllByName("www.daum.net");
		
		for(InetAddress address:daum) {
			System.out.println("[www.daum.net]의 IP주소 = "+address.getHostAddress());
		}
		System.out.println("=========================================================");
		
		
	}
}
