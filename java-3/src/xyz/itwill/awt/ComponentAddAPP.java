package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddAPP extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddAPP(String title) {
		super(title);
		
		//Button : ��ư�� ������ ���۳�Ʈ Ŭ���� - ��ư�� ����
			//��ư�� �ִ� ���ڿ��� �󺧸��̶�� �θ���.
		Button button = new Button("��ư");
		
		//Container.add(Component c) : ���۳�Ʈ�� �����̳ʿ� �����ϴ� �޼ҵ�
			//��� �����̳ʿ��� ���۳�Ʈ�� �����ϴ� ���(��Ģ)�� ����Ǿ� �ִ�. - ���̾ƿ�
			//���̾ƿ��� �ٲ��־�� ���ϴ� ������� ���۳�Ʈ�� ������ �� �ִ�.  - LayoutManager
		add(button);
		
		setBounds(600, 100, 300, 300);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new ComponentAddAPP("���۳�Ʈ");
		
		
	}

}
