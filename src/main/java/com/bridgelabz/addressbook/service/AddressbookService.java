package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressbookDTO;
import com.bridgelabz.addressbook.entity.AddressbookEntity;
import com.bridgelabz.addressbook.exception.ContactNotFoundException;
import com.bridgelabz.addressbook.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressbookService {
    @Autowired
    AddressbookRepository addressBookRepository;
    public AddressbookEntity createAddress(AddressbookDTO addressDTO){
        AddressbookEntity addressData = new AddressbookEntity(addressDTO);
        return addressBookRepository.save(addressData);
    }
    public AddressbookEntity getAddress(int id){
        try {
            Optional<AddressbookEntity> addressDataOptional = addressBookRepository.findById(id);
            AddressbookEntity contactAddress = addressDataOptional.get();
            return contactAddress;

        }
        catch (NoSuchElementException exception)
        {
            throw new ContactNotFoundException(id);
        }

    }

    public AddressbookEntity updateAddress(int id, @Valid AddressbookDTO addressDTO) {
        try {
            Optional<AddressbookEntity> addressDataOptional = addressBookRepository.findById(id);
            AddressbookEntity addressData = addressDataOptional.get();
            addressData.setFirstName(addressDTO.firstName);
            addressData.setLastName(addressDTO.lastName);
            addressBookRepository.save(addressData);
            return addressData;
        }
        catch (NoSuchElementException exception)
        {
            throw new ContactNotFoundException(id);
        }
    }
    public AddressbookEntity deleteAddress(int id) {
        try {
            addressBookRepository.deleteById(id);
            return null;
        } catch (EmptyResultDataAccessException exception) {
            throw new ContactNotFoundException(id);
        }
    }

}
