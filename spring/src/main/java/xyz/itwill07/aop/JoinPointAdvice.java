package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

// Ⱦ�ܰ��ɸ���� ����� Ŭ����
public class JoinPointAdvice {
	// Around Advice�� ������ Advice �޼ҵ�� ��ȯ���� void�� �ۼ��ϰ� �Ű�������
	// ���ۼ� �ϰų� JoinPoint�� �ڷ������� �ϴ� �Ű����� �ۼ� ����
	// JoinPoint : Ÿ�ٸ޼ҵ�(�ٽɰ��ɸ��)�� ������ �����ϱ� ���� ��ü
	// => Spring Container�� Advice �޼ҵ带 ȣ���� �� Ÿ�ٸ޼ҵ��� ����(JoinPoint ��ü)�� �ڵ����� JoinPoint �Ű������� ���޵Ǿ� ����
	// => Advice �޼ҵ�(Ⱦ�ܰ����ڵ�)���� Ÿ�ٸ޼ҵ��� ������ �ʿ��� ��� JoinPoint �Ű����� �ۼ�
	public void displayTarget(JoinPoint joinPoint) {// before Advice
		// System.out.println("[before] �ٽɰ��ɸ�� ���� �� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		
		// JoinPoint.getTarget() : Ÿ�ٸ޼ҵ带 ȣ���ϴ� Spring Bean ��ü�� ��ȯ�ϴ� �޼ҵ�
		// => Ÿ�ٸ޼ҵ尡 ����� Ŭ���� ��ü�� Object Ÿ������ ��ȯ
		// Object.getClass() : ��ü�� ���� Ŭ���� ����(Class ��ü - Clazz)�� ��ȯ�ϴ� �޼ҵ�
			// Clazz : �޸𸮿� �ε�(����)�� Ŭ���� ������ �ǹ��Ѵ�.
		// Class.getName() : Class ��ü(Clazz)�� Ŭ������(��Ű�� ����)�� ��ȯ�ϴ� �޼ҵ�
		// System.out.println(joinPoint.getTarget().getClass().getName());
		// Class.getSimpleName() : Class ��ü(Clazz)�� Ŭ������(��Ű�� ������)�� ��ȯ�ϴ� �޼ҵ�
		// System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		
		// JoinPoint.getSignature() : Ÿ�ٸ޼ҵ��� ����(Signature ��ü)�� ��ȯ�ϴ� �޼ҵ�
		// Signature.getName() : Signature ��ü�� Ÿ�ٸ޼ҵ���� ��ȯ�ϴ� �޼ҵ�
		// System.out.println(joinPoint.getSignature().getName());
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		// System.out.println("[before]"+className+" Ŭ������ "+methodName+"() �޼ҵ� ȣ��");
		
		// JoinPoint.getArgs() : Ÿ�ٸ޼ҵ��� �Ű������� ����� ��� ���� Object �迭�� ��ȯ�ϴ� �޼ҵ�
		Object[] objects=joinPoint.getArgs();
	
		/*
		if(methodName.equals("remove")) {
			int num=(Integer)objects[0];
			System.out.println("[���]"+methodName+"() �޼ҵ��� �Ű������� ���޵� �� = "+num);
		}
		*/
		
		System.out.println("[before]"+className+" Ŭ������ "+methodName+"() �޼ҵ忡 ����� �Ű������� ���� = "+objects.length);
			// Ÿ�� Ŭ������ �̸�, �޼ҵ��, �޼ҵ��� �Ű������� JoinPoint�� Ⱦ�ܰ����ڵ忡�� ��밡�� - Around Advice ����
	}
	
	// After Returning Advice �޼ҵ忡�� JoinPoint �Ű������� Object Ÿ���� �Ű����� �ۼ� ����
	// => Object Ÿ���� �Ű��������� Ÿ�ٸ޼ҵ��� ��ȯ���� ���޹޾� ����
	// => Ÿ�ٸ޼ҵ��� ��ȯ���� �ڷ����� ������ ��� Object Ÿ�� ��� ��ȯ���� �ڷ���(Ŭ����) �ۼ� ����
	// after-returning ������Ʈ�� returning �Ӽ��� �Ű��������� �Ӽ������� �ݵ�� �����ؾ߸�
	// Ÿ�ٸ޼ҵ��� ��ȯ���� �Ű������� ���޵Ǿ� ����
	public void displayName(Object object) { // After Returning Advice
		// System.out.println("[after-returning] �ٽɰ��ɸ���� ���������� ���۵� �� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"��, ȯ���մϴ�.");
		}
	}
	
	// After Throwing Advice �޼ҵ忡�� JoinPoint �Ű������� Exception Ÿ���� �Ű����� �ۼ� ����
	// => Exception �Ű��������� Ÿ�ٸ޼ҵ忡�� �߻��� ����(Exception ��ü)�� ���޹޾� ����
	// after-throwing ������Ʈ�� throwing �Ӽ��� �Ű��������� �Ӽ������� �ݵ�� �����ؾ߸�
	// Ÿ�ٸ޼ҵ��� ����(Exception ��ü)�� �Ű������� ���޵Ǿ� ����
	public void displayException(Exception exception) { // After Throwing Advice
		// System.out.println("[after-throwing] �ٽɰ��ɸ�� ���۽� ���ܰ� �߻��� �� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		
		System.out.println("[after-throwing]Ÿ�ٸ޼ҵ忡�� �߻��� ���� �޼��� = "+exception.getMessage());
	}
	
	// Around Advice �޼ҵ�� ��ȯ���� Object Ÿ������ �ۼ��ϰ� ProceedingJoinPoint �Ű����� �ۼ� 
	// => Around Advice �޼ҵ�� Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ�ϱ� ���� ��ȯ���� Object�� �ۼ�
	// ProceedingJoinPoint : Ÿ�ٸ޼ҵ��� ������ �����ϱ� ���� ��ü
	// => Ÿ�� �޼ҵ带 ȣ���� �� �ִ� ��� ���� - Throwable ��ü �߻�
	// => Throwable ��ü(���α׷����� �߻��Ǵ� ��� ���� ������ ������ ��ü) ����
		// �Ϲ� joinpoint�� Ÿ�ٸ޼ҵ��� ������ ������ �ִ� �ݸ鿡 ProceedingJoinPoint�� Ÿ�ٸ޼ҵ��� ���� �ܿ� ȣ���� �� �ִ� ��ɵ� ������ �ִ�.
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable { // Around Advice
		System.out.println("[around] �ٽɰ��ɸ�� ���� ���� ���ԵǾ� ����Ǵ� Ⱦ�ܰ��ɸ��");
		// ProceedingJoinPoint.proceed() : Ÿ�ٸ޼ҵ带 ȣ���ϴ� �޼ҵ� - �ٽɰ��ɸ�� ����
		// => Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ�޾� ����
		// => Throwable ��ü(���� ����) �߻� - ���� ó��
		Object object=joinPoint.proceed();
		System.out.println("[around] �ٽɰ��ɸ�� ���� �Ŀ� ���ԵǾ� ����Ǵ� Ⱦ�ܰ��ɸ��");
		
		return object; // Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ
	}
	
}

/*
	Advice Ŭ������ �޼ҵ带 ������ ��,
	�ĺ���(�̸�)�� ���Ƿ� �ۼ��ص� ��� ������
	��ȯ���� �Ű������� ������ ��Ģ��� �����Ѵ�.
	
	Advice Ŭ���� �޼ҵ�� Spring Container�� ȣ���Ѵ�.
 */

