package org.example;

import org.example.crudServise.ClientCrudService;
import org.example.crudServise.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.storage.DatabaseinitService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        new DatabaseinitService().initDb();

        ClientCrudService clientService = new ClientCrudService();

        Client newClient = new Client();
        newClient.setName("Taras Potato");
        Client newAnakin = new Client();
        newAnakin.setId(4L);
        newAnakin.setName("Darth Vader");

        clientService.createClient(newClient);
        clientService.deleteClientById(17L);
        clientService.updateClient(newAnakin);

        Client client = clientService.getClientById(9L);
        System.out.println("client = " + client);
        Client palpatine = clientService.getClientById(10L);

        clientService.deleteClient(palpatine);

        List<Client> clients = clientService.getAllClients();
        System.out.println("clients = " + clients.toString());

        System.out.println("----------------------------");

        PlanetCrudService planetService = new PlanetCrudService();

        Planet newPlanet = new Planet();
        newPlanet.setId("ENDOR");
        newPlanet.setName("Endor");
        Planet planetCoruscant = new Planet();
        planetCoruscant.setId("NAB007");
        planetCoruscant.setName("Coruscant");

        planetService.createPlanet(newPlanet);
        planetService.updatePlanet(planetCoruscant);
        planetService.deletePlanetById("HOTH");
        Planet planetEndor = planetService.getPlanetById("EARTH");
        planetService.deletePlanet(planetEndor);
        List<Planet> planets = planetService.getAllPlanets();
        System.out.println("planets = " + planets.toString());
    }
}




