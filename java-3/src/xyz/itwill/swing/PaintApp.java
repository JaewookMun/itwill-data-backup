package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

//프레임에서 마우스 버튼을 클릭하면 클릭한 위치의 좌표값을 프레임에 문자열로 출력하는 프로그램
public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//마우스 버튼을 클릭한 위치의 좌표값을 저장하기 위한 필드
	//private Point point; 
		// Point 클래스를 이용하는 경우가 많음 (official한 느낌)
	private int x, y;
	
	public PaintApp(String title) {
		super(title);
		
		//프레임에서 발생되는 MouseEvent를 처리하기 위한 이벤트 핸들러 등록
		//=> MouseAdapter 클래스를 상속받은 Anonymous Inner Class로 이벤트 핸들러 등록
		addMouseListener(new MouseAdapter() {
			//마우스 버튼을 누른 경우 호출되는 이벤트 핸들러 메소드를 오버라이드 선언
			@Override
			public void mouseClicked(MouseEvent e) {
				//MouseEvent.getX() : 마우스 이벤트가 발생된 X좌표값을 반환하는 메소드
				x=e.getX();
				
				//MouseEvent.getY() : 마우스 이벤트가 발생된 Y좌표값을 반환하는 메소드
				y=e.getY();
				
					//수동으로 paint()메소드를 호출하는 방법 - 컨테이너를 다시 그리기위해 사용
				//Window.repaint() : paint() 메소드를 호출하는 메소드
				//=> paint() 메소드를 직접 호출할 수 없을 때 사용하는 메소드
				//paint(getGraphics());
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 300, 400);
		setVisible(true);
	}
	
		//main 스레드는 생성자만 만들어주고 끝난다.
		//EventQueue라는 스레드가 존재. 프레임이 종료될때까지 기다린다.
		//GUI프로그램에서 main 스레드는 생성자를 실행시키는 역할. EventQueue가 실행되며 프레임 유지
		//스레드를 만들지 않아도 GUI프로그램은 디자인, 이벤트와 관련된 스레드가 여러개 동작 - 다중스레드 프로그램
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
	
	//JWindow.paint(Graphics g) : 컨테이너(JFrame, JWindow, JDialog 등)를 출력하는 메소드
	//paint() 메소드는 컨테이너 관련 이벤트가 발생될 경우 자동 호출
	//=> 프로그램이 실행되어 컨테이너가 보여질 경우
	//=> 프로그램이 아이콘에서 해제되어 컨테이너가 보여질 경우
	//=> 컨테이너의 크기가 변경될 경우
	//Graphics : 컨테이너에 그림을 그리기 위한 기능을 제공하는 클래스
	//=> paint() 메소드가 호출될 때 매개변수에 Graphics 인스턴스가 자동으로 저장
	@Override
	public void paint(Graphics g) {
		//System.out.println("["+Thread.currentThread().getName()+"]이름의 스레드에 의해 paint() 메소드의 명령호출");
			// [AWT-EventQueue-0]이름의 스레드가 실행
		
		//부모 클래스의 숨겨진 메소드 호출 - 컨테이너 초기화
			//부모클래스가 컨테이너를 초기화시켜주는 역할을 해준다. - 프레임을 다시 그려준다.
			//지우면 화면을 재조정할때 (resize) 화면이 이상하게 보인다.
		super.paint(g);
			//super.paint(g) 밑에 명령을 작성해야 화면에서 볼 수 있다.
		
		/*
		g.setColor(Color.RED);
		g.drawRect(20, 40, 50, 50);
		g.fillRect(20, 100, 100, 50);
		
		g.setColor(Color.GREEN);
		g.drawOval(125, 175, 50, 50); //정사각형에 타원을 그리면 원이됨.
		g.fillOval(100, 250, 100, 50);
		
		g.setColor(Color.BLUE);
		g.drawLine(100, 320, 200, 320);
		g.drawString("홍길동", 100, 350);
		*/
		
			//click 후 윈도우창을 조절할 떄 생성
			//필요할 때 호출
		g.drawString("["+x+","+y+"]", x, y);
	}
	
}
