package app.worker;

import app.common.TimeSimulator;

import java.util.Scanner;

public class WorkerApp {
    public static void main(String[] args) {
        ComplaintListReader complaintListReader = new ComplaintListReader();
        System.out.println("Witaj pracowniku AGD");
        TimeSimulator timeSimulator = new TimeSimulator();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n\nWcisnij 1 aby pobrac liste reklamacji");
            System.out.println("Wcisnij 2 aby przyjac reklamacje i przekazac producentowi");
            System.out.println("Wcisnij 3 aby odrzucic reklamacje");
            System.out.println("Wcisnij 4 aby zakonczyc reklamacje");
            System.out.println("Wcisnij 5 aby przekazac reklamacje do odbioru");
            System.out.println("Wcisnij 6 aby wyjść");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    complaintListReader.readAllComplaints();
                    System.out.println(complaintListReader.getComplaintList());
                }
                case 2 -> {
                    complaintListReader.readAllComplaints();
                    System.out.println("Wpisz ID reklamacji ktora chcesz przyjac");
                    int acceptComplaintId = scanner.nextInt();
                    complaintListReader.changeAcceptStatus(acceptComplaintId,timeSimulator.checkTime());

                }
                case 3 -> {
                    complaintListReader.readAllComplaints();
                    System.out.println("Wpisz ID reklamacji ktora chcesz odrzucic");
                    int declineComplaintId = scanner.nextInt();
                    complaintListReader.changeDeclineStatus(declineComplaintId,timeSimulator.checkTime());
                }
                case 4 -> {
                    complaintListReader.readAllComplaints();
                    System.out.println("Wpisz ID reklamacji ktora chcesz zakonczyc");
                    int endComplaintId = scanner.nextInt();
                    complaintListReader.changeEndStatus(endComplaintId,timeSimulator.checkTime());
                }
                case 5 -> {
                    complaintListReader.readAllComplaints();
                    System.out.println("Wpisz ID reklamacji ktora chcesz przekazac klientowi do odbioru");
                    int readyComplaintId = scanner.nextInt();
                    complaintListReader.changeReadyStatus(readyComplaintId,timeSimulator.checkTime());
                }
                case 6 -> System.exit(0);
                default -> System.out.println("Niepoprawny wybor! Wpisz jeszcze raz \n\n");
            }
        }
    }
}
