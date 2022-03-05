package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// @Component

// @Service : Service 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//=> 기본적으로 클래스명을 beanName으로 설정하며 value 속성을 사용하여 beanName 변경 가능
	// value 속성밖에 없기 때문에 괄호안에 value 없이 더블쿼테이션과 함께 표기 가능
	// Repository나 Service가 Component보다 더 많은 기능을 제공한다.
	// Component가 부모, Repository & Service가 자식 이라고 생각하면 된다.
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	
	// @Autowired : Spring Bean 객체로 필드에 의존관계를 자동으로 설정하기 위한 기능을 제공하는 어노테이션
	// => 필드의 Setter 메소드를 선언하지 않아도 Setter Injection 기능 제공
	// => bean 엘리먼트의 autowire 속성의 [byType] 속성값과 동일한 방법으로 의존관계 설정
	// 문제점) 필드의 자료형이 인터페이스인 경우 자식클래스로 Spring Bean이 여러개 등록된 경우
	// 의존관계를 설정할 때 NoUniqueBeanDefinitionException 발생
	// 해결법-1) Spring Bean으로 등록된 자식클래스 중 하나의 beanName을 필드명과 같은 이름으로 변경
	// => 자식클래스로 Spring Bean이 여러 개 등록된 경우 autowire 속성의 [byName] 속성값과 같은 방법으로 의존관계 설정
	// 해결법-2) Qualifier 어노테이션을 사용하여 의존관계를 설정할 Spring Bean을 선택 
	// @Qualifier : 의존관계를 설정하고자 하는 Spring Bean을 선택하기 위한 어노테이션
	// => @Autowired 어노테이션에 종속된 어노테이션
	// => 의존관계를 설정할 Spring Bean의 beanName을 value 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정
		// 자동 디펜던시 인젝션을 위한 어노테이션 - Setter Injection
		// byType에서 문제가 생기면 byName 방식으로 재탐색한다고 볼 수 있다. (동일한 beanName을 사용하면 충돌발생)
		// Qualifier는 @Autowired 어노테이션에 종속된 어노테이션 - autowired 가 없으면 사용못함
		// Qualifier 사용 권장
		// Setter 메소드가 없어도 Injection된다는 점이 장점이다.!!
	@Autowired
	// @Qualifier("annotationStudentJdbcDAO")
	@Qualifier("annotationStudentMybatisDAO")
	// @Resource : Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	// => JDK 라이브러리에 의해 제공되는 어노테이션 - 다른 Framework에서 사용 가능
	// => 기본적으로 [byName]으로 의존관계 설정
	// @Inject : Spring Framework의 @Autowired 어노테이션을 바탕으로 만들어진 어노테이션
	// => JDK 라이브러리에 의해 제공되는 어노테이션 - 다른 Framework에서 사용 가능
	// => 기본적으로 [byType]으로 의존관계 설정
		// Spring Framework 외에 다른 프레임워크를 가져다 사용할 때는 Resource와 Inject 어노테이션을 많이 사용
	private StudentDAO studentDAO;
		// 인터페이스로 되어있으면 인터페이스를 상속받은 자식클래스로 인젝션한다.
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}

}
