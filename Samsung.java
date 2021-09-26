package ex_1;

import java.util.HashMap;
import java.util.Map;


public class Samsung {
	private int sn;   // 제품번호
	private int pn;   // 수량
	private int cost; // 단가
	private int dpm;  // 부서
	private int sum;  //금액
	private String pdn; //제품명
	private String dpn; //부서명
	private int rank = 1;
	
	//Constructor
	public Samsung() {
		
	}
	
	public Samsung(int sn, int pn, int cost, int dpm) {
		super();
		this.sn = sn;
		this.pn = pn;
		this.cost = cost;
		this.dpm = dpm;
	}
	//Method
	public void setSn(int sn) {
		this.sn = sn;
	}


	public void setPn(int pn) {
		this.pn = pn;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public void setDpm(int dpm) {
		this.dpm = dpm;
	}




	public int getSum() {
		sum = pn*cost;
		return sum;
	}


	public int getSn() {
		return sn;
	}
	
	public String getPdn() {
		String[] g = {"TV","갤럭시노트","냉장고","컴퓨터","세탁기"};
		this.pdn = g[sn/10-1];
		return pdn;
	}
	public void getDpn() {
		
		/*String[] d = {"개발팀","인사팀","연구개발팀","생산팀","마케팅"};
		this.dpn = d[sn/10-1];
		return dpn;*/
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "개발팀");
		map.put(20, "인사팀");
		map.put(30, "연구개발팀");
		map.put(40, "생산팀");
		map.put(50, "마케팅팀");
		
		this.dpn = map.get(this.sn);
	}
	
	
	
	public void print() {
		System.out.printf("제품번호 :%4d, 제품명 :%10s, 수량 :%4d, 단가 :%9d, 금액 :%9d, 부서명 :%4s \n",
				this.sn, this.pdn, this.pn, this.cost, this.sum, this.dpn);
	}



	@Override
	public String toString() {
		return "Samsung [sn=" + sn + ", pn=" + pn + ", cost=" + cost + ", dpm=" + dpm + ", sum=" + sum + ", pdn=" + pdn
				+ ", dpn=" + dpn + "]";
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return this.rank;
	}

}

