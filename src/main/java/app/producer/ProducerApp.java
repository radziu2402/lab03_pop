package app.producer;
import app.common.Status;

import java.util.Scanner;

public class ProducerApp {
    public static void main(String[] args) {
        ProducerListComplaint producerListComplaint = new ProducerListComplaint();
        System.out.println("Witaj producencie");
        System.out.println("Podaj nazwe firmy aby przejsc dalej");
        Scanner scanner = new Scanner(System.in);
        String producerr = scanner.nextLine();
        while(true) {
            System.out.println("\n\nWcisnij 1 aby pobrac liste reklamacji");
            System.out.println("Wcisnij 2 aby zaakceptowac reklamacje");
            System.out.println("Wcisnij 3 aby odrzucic reklamacje");
            System.out.println("Wcisnij 4 aby wyjść");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    producerListComplaint.readAllComplaints(producerr);
                    System.out.println(producerListComplaint.getComplaintList());
                }
                case 2 -> {
                    producerListComplaint.readAllComplaints(producerr);
                    System.out.println("Wpisz ID reklamacji ktora chcesz przyjac");
                    int acceptComplaintId = scanner.nextInt();
                    producerListComplaint.changeStatus(acceptComplaintId, Status.ZAAKCEPTOWANA);

                }
                case 3 -> {
                    producerListComplaint.readAllComplaints(producerr);
                    System.out.println("Wpisz ID reklamacji ktora chcesz odrzucic");
                    int declineComplaintId = scanner.nextInt();
                    producerListComplaint.changeStatus(declineComplaintId, Status.ODRZUCONA);
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Niepoprawny wybor! Wpisz jeszcze raz \n\n");
            }
        }
    }
}
