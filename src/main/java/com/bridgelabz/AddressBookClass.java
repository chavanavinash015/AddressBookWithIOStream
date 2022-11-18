package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookClass {
    static final Scanner scanner = new Scanner(System.in);
    static final LinkedList<Contact> contact = new LinkedList<>();
    private List<Contact> contactsList;

    public AddressBookClass(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public AddressBookClass() {
    }


    public void addContact(Scanner scanner) {
        Contact addressBook = new Contact();
        System.out.println("Enter a first name:");
        addressBook.setFirstName(scanner.next());
        System.out.println("Enter a last name:");
        addressBook.setLastName(scanner.next());
        System.out.println("Enter a Address:");
        addressBook.setAddress(scanner.next());
        System.out.println("Enter a City name:");
        addressBook.setCity(scanner.next());
        System.out.println("Enter a state:");
        addressBook.setState(scanner.next());
        System.out.println("Enter a email:");
        addressBook.setEmail(scanner.next());
        System.out.println("Enter a zip code:");
        addressBook.setZip((scanner.nextInt()));
        System.out.println("Enter a phone number:");
        addressBook.setPhoneNumber(scanner.nextLong());
        contactsList.add(new Contact(addressBook.getFirstName(), addressBook.getLastName(), addressBook.getAddress(), addressBook.getCity(), addressBook.getState(), addressBook.getEmail(), addressBook.getZip(), addressBook.getPhoneNumber()));
        System.out.println("Contact added success fully");
    }

    public void writeTheData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n writing Employee Payroll Roaster to console \n" + contactsList);
        else if (ioService.equals(IOService.FILE_IO))
            new AddressBookFileIO().writeData(contactsList);
    }

    public long readContactDetails(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            this.contactsList = new AddressBookFileIO().readData();
        return contactsList.size();
    }

    public void editContacts() {
        System.out.println("Enter first or last name  to edit ");
        String editName = scanner.next();
        for (int i = 0; i < contact.size(); i++) {
            if (contact.get(i).getFirstName().equals(editName) || contact.get(i).getLastName().equals(editName)) {
                System.out.println("Select options \n1.first name \n2.last name\n3.address\n4.city\n5.state\n6.email\n7.zipcode\n8.phoneNum\n9.Exit ");
                int edit = scanner.nextInt();
                switch (edit) {
                    case 1 -> {
                        System.out.println("Enter first name ");
                        String editFirstName = scanner.next();
                        contact.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                    }
                    case 2 -> {
                        System.out.println("Enter last name ");
                        String editLastName = scanner.next();
                        contact.get(i).setLastName(editLastName);
                        System.out.println(editLastName);
                    }
                    case 3 -> {
                        System.out.println("Enter Address ");
                        String editAddress = scanner.next();
                        contact.get(i).setAddress(editAddress);
                        System.out.println(editAddress);
                    }
                    case 4 -> {
                        System.out.println("Enter city ");
                        String editCity = scanner.next();
                        contact.get(i).setCity(editCity);
                        System.out.println(editCity);
                    }
                    case 5 -> {
                        System.out.println("Enter state ");
                        String editState = scanner.next();
                        contact.get(i).setState(editState);
                        System.out.println(editState);
                    }
                    case 6 -> {
                        System.out.println("Enter email ");
                        String editEmail = scanner.next();
                        contact.get(i).setEmail(editEmail);
                        System.out.println(editEmail);
                    }
                    case 7 -> {
                        System.out.println("Enter zipcode");
                        int editZip = scanner.nextInt();
                        contact.get(i).setZip((editZip));
                        System.out.println(editZip);
                    }
                    case 8 -> {
                        System.out.println("Enter phone number ");
                        long editPhoneNumber = scanner.nextLong();
                        contact.get(i).setPhoneNumber(editPhoneNumber);
                        System.out.println(editPhoneNumber);
                    }
                    default -> System.out.println("Exit the loop");
                }
                System.out.println("Contact edited successfully");
                System.out.println(contact);
            } else {
                System.out.println("Contact not found ");
            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter first or last name to Delete contact");
        String confirmName = scanner.next();
        for (int i = 0; i < contact.size(); i++) {
            if (contact.get(i).getFirstName().equals(confirmName) || contact.get(i).getLastName().equals(confirmName)) {
                Contact person = contact.get(i);
                contact.remove(person);
                System.out.println("Contact delete successfully");
            } else {
                System.out.println("Contact not found in AddressBook");
            }

            System.out.println(contact);
        }
    }

    public void addMultipleContacts() {
        System.out.println("Enter number of contacts added to the AddressBook");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            addContact(scanner);
            System.out.println(i + 1 + "-->Contact added successfully");
        }
    }

    public void showContacts() {
        if (contact.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            Set<Contact> productSet = contact.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Contact::toString))));
            productSet.forEach(System.out::println);
        }
    }// ability to view

    public void searchMethod() {
        System.out.println("Enter the city or state to search Contact ");
        String input = scanner.next();
        contact.stream().filter(city -> city.getCity().equals(input)).filter(state -> state.getState().equals(input)).forEach(System.out::println);
//        for (Contacts book : contact) {
//            if (book.getCity().equals(input) || book.getState().equals(input)) {
//                System.out.println("Matches with city name contact is :" + book);
//            }
//        }
    }

    public void sortingByPersonName() {
        if (contact.isEmpty()) {
            System.out.println("Contacts book is empty");
        } else {
            contact.stream().sorted(Comparator.comparing(Contact::getFirstName)).forEach(System.out::println);
        }
    }

    public void sortingByCity() {
        if (contact.isEmpty()) {
            System.out.println("Contact book is empty");
        } else {
            contact.stream().sorted(Comparator.comparing(Contact::getCity)).forEach(System.out::println);
        }
    }

    public void countCity() {
        System.out.println("Enter a City name ");
        String input = scanner.next();
        long count = contact.stream().filter(city -> city.getCity().equals(input)).count();
        System.out.println("No of contacts Matched " + input + " city is : " + count);
    }

    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_ID
    }


    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook program");
        AddressBookClass addressBookClass = new AddressBookClass();
        boolean condition = true;
        while (condition) {
            System.out.println("Choose the options \n1.AddContact\n2.EditContact\n3.DeleteContact\n4.AddMultipleContacts\n5.CountByCity\n6.Exit");
            int options = scanner.nextInt();
            switch (options) {
                case 1 -> addressBookClass.addContact(scanner);
                case 2 -> addressBookClass.editContacts();
                case 3 -> addressBookClass.deleteContact();
                case 4 -> addressBookClass.addMultipleContacts();
                case 5 -> addressBookClass.countCity();
                case 6 -> {
                    condition = false;
                    System.out.println("Exiting the loop....");
                }
                default -> System.out.println("Enter the correct number");
            }
        }
    }
}