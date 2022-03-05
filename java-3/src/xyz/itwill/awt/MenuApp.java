package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

public class MenuApp extends Frame {
	private static final long serialVersionUID = 1L;

	public MenuApp(String title) {
		super(title);
		
		//MenuBar : Menu �����̳ʸ� ��ġ�ϱ� ���� �����̳� - Frame�� ��ġ
		//=> Frame�� ��ġ�ϴ� �����̳�
		MenuBar bar = new MenuBar();
		
		//Menu : MenuItem ���۳�Ʈ�� ��ġ�ϱ� ���� ���۳�Ʈ
		//=> MenuBar�� ��ġ�ϴ� �����̳�
			//"����", "����" : Menu Label
		Menu file = new Menu("����"); 
		Menu help = new Menu("����");
		
		//MenuItem : ���� ����� �����ϴ� ���۳�Ʈ
		//=> Menu�� ��ġ�ϴ� ���۳�Ʈ
		//MenuShortcut : ����Ű ���� ������ �����ϱ� ���� Ŭ����
		//=> MenuItem �ν��Ͻ� ������ ����Ű ��� : [Ctrl]+[����]
		//KeyEvent : Ű���� ���� �̺�Ʈ ������ �����ϱ� ���� Ŭ����
		//=> Ű���� ��ư ������ ����ʵ�� ����
			// - �Է±��
			//VK : Virtual Keyboard�� �ǹ�  - MenuItem�� Ctrl�� ����
		MenuItem open = new MenuItem("����", new MenuShortcut(KeyEvent.VK_O)); 
		MenuItem save = new MenuItem("����", new MenuShortcut(KeyEvent.VK_S)); 
		MenuItem exit = new MenuItem("������"); 
		MenuItem view = new MenuItem("���򸻺���"); 
		MenuItem info = new MenuItem("�޸��� ����"); 
		
		//Menu �����̳ʿ� MenuItem ���۳�Ʈ ��ġ
		file.add(open);
		file.add(save);
		file.add(exit);
		//Menu.addSeparator() : Menu �����̳ʿ� ���м��� ��ġ�ϴ� �޼ҵ�
		file.addSeparator();
		file.add(open);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		//MenuBar �����̳ʿ� Menu �����̳� ��ġ
		bar.add(file);
		bar.add(help);
		
		//Frame.setMenuBar(MenuBar m) : �������� �޴��ٸ� �����ϴ� �޼ҵ�
		setMenuBar(bar);
		
		
		
		TextArea area = new TextArea();
		area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		add(area, BorderLayout.CENTER);
		
		setBounds(500, 100, 1000, 700);
		setVisible(true);
	}
	
		
	public static void main(String[] args) {
		new MenuApp("Menu");
		
		//���ϴ� ����� �������� ����� �������� �����ϰ� 
		//�̺�Ʈ�� �߻����� �� ���ϴ� ����� ������ �� �ֵ��� ����� �ִ°��� �߿�
	}
}
