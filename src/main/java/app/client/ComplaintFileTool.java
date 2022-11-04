package app.client;

import app.common.Status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ComplaintFileTool {
    private String filename;

    public ComplaintFileTool(int clientId) {
        this.filename = clientId + "_Complaint.txt";
    }
    public void addComplaint(Client client){
        File file = new File(filename);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write(String.valueOf(client.getComplaint().getcId()) + "\n");
            myWriter.write(client.getComplaint().getProduct().getNameOfProduct() + "\n");
            myWriter.write(String.valueOf(client.getComplaint().getProduct().getProductId()) + "\n");
            myWriter.write(String.valueOf(client.getComplaint().getComplaintId()) + "\n");
            myWriter.write(client.getComplaint().getDescription() + "\n");
            myWriter.write(String.valueOf(client.getComplaint().getStatus()) + "\n");
            myWriter.write(client.getComplaint().getProduct().getProducer() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public Status checkStatus(){
        String status;
        try {
            status = Files.readAllLines(Paths.get(filename)).get(5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Status.valueOf(status);
    }
    public String checkNote(){
        try {
            return Files.readAllLines(Paths.get(filename)).get(7);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStatus(Client client){
        String filePath = client.getClientId() + "_Complaint.txt";
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
        String oldLine = null;
        try {
            oldLine = Files.readAllLines(Paths.get(filePath)).get(5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String newLine = "ODEBRANA";
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
    }
}
