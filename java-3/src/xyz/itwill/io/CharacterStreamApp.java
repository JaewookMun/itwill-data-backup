package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//Character Stream : ���ڵ� ó���� ���� ������(2Byte)�� �����ϱ� ���� �Է� �Ǵ� ��� ��Ʈ��
//=> Reader Ŭ���� �Ǵ� Writer Ŭ������ ��� ���� �ڽ� Ŭ������ ������ ��Ʈ��(�ν��Ͻ�)

//Ű���� �Է°��� ���ڵ� ó���� ���� �����ͷ� �Է¹޾� ����Ϳ� ����ϴ� ���α׷�
//=> EOF(End Of File : �Է� ���� - Ctrl+Z) ��ȣ�� �����ϸ� ���α׷� ����
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[�޼���]Ű���带 ���� ���� �Է��� �ּ���.[����:Ctrl+Z]");
		
		//InputStreamReader : ���ڵ� ó���� ���� �����͸� ��ȯ�ϱ� ���� ����� �����ϴ� Ŭ����
		//=> InputStream �ν��Ͻ��� ���޹޾ƾ� �Է� ��Ʈ�� ���� ���� - Ȯ�� ��Ʈ��
			//�Ű������� ���� �����ڰ� ����. - input stream�� ������ �ʿ���.
			//��Ʈ�� ����
			//������Ʈ���� ���޹��� �ʾƵ� ���� �� ����.
			//�⺻������ �����ϴ� Ű���� �Է½�Ʈ��(���õ�����)�� ���ڵ����͸� �о� ���� �� �ִ�
			//��Ʈ������ Ȯ���Ͽ� in �̶�� ������ �� ��Ʈ���� �����ϰڴٴ� �ǹ� 
		InputStreamReader in = new InputStreamReader(System.in);
		
			//InputStream, OutputStream�� �������� ������
			//Writer�� Reader�� ���������� �����Ѵ�.
		//OutputStreamWriter : ���ڵ� ó���� ���� ����Ÿ�� �����ϱ� ���� ����� �����ϴ� Ŭ����
		//=> OutputStream �ν��Ͻ��� ���� �޾ƾ� ��� ��Ʈ�� ���� ���� - Ȯ�� ��Ʈ��
		//OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		//OutputStreamWriter : ���ڵ� ó���� ���� ����Ÿ�� �����ϱ� ���� ����� �����ϴ� Ŭ����
		//=> ��� ���� ���� �����ͷ� ��ȯ�Ͽ� �����ϴ� �޼ҵ尡 �߰��� Ŭ����
			//OutputStreamWriter���� PrintWriter�� �޼ҵ带 �� ���� ������ �ִ�.
			//e.g. print() or println() method
		
		PrintWriter out = new PrintWriter(System.out);
		
		int readByte;
			//Ű����� �Էµ� ��Ʈ�� : System.in �̸� �� ��Ʈ���� Read()�� ���õ����ͷ� ��ȯ
		while(true) {
			//Reader.read() : �Է� ��Ʈ���� �����ϴ� ���� ���ڵ� ó���� ���� ������(2Byte)��
			//�о� ��ȯ�ϴ� �޼ҵ�
				//byte�� �����͸� �ΰ��� �ϳ��� ��� ���ڷ� �о���� = ���ڵ�
			readByte = in.read();
			
			if(readByte == -1) break;
				
				//�ѱ۷� �Է��ϸ� ��½� ����
				//�о���� ���� 2����Ʈ�� �о������� ����� ���� 1����Ʈ�� �ɰ��� ��� - ���ڰ� ����������.
			//System.out.write(readByte);
			
			//Writer.write(int b) : ��� ��Ʈ���� ���ڵ� ó���� ���� ����Ÿ�� �����ϴ� �޼ҵ�
			//=> ���� �����͸� ���� ũ�⸸ŭ ��� ���۸�Ƽ� �ѹ��� ��� ��Ʈ���� ����
				//���� : �ӽø޸𸮸� �ǹ�
				//Writer�� Ư¡
			out.write(readByte);
			
			//Writer.flush() : ��� ���ۿ� ����� ���� ����Ÿ�� ��� ��Ʈ������ �����ϴ� �޼ҵ�
				//�̰� ���ϸ� ����� Ȯ�� ����.
			out.flush();
				//1byte�� �о����� 1byte�� ���, 2byte�� �о����� 2byte�� ����ؾ��Ѵ�.
		}
		
		System.out.println("[�޼���]���α׷��� �����մϴ�.");
		
	}
}
