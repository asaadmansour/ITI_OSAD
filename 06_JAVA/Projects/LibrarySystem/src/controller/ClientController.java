
package controller;

import view.ClientView;
import view.UpdateClientView;
import service.ClientService;
import model.Client;
import model.LibraryItem;
import Util.*;
import exception.ItemNotFoundException;
import java.util.List;

public class ClientController {
    private final ClientService clientService;
    Utils utils = new Utils();

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public void showMenu() {
        Integer menuOption = ClientView.showMenu();
        while (menuOption != 8) {
            switch (menuOption) {
                case 1:
                    handleAddClient();
                    break;
                case 2:
                    handlePrintClientDetails();
                    break;
                case 3:
                    handleUpdateClientDetails();
                    break;
                case 4:
                    handleDeleteClient();
                    break;
                case 5:
                    handleBorrowItem();
                    break;
                case 6:
                    handleReturnItem();
                    break;
                case 7:
                    handlePrintBorrowedItems();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Enter a valid option!");
            }
            menuOption = ClientView.showMenu();
        }
    }

    public void handleAddClient() {
        int clientId = utils.readInt("Enter the Id: ", 
            id -> id > 0 && clientService.isIdUnique(id), "ID must be positive and unique!");
        String clientName = utils.readString("Enter the name: ", Utils::isString, "Name should contain letters only!");
        String clientEmail = utils.readString("Enter the client email: ", Utils::isValidEmail, "Enter a valid Email");
        try {
            clientService.addClient(clientId, clientName, clientEmail);
            System.out.println("Client added successfully!");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handlePrintClientDetails() {
        int clientId = utils.readInt("Enter the Client ID: ", id -> id > 0, "ID must be positive!");
        try {
            Client client = clientService.getClientById(clientId);
            System.out.println("\n  ── Client Details ──");
            System.out.println("  ID:    " + client.getId());
            System.out.println("  Name:  " + client.getName());
            System.out.println("  Email: " + client.getEmail());
            System.out.println();
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDeleteClient() {
        int clientId = utils.readInt("Enter the client ID: ", id -> id > 0, "ID must be positive!");
        try {
            clientService.deleteClient(clientId);
            System.out.println("Client deleted successfully!");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleUpdateClientDetails() {
        int clientId = utils.readInt("Enter the client ID: ", id -> id > 0, "ID must be positive!");
        try {
            clientService.getClientById(clientId);
            
            Integer menuOption = UpdateClientView.showMenu();
            while (menuOption != 4) {
                switch (menuOption) {
                    case 1:
                        handleUpdateName(clientId);
                        break;
                    case 2:
                        handleUpdateEmail(clientId);
                        break;
                    case 3:
                        handleUpdateName(clientId);
                        handleUpdateEmail(clientId);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Enter a valid option!");
                }
                menuOption = UpdateClientView.showMenu();
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdateName(int clientId) {
        String newName = utils.readString("Enter the new name: ", Utils::isString, "Name should contain letters only!");
        try {
            clientService.updateName(clientId, newName);
            System.out.println("Name updated!");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdateEmail(int clientId) {
        String newEmail = utils.readString("Enter the client email: ", Utils::isValidEmail, "Enter a valid Email");
        try {
            clientService.updateEmail(clientId, newEmail);
            System.out.println("Email updated!");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleBorrowItem() {
        int clientId = utils.readInt("Enter client ID: ", id -> id > 0, "Must be positive");
        int itemId = utils.readInt("Enter item ID: ", id -> id > 0, "Must be positive");
        try {
            clientService.borrowItem(clientId, itemId);
            System.out.println("Item borrowed successfully!");
        } catch (ItemNotFoundException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleReturnItem() {
        int clientId = utils.readInt("Enter the client ID: ", id -> id > 0, "ID must be positive!");
        int itemId = utils.readInt("Enter the item ID: ", id -> id > 0, "ID must be positive!");
        try {
            clientService.returnItem(clientId, itemId);
            System.out.println("Item returned successfully!");
        } catch (ItemNotFoundException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handlePrintBorrowedItems() {
        int clientId = utils.readInt("Enter the Id: ", id -> id > 0, "ID must be positive!");
        try {
            List<LibraryItem> items = clientService.getBorrowedItems(clientId);
            if (items.isEmpty()) {
                System.out.println("No borrowed items.");
            } else {
                System.out.println("\n  ── Borrowed Items ──");
                for (LibraryItem item : items) {
                    System.out.println("  ID: " + item.getId() + " | Title: " + item.getTitle());
                }
                System.out.println();
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
