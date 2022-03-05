package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File : ���� ����(���ϰ��, ���ϱ���, ����ũ�� ��)�� �����ϱ� ���� Ŭ����
//=> ����(���丮)�� ���Ϸ� �νĵǾ� File Ŭ������ ǥ�� ����
	//������ ���� �� ���������� �����ϱ����� ���� �ý�����ġ
	//���� : ���� ���� - ũ�Ⱑ ����.
	//���丮 : ������ ���� - ����ó�� ũ�⸦ ������ �ִ�. - ���Ϸ� �ν�
	//�ٺ��� ���Ǵ� �ٸ����� ���� �������� ���� ����
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathname) : �ý����� ���ϰ�θ� ���޹޾� File �ν��Ͻ��� �����ϴ� ������
		//�ý��� ���ϰ��(System File Path) : �ý��ۿ� �����ϴ� ���� ��ġ�� ǥ���ϱ� ���� ���
		//=> ������ ǥ�����, ����� ǥ�����
		//������ : �ֻ��� ���丮(����̺�)�� �������� ������ ��ġ�� ǥ���ϴ� ���
		//����� : ���� ���� ���α׷��� �۾� ���丮�� �������� ������ ��ġ�� ǥ���ϴ� ���
		//=> ��Ŭ���������� ������Ʈ ���丮�� �۾����丮�� ó��
			//default? �۾����丮�� �ֻ���� workspace�̱� ������
			//����ΰ� /project_name/src �� �����ϴ°��̶� �Ǵܵ�.
		//Windows �ü�������� ���丮(����̺�)�� ������ �����ϱ� ���� \ ��ȣ ���
		//=> Java������ \ ��ȣ�� Escape ���ڸ� ǥ���ϴ� �뵵�� ���
		//=> \ ��ȣ�� ���ڷ� ǥ���ϱ� ���ؼ��� \\ ���·� ǥ��
			//�ü���� �ý��� or �÷����̶�� ǥ��
			//\�� �ѹ��� ����ϸ� ����ڷ� �ν��ؼ� ��� ����. �ι��� ������ �ȴ�.
			//���丮�� ��� '����'�� �ٲ㼭 ǥ���� (���� ������)
			// ������ : "C:\\data", Mac : "/data"
		File fileOne=new File("C:\\data");
		
		//File.exists() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ �������� ���� ��� false��
		//��ȯ�ϰ� �����ϴ� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(fileOne.exists()) {
			System.out.println("C:\\data ������ �����մϴ�.");
		} else {
			//File.mkdir() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ �����ϴ� �޼ҵ�
			fileOne.mkdir();
			System.out.println("C:\\data ������ �����Ͽ����ϴ�.");
		}
		System.out.println("=========================================================================");
		//File fileTwo = new File("C:\\data\\abc.txt");
		//Windows �ü���� ������ ������ �ü�������� ���丮(����̺�)�� ������ �����ϱ�
		//���� / ��ȣ ��� - ���� ��θ� ǥ���� �� \ ��ȣ ��� / ��ȣ�� ����ϴ� ���� ����
			//Java ������ ��������(\) ��� ������(/)�� �ᵵ ��θ� ǥ���� �� �ֵ��� ó���� - �����쿡�� �������� \ �� ��� �⺻
		File fileTwo = new File("C:/data/abc.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\abc.txt ������ �����մϴ�.");
		} else {
			//File.createNewFile() : File �ν��Ͻ��� ����� ���ϰ�ο� ������ �����ϴ� �޼ҵ�
				//���ѹ��� ������ �������� ���� ��찡 �ֱ� ������ IOException�� ����ó�� �������
			fileTwo.createNewFile();
			System.out.println("C:\\data\\abc.txt ������ �����Ͽ����ϴ�.");
		}
		System.out.println("=========================================================================");
		//File fileThree = new File("C:/data/xyz.txt");
		
		//File(File parent, String child) ������ �Ǵ� File(Stirng parent, String child) ������
		//=> ���ϰ�θ� �θ�(���� ���)�� �ڽ�(���ϸ�)���� �����Ͽ� File �ν��Ͻ��� �����ϴ� ������
		//File fileThree=new File(fileOne, "xyz.txt");
		File fileThree = new File("c:/data", "xyz.txt");
	
		if(fileThree.exists()) {
			fileThree.delete();
			System.out.println("C:\\data\\xyz.txt ������ ���� �Ͽ����ϴ�.");
		}else {
			System.out.println("C:\\data\\xyz.txt ������ �������� �ʽ��ϴ�.");
		}
		System.out.println("=========================================================================");
		//���ϰ�θ� ����� ǥ��������� �����Ͽ� File �ν��Ͻ� ����
		//=> ���� �۾� ������ �⺻������ ������Ʈ ������ ����
		//=> [..] �������� ���� ������ ǥ���ϸ� [����(����)] �������� ���� ���� �Ǵ� ���� ǥ��
			//"src" : ���� �۾��ϰ� �ִ� java-3���� �Ʒ��� �ִ� src�� �ǹ�
		
		
		File fileFour = new File("src");
		
		if(fileFour.exists()) {
			//File.toString() : File �ν��Ͻ��� ����� ���ϰ�θ� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			//System.out.println("���� ��� = "+fileFour.toString());
			System.out.println("���� ��� = "+fileFour);
			
			//File.getAbsolutePath() : File �ν��Ͻ��� ����� ���ϰ�θ� ������ ǥ�������
			//���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
				//�����ڵ��� �����θ� �ַ� ��� - ����δ� ��Ȯ�Ǽ��� ������ ���ɼ� ����
			System.out.println("���� ��� = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("�۾� ������ src ���� ������ �������� �ʽ��ϴ�.");
		}
		System.out.println("=========================================================================");
			//������� ������ġ�� ǥ�� , Mac & �������� ���丮�� ǥ��
		File fileFive=new File("C:/");
		
		//File.isDirectory() : File �ν��Ͻ��� ����� ���ϰ�ΰ� ������ �ƴ� ���
		//false�� ��ȯ�ϰ� ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(fileFive.isDirectory()) {
			//File.listFiles() : File �ν��Ͻ��� ����� ���ϰ���� �ڽ� ���� ����� File
			//�ν��Ͻ� �迭�� ��ȯ�ϴ� �޼ҵ�
				//������ �����Ͽ� ��ȯ
			File[] subFiles = fileFive.listFiles();
			
			System.out.println(fileFive+"������ �ڽ� ��� >>");
			for(File file : subFiles) {
				//File.isFile() : File �ν��Ͻ��� ����� ���ϰ�ΰ� ������ �ƴ� ���
				//false�� ��ȯ�ϰ� ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
				if(file.isFile()) {
					System.out.println("���� = "+file);
				} else {
					System.out.println("���� = "+file);
				}
			}
		}
	}
}
