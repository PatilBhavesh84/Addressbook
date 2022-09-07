package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.AddressbookDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class AddressbookEntity {

    public String firstName;
    public String lastName;
       @ElementCollection
    @CollectionTable(name = "addresses", joinColumns = @JoinColumn(name = "id"))
    public List<String> addresses;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userId;

    public AddressbookEntity(AddressbookDTO addressBookDTO) {

        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.addresses = addressBookDTO.addresses;
    }

    public AddressbookEntity() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
}