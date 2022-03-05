package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	// Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð�(ms)�� ����Ͽ� ����ϴ� �޼ҵ� - Around Advice
	// timeWatchLog
		// ���� Ÿ�ٸ޼ҵ尡 �����Ǿ� �ִٸ� Ÿ�ٸ޼ҵ忡 ���߾� void, String ó�� Ÿ�ٸ޼ҵ忡 ���߾� ��ȯ���� �����ص� �������.
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		// Ÿ�ٸ޼ҵ� ���� �� ���۵� ��� �ۼ�
		// System.currentTimeMillis() : �ý����� ���� Ÿ�ӽ�����(TimeStamp)�� ��ȯ�ϴ� �޼ҵ�
		// => Ÿ�ӽ�����(TimeStamp) : ��¥�� �ð��� ����(long)�� ǥ���ϱ� ���� ��
			// Ÿ�ӽ����� - ��¥�� �ð��� �����ϱ� ���� �ʿ��� ��.
		long beginTime=System.currentTimeMillis();
		
		Object object=joinPoint.proceed();// Ÿ�ٸ޼ҵ� ȣ�� - Ÿ�ٸ޼ҵ��� ��� ����
		
		// Ÿ�ٸ޼ҵ� ���� �� ���۵� ��� �ۼ�
		long endTime=System.currentTimeMillis();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		logger.info(className+" Ŭ������ "+methodName+" �޼ҵ� ����ð� = "+(endTime-beginTime)+"ms");
		
		return object;
		*/
		
		// StopWatch : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
			// Spring Framework�� �����ϴ� util Ŭ����
		StopWatch stopWatch=new StopWatch();
		
		// StopWatch.start() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.start();
		
		Object object=joinPoint.proceed();// Ÿ�ٸ޼ҵ� ȣ�� - Ÿ�ٸ޼ҵ��� ��� ����
		
		// StopWatch.stop() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.stop();

		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		// StopWatch.getTotalTimeMillis() : ������ �ð�(ms)�� ��ȯ�ϴ� �޼ҵ�
		logger.info(className+" Ŭ������ "+methodName+" �޼ҵ� ����ð� = "+stopWatch.getTotalTimeMillis()+"ms");
		
		return object;

	}
	
	/*
	// ���� �ۼ��� �ڵ�
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		long startStamp=System.currentTimeMillis();
		logger.info("currentTime[start]: "+startStamp);
		Object object=joinPoint.proceed();
		long endStamp=System.currentTimeMillis();
		
		logger.info("currentTime[end]: "+endStamp);
		logger.info(className+"Ŭ������ "+methodName+"()�޼ҵ��� [�ҿ�ð�] : "+(endStamp-startStamp)*0.001+"��");
		return object;
	}
	 */
	
}
