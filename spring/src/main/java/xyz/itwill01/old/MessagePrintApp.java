package xyz.itwill01.old;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessagePrint print=new HelloMessagePrint();
		print.helloMessagePrint();
		*/
		
		HiMessagePrint print=new HiMessagePrint();
		print.hiMessagePrint();
	}
}

/*
	MessagePrintApp < HelloMessagePrint < HelloMessageObject
	
	���յ��� ������ ���� ������ ���������� �����.
	HelloMessageObject�� �ٸ� Ŭ������ �ٲ� ��� 
	�̸� ����ϴ� HelloMessagePrint�� MessagePrintApp ���� �̿� ���߾� �ٲ�����Ѵ�.
	
	- ���յ��� ���� ������ �ٸ� Ŭ���� �� ���α׷����� ������ �ʿ���.
	> ���������� �ƴ϶� ���� �����ϴ� �Ͱ� ���� ȿ���� ������.
 */
