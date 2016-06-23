package com.pivotal.legacy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mwright on 6/21/16.
 */

@Entity
final class Contact {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNbr() {
        return phoneNbr;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    private String firstName;
    private String lastName;
    private String phoneNbr;

    @Id
    private Long contactId;
}
