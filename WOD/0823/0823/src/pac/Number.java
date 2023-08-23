package pac;
 public class Number {
	private int pnum;
	private void pmethod() {
		pnum = 10;
	}
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	int dnum;  //default
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int data) {
		dnum = data;
	}
	public void dmethod() { //default
		System.out.println(pnum);
	}  
	
	public int punum;
	public void pumethod() {
		System.out.println(pnum);
	}
	
	protected int prnum;
	public void prmethod() {}

}