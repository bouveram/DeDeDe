package io.snowcamp.workshop.dedede.domain;

import lombok.Getter;

@Getter
public class Gold {
    private PhysicalStatus status;

    public Gold() {
        this.status = PhysicalStatus.SOLID;
    }

    public Gold mold() {
        this.status = PhysicalStatus.LIQUID;
        return this;
    }
}
