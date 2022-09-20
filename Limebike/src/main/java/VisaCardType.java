
public class VisaCardType implements ICardTypeState{
	
	ICardTypeStateMachine machine;
	
	public VisaCardType(ICardTypeStateMachine m) {
		// TODO Auto-generated constructor stub
		this.machine = m;
	}

	@Override
	public void singleDigit(String digit, int count, String number) {
		// TODO Auto-generated method stub
		if(number.length() > 0) {
			if(number.charAt(0)=='3') {
				
				if(number.length()>=2&&(number.charAt(1)=='4'||number.charAt(1)=='7')) {		//AMEX
					machine.setAmexCardType();
				}else {
					machine.setBlankCardType();
				}
			}else if(number.charAt(0)=='4') {	//visa
					machine.setVisaCardType();				
			}else if(number.charAt(0)=='5'||number.charAt(0)=='2') {	//master card
				machine.setMCCardType();
			}else {
				machine.setBlankCardType();
			}
		}else {
			machine.setBlankCardType();
		}
	}

	@Override
	public void digitDelete(String digit, int count, String number) {
		// TODO Auto-generated method stub
		if(number.length() > 0) {
			if(number.charAt(0)=='3') {
				
				if(number.length()>=2&&(number.charAt(1)=='4'||number.charAt(1)=='7')) {		//AMEX
					machine.setAmexCardType();
				}else {
					machine.setBlankCardType();
				}
			}else if(number.charAt(0)=='4') {	//visa
					machine.setVisaCardType();				
			}else if(number.charAt(0)=='5'||number.charAt(0)=='2') {	//master card
				machine.setMCCardType();
			}else {
				machine.setBlankCardType();
			}
		}else {
			machine.setBlankCardType();
		}
	}

}
