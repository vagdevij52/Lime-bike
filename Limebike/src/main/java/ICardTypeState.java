
	/**
	 * Card Type Interface
	 */
	public interface ICardTypeState
	{
	    /**
	     * Number Event
	     * @param digit Digit/Key Pressed
	     */
	    
	    /** Single digit event **/
	    void singleDigit(String digit, int count, String number);
	    
	    /** Digit Delete **/
	    void digitDelete(String digit, int count, String number);
	}

