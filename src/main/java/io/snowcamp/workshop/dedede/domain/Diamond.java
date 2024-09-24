package io.snowcamp.workshop.dedede.domain;

import lombok.Getter;

@Getter
public class Diamond {
    private Sharpness sharpness;

    public Diamond() {
        this.sharpness = Sharpness.BLUNT;
    }

    public Diamond sharpen() {
        this.sharpness = Sharpness.SHARP;
        return this;
    }
}
