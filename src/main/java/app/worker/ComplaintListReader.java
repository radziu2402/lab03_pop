package app.worker;

import app.common.Product;
import app.common.Complaint;
import app.common.Status;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComplaintListReader {
    private final List<Complaint> complaintList = new ArrayList<>();
    public List<Complaint> getComplaintList() {
        return complaintList;
    }
    public void changeAcceptStatus(int complaintId){
        int j = 0;
        int i = 0;
        for (Complaint complaint: complaintList) {
            if(complaint.getComplaintId() == complaintId) {
                if(complaint.getStatus().equals(Status.ZGLOSZONA)){
                    i++;
                    complaint.setStatus(Status.PRZYJETA);
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
                    String newLine = "PRZYJETA";
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
                    System.out.println("Reklamacja zostala przyjeta");
                }
                j++;
            }
        }
        if(j==0){
            System.out.println("Nie ma reklamacji o takim ID");
        }
        if(i==0){
            System.out.println("Nie mozesz przyjac reklamacji o tym statusie");
        }
    }

    public void changeDeclineStatus(int complaintId){
        int j = 0;
        int i = 0;
        for (Complaint complaint: complaintList) {
            if(complaint.getComplaintId() == complaintId) {
                if(complaint.getStatus().equals(Status.ZGLOSZONA)){
                    i++;
                    complaint.setStatus(Status.ODRZUCONA);
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
                    String newLine = "ODRZUCONA";
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
                    System.out.println("Reklamacja zostala odrzucona");
                }
                j++;
            }
        }
        if(j==0){
            System.out.println("Nie ma reklamacji o takim ID");
            return;
        }
        if(i==0){
            System.out.println("Nie mozesz odrzucic reklamacji o tym statusie");
        }
    }
    public void changeEndStatus(int endComplaintId) {
        int j = 0;
        int i = 0;
        for (Complaint complaint: complaintList) {
            if(complaint.getComplaintId() == endComplaintId) {
                if(complaint.getStatus().equals(Status.ODEBRANA)){
                    i++;
                    complaint.setStatus(Status.ZAKONCZONA);
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
                    String newLine = "ZAKONCZONA";
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
                    System.out.println("Reklamacja zostala zakonczona");
                }
                j++;
            }
        }
        if(j==0){
            System.out.println("Nie ma reklamacji o takim ID");
            return;
        }
        if(i==0){
            System.out.println("Reklamacja nie zostala jeszcze odebrana wiec nie mozna jej zakonczyc");
        }
    }

    public void changeReadyStatus(int readyComplaintId) {
        int j = 0;
        int i = 0;
        for (Complaint complaint: complaintList) {
            if(complaint.getComplaintId() == readyComplaintId) {
                if(complaint.getStatus().equals(Status.ZAAKCEPTOWANA)){
                    i++;
                    complaint.setStatus(Status.DO_ODBIORU);
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
                    String newLine = "DO_ODBIORU";
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
                    System.out.println("Reklamacja zostala przekazana do odbioru");
                }
                j++;
            }
        }
        if(j==0){
            System.out.println("Nie ma reklamacji o takim ID");
            return;
        }
        if(i==0){
            System.out.println("Reklamacja nie zostala jeszcze zaakceptowana przez producenta wiec nie mozna jej przekazac do odbioru");
        }
    }




    public void readAllComplaints(){
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
                    complaintList.add(new Complaint(complaintId,cId,status,description,new Product(productId,productName,producer)));
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

