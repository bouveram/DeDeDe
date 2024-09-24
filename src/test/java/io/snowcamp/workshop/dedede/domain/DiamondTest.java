package io.snowcamp.workshop.dedede.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiamondTest {

    @Test
    void sharpen() {
        Diamond diamond = new Diamond();
        assertEquals(Sharpness.BLUNT, diamond.getSharpness());
        diamond.sharpen();
        assertEquals(Sharpness.SHARP, diamond.getSharpness());
    }
}