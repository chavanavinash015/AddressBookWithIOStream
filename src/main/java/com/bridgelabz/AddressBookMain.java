package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    static ArrayList<Contact> addressBook = new ArrayList<Contact>();
    static Scanner scanner = new Scanner(System.in);
    Contact contact = new Contact();


    public void addContactDetails() {
        Contact contact = new Contact();
        System.out.println("Enter First name");
        String firstName = scanner.next();
        contact.setFirstName(firstName);

        System.out.println("Enter Last name");
        String lastName = scanner.next();
        contact.setLastName(lastName);

        System.out.println("Enter Address");
        String address = scanner.next();
        contact.setAddress(address);

        System.out.println("Enter City name");
        String city = scanner.next();
        contact.setCity(city);

        System.out.println("Enter State name");
        String state = scanner.next();
        contact.setState(state);

        System.out.println("Enter Zip code");
        int zip = scanner.nextInt();
        contact.setZip(zip);

        System.out.println("Enter Phone number");
        long phoneNumber = scanner.nextLong();
        contact.setPhoneNumber(phoneNumber);

        System.out.println("Enter Email");
        String email = scanner.next();
        contact.setEmail(email);

        addressBook.add(contact);
        System.out.println(addressBook);
        System.out.println("created contacts ");


    }

    public void editContactDetails() {
        System.out.println("Enter first name for edit:");
        String editName = scanner.next();
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getFirstName().equals(editName)) {
                System.out.println("Select options");
                System.out.println("1.first Name \t2.last Name \t3.Address \t4.city \t5.State \t6. Zip \t7.Phone Number \t8.Email");
                int editOption = scanner.nextInt();
                switch (editOption) {
                    case 1:
                        System.out.println("Enter First name");
                        addressBook.get(i).setFirstName(scanner.next());
                        break;

                    case 2:
                        System.out.println("Enter Last name");
                        addressBook.get(i).setLastName(scanner.next());
                        break;

                    case 3:
                        System.out.println("Enter Address");
                        addressBook.get(i).setAddress(scanner.nextLine());
                        break;

                    case 4:
                        System.out.println("Enter City name");
                        addressBook.get(i).setCity(scanner.nextLine());
                        break;

                    case 5:
                        System.out.println("Enter State name");
                        addressBook.get(i).setState(scanner.nextLine());
                        break;

                    case 6:
                        System.out.println("Enter Zip code");
                        addressBook.get(i).setZip(scanner.nextInt());
                        break;

                    case 7:
                        System.out.println("Enter Phone number");
                        addressBook.get(i).setPhoneNumber(scanner.nextLong());
                        break;

                    case 8:
                        System.out.println("Enter Email");
                        addressBook.get(i).setEmail(scanner.next());
                        break;

                    default:
                        System.out.println("Enter valid Name");
                }
                System.out.println("Edited list :");
                System.out.println(addressBook);
            }
        }
    }
    public void deleteContacts () {
        System.out.println("Confirm first name to delete contact");
        String confirmName = scanner.next();
        System.out.println(confirmName);
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getFirstName().equals(confirmName)) ;
            Contact person = addressBook.get(i);
            addressBook.remove(person);

        }
        System.out.println(addressBook);



    }

    public void addMultipleContacts() {
        System.out.println("Enter Number of Contacts to Add into Contact Book");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addContactDetails();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }
    public void showAddressBookDetails() {
        if (addressBook.isEmpty()) {
            System.out.println("Address book is empty");
        } else {
            Set<Contact> set = addressBook.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Contact::toString))));
            set.forEach(System.out::println);
        }
    }
    public void searchContactDetails() {
        System.out.println("Enter the city or state to search Contact ");
        String input = scanner.next();
        for (Contact person : addressBook) {
            if (person.getCity().equals(input) || person.getState().equals(input)) {
                System.out.println("Matches with city and state name contact is :" + person);
            }
        }
    }
    public void sortByPersonName(){
        if(addressBook.isEmpty()){
            System.out.println("contact book is empty");
        }else{
            addressBook.stream().sorted(Comparator.comparing(Contact::getFirstName)).forEach(System.out::println);
        }
    }
    public void sortingByCity() {
        if (addressBook.isEmpty()) {
            System.out.println("Contact book is empty");
        } else {
            addressBook.stream().sorted(Comparator.comparing(Contact::getCity)).forEach(System.out::println);
        }
    }


    public void sortingByState() {
        if (addressBook.isEmpty()) {
            System.out.println("Contact book is empty");
        } else {
            addressBook.stream().sorted(Comparator.comparing(Contact::getState)).forEach(System.out::println);
        }
    }


    public void sortingByZip() {
        if (addressBook.isEmpty()) {
            System.out.println("Contact book is empty");
        } else {
            addressBook.stream().sorted(Comparator.comparing(Contact::getZip)).forEach(System.out::println);
        }
    }
    public static void main(String[] args) {

        System.out.println("Welcome to the AddressBook Program ");
        AddressBookMain addressBook = new AddressBookMain();

        addressBook.addContactDetails();
        boolean condition = true;

        while (condition == true) {
            System.out.println("1.Add" + "\n" + "2.Edit" + "\n" + "3.Delete" + "\n" + "4.AddMultipleContacts");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addressBook.addContactDetails();
                    break;
                case 2:
                    addressBook.editContactDetails();
                    break;
                case 3:
                    addressBook.deleteContacts();
                    break;
                case 4:
                    addressBook.addMultipleContacts();
                    break;
                case 5 :
                    addressBook.showAddressBookDetails();
                    break;
                case 6:
                    addressBook.searchContactDetails();
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

}
