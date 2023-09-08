import service.BaseballService;

public class BaseBallProj {
	public static void main(String[] args) {
		BaseballService baseballService = new BaseballService();
		
		while (true) {
			int sel = baseballService.menu();
			if (sel == 0) {
				break;
			} else {
				baseballService.selNumber(sel);
			}

		}

	}

}
