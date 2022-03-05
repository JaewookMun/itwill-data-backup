package inheritance;

//사원 급여 관리 프로그램
public class EmployeeApp {
	public static void main(String[] args) {
		//추상클래스로 인스턴스를 생성할 경우 에러 발생
			//think: 추상클래스로 참조변수는 만들 수 있다.
		//Employee employee = new Employee();
		
		//추상 클래스로 참조변수를 생성하여 자식클래스의 생성자로 인스턴스를 
		//생성하여 저장 가능
		/*
		Employee employee1=new EmployeeRegular();
		Employee employee2=new EmployeeTime();
		Employee employee3=new EmployeeContract();
		*/
		
		Employee[] empArray=new Employee[5];
		
		empArray[0]=new EmployeeRegular(1000, "홍길동", 96000000);
		empArray[1]=new EmployeeTime(2000, "임꺽정", 50000, 150);
		empArray[2]=new EmployeeContract(3000, "전우치", 7000000);
		empArray[3]=new EmployeeTime(4000, "일지매", 10000, 100);
		empArray[4]=new EmployeeRegular(5000, "장길산", 60000000);
		
		for(Employee emp:empArray) {
			System.out.println("사원번호 = "+emp.getEmpNo());
			System.out.println("사원이름 = "+emp.getEmpName());
			
			//사원의 급여를 반환받아 출력
			/*
			//=> 명시적 객체 형변환을 이용하여 자식 인스턴스의 메소드 호출
			//=> instanceof 연산자를 이용하여 자식 인스턴스를 구분하여 객체 형변환
			if(emp instanceof EmployeeRegular) {
				System.out.println("사원급여 = "+((EmployeeRegular)emp).getEmpName());
			} else if(emp instanceof EmployeeTime) {
				System.out.println("사원급여 = "+((EmployeeTime)emp).calcPay());
			} else if(emp instanceof EmployeeContract) {
				System.out.println("사원급여 = "+((EmployeeContract)emp).returnPay());
			}
			*/
			
			//메소드 오버라이드를 이용하여 묵시적 객체 형변환으로 자식 인스턴스의 메소드 호출
			
			System.out.println("사원급여 = "+ emp.computePay());
			
			System.out.println("인센티브 = "+ emp.computeIncentive());
			System.out.println("===============================================================");
		}
	}
}
