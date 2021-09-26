package ex_1;

import java.util.Scanner;

public class Order {
	
	static final int N = 5;
	/*
10,20,500000,10
20,5,1000000,20
30,10,1500000,30
40,3,3000000,40
50,5,800000,50
	 */

	public static void main(String[] args) {
		
		Samsung[] s = new Samsung[N];
		input(s);
		process(s);
		output(s);

	}

	private static void input(Samsung[] s) {
		Scanner in = new Scanner(System.in);
		System.out.println("제품번호,수량,단가,부서");
	    for (int i = 0; i < s.length; i++) {
	    	String line = in.nextLine();
	    	String[] li = line.split(",");
	    	int sn = Integer.parseInt(li[0]); 
	    	int pn = Integer.parseInt(li[1]);
	    	int cost = Integer.parseInt(li[2]);
	    	int dpm = Integer.parseInt(li[3]);
			s[i] = new Samsung(sn, pn, cost, dpm);
		}
	    in.close();
	}
	

	private static void process(Samsung[] s) {
		for (int i = 0; i < s.length; i++) {
			s[i].getSum();
			s[i].getDpn();
			s[i].getPdn();
		}
		
		getRank(s);
	}

	private static void getRank(Samsung[] s) {
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if(i==j) continue;
				if(s[i].getSum()< s[j].getSum()) {
					s[i].setRank(s[i].getRank()+1);
				}
			}
		}
	}

	private static void output(Samsung[] s) {
		for (int i = 0; i < s.length; i++) {
		s[i].print();
		System.out.println(s[i].getRank());
		}
	}

}
