public class Game {
    // Fields to store game details 
    private String title;             
    private String genre;          
    private boolean isAvailable;
    private int releaseYear;
    private double rating;

    //Constructor to initialize a new Game object
    public Game(String title, String genre, int releaseYear, double rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.isAvailable = true;
    }
    //Get Method to retieve the game
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getReleaseYear() { return releaseYear; }
    public double getRating() { return rating; }
    public boolean isAvailable() { return isAvailable; }
     
     //Method to rent thr game, throws an exceptionif the game is unavailable
    public void rent() throws GameNotAvailableException {
        if (!isAvailable) {
            throw new GameNotAvailableException("This game is currently unavailable.");
        }
        isAvailable = false;
    }
    //Method to return the game, making it available for rent again
    public void returnGame() { isAvailable = true; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}


