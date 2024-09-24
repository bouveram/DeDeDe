package io.snowcamp.workshop.dedede.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldTest {

    @Test
    void mold() {
        Gold gold = new Gold();
        assertEquals(PhysicalStatus.SOLID, gold.getStatus());
        gold.mold();
        assertEquals(PhysicalStatus.LIQUID, gold.getStatus());
    }
}