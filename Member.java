//implements Comparable<E> : Arrys.sort()의 인자로 사용하기 위해서
public class Member implements Comparable<Member> {
	
	private int num;
	private String name;
	

	public Member(int num, String name) {
	
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + "]";
	}

	//정렬을 위한 비교 option지정
	@Override
	public int compareTo(Member o) {
		
		//return this.num - o.num;          //숫자(asc)
		//return this.name.compareTo(o.name); //문자(asc)
		//return o.num - this.num;            //숫자(desc)
		return o.name.compareTo(this.name); //문자(desc)
	}
	
	

}
