package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressbookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.entity.AddressbookEntity;
import com.bridgelabz.addressbook.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressbookController {
    @Autowired
    AddressbookService addressBookService;

    @PostMapping("/create")
    public ResponseDTO createAddress(@Valid @RequestBody AddressbookDTO addressDTO) {
        AddressbookEntity addressData = addressBookService.createAddress(addressDTO);
        ResponseDTO addressResponse = new ResponseDTO("Created successful", addressData);
        return addressResponse;
    }

    @PutMapping("/set/{id}")
    public ResponseDTO updateAddress(@PathVariable("id") int id, @Valid @RequestBody AddressbookDTO addressDTO) {
        AddressbookEntity addressData = addressBookService.updateAddress(id, addressDTO);
        ResponseDTO addressResponse = new ResponseDTO("Updated Address", addressData);
        return addressResponse;
    }

    @GetMapping("/get/{id}")
    public ResponseDTO getAddress(@PathVariable("id") int id) {
        AddressbookEntity addressData = addressBookService.getAddress(id);
        ResponseDTO addressResponse = new ResponseDTO("Get call Successful", addressData);
        return addressResponse;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteAddress(@PathVariable("id") int id) {
        AddressbookEntity addressData = addressBookService.deleteAddress(id);
        ResponseDTO addressResponse = new ResponseDTO("Deleted Address", addressData);
        return addressResponse;
    }
}