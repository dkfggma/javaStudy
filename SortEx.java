
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class SortEx {

	//sort : 자료를 순서대로 정렬하는것
	//ascending  오름차순 : 1 -> 9, abcd
	//descending 내림차순 : 9 -> 1, dcba

	public static void main(String[] args) {

		int[] scores = {99, 100, 88, 56};
		
		dispArr(scores);
		//정렬
		Arrays.sort(scores);
		dispArr(scores);
		
		// 숫자 배열 역순(descending sort)
		Integer[] scores2 = {99, 100, 88, 56};
		//Integer[] scores2 = scores;
		System.out.println("숫자 desc---------------------------");
		for (int i = 0; i < scores2.length; i++) {
			System.out.print(scores2[i]+" ");
		}
		System.out.println();
		Arrays.sort(scores2, Collections.reverseOrder()); //내림차순 (대신 레퍼클래스여야함)
		for (int i = 0; i < scores2.length; i++) {
			System.out.print(scores2[i]+" ");
		}
		System.out.println();
		//---------------------------------------------
		Integer[] arr ={99, 100, 88, 56};
		System.out.println("arr="+Arrays.toString(arr));
		//익명 class (레퍼클래스여야만함)
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//return o1 - o2;//asc
				return o2 - o1;//dssc
			}
			
		});
		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("-------------------------------");
		
		String[] menuList = {"JAVA","JSP","ORACLE","SPRING"};
		System.out.println("menuList=" + Arrays.toString(menuList));
		Arrays.sort(menuList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//return o1.compareTo(o2);
				return o2.compareTo(o1);
			}
			
		});
		System.out.println("menuList=" + Arrays.toString(menuList));
		
		System.out.println("----------------------------------------------------");
		
		//람다식 사용
		Integer [] scores3 = {100, 80, 70, 95, 50};
		System.out.println("scores3 =" + Arrays.toString(scores3));
		Arrays.sort(scores3, (o1,o2)->o1 - o2);
		System.out.println("scores3 =" + Arrays.toString(scores3));
		Arrays.sort(scores3, (o1,o2)->o2 - o1);
		System.out.println("scores3 =" + Arrays.toString(scores3));
		
		System.out.println("-------------------------------------------------------");
		String[] names = {"깜모", "김쉑흉", "한잔만", "홍짱석"};
		
		dispArrStr(names);
		Arrays.sort(names);
		dispArrStr(names);
		
		//ArrayList<Member> m = new ArrayList<>();
		//m.add(1, "깜모");
		
		Member m1 = new Member(3, "깜모");	
		Member m2 = new Member(1, "김쉑흉");	
		Member m3 = new Member(2, "한잔만");	
		
		Member[] members = {m1,m2,m3};
		dispArrMember(members);
		Arrays.sort(members);
		dispArrMember(members);
	}

	private static void dispArrMember(Member[] members) {
		for (int i = 0; i < members.length; i++) {
			System.out.println( members[i] +" " );
		}
		System.out.println();
	}

	private static void dispArrStr(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.println( names[i] +" " );
		}
		System.out.println();
	}

	private static void dispArr(int[] scores) {
		for (int i = 0; i < scores.length; i++) {
			System.out.println( scores[i] +" " );
		}
		System.out.println();
	}

}
