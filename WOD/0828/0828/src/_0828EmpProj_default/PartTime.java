package _0828EmpProj_default;

public class PartTime extends Employee implements Trip {

	// id, name

	int time;
	int payPerTime;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPayPerTime() {
		return payPerTime;
	}

	public void setPayPerTime(int payPerTime) {
		this.payPerTime = payPerTime;
	}

	public PartTime() {
	}

	public PartTime(int id, String name, int time, int payPerDate) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerDate;
	}

	public int getPay() {
		return getTime() * getPayPerTime();
	}

	@Override
	public String info() {
		return super.info() + ", 급여 : " + getPay();
	}

//	@Override
//	public void trip(Trip emp, int day) {
//		day *= 24;
//		if (emp instanceof PartTime) {
//			PartTime part = (PartTime) emp;
//			part.time += day;
//		}
//	}
	@Override
	public void trip( int day) {
		day *= 24;
//		if (emp instanceof PartTime) {
//			PartTime part = (PartTime) emp;
//			part.time += day;
//		}
		this.time += day;
	}

}
