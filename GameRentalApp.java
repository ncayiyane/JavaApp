import java.util.List;        // Importing the list interface for handling lists of games
import java.util.Scanner;    // Importing the Scanner class for user input 

// Main class for the Game Rental Application 
public class GameRentalApp {
    public static void main(String[] args) {
        GameRentalService service = new GameRentalService();

        try (Scanner scanner = new Scanner(System.in)) {
            // Adding sample games to the rental service
            service.addGame(new Game("Shadow of Tombo Raider", "Animation", 2001, 7.9));
            service.addGame(new Game("Spider-Man", "Action", 2002, 7.3));
            service.addGame(new Game("Finding Nemo", "Animation", 2003, 8.2));
            service.addGame(new Game("PES 2004", "Animation", 2004, 8.0));
            service.addGame(new Game("GTA 3", "Action", 2005, 8.2));
            service.addGame(new Game("God Of War", "Animation", 2006, 8.5));
            service.addGame(new Game("Need For Speed", "Action", 2008, 7.9));
            service.addGame(new Game("Fifa 22", "Animation", 2022, 8.5));
            service.addGame(new Game("All of Us", "Horror", 2010, 8.2));
            service.addGame(new Game("Marvel's Spider-Man 2", "Action", 2024, 9.5));
            service.addGame(new Game("Alan Wake II", "Action", 2024, 9.0));
            service.addGame(new Game("Star Wars Jedi: Survivor", "Action", 2024, 9.2));
            service.addGame(new Game("The Legend of Zelda: Tears of the Kingdom", "Adventure", 2024, 10.0));
            service.addGame(new Game("Final Fantasy XVI", "RPG", 2024, 9.5));
            service.addGame(new Game("Starfield", "RPG", 2024, 9.0));
            service.addGame(new Game("Baldur's Gate 3", "RPG", 2024, 9.8));
            service.addGame(new Game("FIFA 24", "Sports", 2024, 8.5));
            service.addGame(new Game("NBA 2K24", "Sports", 2024, 8.7));
            service.addGame(new Game("Resident Evil 4 Remake", "Horror", 2024, 9.0));
            service.addGame(new Game("Amnesia: The Bunker", "Horror", 2024, 8.5));
            service.addGame(new Game("Hollow Knight: Silksong", "Indie", 2024, 9.5));
            service.addGame(new Game("Hades II", "Indie", 2024, 9.5));
            service.addGame(new Game("Cities: Skylines II", "Simulation", 2024, 9.0));
            service.addGame(new Game("Sims 5", "Simulation", 2024, 8.5));

            
            // Prompting user for details to create a new RegularUser
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            System.out.print("Enter your User ID: ");
            String userId = scanner.nextLine();
            
            // Creating a Regular User with the provided details
            RegularUser regularUser = new RegularUser(userName, userId);
            service.addUser(regularUser); // Adding the user to the service

            // Option to become a Premium User
            System.out.print("Would you like to upgrade to a Premium User? (yes/no): ");
            String upgradeChoice = scanner.nextLine();
            if (upgradeChoice.equalsIgnoreCase("yes")) {
                PremiumUser premiumUser = new PremiumUser(userName, userId);
                service.addUser(premiumUser); // Adding the Premium User
                System.out.println("You have been upgraded to a Premium User!");
            }
            
            // Menu of the Application
            while (true) {
                System.out.println("\n--- Game Rental System ---");
                System.out.println("1. Browse Games by genre");
                System.out.println("2. View new releases");
                System.out.println("3. View best games of all time");
                System.out.println("4. View editor's picks");
                System.out.println("5. Rent a Game");
                System.out.println("6. Return a Game");
                System.out.println("7. View rented Games");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 8) break; // exit the menu if the user chooses to exit
                
                // Handling user choices using a switch
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter genre (e.g., Sci-Fi, Romance, Action): ");
                        String genre = scanner.nextLine();
                        List<Game> genreGames = service.getGamesByGenre(genre);
                        service.displayGames(genreGames);
                    }
                    case 2 -> {
                        System.out.print("Enter the current year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        List<Game> newReleases = service.getNewReleases(year);
                        service.displayGames(newReleases);
                    }
                    case 3 -> {
                        List<Game> bestGames = service.getBestGamesOfAllTime();
                        service.displayGames(bestGames);
                    }
                    case 4 -> {
                        List<Game> editorsPicks = service.getEditorsPicks();
                        service.displayGames(editorsPicks);
                    }
                    case 5 -> {
                        System.out.print("Enter User ID: ");
                        String userIdInput = scanner.nextLine();
                        User user = service.getUserById(userIdInput);
                        if (user == null) {
                            System.out.println("Invalid User ID.");
                            break;
                        }
                        System.out.println("Available Games:");
                        service.displayGames(service.getAvailableGames());
                        System.out.print("Enter Game Title to rent: ");
                        String rentTitle = scanner.nextLine();
                        Game rentGame = service.findGameByTitle(rentTitle);
                        if (rentGame == null) {
                            System.out.println("Game not found.");
                        } else {
                            try {
                                user.rentGame(rentGame);
                            } catch (GameNotAvailableException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter User ID: ");
                        String userIdInput = scanner.nextLine();
                        User user = service.getUserById(userIdInput);
                        if (user == null) {
                            System.out.println("Invalid User ID.");
                            break;
                        }
                        System.out.println("Rented Games:");
                        service.displayGames(user.getRentedGames());
                        System.out.print("Enter Game Title to return: ");
                        String returnTitle = scanner.nextLine();
                        Game returnGame = service.findGameByTitle(returnTitle);
                        if (returnGame == null || !user.getRentedGames().contains(returnGame)) {
                            System.out.println("Game not found in your rented list.");
                        } else {
                            user.returnGame(returnGame);
                        }
                    }
                    case 7 -> {
                        System.out.print("Enter User ID: ");
                        String userIdInput = scanner.nextLine();
                        User user = service.getUserById(userIdInput);
                        if (user == null) {
                            System.out.println("Invalid User ID.");
                            break;
                        }
                        System.out.println("Your Rented Games:");
                        service.displayGames(user.getRentedGames());
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }
}
