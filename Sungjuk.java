package io2;

public class Sungjuk {

	//fields
	private int    num;
	private String name;
	private int    kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private double avg;
	
	//constructor
	public Sungjuk( int num, String line) {
		
		this.num = num;
		String[] li = line.trim().split(",");
		this.name   = li[0].trim();
		this.kor    = Integer.parseInt(li[1]); 
		this.eng    = Integer.parseInt(li[2]); 
		this.mat    = Integer.parseInt(li[3]);
		calcTot();
		calcAvg();
		
	}
	
	public Sungjuk(int num, String name, int kor, int eng, int mat) {
		
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	//getter
	public String getName() {
		return name;
	}
	
	//method
	private void calcAvg() {
		
		this.tot = this.kor+this.eng+this.mat;
		
	}
	
	private void calcTot() {
		
		this.avg = (this.kor+this.eng+this.mat) /3.0;
	}
	
	@Override
	public String toString() {
		String fmt = "%-3d  %-5s  %3d  %3d  %3d  %3d  %6.2f";
		String msg = String.format(fmt,
				this.num, this.name, this.kor, this.eng, this.mat, this.tot, this.avg);
		return msg;
	}
	
}
