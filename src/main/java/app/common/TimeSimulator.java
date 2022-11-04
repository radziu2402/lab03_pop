package app.common;

import java.io.*;
import java.time.LocalDate;

public class TimeSimulator {
    private LocalDate localDate = LocalDate.now();

    public void addLocalDateTime() {
        int randDays = (int)(Math.random() * ((7 - 1) + 1)) + 1;
        this.localDate = this.localDate.plusDays(randDays);
    }


    public LocalDate checkTime(){
        String filename = "time.txt";
        File file = new File(filename);
            if(!file.exists()){
                try {
                    file.createNewFile();
                    try {
                        FileWriter myWriter = new FileWriter(filename);
                        myWriter.write(String.valueOf(localDate));
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            localDate = LocalDate.parse(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(filename);
            addLocalDateTime();
            myWriter.write(String.valueOf(localDate));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return localDate;
    }

}
