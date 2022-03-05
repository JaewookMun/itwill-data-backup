package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Advice Ŭ���� : Ⱦ�ܰ��ɸ���� ����� Ŭ����
// Ⱦ�ܰ��ɸ��(CrossCutting Concern Module) : Ⱦ�ܰ����ڵ尡 �ۼ��� �޼ҵ�
// Ⱦ�ܰ����ڵ� : �ٽɰ����ڵ� ���� �� �Ǵ� �Ŀ� ����� �ΰ����� ���
// => �α�, ����(���� ó��), Ʈ������ ó��, ����ó�� ���� ���
public class StudentAdvice {
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
	// Ÿ�ٸ޼ҵ�(�ٽɰ��ɸ��)�� ���� �� ���ԵǾ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�(Ⱦ�ܰ��ɸ��)
	// => JoinPoint : Before Advice
	// JoinPoint : �ٽɰ��ɸ���� �������� Ⱦ�ܰ��ɸ���� ���Ե� ��ġ ǥ��
		// �ٽɰ��ɸ�⿡�� ���ϴ� �޼ҵ常 Ÿ�ٸ޼ҵ�� �θ���.
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
			// �α��̺�Ʈ�� �߻���Ű�� log4j��� �α� ����ü�� ����� ���ش�.
	}
	
	// Ÿ�ٸ޼ҵ��� ���� �� ���ԵǾ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => Ÿ�ٸ޼ҵ忡�� �߻��Ǵ� ���ܿ� ������� ������ ���ԵǾ� ����
	// => JoinPoint : After Advice
		// JoinPoint�� 'After' �̴�.
	public void afterLog() {
		logger.info("[after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}

	// Ÿ�ٸ޼ҵ��� ���� �� ���ԵǾ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => Ÿ�ٸ޼ҵ忡�� ���ܰ� �߻����� ���� ��� ���ԵǾ� ����
	// => JoinPoint : After Returning Advice
	public void afterReturningLog() {
		logger.info("[after-returning]�ٽɰ����ڵ� ���� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	// Ÿ�ٸ޼ҵ��� ���� �� ���ԵǾ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => Ÿ�ٸ޼ҵ忡�� ���ܰ� �߻��� ��쿡�� ���ԵǾ� ����
	// => JoinPoint : After Throwing Advice
	public void afterThrowingLog() {
		logger.info("[after-throwing]�ٽɰ����ڵ� ���۽� ���ܰ� �߻��� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
		// ����ó���� �� ���� ���Ǵ� �� - '���ܷα�'
	
	
	// Ÿ�ٸ޼ҵ��� ���� ���� ���ԵǾ� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => JoinPoint : Around Advice
		// ���� ���� ���Ǵ� join point
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object object = joinPoint.proceed(); // Ÿ�ٸ޼ҵ� ȣ�� - �ٽɰ����ڵ� ����
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		return object;
			// Ÿ�ٸ޼ҵ带 �ݵ�� ȣ���Ͽ� �ٽɰ����ڵ带 ������Ѿ��Ѵ�.
	}
	
	

		// Advice Ŭ���� �޼ҵ�� JoinPoint�� ���� ����� �� �ִ� �Ű������� �ٸ���.


}
