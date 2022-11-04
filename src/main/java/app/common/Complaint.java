package app.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Complaint {
    private final int complaintId;
    private final int cId;
    private Status status;
    private final String description;
    private final Product product;

    public Complaint(int cId, String description, Product product) {
        this.cId = cId;
        this.status = Status.ZGLOSZONA;
        this.description = description;
        this.product = product;
        this.complaintId = createid();
    }

    public Complaint(int complaintId, int cId, Status status, String description, Product product) {
        this.complaintId = complaintId;
        this.cId = cId;
        this.status = status;
        this.description = description;
        this.product = product;
    }

    private int createid(){
        String filename = "ComplaintsId.txt";
        File file = new File(filename);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<Integer> idList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null){
                idList.add(Integer.valueOf(reader.readLine()));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        int id = (int)Math.floor(Math.random()*(99999-1+1)+1);
        while(idList.equals(id)){
            id = (int)Math.floor(Math.random()*(99999-1+1)+1);
        }
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write(id);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return id;
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
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}

