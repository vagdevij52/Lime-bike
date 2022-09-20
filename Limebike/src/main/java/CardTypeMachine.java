

public class CardTypeMachine implements ICardTypeStateMachine, ICardNumberObserver, ICardNumSubject, ICardTypeMachineSubject{
	
	 // current state
     private ICardTypeState state ;
     private String cardType;
     private ICardTypeMachineObserver ob;
	 public String getCurrentState()
	 {
	        return state.getClass().getName() ;
	 }
	 
	// pin machine states
	    private AmexCardType c1 ;
	    private VisaCardType c2 ;
	    private MCCardType c3 ;
	    private BlankCardType c4 ;
	    
	// card type captured so far
	    private String amex, visa, mc, blank;
	    public String amex() { return amex ; }
	    public String visa() { return visa ; }
	    public String mc() { return mc ; }
	    public String blank() { return blank ; }
	    
	    /**
	     * Constructor - Set Up State Objects
	     */
	    public CardTypeMachine( )
	    {
	        c1 = new AmexCardType( this ) ;
	        c2 = new VisaCardType( this ) ;
	        c3 = new MCCardType( this ) ;
	        c4 = new BlankCardType( this ) ;


	        this.amex = "" ;
	        this.visa = "" ;
	        this.mc = "" ;
	        this.blank = "" ;
	        this.state = c4 ;
	    }
	    
	    /** Debug Dump to Stderr State Machine Changes */
	    private void debug()
	    {
	        System.err.println( "Current State: " + state.getClass().getName() ) ;
	        System.err.println( "amex = " + amex ) ;
	        System.err.println( "visa = " + visa ) ;
	        System.err.println( "mc = " + mc ) ;
	        System.err.println( "blank = " + blank ) ;
	    }


	@Override
	public void singleDigit(String digit, int count, String number) {
		// TODO Auto-generated method stub
		this.state.singleDigit(digit,count, number);
		
	}

	@Override
	public void digitDelete(String digit, int count, String number) {
		// TODO Auto-generated method stub
		this.state.digitDelete( digit,  count, number);

	}

	@Override
	public void setAmexCardType() {
		// TODO Auto-generated method stub
//		  	this.pinCount = 0 ;
	        this.state = c1 ;
	        this.visa = "" ;
	        this.mc = "" ;
	        this.blank = "" ;
	        this.cardType="AMEX";
	        notifyObserver();
	        debug() ;
	}

	@Override
	public void setVisaCardType() {
		// TODO Auto-generated method stub
		this.state = c2 ;
        this.amex = "" ;
        this.mc = "" ;
        this.blank = "" ;
        this.cardType="VISA";
        notifyObserver();
        debug() ;
	}

	@Override
	public void setMCCardType() {
		// TODO Auto-generated method stub
		this.state = c3 ;
        this.amex = "" ;
        this.visa = "" ;
        this.blank = "" ;
        this.cardType="M/C";
        notifyObserver();
        debug() ;
	}

	@Override
	public void setBlankCardType() {
		// TODO Auto-generated method stub
		this.state = c4 ;
        this.amex = "" ;
        this.visa = "" ;
        this.mc = "" ;
        this.cardType=" ";
        notifyObserver();
        debug() ;
	}
	
	// card type recognizer machine observers for key events to recognize the card type
	public void keyEventUpdate( int c, String key, String number ) 
    {
        System.err.println( "Key: " + key + " Count: " + c + " Number: " + number) ;
        if ( key.equals(" ") )
        /* nothing */ ;
        else if ( key.equals("X") )
            digitDelete(key,c, number) ;
        else
        	singleDigit( key,c, number ) ;        
    }
	
	/**
     * Notify Card Type Recognizer Observers - Card type
     */
    public void notifyObserver( ) 
    {
        if ( this.cardType != null ) {
        		this.ob.cardType(cardType) ;
        }
    }
	@Override
	public void registerObserver(ICardTypeMachineObserver obj) {
		// TODO Auto-generated method stub
		this.ob = obj;
	}
	@Override
	public void removeObserver(ICardTypeMachineObserver obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerObserver(ICardNumberObserver obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeObserver(ICardNumberObserver obj) {
		// TODO Auto-generated method stub
		
	}


}
