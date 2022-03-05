package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//�ؽ�Ʈ ���� ������ ���α׷� - �޸���
public class NotepadApp extends JFrame implements ActionListener {
		//notepadApp���� ��ü������� �� ���� �ƴϱ� ������ UID�� default�� ����
	private static final long serialVersionUID = 1L;
	
		//�̺�Ʈ �ڵ鷯���� ����ϱ� ���� �ʵ�� ����(�̺�Ʈ �ڵ鷯�� �̿����� �����Ÿ� ���⿡ ������ �ʿ� x)
	private JMenuItem init, open, save, exit;
	private JTextArea area;
	private FileDialog openDialog, saveDialog;

	//���� �������� ������ ��θ� �����ϱ� ���� �ʵ�
	private String filePath;
	
	//JTextArea ���۳�Ʈ�� ���� ���� ���¸� �����ϱ� ���� �ʵ�
	//=> false : �̺���, true : ����
	private boolean state;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu = new JMenu("����(F)");
		menu.setMnemonic('F');
		init=new JMenuItem("���� �����(N)", 'N');
		open=new JMenuItem("����(O)", 'O');
		save=new JMenuItem("����(S)", 'S');
		exit=new JMenuItem("������(X)", 'X');
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		menu.add(init);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		area=new JTextArea();
		area.setFont(new Font("����", Font.PLAIN, 16));
		JScrollPane pane = new JScrollPane(area);
		getContentPane().add(pane, BorderLayout.CENTER);
		
		openDialog=new FileDialog(this, "����", FileDialog.LOAD);
		saveDialog=new FileDialog(this, "����", FileDialog.SAVE);
		
		init.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//JTextArea ���۳�Ʈ���� Ű���� �̺�Ʈ�� �߻��� ��� ����� �̺�Ʈ �ڵ鷯 ���
		//=> �̺�Ʈ �ڵ鷯�� Anonymous Inner Type���� ���
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//�̺�Ʈ �߻� Ű������ ���ڰ��� Null�� �ƴ� ���
					// \0 : Null�� �ǹ�
				if(e.getKeyChar() != '\0' && !state) {
					state=true;
					setTitle("* "+getTitle()); //������ ���� ����
				}
			}
		});
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//�������� �ݱ� ��ư�� ���� ��� ����� �̺�Ʈ �ڵ鷯 ���
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!saveConfirm()) return;
				System.exit(0);
			}
		});
		
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("���� ���� - Java �޸���");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if(eventSource == init) {
			//���� ���̾�α׿��� ��� �Ǵ� â�ݱ⸦ ������ ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ����
			if(!saveConfirm()) return;
			
			//JTextArea ���۳�Ʈ �ʱ�ȭ
			area.setText("");
			//���� ��� �ʱ�ȭ
			filePath=null;
			//�������� ���� ����
			setTitle("���� ���� - Java �޸���");
			
		} else if(eventSource == open) {
			if(!saveConfirm()) return;
			//���� ���� FileDialog ���۳�Ʈ�� ȭ�鿡 ���
			//=> ������ �����ϰų� ������ ����� ��� FileDialog ���۳�Ʈ�� �ڵ����� ���� ó��
			openDialog.setVisible(true);
			
			//FileDialog ���۳�Ʈ���� ������ ����� ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ����
			//FileDialog.getFile() : ���� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
			if(openDialog.getFile()==null) return;
			
			//���� ������ ��θ� ��ȯ�޾� �ʵ忡 ����
			//FileDialog.getDirectory() : ���� ������ ����� ���� ��θ� ��ȯ�ϴ� �޼ҵ�
			filePath = openDialog.getDirectory()+openDialog.getFile();
			
				
				//override�� �޼ҵ忡�� ���ܴ� �����ѱ��.(Throws ��� �Ұ���)
			try {
				//���� �Է� ��Ʈ���� �����Ͽ� ����
				BufferedReader in = new BufferedReader(new FileReader(filePath));
				
				//���� ���ϸ����� �������� ���� ����
				setTitle(openDialog.getFile()+" - Java �޸���");
				
				//JTextArea ���۳�Ʈ �ʱ�ȭ
				area.setText("");
				
				//���Ͽ� ����� ���� �о� JTextArea ���۳�Ʈ�� ���
				//=> ���� ������ �� �پ� �о� JTextArea ���۳�Ʈ�� �߰� - �ݺ� ó��
					// ����('\n') - ���� �����͸� �����ϴ� �������̴�.
				while(true) {
					//���� �Է� ��Ʈ������ ����(Enter) �������� ���� �����͸� �о� ���ڿ��� ��ȯ
					String text=in.readLine();
					if(text==null) break;
					area.append(text+"\n");
				}
				
				//JTextArea ���۳�Ʈ�� Ŀ���� ó�� ��ġ�� ����
				//JTextArea.setCaretPosition(int position) : Ŀ�� ��ġ�� �����ϴ� �޼ҵ�
				area.setCaretPosition(0);
				
				in.close();
			} catch (FileNotFoundException exception) {
				JOptionPane.showMessageDialog(this, "������ ������ �����ϴ�.","����",JOptionPane.ERROR_MESSAGE);
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�.","����",JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(eventSource == save) {
			if(filePath==null) { //���� �������� ������ ���� ���
				//���� ���� FileDialog ���۳�Ʈ�� ȭ�鿡 ���
				saveDialog.setVisible(true);
				
				//FileDialog ���۳�Ʈ���� ������ ����� ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ����
				if(saveDialog.getFile()==null) return;
				
				//���� ������ ��θ� ��ȯ�޾� �ʵ忡 ����
				filePath = saveDialog.getDirectory()+saveDialog.getFile();
				
				//���� ���ϸ����� �������� ���� ����
				setTitle(saveDialog.getFile()+" - Java �޸���");
			}
			
			try {
				//���� ��� ��Ʈ���� �����Ͽ� ����
				BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
				
				//JTextArea ���۳�Ʈ�� ��� ���ڿ��� ��ȯ�޾� ����
					//���پ� �о���̴� ���� �ƴϱ� ������ �ݺ�ó������ �ʴ´�.
					//��°�� �о���̰� ��°�� �����Ѵ�.
				String text = area.getText();
				
				//���� ��� ��Ʈ���� ���ڿ��� �����Ͽ� ����
				out.write(text);
				
				out.close();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�.","����",JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(eventSource == exit) {
			if(!saveConfirm()) return;
			System.exit(0);
		}
	}
	
	//JTextArea ���۳�Ʈ�� ���� ���濡 ���� ���� ������ ���� ó���ϱ� ���� �޼ҵ�
	//=> ���� ���̾�α׸� ����Ͽ� ���� ���� ���� ó��
	//=> ��ȯ�� - false : â�ݱ� �Ǵ� ���, true : ���� �Ǵ� ������
	//=> [���� �����], [����], [������] JMenuItem ���۳�Ʈ�� ������ ��� ȣ��
	public boolean saveConfirm() { //JTextArea ���۳�Ʈ�� ������ ����� ���
		//JOptionPane.showConfirmDialog(Component parent, Object Message
		//, String title, int option) : ���� ���̾�α׸� ����ϴ� �޼ҵ�
		//=> ���ð�(������) ��ȯ
		int choice = JOptionPane.showConfirmDialog(this, "����� ������ ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION);
		
		
		if(choice==JOptionPane.YES_OPTION) {//��(����)�� ������ ���
			if(filePath==null) { 
				saveDialog.setVisible(true);
				if(saveDialog.getFile()==null) return false;
				filePath = saveDialog.getDirectory()+saveDialog.getFile();
				setTitle(saveDialog.getFile()+" - Java �޸���");
			}
			
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
				String text = area.getText();
				out.write(text);
				
				out.close();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�.","����",JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(choice == JOptionPane.CLOSED_OPTION || choice == JOptionPane.CANCEL_OPTION) {
			//â�ݱ� �Ǵ� ��Ҹ� ������ ���
			return false;
		}
		
		//���� �Ǵ� �������� ������ ���
		state=false; //���� ���� �ʱ�ȭ
		return true;
	}
	
}