package xyz.itwill.util;

import java.util.Random;

//java.util.Random : ���� ���� ����� �����ϴ� Ŭ����
	//Random - ���ӿ� ���� ���� ���ȴٰ� ������ �� �ִ�.
public class RandomApp {
	public static void main(String[] args) {
		Random random = new Random();
			//seed���� ������ ��� ������ ������ �߻�. -> ���ڿ� �ƹ��͵� �ȳ־�� ������ ������ �߻����� �ʴ´�.
			//�ð��� ���� seed���� �ٲ�� ȿ�� �߻�. (=���� ���� �߻�x)
		
		for(int i=1; i<=5; i++) {
			//Random.nextInt(int bound) : 0~bound-1 ������ ���������� �߻��Ͽ� ��ȯ�ϴ� �޼ҵ�
			System.out.println(i+"��° �������� = "+random.nextInt(100));// 0~99
		}
		
	}
}
