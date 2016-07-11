package com.hack.entities;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
public class Picture {

    @Id
    @GeneratedValue
    private Long id;
    private byte[] data;

    @ManyToOne
    private User user;

}
