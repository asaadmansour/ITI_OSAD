package service;

import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.Library;
import model.LibraryItem;
import Util.*;
import exception.ItemNotFoundException;

public class ClientService {
    List<Client> clients = new ArrayList<>();
    Library<LibraryItem> library;

    public ClientService(Library<LibraryItem> library) {
        this.library = library;
    }

    public void addClient(int clientId, String clientName, String clientEmail) {
        if (Utils.isIdThere(clientId, clients) != null) {
            throw new IllegalStateException("Client ID already exists!");
        }
        Client client = new Client(clientId, clientName, clientEmail);
        clients.add(client);
    }

    public Client getClientById(int clientId) throws ItemNotFoundException {
        return Utils.findByIdOrThrow(clientId, clients, "Client");
    }

    public void deleteClient(int clientId) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        clients.remove(client);
    }

    public void updateEmail(int clientId, String newEmail) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        client.setEmail(newEmail);
    }

    public void updateName(int clientId, String newName) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        client.setName(newName);
    }

    public void borrowItem(int clientId, int itemId) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        LibraryItem item = Utils.findByIdOrThrow(itemId, library.getItems(), "Item");
        client.borrowItem(item);
    }

    public void returnItem(int clientId, int itemId) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        LibraryItem item = Utils.findByIdOrThrow(itemId, client.getBorrowedItem(), "Borrowed Item");
        client.returnItem(item);
    }

    public List<LibraryItem> getBorrowedItems(int clientId) throws ItemNotFoundException {
        Client client = Utils.findByIdOrThrow(clientId, clients, "Client");
        return client.getBorrowedItem();
    }

    public boolean isIdUnique(int id) {
        return Utils.isIdThere(id, clients) == null;
    }
}
