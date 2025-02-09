package com.javarush.domian;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

import java.math.BigDecimal;

@Entity
@Table(name = "country_language", schema = "world")
public class CountryLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

//    @Column(name = "language")
    private String language;


//    @Column(name = "is_official")
    @Column(name = "is_official", columnDefinition = "BIT", length = 1)
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isOfficial;

//    @Column(name = "percentage")
    private BigDecimal percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", country=" + country +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }
}
