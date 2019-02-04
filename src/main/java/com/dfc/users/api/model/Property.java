package com.dfc.users.api.model;

import javax.persistence.*;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @Column(name = "idProperty")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_generator")
    @SequenceGenerator(name = "property_generator", sequenceName = "property_seq")
    private Long idProperty;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;

    public Long getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Long idProperty) {
        this.idProperty = idProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
