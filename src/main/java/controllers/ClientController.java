package controllers;

import people.users.client.Client;
import people.users.client.ClientCollection;

import java.util.Set;

public class ClientController {
    private ClientCollection clientCollection = new ClientCollection();

    public ClientController() {
    }

    public void add(Client client){
        clientCollection.add(client);
    }

    public void delete(Client client){
        clientCollection.delete(client);
    }

    public void clear(){
        clientCollection.clear();
    }

    public Client find(String pattern){
        return clientCollection.find(pattern);
    }

    public Set<Client> findAll(String pattern){
        return clientCollection.findAll(pattern);
    }

    @Override
    public String toString(){
        return clientCollection.toString();
    }
}
