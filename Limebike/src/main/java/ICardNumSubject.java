
public interface ICardNumSubject {
	 /**
     * Add a Pin Auth Observer
     * @param obj Observer Object
     */
    void registerObserver( ICardNumberObserver obj ) ;

    /**
     * Remove Observer
     * @param obj Pin AUth Observer to Remove
     */
    void removeObserver( ICardNumberObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;
}
