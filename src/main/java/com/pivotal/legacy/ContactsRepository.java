package com.pivotal.legacy;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by mwright on 6/22/16.
 */

public interface ContactsRepository extends CrudRepository<Contact, Long> {
}
