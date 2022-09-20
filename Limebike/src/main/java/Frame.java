
public class Frame implements IFrame{

	private IScreen current;
	@Override
	public void setCardNameType(IScreen s) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Return Screen Name
     * @return Screen Name
     */
	@Override
	public String screenCardName() {
		// TODO Auto-generated method stub
		return current.name();
	}

}
