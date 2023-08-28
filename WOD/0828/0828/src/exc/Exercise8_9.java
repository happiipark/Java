package exc;

class UnsupportedFuctionException extends RuntimeException {
	final private int ERR_CODE;
	
//	public UnsupportedFuctionException(String message) {
//		super(message);
//		ERR_CODE = 100;
//	}
	public UnsupportedFuctionException(String message, int errCode) {
		super(message);
		ERR_CODE = errCode;
	}
	
	@Override
	public String getMessage() {	
		return "[" + ERR_CODE + "]" + super.getMessage();
	}
}


public class Exercise8_9 {

	public static void main(String[] args) throws Exception {
		try {
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);
		} catch (UnsupportedFuctionException e) {
			System.out.println(e.getMessage());
		}
	}
}
