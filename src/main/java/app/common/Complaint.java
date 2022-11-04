package app.common;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Complaint {
    private final int complaintId;
    private final int cId;
    private Status status;
    private LocalDate date;
    private final String description;
    private final Product product;

    public Complaint(int cId, String description, Product product, LocalDate localDate) {
        this.cId = cId;
        this.status = Status.ZGLOSZONA;
        this.description = description;
        this.product = product;
        this.complaintId = createid();
        this.date = localDate;
    }

    public Complaint(int complaintId, int cId, Status status, LocalDate date, String description, Product product) {
        this.complaintId = complaintId;
        this.cId = cId;
        this.status = status;
        this.date = date;
        this.description = description;
        this.product = product;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private int createid(){
        String filename = "ComplaintsId.txt";
        File file = new File(filename);
        List<Integer> idList = new ArrayList<>();

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int id = (int) Math.floor(Math.random() * (99999 - 1 + 1) + 1);
            while (idList.equals(id)) {
                id = (int) Math.floor(Math.random() * (99999 - 1 + 1) + 1);
            }
            try {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(String.valueOf(id));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
            return id;
        }
        else {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    idList.add(Integer.valueOf(line));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            int id = (int) Math.floor(Math.random() * (99999 - 1 + 1) + 1);
            while (idList.equals(id)) {
                id = (int) Math.floor(Math.random() * (99999 - 1 + 1) + 1);
            }
            try {
                FileWriter myWriter = new FileWriter(filename, true);
                myWriter.write("\n");
                myWriter.write(String.valueOf(id));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        return id;
        }
    }

    public Status getStatus() {
        return status;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getcId() {
        return cId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", cId=" + cId +
                ", status=" + status +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}

