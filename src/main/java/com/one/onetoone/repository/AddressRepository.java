package com.one.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.onetoone.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
