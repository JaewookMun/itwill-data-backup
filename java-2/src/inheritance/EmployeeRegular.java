package inheritance;

//정규직 사원정보(사원번호, 사원정보, 연봉)를 저장하기 위한 클래스
//=> Employee 클래스를 상속 받아 작성
	// 동일한 목적의 클래스들은 상속을 통해 좀 더 쉽게 작성할 수 있다.
public class EmployeeRegular extends Employee{
	private int annualSalary;
	
	public EmployeeRegular() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeRegular(int empNo, String empName, int annualSalary) {
		super(empNo, empName);
		this.annualSalary = annualSalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	/*
	//급여를 계산하여 반환하는 메소드
	public int computeSalary() {
		return annualSalary/12;
	}
	*/
	
	@Override
	public int computePay() {
		return annualSalary/12;
	}
	
	//final 메소드를 오버라이드 선언할 경우 에러 발생
	/*
	@Override
	public int computeIncentive() {
		return 100_000_000;
	}
	*/
	
}
