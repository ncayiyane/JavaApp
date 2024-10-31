
import java.util.ArrayList;
import java.util.List;

 //Abstract class representing a user in the game rental system
public abstract class User {
    protected String name;
    protected String userId;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Game> rentedGames = new ArrayList<>();

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getUserId() { return userId; }
    public List<Game> getRentedGames() { return rentedGames; }
    public abstract void rentGame(Game game) throws GameNotAvailableException;

    public void addRentedGame(Game game) { rentedGames.add(game); }

    public void returnGame(Game game) {
        if (rentedGames.remove(game)) {
            game.returnGame();
            System.out.println(name + " returned the game: " + game.getTitle());
        } else {
            System.out.println("Game not found in your rented list.");
        }
    }
}
