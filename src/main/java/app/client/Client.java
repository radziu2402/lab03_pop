package app.client;


import app.common.Complaint;
import app.common.Status;

public class Client {
    private final int clientId;
    private final String name;
    private Complaint complaint;

    public Client(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public int getClientId() {
        return clientId;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getName() {
        return name;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public Status getStatus() {
        return complaint.getStatus();
    }
    public void changeStatus(Status status){
        complaint.setStatus(status);
    }
}
