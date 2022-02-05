import exceptions.NameNullException;
import model.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SkiResort implements Payable {

    @Override
    public int getEquipmentPrice (AdultClient client ) {
        return SkiRent.rentEquipment();                         ///делегування

    }

    @Override
    public int getEquipmentPrice (ChildClient client ) {
        int equipmentPrice = SkiRent.rentEquipment();           ///делегування
        return (int) (equipmentPrice * 0.8);
    }

    public Set<ClientSkiResort> skiingClients(Set<ClientSkiResort> clients) {

        System.out.println("\n" + "Clients buy equipment. Children have 20% discount");
        AtomicInteger random = new AtomicInteger();
        Set<ClientSkiResort> setToRemoveNullNameClients = new HashSet<>();

//        for (ClientSkiResort client : clients) {
//            try {
//                if (client instanceof AdultClient) {
//                    System.out.println("\n" + client.getName() + " pay " + getEquipmentPrice((AdultClient) client));       //  розрахунок вартості
//                } else {                                                                                                   //  за оренду лижного
//                    System.out.println("\n" + client.getName() + " pay " + getEquipmentPrice((ChildClient) client));       //  спорядження
//                }
//                for (Tracks track : Tracks.values()) {
//                    random = (int) (20 + Math.random() * 30);
//                    client.setTimeToFinishRace(track, random);     //час проходження траси від 20 до 50 одиниць часу
//                    TracksAndMetrics clientTrackMetrics;
//                    for (int i = 0; i < client.getTracksAndMetrics().size(); i++) {
//                        clientTrackMetrics = client.getTracksAndMetrics().get(i);
//                        if (clientTrackMetrics.getTrack().equals(track)) {
//                            System.out.println( client.getName() + " finished " + track + " in " + random + " min and avg speed was "
//                                                    + clientTrackMetrics.getMetrics().get( clientTrackMetrics.getMetrics().size() - 1)
//                                                        .calculateSkierAvgSpeed(track).getAvgSpeed() + " km/h");
//                        }
//                    }
//                }
//            } catch (NameNullException e ) {
//                System.out.println("\n" + e.getMessage() + " We will delete this client!");
//                setToRemoveNullNameClients.add(client);
//            }
//        }

        clients.stream().forEach( client -> {
                new Thread(() -> {
                    try {
                        if (client instanceof AdultClient) {
                            System.out.println("\n" + client.getName() + " pay " + getEquipmentPrice((AdultClient) client));       //  розрахунок вартості
                        } else {                                                                                                   //  за оренду лижного
                            System.out.println("\n" + client.getName() + " pay " + getEquipmentPrice((ChildClient) client));       //  спорядження
                        }
                    } catch (NameNullException e) {
                        System.out.println("\n" + e.getMessage() + " We will delete this client!\n");
                        setToRemoveNullNameClients.add(client);
                    }
                }).start();

                Arrays.stream(Tracks.values()).forEach(track -> {
                    random.set((int) (20 + Math.random() * 30));
                    client.setTimeToFinishRace(track, random.get());                      // час проходження траси від 20 до 50 одиниць часу
                    client.getTracksAndMetrics().stream().filter(tam -> tam.getTrack().equals(track)).forEach(tam -> {
                        try {
                            System.out.println( client.getName() + " finished " + track + " in " + random + " min and avg speed was "
                                    + tam.getMetrics().get( tam.getMetrics().size() - 1)
                                    .calculateSkierAvgSpeed(track).getAvgSpeed() + " km/h");
                        } catch (NameNullException e) {
                            setToRemoveNullNameClients.add(client);
                        }
                    });
                });
        });


        clients.removeAll(setToRemoveNullNameClients);
        return clients;
    }

}
