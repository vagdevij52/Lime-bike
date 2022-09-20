/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardType implements IDisplayComponent,ICardTypeMachineObserver,ICardTypeMachineSubject
{

	private String cardName = " ";
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String display() {
		return cardName ; // AMEX, VISA or M/C
	}

	@Override
	public void addSubComponent(IDisplayComponent c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardType(String cardName) {
		// TODO Auto-generated method stub
		setCardName(cardName);
		System.err.println("Card type: "+cardName);
	}

	@Override
	public void removeObserver(ICardTypeMachineObserver obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(ICardTypeMachineObserver obj) {
		// TODO Auto-generated method stub
		
	}	

}