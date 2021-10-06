package ex03;

public class FriendVo {
	
	private int    num;
	private String name;
	
	public FriendVo() {
		
	}
	public FriendVo(int num, String name) {
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
		return "FriendVo [num=" + num + ", name=" + name + "]";
	}

}
