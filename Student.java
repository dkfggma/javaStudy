package sungjuk3;

public class Student {
	//Field
	private int    num;
	private String name;
	private int    kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private int    avg;
	private char   grade;
	private int rank;
	
	//constructor
	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Student() {
		
	}

	public void print() {
		String fmt =  "%3d, %-4s, %3d, %3d, %3d, %3d, %3d, %c";
		String msg = String.format(fmt, this.num, this.name, this.kor, this.eng, this.mat, this.tot, this.avg, this.grade);
		System.out.println(msg); 
	}
	
	public int getRank() {
		rank++;
		return rank;
	}
	
	public int getTot() {
		this.tot = this.kor+this.eng+this.mat;
		return this.tot;
	}


	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getAvg() {
		this.avg = this.tot/3;
		return this.avg;
	}


	public char getGrade() {
		char[] g = {'F','F','F','F','F','F','D','C','B','A','A'};
		this.grade = g[getAvg()/10];
		return grade;
	}
	
	

	
	//method


	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}

	
	

}
