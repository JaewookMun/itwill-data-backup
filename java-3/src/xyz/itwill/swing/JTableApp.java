package xyz.itwill.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public JTableApp(String title) {
		super(title);
		
		String[] columnNames = {"학번","이름","전화번호"};
		
		String[][] rowData = {{"1000","홍길동","010-1234-5508"}, 
				{"2000","임꺽정","010-1234-5508"},
				{"3000","전우치","010-9871-3444"},
				{"4000","일지매","010-7864-3456"},
				{"5000","장길산","010-5647-1343"}};
		
		//DefaultTableModel : 테이블 관련 정보를 저장하기 위한 클래스
		//=> 테이블의 행 또는 열(셀 : Cell)을 메소드를 호출하여 조작 가능
			//행에대한 삽입삭제 조작 가능
			//표 형식으로 값들을 표현할 수 있는 클래스 : DefaultTableModel
			//JTable은 단순히 출력하는 역할을 함. 메소드가 훨씬 더 다양. 
			//즉, 데이터처리(CRUD)의 기능은 DefaultTableModle 에 있다고 보면됨 
		DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
		
		//JTable : 값을 행과 열로 구성된 표 형식으로 출력하는 컴퍼넌트
			//JTable은 행에대한 삽입과 삭제가 불가능하다 보여주기만함.
			//DefaultTableModel이 갖고 있는 정보를 넘겨주면 이 정보들을 가지고 표를 만들 수 있다.
			//* '표'출력 컴퍼넌트 > JTable, '표 데이터 처리' > 위 Table모델
		//JTable table = new JTable(rowData, columnNames);
		JTable table = new JTable(tableModel);
		
		JScrollPane pane = new JScrollPane(table);
		
		getContentPane().add(pane, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JTableApp("Jtable");
	}
}
