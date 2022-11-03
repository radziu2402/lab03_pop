package app.client;

import java.io.*;

public class ClientFileTool {
    String filename = "clients.txt";

    public int checkNumberOfClients(){

        File file = new File(filename);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return 0;
        }
        else{
            int lines = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                while (reader.readLine() != null) lines++;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }
    }

    public void addClientToFile(Client client){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write(client.getClientId() + "," + client.getName() + "\n" );
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
