
public interface ICardTypeMachineSubject {
    /**
     * Remove Observer
     * @param obj Pin AUth Observer to Remove
     */
    void removeObserver( ICardTypeMachineObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;

	void registerObserver(ICardTypeMachineObserver obj);
}
