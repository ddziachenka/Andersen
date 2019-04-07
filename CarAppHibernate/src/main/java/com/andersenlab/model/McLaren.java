package com.andersenlab.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class McLaren extends Car {

    @Column(name = "fernando_alonso_karma")
    private String fernandoAlonsoKarma;

    public McLaren(String fernandoAlonsoKarma) {
        this.fernandoAlonsoKarma = fernandoAlonsoKarma;
    }

    public McLaren(Factory factory, String name, int productionYear, String fernandoAlonsoKarma) {
        super(factory, name, productionYear);
        this.fernandoAlonsoKarma = fernandoAlonsoKarma;
    }
}
