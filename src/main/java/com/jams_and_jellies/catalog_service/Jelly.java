package com.jams_and_jellies.catalog_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jelly {
    @Id
    String stockNumber;

    @NotNull
    String name;

    Jelly() {}

    Jelly(String stockNumber, String name) {
        this.stockNumber = stockNumber;
        this.name = name;
    }
}
