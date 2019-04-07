package com.andersenlab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Ferrari extends Car {
    @Column(name = "red_color_intensity")
    private int redColorIntensity;

    public Ferrari(int redColorIntensity) {
        this.redColorIntensity = redColorIntensity;
    }

    public Ferrari(Factory factory, String name, int productionYear, int redColorIntensity) {
        super(factory, name, productionYear);
        this.redColorIntensity = redColorIntensity;
    }
}
