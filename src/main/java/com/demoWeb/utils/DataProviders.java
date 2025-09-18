package com.demoWeb.utils;

import com.demoWeb.models.RegisterUser;
import com.demoWeb.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newUserRegistrationWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/Users.csv"));
        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/Login.csv"));
        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");

            list.add(new Object[]{new RegisterUser()
                    .setEmail(split[0])
                    .setPassword(split[1])});

            line = reader.readLine();
        }
        return list.iterator();
    }
}
