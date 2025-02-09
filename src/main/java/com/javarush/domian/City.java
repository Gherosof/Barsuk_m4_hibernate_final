package com.javarush.domian;


import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.math.BigDecimal;

@Entity
@Table(name = "city", schema = "world")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "name")
    private String name;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    Country country;

//    @Column(name = "district")
    private String district;

//    @Column(name = "population")
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
