

# Game Rental App

The Game Rental App is a console-based Java application for renting video games. Designed to be user-friendly, the app offers different user types (Regular and Premium) with unique renting privileges, along with functionalities to browse, rent, and return games. With a diverse selection of games spanning various genres and release years, users can explore classic titles and new releases alike.

## Features

1. **User Types**  
   - *Regular Users*: Standard access to game rentals.
   - *Premium Users*: Enhanced access with premium benefits, such as priority rental status.

2. **Game Browsing Options**  
   - Browse games by genre (e.g., Sci-Fi, Action, Animation).
   - View new releases based on the current year.
   - Access a list of "Best Games of All Time" for top-rated games.
   - Explore "Editor's Picks" for highly recommended games.

3. **Game Renting and Returning**  
   - Rent a game by entering the game title and user ID.
   - Return rented games easily by selecting from a list of current rentals.

4. **User Account Management**  
   - Register Regular and Premium users by entering a user name and ID.
   - Check and view all games rented by a user.

## Getting Started

### Prerequisites
To run the application, ensure you have:
- Java Development Kit (JDK) 8 or higher installed
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code)

### Installation
1. Clone the repository or download the source files.
2. Compile the Java files:
   ```bash
   javac GameRentalApp.java



## Usage

Launching the App
When the app starts, it will load several sample games and users. You can follow the menu options to explore, rent, or return games.

Navigating the Menu

Enter the number corresponding to your chosen option.
Follow prompts to enter any necessary information, such as user ID, game title, or genre.

## Sample Menu Options

--- Game Rental System ---
1. Browse Games by Genre
2. View New Releases
3. View Best Games of All Time
4. View Editor's Picks
5. Rent a Game
6. Return a Game
7. View Rented Games
8. Exit


## Adding New Users

During runtime, add Regular or Premium users by entering their name and ID.
Renting Games

When renting a game, if the game is already rented by another user, a GameNotAvailableException will be displayed for Regular users, while Premium users may have priority access.


## Classes and Methods
Main Classes
GameRentalApp: Entry point for running the application.
GameRentalService: Manages the core operations, including adding, finding, and displaying games.
User (Abstract Class): Base class for user types.
RegularUser: Represents a standard user.
PremiumUser: Represents a premium user with special privileges.
Key Methods
getGamesByGenre(String genre): Fetch games based on genre.
getNewReleases(int year): Show games released in the current year.
getBestGamesOfAllTime(): Returns a list of top-rated games.
getEditorsPicks(): Displays recommended games.
rentGame(Game game): Rents a game for the user.
returnGame(Game game): Returns a rented game.
Example Run
Here's a sample interaction with the application:

```bash
Game Rental System 
1. Browse Games by Genre
2. View New Releases
3. View Best Games of All Time
4. View Editor's Picks
5. Rent a Game
6. Return a Game
7. View Rented Games
8. Exit
Choose an option: 5

Enter User ID: U002
Available Games:
1. The Matrix (1999) - Sci-Fi - Rating: 8.7
2. Gladiator (2000) - Action - Rating: 8.5
...
Enter Game Title to rent: Gladiator
Bob (Premium User) rented the game: Gladiator


## Enjoy the Gaming App


