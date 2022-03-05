package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//��� �����̳ʿ��� ���޵� ���۳�Ʈ�� �ڵ� �����ϴ� ����� �����ϴ� ��ġ �����ڰ� ����
//��ġ ������(Layout Manager) : �����̳ʿ� ���۳�Ʈ�� ��ġ�� �� ���۳�Ʈ�� ũ��� ���
//��ġ�� �ڵ����� �����ϴ� ����� �����ϴ� Ŭ����
//=> BorderLayout, FlowLayout, GridLayout ��
//=> �����̳ʿ��� �⺻ ��ġ �����ڰ� �����ϸ� �����̳��� ��ġ �����ڴ� ���� ����
	//��� GUI�� ��ġ�����ڰ� ���� - e.g. �ȵ���̵� ���� ����(���۳�Ʈ ���)�� ���� ��ġ������ ����
public class NonLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public NonLayoutApp(String title) {
		super(title);
		
		//Container.setLayout(LayoutManager mgr) : �����̳��� ��ġ �����ڸ� �����ϴ� �޼ҵ�
		//=> setLayout()�޼ҵ忡 (LayoutManager ���� �ν��Ͻ� ���) null�� �����ϸ� ��ġ �����ڸ� ������� �ʵ��� ����
			//��ġ�����ڸ� ��� ���ϰ� �������� �����ϰڴٴ� �ǹ� - ����x
			//LayoutManager ����� �����Ѵ�.
		setLayout(null);
		
		Button button1 = new Button("��ư-1");
		Button button2 = new Button("��ư-2");
		
		//��ġ �����ڸ� ������� ���� ��� ���۳�Ʈ�� ũ��� �����ġ�� �����ؾ߸� �����̳ʿ� ���� ����
			//�������� �������� �����̴�. (������ �»�� �������� ����(0,0)���� ��´�.)
			//�Ӽ��� �����Ǳ� ������ �������� ���濡 ������ ���� �ʴ´�. - �������� ������ �� �ִ�.
		button1.setBounds(80, 100, 50, 80);
		button2.setBounds(190, 130, 100, 120);
		
		add(button1);
		add(button2);
		
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutApp("NonLayout");
	}

}
