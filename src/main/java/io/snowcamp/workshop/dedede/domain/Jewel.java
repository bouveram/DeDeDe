package io.snowcamp.workshop.dedede.domain;

import lombok.Getter;

@Getter
public enum Jewel {
    RING("The Ring", "One ring to rule them all"),
    NECKLACE("The Necklace", "One necklace to find them"),
    BRACELET("The Bracelet", "One bracelet to bring them all");

    private final String name;
    private final String description;

    Jewel(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
