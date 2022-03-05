package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//날짜와 시간을 출력하는 GUI 프로그램
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//날짜와 시간을 출력하기 위한 컴퍼넌트
	private JLabel clockLabel;
	
	//스레드를 일시 중지하거나 다시 실행하기 위한 컴퍼넌트
	private JButton startBtn, stopBtn;
	
	//날짜와 시간정보를 변경하는 스레드의 실행 상태를 저장하기 위한 필드
	//=> false : 스레드 일시 중지 상태, true : 스레드 동작 상태(기본)
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);
			
			//버튼의 눌림에 따라 상태가 바뀔수 있도록 함 -> 상태에 따라 스레드가 명령을 수행하도록 조절할 수 있다.
		isRun=true;
		
		//clockLabel = new JLabel("2021년 05월 25일 16시 55분 30초", JLabel.CENTER);
		clockLabel = new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림", Font.BOLD, 30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("다시 실행");
		stopBtn=new JButton("일시 중지");
		JPanel panel = new JPanel();
		panel.add(startBtn);
		panel.add(stopBtn);
		
		startBtn.setFont(new Font("굴림", Font.BOLD, 20));
		stopBtn.setFont(new Font("굴림", Font.BOLD, 20));
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		//새로운 스레드를 생성하여 run() 메소드에 명령 실행
		new ClockThread().start();
		
		//버튼을 누른 경우 이벤트 핸들러 클래스의 메소드가 호출되도록 이벤트 핸들러 등록
		startBtn.addActionListener(new ButtonEventHandler());
		stopBtn.addActionListener(new ButtonEventHandler());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
	}
	
		// main thread는 객체를 생성하며 컴퍼넌트 등 디자인을 구현하고 종료됨.
		// 종료 후 EventQueue 같은 event thread는 이벤트가 발생하기 전까지 종료되지 않음.
		// GUI는 실질적으로 무한루프이기 때문에 무한루프를 의도적으로 사용하는 경우가 많다.
		// GUI는 다중스레드 프로그램이기 때문에 새롭게 스레드를 만들어서 활용 및 제어하는 법을 알아야 한다.
		// 자동으로 동작되는 기능을 만들기 위해서 thread를 추가해야함.
	public static void main(String[] args) {
		new DigitalClockApp("DigitalClock");
		
	}
	
	//시스템의 현재 날짜와 시간 정보를 얻어와 컴퍼넌트를 변경하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			
			while(true) {
					//  thread를 중지시키는 것이 아니라 if문을 통해 thread가 명령을 못읽게 만든다.
					// 못읽게 만들어서 프로그램을 중지시키는 효과를 가져옴
					//  wait()를 통해 스레드를 중지시키는 것보다 boolean 변수를 통해 조건에 따라 thread를 제어하는것이 좀더 효율적
					// wait or resume을 잘못 사용할 경우 interrupt(응답없음)이 발생할 수 있음
				if(isRun) {			
					/*
					Date now = new Date();
					String clock = dateFormat.format(now);
					clockLabel.setText(clock);
					*/
					clockLabel.setText(dateFormat.format(new Date()));
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//버튼을 누른 경우 동작될 이벤트 핸들러 클래스
	public class ButtonEventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource = e.getSource();
			if(eventSource == startBtn) {
				isRun=true;
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			} else if(eventSource == stopBtn) {
				isRun=false;
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				
			}
		}
	}
}
