package com.bridgelabz;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AddressBookTest {

    @BeforeAll
    static void displayMethod(){
        System.out.println("Welcome to the Address Book");

    }

    @AfterEach
    public void AfterTest(){
        System.out.println("Test Run Successfully ");

    }

    @Test
    public void givenwrite_whenCcontactDetail_shouldReturn(){
        Contact[] array = {
                new Contact("FirstName", "LastName", "Address", "City" ),
                new Contact("State", "Email", "zip", "phoneNumber" ),
        };
        AddressBookClass addressBookClass;
        addressBookClass = new AddressBookClass(Arrays.asList(array));
        addressBookClass.writeTheData(AddressBookClass.IOService.FILE_IO);

    }

    @Test
    public void givenread_whenContactDetail_shouldReturn() {
        AddressBookClass addressBookClass = new AddressBookClass();
        addressBookClass.readContactDetails(AddressBookClass.IOService.FILE_IO);

    }
}
