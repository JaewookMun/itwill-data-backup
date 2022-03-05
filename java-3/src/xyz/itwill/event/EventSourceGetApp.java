package xyz.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//ActionEvent가 발생되는 경우
//1.Button 컴퍼넌트를 누른 경우
//2.MenuItem 컴퍼넌트를 선택한 경우
//3.TextField 컴퍼넌트에서 엔터를 입력한 경우
public class EventSourceGetApp extends Frame{
	private static final long serialVersionUID = 1L;

	MenuItem init, exit;
	Button red, green, blue, black;
	TextArea area;
	TextField field;
	
	public EventSourceGetApp(String title) {
		super(title);
		setBounds(800, 200, 400, 500);
		
		MenuBar bar=new MenuBar();
		Menu menu = new Menu("파일");
		init= new MenuItem("화면 초기화", new MenuShortcut(KeyEvent.VK_I));
		exit= new MenuItem("프로그램 종료", new MenuShortcut(KeyEvent.VK_E));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setMenuBar(bar);
		
		red=new Button("빨간색");
		green=new Button("초록색");
		blue=new Button("파란색");
		black=new Button("검정색");
		
		Panel panel = new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new TextArea();
		field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		black.setEnabled(false);
		area.setFocusable(false);	//출력 컴포넌트의 역할만 할 수 있도록 false로 설정하여 커서 제거
		panel.setBackground(Color.GRAY);
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		//이벤트 핸들러 등록
			//MenuItem, Button, TextField 를 한개의 핸들러 클래스에서 처리할 수 있다.
		init.addActionListener(new ActionEventHandler());
		exit.addActionListener(new ActionEventHandler());
		red.addActionListener(new ActionEventHandler());
		green.addActionListener(new ActionEventHandler());
		blue.addActionListener(new ActionEventHandler());
		black.addActionListener(new ActionEventHandler());
		field.addActionListener(new ActionEventHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new EventSourceGetApp("EventSource");
	}
	
	//모든 컴퍼넌트에서 발생된 ActionEvent를 처리하기 위한 이벤트 핸들러 클래스
		//TextField는 대표할 수 있는 이름이 없어서 ActionCommand로 이벤스 소스를구분하기 힘들다.
	public class ActionEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//EventObject.getSource() : 이벤트가 발생된 컴퍼넌트(Event Source)를 반환하는 메소드
			//=> 이벤트 소스를 Object 타입으로 반환
			
			Object eventSource=e.getSource();
			//이벤트 소스를 컴퍼넌트 클래스로 구분하여 처리
				//Object로 인스턴스를 받았기 때문에 강제형변환 전에 소스 출처클래스를 확인
			if(eventSource instanceof MenuItem) {
				//이벤트 소스를 컴퍼넌트 인스턴스로 구분하여 처리 - 인스턴스 비교
				if(eventSource==init) {
					//Component.setText(String text) : 컴퍼넌트의 문자열을 변경하는 메소드
						//문자 하나도 없이 만들겠다. => 화면 초기화
					area.setText("");//컴퍼넌트의 텍스트 초기화
				} else if(eventSource==exit) {
					System.exit(0);
				}
			} else if(eventSource instanceof Button) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				//명시적 객체 형변환을 이용하여 Object 타입을 Button 타입으로 형변환
				//=> Button 클래스의 메소드 호출
				((Button)eventSource).setEnabled(false);
				
				if(eventSource==red) {
					//red.setEnabled(false);
					area.setForeground(Color.RED);
				}else if(eventSource==green) {
					//green.setEnabled(false);
					area.setForeground(Color.GREEN);
					
				}else if(eventSource==blue) {
					//blue.setEnabled(false);
					area.setForeground(Color.BLUE);
					
				}else if(eventSource==black) {
					//black.setEnabled(false);
					area.setForeground(Color.BLACK);
					
				}
				
			} else if(eventSource instanceof TextField) {
				//Component.getText() : 컴퍼넌트의 문자열을 반환하는 메소드
				//=> TextField 컴퍼넌트에서는 키보드로 입력한 문자열을 반환
					//엔터를 치면 액션이 발생하는데 엔터치기 전까지 입력한 값을 위로 올리는 역할을 함
				String text = field.getText();
				
				if(!text.equals("")) {//반환받은 문자열이 있는 경우
					//TextArea.append(String) : 전달받은 문자열을 TextArea 컴퍼넌트에
					//추가하여 출력하는 메소드
					area.append("[홍길동]"+text+"\n");
					field.setText("");
				}
				
			}
		
		}
		
	}
}
