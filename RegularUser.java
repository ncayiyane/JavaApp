// RegularUser.java
public class RegularUser extends User {
    public RegularUser(String name, String userId) {
        super(name, userId);
    }

    @Override
    public void rentGame(Game game) throws GameNotAvailableException {
        game.rent();
        addRentedGame(game);
        System.out.println(name + " (Regular User) rented the game: " + game.getTitle());
    }
}
