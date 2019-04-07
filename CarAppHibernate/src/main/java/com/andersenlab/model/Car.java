package com.andersenlab.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factory_id", referencedColumnName = "id")
    private Factory factory;

    @Column(name = "name")
    private String name;

    @Column(name = "production_year")
    private int productionYear;

    public Car(Factory factory, String name, int productionYear) {
        this.factory = factory;
        this.name = name;
        this.productionYear = productionYear;
    }
}
