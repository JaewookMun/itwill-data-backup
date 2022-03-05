package xyz.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//색상버튼을 누른 경우 캔버스의 배경색을 변경하는 프로그램
public class ActionCommandApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//이벤트 핸들러 메소드에서 사용할 컴퍼넌트 또는 컨테이너는 필드로 선언하여 저장
		//생성자에서 선언 및 초기화를 하면 외부에서 사용하지 못하기 때문에.
		//  -> 이벤트핸들러클래스에서 사용할 수 있도록
		//이벤트핸들러클래스로 수정하지 않을 경우 생성자 내부에서 선언&초기화해도 괜찮다. (Field에서 할 필요가 없음.) 
	Button red, green, blue, white;
	Canvas canvas;
	
	public ActionCommandApp(String title) {
		super(title);
		setBounds(800, 200, 400, 400);

		red=new Button("빨간색");
		red.setForeground(Color.RED);//
		green=new Button("초록색");
		green.setForeground(Color.GREEN);//
		blue=new Button("파란색");
		blue.setForeground(Color.BLUE);//
		white=new Button("하얀색");
		white.setForeground(Color.WHITE);//
		
		Panel panel = new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		canvas=new Canvas();
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		panel.setBackground(Color.GRAY);
		
		white.setEnabled(false);
		
		/*
		red.addActionListener(new RedButtonEventHandler());
		green.addActionListener(new GreenButtonEventHandler());
		blue.addActionListener(new BlueButtonEventHandler());
		white.addActionListener(new WhiteButtonEventHandler());
		*/
		
		red.addActionListener(new ColorButtonEventHandler());
		green.addActionListener(new ColorButtonEventHandler());
		blue.addActionListener(new ColorButtonEventHandler());
		white.addActionListener(new ColorButtonEventHandler());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ActionCommandApp("ActionCommand");
	}
	
	/*
	
	//모든 생상 버튼을 활성화 처리하는 메소드 - 초기화
	private void initColorButton() {
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		white.setEnabled(true);
	}
	
	public class RedButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			initColorButton();
			red.setEnabled(false);
			
			canvas.setBackground(Color.RED);
		}
	}
	public class GreenButtonEventHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			initColorButton();
			green.setEnabled(false);
			
			canvas.setBackground(Color.GREEN);
		}
	}
	public class BlueButtonEventHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			initColorButton();
			blue.setEnabled(false);
			
			canvas.setBackground(Color.BLUE);
		}
	}
	public class WhiteButtonEventHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			initColorButton();
			white.setEnabled(false);
			
			canvas.setBackground(Color.WHITE);
		}
	}
	*/

		//색별로 이벤트핸들러를 만드는 것이 아니라 하나의 이벤트핸들러를 통해 이벤트 처리
	public class ColorButtonEventHandler implements ActionListener {
		//이벤트 핸들러 메소드의 매개변수에는 이벤트 소스에 의해 생성된 XXXEvent 인스턴스가
		//자동으로 전달되어 저장
		//=> 매개변수에 저장된 이벤트 정보를 이용하여 이벤트 소스 구분
			//자동호출되는 메소드는 필요한 정보를 자동으로 받는다.
		@Override
		public void actionPerformed(ActionEvent e) {
			red.setEnabled(true);
			green.setEnabled(true);
			blue.setEnabled(true);
			white.setEnabled(true);
			
			//이벤트 소스를 구분하여 이벤트 처리
			//ActionEvent.getActionCommand() : ActionEvent를 발생시킨 이벤트 소스의
			//ActionCommand를 반환하는 메소드
			//ActionCommand : ActionEvent를 발생시킨 컴퍼넌트의 이름(문자열)
			//=> Button 컴퍼넌트는 버튼 라벨명이 ActionCommand로 설정
				//컴퍼넌트마다 컴퍼넌트를 표현할 수 있는 이름이 있다.
				//actionEvent에 적용됨
				//더좋은방법 존재
			String actionCommand=e.getActionCommand();
			
			if(actionCommand.equals("빨간색")) {
				red.setEnabled(false);
				canvas.setBackground(Color.RED);
			} else if(actionCommand.equals("초록색")) {
				green.setEnabled(false);
				canvas.setBackground(Color.GREEN);
			} else if(actionCommand.equals("파란색")) {
				blue.setEnabled(false);
				canvas.setBackground(Color.BLUE);
			} else if(actionCommand.equals("하얀색")) {
				white.setEnabled(false);
				canvas.setBackground(Color.WHITE);
			} 
			
		}
		
	}
}
