// GameRentalService.java
import java.util.ArrayList;       //importing ArrayList for storing games
import java.util.HashMap;         //Importing HashMap for mapping user ID's
import java.util.List;            //Importing List interface for returning lists of games
import java.util.stream.Collectors;  //Importing Collectors for stream operations 

public class GameRentalService {
    private ArrayList<Game> games = new ArrayList<>(); //List to hold all available games
    private HashMap<String, User> users = new HashMap<>(); // Map to hold users with thier user ID's 

    public void addGame(Game game) { games.add(game); }
    public void addUser(User user) { users.put(user.getUserId(), user); }

    public Game findGameByTitle(String title) {
        for (Game game : games) {
            if (game.getTitle().equalsIgnoreCase(title)) {
                return game;
            }
        }
        return null;
    }

    public User getUserById(String userId) { return users.get(userId); }

    public List<Game> getGamesByGenre(String genre) {
        return games.stream()
                     .filter(game -> game.getGenre().equalsIgnoreCase(genre))
                     .collect(Collectors.toList());
    }

    public List<Game> getNewReleases(int currentYear) {
        return games.stream()
                     .filter(game -> game.getReleaseYear() == currentYear)
                     .collect(Collectors.toList());
    }

    public List<Game> getBestGamesOfAllTime() {
        return games.stream()
                     .filter(game -> game.getRating() >= 8.5)
                     .collect(Collectors.toList());
    }

    public List<Game> getEditorsPicks() {
        return games.stream()
                     .filter(game -> game.getRating() >= 7.5 && game.getReleaseYear() > 2000)
                     .collect(Collectors.toList());
    }

    public void displayGames(List<Game> gameList) {
        if (gameList.isEmpty()) {
            System.out.println("No games found in this category.");
        } else {
            for (Game game : gameList) {
                System.out.println("- " + game.getTitle() + " (" + game.getReleaseYear() + "), Rating: " + game.getRating());
            }
        }
    }
    
    public List<Game> getAvailableGames() {
        return games.stream()
                     .filter(Game::isAvailable)
                     .collect(Collectors.toList());
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
}
