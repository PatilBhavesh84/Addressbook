package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends JpaRepository<AddressbookEntity, Integer> {
}
