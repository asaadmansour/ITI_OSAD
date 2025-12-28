import controller.ClientController;
import controller.LibraryItemController;
import model.Library;
import model.LibraryItem;
import service.ClientService;
import service.LibraryService;
import view.MenuView;


public class Main {
    public static void main(String[] args) {
        // Lifted the state to a common parent and injected it.
        Library<LibraryItem> library = new Library<LibraryItem>();
        //  services
        ClientService clientService = new ClientService(library);
        LibraryService libraryService = new LibraryService(library);
        // controllers with their dependencies
        LibraryItemController libraryController = new LibraryItemController(libraryService);
        ClientController clientController = new ClientController(clientService);
        
        try {
            Integer menuOption = MenuView.showMenu();
            while (menuOption != 3) {
                switch (menuOption) {
                    case 1:
                        libraryController.showMenu();
                        break;
                    case 2:
                        clientController.showMenu();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Enter a valid input");
                }
                menuOption = MenuView.showMenu();
            }
            System.out.println("Goodbye!");
        } catch (Exception e) {
            System.out.println("Check your input!");
        }
    }
}
