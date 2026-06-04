package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

        public void writeTransaction(
                        String data) {

                try {

                        BufferedWriter writer = new BufferedWriter(
                                        new FileWriter(
                                                        "transactions.txt",
                                                        true));

                        writer.write(data);

                        writer.newLine();

                        writer.close();

                }

                catch (IOException e) {

                        System.out.println(
                                        e.getMessage());
                }
        }
}