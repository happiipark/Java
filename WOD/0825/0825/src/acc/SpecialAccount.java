package acc;

public class SpecialAccount extends Account{
	private double interest = 0.01; // 이자
	String grade = "Normal"; //등급

	public String getGrade() {
		return grade;
	}

	SpecialAccount(){}
	
	public SpecialAccount(String id, String name, int money, String grade){
		super(id,name,money);
		setGrade(grade);
	}
	
	
	public void setGrade(String grade) {
		switch(grade) {
		case "V":
		case "v":
			this.grade = "VIP";
			this.interest = 0.04;
			break;
		case "G":
		case "g":
			this.grade = "Gole";
			this.interest = 0.03;
			break;
		case "S":
		case "s":
			this.grade = "Silver";
			this.interest = 0.02;
			break;
		case "N":
		case "n":
			this.grade = "Normal";
			this.interest = 0.01;
			break;
		}
	}
	

	@Override
	public void deposit(int deposit) {
//		if(grade.equals("V")) {
//			interest = 0.04;
//			System.out.println("ssdsdd");
//		} else if(grade.equals("G")) {
//			interest = 0.03;
//		} else if(grade.equals("S")) {
//			interest = 0.02;
//		} else if (grade.equals("N")) {
//			interest = 0.01;
//		}
//		balance = balance + deposit + (int)(deposit * interest);
		super.deposit((int)(Math.round(deposit+deposit*interest)));
	}
	
	@Override
	public String info() {
		return super.info()+ ", 등급 : "+grade;
	}
}
