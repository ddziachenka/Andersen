package com.andersenlab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "production_might")
    private int productionMight;

    public Factory(String address, int productionMight) {
        this.address = address;
        this.productionMight = productionMight;
    }
}
