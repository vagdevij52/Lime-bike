public interface ITouchEventHandler
{

    /**
     * Touch Event at X and Y
     * @param x X Coord
     * @param y Y Coord
     */
    void touch(int x, int y);

    /**
     * Set Next Handler in Event Chain
     * @param next Next Handler Object
     */
    void setNext( ITouchEventHandler next) ;
}