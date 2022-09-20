public interface ICardTypeStateMachine {
	
	
	/** Pin State Machine Interface */
	
	    /**
	     * Number/Key Pressed Event
	     */

	    /** Single digit event **/
	    void singleDigit(String digit,int count, String number);
	    
	    /** Digit Delete **/
	    void digitDelete(String digit, int count, String number);

	    /** S1 Set Amex Card Type */
	    void setAmexCardType() ;

	    /** 
	     * S2 Set Visa card type
	     */
	    void setVisaCardType() ;

	    /** 
	     * S3 Set MC Card type
	     */    
	    void setMCCardType() ;

	    /** 
	     * S4 Set Blank Card type
	     */    
	    void setBlankCardType() ;

}
