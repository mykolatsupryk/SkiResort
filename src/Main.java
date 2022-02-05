import exceptions.NameNullException;
import model.AdultClient;
import model.ChildClient;
import model.ClientSkiResort;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        SkiResort skiResort = new SkiResort();

        AdultClient client1 = new AdultClient("John", 190, 105, 44);
        AdultClient client2 = new AdultClient(null, 170, 55, 40);
        ChildClient client3 = new ChildClient("Rita", 160, 51, 38, client2);
        AdultClient client4 = new AdultClient(null, 185, 85, 42);
        ChildClient client5 = new ChildClient("Oskar", 160, 60, 41, client4);

        Set<ClientSkiResort> clients = new HashSet<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);

        skiResort.skiingClients(clients);


//        for (ClientSkiResort clientSkiResort : clients) {
//            System.out.println(clientSkiResort);
//        }
        new Thread(() -> {
//            Thread.currentThread().setName("Lambda Thread");
                clients.stream().forEach(System.out::println);
        }).start();


//        System.out.println(clients);
//        for (ClientSkiResort client : clients) {
//            client.addToResumeFile("My name is " + client.getName() + " and I come to go skiing!");
//        }
        clients.stream().forEach( c -> {
            try {
                c.addToResumeFile("My name is " + c.getName() + " and I come to go skiing!");
//                c.readResumeFile();
//                c.clearResumeFile();
//                c.deleteResumeFile();
            } catch (NameNullException | IOException e) {
                e.printStackTrace();
            }
        });
//        client1.readResumeFile();








    }



}
