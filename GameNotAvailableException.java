// Custom exception class for handling cases when a game is not available for rent 
public class GameNotAvailableException extends Exception {
    public GameNotAvailableException(String message) {
        super(message);
    }
}
