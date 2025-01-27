package com.blissom.userservice.dataexporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.blissom.userservice.model.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserDataExporter {

    public static void export(UserEntity user) {
        try {
            String filename = String.format("user_data_%d.json", user.getUserId());
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            String json = writer.writeValueAsString(user);
            Path path = Paths.get(filename);
            Files.write(path, json.getBytes());
            System.out.println("Exported user data to " + filename);
        } catch (IOException e) {
            throw new RuntimeException("Failed to export user data", e);
        }
    }

}
