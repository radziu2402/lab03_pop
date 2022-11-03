package app.common;

public class Complaint {
    private int complaintId = (int)Math.floor(Math.random()*(99999-1+1)+1);
    private final int cId;
    private Status status;
    private final String description;
    private final Product product;

    public Complaint(int cId, String description, Product product) {
        this.cId = cId;
        this.status = Status.ZGLOSZONA;
        this.description = description;
        this.product = product;
    }

    public Complaint(int complaintId, int cId, Status status, String description, Product product) {
        this.complaintId = complaintId;
        this.cId = cId;
        this.status = status;
        this.description = description;
        this.product = product;
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

