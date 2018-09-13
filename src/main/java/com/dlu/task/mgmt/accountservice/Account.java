package com.dlu.task.mgmt.accountservice;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@ToString
@EqualsAndHashCode
@Entity
public class Account {

    @Id @GeneratedValue
    private long id;


    private String accountName;

    public Account(String accountName){
        this.accountName = accountName;
    }


}
