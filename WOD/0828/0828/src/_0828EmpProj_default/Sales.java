package _0828EmpProj_default;

public class Sales extends Permanent implements Trip{
	
	//id, name
	
	int incentive;
	
	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	public Sales(){}
	
	public Sales(int id, String name, int salary,int incentive){
		super(id, name, salary);
		this.incentive = incentive;
	}
	
	@Override  // 부모의 메서드를 자식이 재정의
	public int getPay() {
		return super.getPay() + getIncentive();
	}
	
//	public void trip(Trip emp, int day) {
//		if(emp instanceof Sales) {
//			Sales sales = (Sales)emp;
//			sales.incentive += 300000 * day;
//		}
//	}
	public void trip(int day) {
//		if(emp instanceof Sales) {
//			Sales sales = (Sales)emp;
//			sales.incentive += 300000 * day;
//		}
		this.incentive += 300000 * day;
	}

}
