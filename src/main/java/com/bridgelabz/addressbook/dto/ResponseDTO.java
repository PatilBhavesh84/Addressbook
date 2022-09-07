package com.bridgelabz.addressbook.dto;

import com.bridgelabz.addressbook.entity.AddressbookEntity;

public class ResponseDTO {
    public String message;
    public AddressbookEntity data;

    public ResponseDTO(String message, AddressbookEntity data) {
        this.message = message;
        this.data = data;
    }
}