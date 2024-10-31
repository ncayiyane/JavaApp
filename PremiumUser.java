// 
public class PremiumUser extends User {
    public PremiumUser(String name, String userId) {
        super(name, userId);
    }

     // Override the rentGame method to add premium user-specific behavior
    @Override
    public void rentGame(Game game) throws GameNotAvailableException {
        game.rent(); // Attempt to rent the game, may throw GameNotAvailableException
        addRentedGame(game);
        System.out.println(name + " (Premium User) rented the game: " + game.getTitle());
    }
}