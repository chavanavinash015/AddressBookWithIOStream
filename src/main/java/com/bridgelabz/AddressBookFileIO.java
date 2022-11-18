package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {
    public String ADDRESS_BOOK_FILE_NAME = "address-bookIo.txt";

    public List<Contact> readData() {
        List<Contact> contactList = new ArrayList<>();
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).map(line -> line.trim()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }


    public void writeData(List<Contact> contactList) {
        StringBuffer empBuffer = new StringBuffer();
        contactList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
