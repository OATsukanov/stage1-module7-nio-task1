package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {

        String profileString = "";

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int c;
            while ((c = inputStream.read()) != -1) {
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try {

            byte[] bytes = Files.readAllBytes(file.toPath());

            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : bytes) {
                stringBuilder.append((char) b);
            }

            profileString = stringBuilder.toString();

        } catch (IOException e){

            e.printStackTrace();
        }

        String[] pairs = profileString.split("\\n");
        for (int i = 0; i < pairs.length; i++) {

            pairs[i] = pairs[i].split(": ")[1];
        }

        String name = pairs[0];
        int age = Integer.parseInt(pairs[1]);
        String email = pairs[2];
        long phone = Long.parseLong(pairs[3]);

        return new Profile(name, age, email, phone);

    }
}
