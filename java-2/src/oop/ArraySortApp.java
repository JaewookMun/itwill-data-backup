package oop;

import java.util.Arrays;

//�迭�� ��Ұ��� �������� �����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���
public class ArraySortApp {
	public static void main(String[] args) {
		// ��Ұ����� ���ʷ� �ٽ� �����Ͽ� ���.
		int[] array = {30,50,10,40,20};
		
		/*	<�ڹٽ����� �ʴ�.>
		System.out.print("���� �� >> ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();

		// �Ʒ� �˰����� �̿��� ��� => �������� ���α׷�
		//�迭�� ��Ұ����� ���� ���� �˰����� �̿��Ͽ� �������� ����ó�� (Selection Sort Algorithm)
		// >> ��ҵ��� ���� ���ؾ���.
		// �ݺ���, ���ǹ� ���� Ȱ���Ͽ� ���α׷��� �帧�� ����
		for(int i=0; i<array.length-1; i++) { //�񱳿���� ÷��
			for(int j=i+1; j<array.length; j++) { //�Ǻ� ����� ÷�� : ��+1 ~ ����������.
				//��Ұ��� ���Ͽ� ��ҿ� ����� ���� ���� ġȯ
				if(array[i]>array[j]) {
					int temp=array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.print("���� �� >> ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();
		*/
		
		// <�ڹٽ����� ���� - ��ü����>
		System.out.print("���� �� >> ");
		//Arrays : �迭�� ���� �پ��� ���(�޼ҵ�)�� �����ϴ� Ŭ����
		//Arrays.toString(Object[] array) : �迭������ ���޹޾� ��Ұ��� ���ڿ���
		//��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println(Arrays.toString(array));
		
		//Arrays.sort(Object[] array) : �迭 ������ ���޹޾� �迭�� ��Ұ��� �����ϴ� �޼ҵ�
		Arrays.sort(array);
		
		System.out.print("���� �� >> ");
		// ������ Ŭ������ ������ �ִ� ��Ҹ� ����Ϸ��� �ν��Ͻ��� ����������.
		System.out.println(Arrays.toString(array));
		
		// Jdk�� �ٿ������ �ڹٰ����� ���� Ŭ�������� library�� ���� �� �ִ�. 
		// �����ϵ� Ŭ���� ����(jar)���� ����Ǿ��ִ�.
		// Library�� ����Ǿ��ִٸ�(����) �ҽ��� �ۼ��� �� Ŭ������ Ȱ���� �� �ִ�.
		// �ڹٴ� Ŭ������ ������ �ִ� �޼ҵ带 ȣ���ؼ� ��� ����� ���� �߿� (�帧)
		// �ý��ۿ����Ͼ ������ �ڷḦ ������ ���̺귯���� �־ ������ ����ȴ�.
		// �ڹٴ� ����� ���� �ƴ϶� Ŭ������ �����ִ� �޼ҵ带 �� ������ ���� �ȴ�.
		// �ڹٴ� ������ ����� �ʿ����. Ŭ������ ����� ��ü�� ���� �� �������� ���� �߿�.
		// �������� - flow chart	/ ��ü���� - diagram  �� �̿��ؼ� ���α׷� ����
	}
}
