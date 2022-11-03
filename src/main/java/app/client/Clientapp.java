package app.client;

import app.common.Complaint;
import app.common.Product;
import app.common.Status;

import java.util.Scanner;

public class Clientapp {
    public static void main(String[] args) {
        ClientFileTool fileTool = new ClientFileTool();
        System.out.println("Witaj w sklepie AGD");
        System.out.println("Podaj swoje imie aby przejsc dalej");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Client client = new Client(fileTool.checkNumberOfClients() + 1, name);
        fileTool.addClientToFile(client);
        ComplaintFileTool complaintFileTool = new ComplaintFileTool(client.getClientId());

        boolean complaint = false;
        while(true) {
            System.out.println("\n\nWcisnij 1 aby wyswietlic swoje dane");
            System.out.println("Wcisnij 2 aby zglosic nowa reklamacje");
            System.out.println("Wcisnij 3 aby sprawdzic status swojej reklamacji");
            System.out.println("Wcisnij 4 aby odebrać towar");
            System.out.println("Wcisnij 5 zeby wyjsc");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("TWOJE DANE:");
                    System.out.println("Id = " + client.getClientId());
                    System.out.println("Imie = " + client.getName());
                    break;

                case 2:
                    if(complaint){
                        System.out.println("Reklamacja juz istnieje");
                        break;
                    }
                    System.out.println("Postępuj zgodnie z poleceniami:");
                    scanner.nextLine();
                    System.out.println("Podaj nazwe produktu, ktory chcesz reklamowac");
                    String nameOfProduct = scanner.nextLine();
                    System.out.println("Podaj producenta produktu, ktory chcesz reklamowac");
                    String producer = scanner.nextLine();
                    System.out.println("Podaj jego numer seryjny");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Opis krotko reklamacje");
                    String description = scanner.nextLine();
                    client.setComplaint(new Complaint(client.getClientId(),description ,new Product(productId,nameOfProduct,producer)));
                    complaint = true;
                    complaintFileTool.addComplaint(client);
                    break;

                case 3:
                    System.out.println(complaintFileTool.checkStatus());
                    client.getComplaint().setStatus(complaintFileTool.checkStatus());
                    break;

                case 4:
                    if(client.getStatus().equals(Status.DO_ODBIORU)){
                        System.out.println("Produkt zostal odebrany. Przesylka dojdzie do ciebie w ciagu 3 dni roboczych");
                        client.getComplaint().setStatus(Status.ODEBRANA);
                        complaintFileTool.updateStatus(client);
                    }
                    else
                        System.out.println("Produkt nie jest jeszcze gotowy do odbioru");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Niepoprawny wybor! Wpisz jeszcze raz \n\n");
            }
    }
}
}