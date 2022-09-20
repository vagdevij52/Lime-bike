/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

import java.util.* ;


public class Screen implements IScreen, IDisplayComponent
{

    private CreditCardNum num;
    private CreditCardType ctype;
    private Spacer spc ;
    private CardTypeMachine ctm;
    /** Display Components */
    private ArrayList<IDisplayComponent> components = new ArrayList<IDisplayComponent>() ;

    public Screen()
    {
        num = new CreditCardNum();
        ctype = new CreditCardType();
        spc = new Spacer() ;
        ctm = new CardTypeMachine();
        //set composite pattern
        this.addSubComponent(ctype);
        this.addSubComponent(spc);
        this.addSubComponent(num);
        
        
        //set observer pattern
        ((ICardNumSubject)num).registerObserver(ctm); //card type state machine observes card number
        ((ICardTypeMachineSubject)ctm).registerObserver(ctype); // cardtype observes cardtype state machine
    }

    public void key(String ch, int cnt) {
        num.key(ch, cnt) ;
    }
    
    /**
     * Get Display Contents
     * @return Display Contents String
     */
    public String display() { 
        String value = "" ;
        StringBuffer tmp = new StringBuffer(value);
        for (IDisplayComponent c : components )
        {
            //System.err.println( "Screen: " + c.getClass().getName() ) ;
            tmp.append(c.display());
            value = tmp.toString();
        }
        return value ;
    }

    public String name() {
        return "       FINAL EXAM (SPRING 2021)       " ; 
    }
    
    // add two componenets - card name and card number - composite pattern
	@Override
	public void addSubComponent(IDisplayComponent c) {
		 	components.add( c ) ;
	}

}
