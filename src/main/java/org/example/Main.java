package org.example;

import org.example.crudServise.ClientCrudService;
import org.example.crudServise.PlanetCrudService;
import org.example.crudServise.TicketCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.storage.DatabaseinitService;

import java.time.LocalDate;
import java.util.List;


public class Main {
        public static void main(String[] args) {

                new DatabaseinitService().initDb();

//                ClientCrudService clientService = new ClientCrudService();
//                PlanetCrudService planetCrudService = new PlanetCrudService();
//                TicketCrudService ticketCrudService = new TicketCrudService();
//
//                Client clientOne = clientService.getClientById(1L);
//                Client clientFive = clientService.getClientById(5L);
//                Planet planetAlderaan = planetCrudService.getPlanetById("MARS");
//                Planet planetNaboo = planetCrudService.getPlanetById("VENUS");
//                Planet planetEndor = planetCrudService.getPlanetById("EARTH");
//
//                Ticket ticketOne = new Ticket();
//                ticketOne.setCreatedAt(LocalDate.now());
//                ticketOne.setClient(clientOne);
//                ticketOne.setFromPlanet(planetAlderaan);
//                ticketOne.setToPlanet(planetNaboo);
//                clientOne.getTickets().add(ticketOne);
//
//                Ticket ticketTwo = new Ticket();
//                ticketTwo.setCreatedAt(LocalDate.now());
//                ticketTwo.setClient(clientOne);
//                ticketTwo.setFromPlanet(planetNaboo);
//                ticketTwo.setToPlanet(planetEndor);
//                clientOne.getTickets().add(ticketTwo);
//
//                Ticket ticketThree = new Ticket();
//                ticketThree.setCreatedAt(LocalDate.now());
//                ticketThree.setClient(clientFive);
//                ticketThree.setFromPlanet(planetEndor);
//                ticketThree.setToPlanet(planetAlderaan);
//                //clientFive.getTickets().add(ticketThree);
//
//                clientService.updateClient(clientOne);
//                clientService.updateClient(clientFive);
//
//                List<Ticket> ticketsBeforeDelete = ticketCrudService.getAll();
//                System.out.println("tickets = " + ticketsBeforeDelete.toString());
//
//                ticketCrudService.deleteById(3L);
//                clientService.deleteClient(clientOne);
//
//                List<Ticket> ticketsAfterDelete = ticketCrudService.getAll();
//                System.out.println("tickets = " + ticketsAfterDelete.toString());
        }
}



