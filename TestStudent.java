package sungjuk3;

import java.util.Scanner;

public class TestStudent {
//data
	/*
1,황팔찌,70,80,80
2,깜깜모,50,60,60
3,김쉑흉,100,100,100
4,한잔만,70,70,80
5,홍짱석,90,80,80
	 */
	static final int N = 5;// 상수 선언

	public static void main(String[] args) {

		Student[] s = new Student[N];
		
		
		input(s);
		process(s);
		output(s);

	}

	private static void input(Student[] s) {
		Scanner in = new Scanner(System.in);
		System.out.println("번호,이름,국어,영어,수학");
		for (int i = 0; i < s.length; i++) {
			String line = in.nextLine();
			String[] li = line.split(",");
			int num = Integer.parseInt(li[0]);
			String name = li[1];
			int kor = Integer.parseInt(li[2]);
			int eng = Integer.parseInt(li[3]);
			int mat = Integer.parseInt(li[4]);
			s[i] = new Student(num, name, kor, eng, mat);
		}
		in.close();
	}

	private static void process(Student[] s) {
		//총점,평균,학점
		for (int i = 0; i < s.length; i++) {
			s[i].getTot();
			s[i].getAvg();
			s[i].getGrade();
		}
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if( i!=j&& s[i].getAvg() < s[j].getAvg() ) {
						s[i].getRank();
					}
					
				}
			}
		}
	

	private static void output(Student[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.printf("번호 %d, 이름 %s, 국어 %3d, 영어 %3d, 수학 %3d, 총점 %3d, 평균%3d, 학점 %c, 등수%d\n",
					s[i].getNum(),s[i].getName(),s[i].getKor(),s[i].getEng(),s[i].getMat(),s[i].getTot(),s[i].getAvg(),s[i].getGrade(),s[i].getRank());			
		}
	}
}
