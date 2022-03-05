package xyz.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//�̺�Ʈ �ڵ鷯 Ŭ������ �������� �ʰ� �̺�Ʈ �ҽ��� ���� �ڵ鷯�� ����Ͽ� 
public class EventAnonymousHandlerapp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnonymousHandlerapp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button button = new Button("���α׷� ����");
		add(button);
		
		//�߻� Ŭ������ �������̽��� �ν��Ͻ� ���� �Ұ���
			//new ������ �ڿ� �����ڰ� �;��ϴµ� �����ڰ� ����
		//=> Ŭ������ ��ӹ޾� ����ϱ� ���� ��� ���� �ڷ���
		//=> �ڽ� Ŭ������ �߻� Ŭ���� �Ǵ� �������̽��� �߻� �޼ҵ带 �������̵� 
		//�����ؾ߸� �ν��Ͻ� ���� ����
		//�߻�Ŭ������ �������̽��� ��� �߻� �޼ҵ带 ���� �������̵� �����Ͽ� �ν��Ͻ� ��������
		//=> �ڽ� Ŭ������ �̸��� ������� �ʴ� �͸��� ���� Ŭ������ �ν��Ͻ� ���� ���� - Anonymous Inner class
		//=> �͸��� ���� Ŭ������ �ϳ��� �ν��Ͻ��� ����
			// - event�ҽ��� ������ ���� �� ��� ����.
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new EventAnonymousHandlerapp("EventHandle");
	}
}
