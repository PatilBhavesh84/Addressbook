package com.bridgelabz.addressbook.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(int id) {
        super("Contact not found of id="+id);
    }
}
