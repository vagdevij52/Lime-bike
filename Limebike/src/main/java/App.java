/**
 *  Main App Class for Displaying Screen.
 */
public class App{

    private Screen screen;
    private int count ;
    private IFrame frame ;
    private CardTypeMachine cm = new CardTypeMachine();
    
    private CreditCardNum num;
    private CreditCardType ctype;
    private Spacer spc ;
    private CardTypeMachine ctm;
    
    private String cardNumFocus = "cardNum";
    private String codeTypeFocus = "cardType";
    private String focusState = cardNumFocus;

    public App() {
        screen = new Screen() ;
        count = 0;
    }
    
    /**
     * Get card name type
     * @return card name type
     */
    public String screenCardName() {
        return frame.screenCardName() ;
    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n"; //screen name - not component
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display(); //card type component
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    
    public void key(String ch) {
    	if(ch.toUpperCase().equals("X")) {
    		if(count>0) {
    			count--;
        		screen.key(ch, count);
    		}   		
    	}
    	else if(Character.isDigit(ch.charAt(0)) && count < 16 && ch.length() == 1) {
    		count++;
    		screen.key(ch, count);
    	}
    	
        
    }

//	@Override
//	public void keyEventUpdate(int numKeys, String key, String number) {
//		// TODO Auto-generated method stub
//		
//	}
}

