package controller;

import service.LibraryService;
import model.LibraryItem;
import view.LibraryView;
import Util.*;
import exception.ItemNotFoundException;

public class LibraryItemController {
    private final LibraryService libraryService;
    Utils utils = new Utils();

    public LibraryItemController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void showMenu() {
        Integer menuOption = LibraryView.showMenu();
        while (menuOption != 6) {
            switch (menuOption) {
                case 1:
                    handleAddItem(1);
                    break;
                case 2:
                    handleAddItem(2);
                    break;
                case 3:
                    handleRetrieveItemDetails();
                    break;
                case 4:
                    handleUpdateTitle();
                    break;
                case 5:
                    handleDeleteItem();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Enter a valid number!");
            }
            menuOption = LibraryView.showMenu();
        }
    }

    public void handleAddItem(int type) {
        int itemId = utils.readInt("Enter item ID: ", 
            id -> id > 0 && libraryService.isIdUnique(id), "ID must be positive and unique!");
        String title = utils.readString("Enter item title: ", 
            s -> !s.isEmpty() && Utils.isString(s), "Title must be letters only and not empty!");
        int stock = utils.readInt("Enter item stock: ", s -> s >= 0, "Stock must be zero or positive!");
        try {
            libraryService.addItem(type, itemId, title, stock);
            System.out.println("Item added successfully!");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleRetrieveItemDetails() {
        int itemId = utils.readInt("Enter the item ID: ", id -> id > 0, "ID must be positive!");
        try {
            LibraryItem item = libraryService.getItemById(itemId);
            System.out.println("\n  ── Item Details ──");
            System.out.println("  ID:    " + item.getId());
            System.out.println("  Title: " + item.getTitle());
            System.out.println("  Stock: " + item.getStock());
            System.out.println();
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleUpdateTitle() {
        int itemId = utils.readInt("Enter item id: ", id -> id > 0, "ID must be positive!");
        try {
            libraryService.getItemById(itemId);
            String newTitle = utils.readString("Enter the new title: ", 
                title -> !title.isEmpty() && Utils.isString(title), "Title must be letters only and not empty!");
            libraryService.updateTitle(itemId, newTitle);
            System.out.println("Title updated!");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDeleteItem() {
        int itemId = utils.readInt("Enter item Id: ", id -> id > 0, "ID must be positive!");
        try {
            libraryService.deleteItem(itemId);
            System.out.println("Item deleted!");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
