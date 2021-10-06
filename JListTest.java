package ex03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest extends JFrame implements MouseListener, KeyListener, ListSelectionListener {

	private JTextField txtName;
	private JButton btnAdd, btnRemove;
	private JList list;

	private DefaultListModel model; // JList 에 보여질 실제 data
	private JScrollPane scrollPane; // scrollbar 처리



	public JListTest() {
		
		super("친구목록관리");
		

		initComponent(); // 화면구성

		// this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 400);

		this.setLocationRelativeTo(null); // 창 가운데 배치 : setSize() 밑에 위치 -> 가운데 위치
		this.setVisible(true);
	}

	private void initComponent() {
		// component 준비
		
		this.model = new DefaultListModel();
		this.list = new JList(model);
		this.txtName = new JTextField(30); // 30 : 크기
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		txtName.setToolTipText("이름");
		this.btnAdd = new JButton("추가");
		this.btnRemove = new JButton("삭제");
		
		FriendDao fDao = new FriendDao();
		ArrayList<FriendVo> fr = fDao.getFriendList();
		for (int i = 0; i < fr.size(); i++) {
			model.addElement(fr.get(i).getName());
		}

		// list 단일(하나만) 선택(가능)모드 설정
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		// 이벤트 연결
		// 1. 이름 : txtName - 엔터키 입력
		// 2. 추가버튼 : btnAdd - 클릭
		// 3. 삭제버튼 : btnRemove - 클릭
		// 4. 목록항목선택 : list - listSelection

		this.btnAdd.addMouseListener(this); // MouseListener
		this.btnRemove.addMouseListener(this); // MouseListener
		this.txtName.addKeyListener(this); // KeyListener
		this.list.addListSelectionListener(this); // list 목록 선택

		// 화면 레이아웃 설정
		getContentPane().setLayout(new BorderLayout());

		// JFrame 추가
		// 텍스트, 추가, 삭제 버튼 준비
		JPanel topPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		topPane.add(this.txtName);
		topPane.add(this.btnAdd);
		topPane.add(this.btnRemove);

		// JList 준비
		scrollPane = new JScrollPane(list);

		topPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		getContentPane().add(topPane, "North");
		getContentPane().add(scrollPane, "Center");

	}

	public static void main(String[] args) {

		new JListTest();

	}

	// 이벤트 처리 함수들
	// list 항목을 선택하면 : valueChanged
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// if 문이 사용되지 않으면 mouse 눌리때 한번, mouse 뗄때 한번씩 두번 실행됨
		if (!e.getValueIsAdjusting()) {
			String msg = "선택한 항목은 :  " + list.getSelectedValue();

			System.out.println(msg);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// 키보드가 눌러졌다가 올라오면 - enter 키 처치
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			addItem();
		}

	}

	// 버튼 클릭
	// btnAdd, btnRemove 처리
	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("additem");

		// 추가버튼 클릭
		if (e.getSource() == btnAdd) {
			addItem();
		}
		// 삭제 버튼 클릭
		if (e.getSource() == btnRemove) {
			int idx = list.getSelectedIndex(); // 선택한 위치를 잧아라 (0 ~)
			// -1 : 선택한 항목이 없당
			removeItem(idx);
		}

	}

	// list 힝목 추가
	private void addItem() {
		FriendDao fDao = new FriendDao();

		if (txtName.getText().trim().length() == 0)
			return;

		String name = txtName.getText();
		model.addElement(name);
		fDao.insertFriend(name);
		txtName.setText("");
		txtName.requestFocus();
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

	}

	// list 항목 삭제
	private void removeItem(int idx) {
		FriendDao fDao = new FriendDao();
		if (idx < 0)
			return;
		model.remove(idx);
		fDao.deleteFriend(idx);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
