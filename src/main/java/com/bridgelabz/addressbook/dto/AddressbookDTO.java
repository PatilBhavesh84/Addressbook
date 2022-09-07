package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Pattern;
import java.util.List;

public class AddressbookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}", message = "Invalid firstname")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}", message = "Invalid lastname")
    public String lastName;

    public List<String> addresses;

    public AddressbookDTO() {
    }
}

