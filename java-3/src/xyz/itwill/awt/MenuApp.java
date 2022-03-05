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
		
		//MenuBar : Menu 컨테이너를 배치하기 위한 컨테이너 - Frame에 배치
		//=> Frame에 배치하는 컨테이너
		MenuBar bar = new MenuBar();
		
		//Menu : MenuItem 컴퍼넌트를 배치하기 위한 컴퍼넌트
		//=> MenuBar에 배치하는 컨테이너
			//"파일", "도움말" : Menu Label
		Menu file = new Menu("파일"); 
		Menu help = new Menu("도움말");
		
		//MenuItem : 선택 기능을 제공하는 컴퍼넌트
		//=> Menu에 배치하는 컴퍼넌트
		//MenuShortcut : 단축키 관련 정보를 저장하기 위한 클래스
		//=> MenuItem 인스턴스 생성시 단축키 등록 : [Ctrl]+[문자]
		//KeyEvent : 키보드 관련 이벤트 정보를 저장하기 위한 클래스
		//=> 키보드 버튼 정보를 상수필드로 제공
			// - 입력기능
			//VK : Virtual Keyboard를 의미  - MenuItem은 Ctrl만 가능
		MenuItem open = new MenuItem("열기", new MenuShortcut(KeyEvent.VK_O)); 
		MenuItem save = new MenuItem("저장", new MenuShortcut(KeyEvent.VK_S)); 
		MenuItem exit = new MenuItem("끝내기"); 
		MenuItem view = new MenuItem("도움말보기"); 
		MenuItem info = new MenuItem("메모장 정보"); 
		
		//Menu 컨테이너에 MenuItem 컴퍼넌트 배치
		file.add(open);
		file.add(save);
		file.add(exit);
		//Menu.addSeparator() : Menu 컨테이너에 구분선을 배치하는 메소드
		file.addSeparator();
		file.add(open);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		//MenuBar 컨테이너에 Menu 컨테이너 배치
		bar.add(file);
		bar.add(help);
		
		//Frame.setMenuBar(MenuBar m) : 프레임의 메뉴바를 변경하는 메소드
		setMenuBar(bar);
		
		
		
		TextArea area = new TextArea();
		area.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		add(area, BorderLayout.CENTER);
		
		setBounds(500, 100, 1000, 700);
		setVisible(true);
	}
	
		
	public static void main(String[] args) {
		new MenuApp("Menu");
		
		//원하는 모양의 프레임을 만들어 디자인을 구성하고 
		//이벤트가 발생했을 때 원하는 기능이 구현될 수 있도록 만들어 주는것이 중요
	}
}
