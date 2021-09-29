package db04;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMem {

	private static Scanner in   = null;
	private static MemDao  mDao = null;
	public static void main(String[] args) {
		
	    in = new Scanner(System.in);
		
		System.out.println("선택하세요");
		System.out.println("1.개인조회");
		System.out.println("2.전체조회");
		System.out.println("3.회원추가");
		System.out.println("4.회원수정");
		System.out.println("5.회원삭제");
		
		mDao = new MemDao();
		mDao.open();
		
		int choice = Integer.parseInt( in.nextLine() );
		switch(choice) {
		case 1:  getMem(); break;
		case 2:  getMemList(); break;
		case 3:  insertMem();  break;
		case 4:  updateMem();  break;
		case 5:  deleteMem();  break;
		default:
			System.out.println("잘못입력하였습니다.");
		
		}
		mDao.close();
	}

	private static void getMem() {
		System.out.println("회원번호 입력: ");
		int memid = Integer.parseInt(in.nextLine());
		
		MEMVO mem = mDao.getMem( memid );
		
		System.out.println(mem);
	}

	private static void getMemList() {
		ArrayList<MEMVO> memList = mDao.getMemList();
		for (int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i));
		}
	}

	private static void insertMem() {
		System.out.println("추가할 회원 정보를 입력(회원이름) :");
		String name = in.nextLine();
		System.out.println("추가할 회원 정보를 입력(이메일) :");
		String email = in.nextLine();
		MEMVO mem = mDao.insertMem( name, email );
		System.out.println("회원정보가 추가되었습니다.");
		
	}

	private static void updateMem() {
		System.out.println("수정할 회원 번호를 입력 :");
		int memid = Integer.parseInt(in.nextLine());
		System.out.println("수정할 회원 정보를 입력(이메일) :");
		String email = in.nextLine();
		MEMVO mem = mDao.updateMem( memid, email );
		
		System.out.println("회원정보가 수정되었습니다.");
	}

	private static void deleteMem() {
		System.out.println("삭제할 회원번호 입력: ");
		int memid = Integer.parseInt(in.nextLine());
		
		MEMVO mem = mDao.deleteMem( memid );
		System.out.println("회원이 삭제되었습니다.");
	}



}
