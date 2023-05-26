package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class Convertor {
    public static void jsonToJava() {
        EveryThing thing;

        String path = Paths.get("TestYourFork.json").toAbsolutePath().toString().
                replace("TestYourFork.json", "src/main/java/org/example/TestYourFork.json");
        File file = new File(path);

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,
                new TypeAdapter<LocalDate>() {
                    @Override
                    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                        jsonWriter.value(localDate.toString());
                    }

                    @Override
                    public LocalDate read(JsonReader jsonReader) throws IOException {
                        return LocalDate.parse(jsonReader.nextString());
                    }
                }).create();

        try(Reader reader = new FileReader(file)) {
            thing = gson.fromJson(reader, EveryThing.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (thing.books != null)
            Main.books = thing.books;
        if (thing.games != null)
            Main.games = thing.games;
        if (thing.movies != null)
            Main.movies = thing.movies;
        if (thing.customers != null)
            Main.customers = thing.customers;
        if (thing.rentals != null)
            Main.rentals = thing.rentals;
    }

    public static void javaToJson() {
        ArrayList<Rental> rentals = new EveryThing().rentals;

        String path = Paths.get("Rentals.json").toAbsolutePath().toString().
                replace("Rentals.json", "src/main/java/org/example/Rentals.json");
        File file = new File(path);

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,
                new TypeAdapter<LocalDate>() {
                    @Override
                    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
                        jsonWriter.value(localDate.toString());
                    }

                    @Override
                    public LocalDate read(JsonReader jsonReader) throws IOException {
                        return LocalDate.parse(jsonReader.nextString());
                    }
                }).create();

        try(Writer writer = new FileWriter(file)) {
             gson.toJson(rentals, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
