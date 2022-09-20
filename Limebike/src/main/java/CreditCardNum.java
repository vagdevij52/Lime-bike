import java.util.ArrayList;

/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements ITouchEventHandler, IDisplayComponent, ICardNumSubject
{

	private String number = "" ;
	private String cardType = "";
    private ICardNumberObserver ob;

	
	private ICardNumberObserver observers ;
    int countPinDigits = 0 ;
    String lastKey = "" ;

    public ICardNumberObserver getObservers() {
		return observers;
	}


	public void setObservers(ICardNumberObserver ob2) {
		this.observers = ob2;
	}
	
	public CreditCardNum() {
	}
	public String display() {
		if ( number.equals("") )
			return "[4444 4444 4444 4444]" + "  " ;
		else {
			if(number.length()==4 || number.length()==9 || number.length()==14) {
				number = number + " ";
			}
			return "[" + number + "]" + "  " ;
		}
		
	}	

	public void key(String ch, int cnt) {
		lastKey = ch;
		countPinDigits = cnt;
		if ( ch.toUpperCase().equals("X") ) {
			if(number.length()==5 || number.length()==10 || number.length()==15) {
				number = number.substring(0, number.length() - 2) ;
			}else {
				number = number.substring(0, number.length() - 1) ;
			}
			if(countPinDigits == 0) {
        		countPinDigits = 0;
        	}else {
        		countPinDigits-- ;
        	}
            notifyObserver() ;
		} else if ( cnt <= 16 ) {
			number += ch ;
            notifyObserver() ;
		}
	}

	@Override
	public void addSubComponent(IDisplayComponent c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touch(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNext(ITouchEventHandler next) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(ICardNumberObserver obj) {
		// TODO Auto-generated method stub
		this.ob = obj;
		setObservers(this.ob);
	}


	@Override
	public void removeObserver(ICardNumberObserver obj) {
		// TODO Auto-generated method stub
		this.ob = null;
	}


	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
	            this.ob.keyEventUpdate(countPinDigits, lastKey, number);
	}	


}