package app.producer;

import app.common.Complaint;
import app.common.Product;
import app.common.Status;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerListComplaint {
    private final List<Complaint> complaintList = new ArrayList<>();
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void changeStatus(int endComplaintId, Status status) {
        int j = 0;
        int i = 0;
        for (Complaint complaint: complaintList) {
            if(complaint.getComplaintId() == endComplaintId) {
                i++;
                if(complaint.getStatus().equals(Status.PRZYJETA)){
                    complaint.setStatus(status);
                    String filePath = complaint.getcId() + "_Complaint.txt";
                    Scanner sc;
                    try {
                        sc = new Scanner(new File(filePath));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (sc.hasNextLine()) {
                        buffer.append(sc.nextLine()+System.lineSeparator());
                    }
                    String fileContents = buffer.toString();
                    sc.close();
                    String oldLine;
                    try {
                        oldLine = Files.readAllLines(Paths.get(filePath)).get(5);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    String newLine = status.toString();
                    System.out.println(newLine);
                    fileContents = fileContents.replaceAll(oldLine, newLine);
                    FileWriter writer;
                    try {
                        writer = new FileWriter(filePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.append(fileContents);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        writer.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Status reklamacji zostal zaktualizowany");
                    System.out.println("Wpisz notke reklamacji:");
                    Scanner scanner = new Scanner(System.in);
                    String reason = scanner.nextLine();
                    try {
                        FileWriter myWriter = new FileWriter(filePath,true);
                        myWriter.write(reason);
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                        e.printStackTrace();
                    }
                }
                j++;
            }
        }
        if(j==0){
            System.out.println("Nie ma reklamacji o takim ID");
        }
        if(i==0){
            System.out.println("Reklamacja zostala juz zaakceptowana lub odrzucona");
        }
    }


































    public void readAllComplaints(String producerr){
        String filename = "clients.txt";
        File file = new File(filename);
        int lines = 0;
        if(file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                while (reader.readLine() != null) {
                    lines++;
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Nie ma zadnych reklamacji");
            return;
        }
        complaintList.clear();
        for(int i = 0 ; i < lines ; i++){
            String complaintFiles = i+1 + "_Complaint.txt";
            File fil = new File(complaintFiles);
            if(fil.exists()){
                try (BufferedReader reader = new BufferedReader(new FileReader(complaintFiles))) {
                    int cId = Integer.parseInt(reader.readLine());
                    String productName = reader.readLine();
                    int productId = Integer.parseInt(reader.readLine());
                    int complaintId = Integer.parseInt(reader.readLine());
                    String description = reader.readLine();
                    Status status = Status.valueOf(reader.readLine());
                    String producer = reader.readLine();
                    if(producer.equals(producerr) && status.equals(Status.PRZYJETA)) {
                        complaintList.add(new Complaint(complaintId, cId, status, description, new Product(productId, productName, producer)));
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
