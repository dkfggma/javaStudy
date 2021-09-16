import java.util.Scanner;

public class CheckDigit {

	public static void main(String[] args) {
		
		String id;
		String[] id2 = new String[13];
		int[] id3 = new int[13];
		int sum = 0;
		int check;
		boolean check2 = false;
		
		Scanner in = new Scanner(System.in);
		id = in.nextLine();
		in.close();
		
		String[] id1 = id.split("-");
		
		id = id1[0].concat(id1[1]);
		
		for (int i = 0; i < id2.length; i++) {
			id2[i] = id.substring(i,i+1);
		}
		
		for (int i = 0; i < id2.length; i++) {
			id3[i] = Integer.parseInt(id2[i]);
		}
		
		sum = id3[0]*2+id3[0]*3+id3[1]*4+id3[2]*5+id3[3]*6
			+ id3[4]*7+	id3[5]*8+id3[6]*9+id3[7]*1+	id3[8]*2
			+id3[9]*3+id3[0]*4+id3[1]*5;
		check = 11-(sum%11);
		if(check == id3[12])
			check2 = true;
		
		System.out.println(check2);
	}

}
