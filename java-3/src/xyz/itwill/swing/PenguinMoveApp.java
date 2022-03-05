package xyz.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame{
	private static final long serialVersionUID = 1L;

	private static final int JFRAME_WIDTH = 616;
	private static final int JFRAME_HEIGHT = 461;
	
	private static final int PENGUIN_SIZE = 60;

	//배경 이미지를 저장하기 위한 필드
	//Image : 이미지 정보를 저장하기 위한 클래스
	private Image backgroundImage;

	//펭귄 이미지를 저장하기위한 필드
	private Image[] penguins;
	
	//펭귄 이미지를 선택하기 위한 필드 - 배열 첨자
	private int penguinNo;
	
	//펭귄 이미지가 출력될 좌표값을 저장하기 위한 필드
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		super(title);
		
		//ImageIcon : 이미지 파일의 정보를 저장하기 위한 클래스
		//=> ImageIcon(URL location) : 이미지 파일의 경로를 전달받아 ImageIcon 인스턴스를 생성하는 생성자
		//URL : 리소스 파일(그림 파일, 음향 파일, 동영상 파일 등) 경로를 저장하기 위한 클래스
		//Object.getClass() : 메모리에 저장된 현재 클래스 정보를 Class 인스턴스(Clazz)로 반환하는 메소드
		//Class.getResource(String name) : 클래스 기준으로 리소스 파일을 읽어 URL 인스턴스로 반환하는 메소드
		//ImageIcon.getImage() : 이미지 파일의 이미지 정보(Image 인스턴스)를 반환하는 메소드
			//file name 
			//URL location -> 인터넷 상의 파일도 읽어들일 수 있음.
			// class path - 클래스가 읽어들일 수 있는 위치 : src까지밖에 못 읽어들인다.
			// 위처럼 하는 이유는 나중에 배포의 편의성을 높이기 위해서이다.
			// src폴더에 함께 배포하면 같이 사용가능.
			// 절대경로 (C://~~)를 사용하면 해당 위치에 이미지가 없으면 깨지는 현상이 발생하여 배포하기 힘들다.
			//PenguinMoveApp.class를 getClass()대신 사용해도 되지만, 클래스 이름이 바뀌면 찾지 못하기 때문에 getClass() 사용
			//메모리에 저장된 클래스를 직접불러들이는것(getClass()) '리플랙션'이라고 표현한다.
			//"/images/back.jpg"에서 '/' src폴더를 의미한다.
		backgroundImage = new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
			//압축률이 가장 높은 이미지파일 : jpg (해상도 high), 압축률이 낮은 이미지파일 : gif (예] 화살표) 
			//중간 : png
		penguins = new Image[3];
		for(int i=0; i<penguins.length; i++) {
				//배열의 첨자 반복문 & 파일이름
			penguins[i] = new ImageIcon(getClass().getResource("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		//penguinNo=0; - 생성자가 필드를 초기화하기 때문에
		
		penguinX = JFRAME_WIDTH/2 - PENGUIN_SIZE/2;
		penguinY = JFRAME_HEIGHT - PENGUIN_SIZE;
		
		//프레임에서 키보드 관련 이벤트가 발생될 경우 처리할 이벤트 핸들러 등록
		addKeyListener(new PenguinMoveHandle());
		
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("Penguin");
	}
	
	@Override
	public void paint(Graphics g) {
			//setResizable을 false로 했기 때문에 super.paint(g)를 주석처리할 수 있다.
		//super.paint(g);
		
		
		//g.drawImage(Image image, int x, int y, int width, int height, ImageObserver observer)
		//=> 이미지를 출력하는 메소드
		g.drawImage(backgroundImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
		
	}
	
	//키보드 관련 이벤트(KeyEvent)를 처리하기 위한 이벤트 핸들러 클래스
	public class PenguinMoveHandle implements KeyListener {

		//키보드를 눌렀다 띄었을 때 호출되는 메소드
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
		//키보드를 눌렀을 때 호출되는 메소드
		@Override
		public void keyPressed(KeyEvent e) {
			//KeyEvent.getKeyCode() : 이벤트를 발생시킨 키보드의 고유값을 반환하는 메소드
				//keyCode는 고유값이다. - 중복되지 않는다.
			int keyCode=e.getKeyCode();
			
			//KeyEvent.getKeyChar() : 이벤트를 발생시킨 키보드의 문자값을 반환하는 메소드
			//int keyChar=e.getKeyChar();
			
			//System.out.println("keyCode = "+keyCode+", keyChar = "+keyChar);
			
			//이벤트가 발생된 키보드를 구분하여 이벤트 처리
			switch (keyCode) {
			//왼쪽 방향키를 누른 경우
			case KeyEvent.VK_LEFT:
				penguinX -= 10;
				if(penguinX<=0) {
					penguinX = 0;
				}
				penguinNo++;
				penguinNo %= 3;
				repaint();
				break;

			//오른쪽 방향키를 누른 경우	
			case KeyEvent.VK_RIGHT:
				penguinX += 10;
				if(penguinX >= JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX = JFRAME_WIDTH-PENGUIN_SIZE;
					//penguinX = -PENGUIN_SIZE;
				}
				penguinNo++;
				penguinNo %= 3;
				repaint();
				break;
			}
		}
		
		//키보드를 띄었을 때 호출되는 메소드
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}
