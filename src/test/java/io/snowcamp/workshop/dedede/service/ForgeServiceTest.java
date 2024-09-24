package io.snowcamp.workshop.dedede.service;

import io.snowcamp.workshop.dedede.domain.Diamond;
import io.snowcamp.workshop.dedede.domain.Gold;
import io.snowcamp.workshop.dedede.domain.Jewel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ForgeServiceTest {

    private ForgeService forgeService;
    private Gold validGold;
    private Gold moldedGold;
    private Diamond validDiamond;
    private Diamond sharpenedDiamond;

    @BeforeEach
    void setUp() {
        forgeService = new ForgeService();
        validGold = new Gold();
        moldedGold = new Gold().mold();
        validDiamond = new Diamond();
        sharpenedDiamond = new Diamond().sharpen();
    }

    @Test
    void makeRing_withValidMaterials() {
        Jewel result = forgeService.makeRing(validGold, validDiamond);
        assertEquals(Jewel.RING, result);
    }

    @Test
    void makeBracelet_withValidMaterials() {
        Jewel result = forgeService.makeBracelet(validGold, validDiamond);
        assertEquals(Jewel.BRACELET, result);
    }

    @Test
    void makeNecklace_withValidMaterials() {
        Jewel result = forgeService.makeNecklace(validGold, validDiamond);
        assertEquals(Jewel.NECKLACE, result);
    }

    @Test
    void makeRing_withInvalidGold() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeRing(moldedGold, validDiamond);
        });
        assertEquals("Gold is not valid", exception.getMessage());
    }

    @Test
    void makeRing_withInvalidDiamond() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeRing(validGold, sharpenedDiamond);
        });
        assertEquals("Diamond is not valid", exception.getMessage());
    }

    @Test
    void makeBracelet_withInvalidGold() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeBracelet(moldedGold, validDiamond);
        });
        assertEquals("Gold is not valid", exception.getMessage());
    }

    @Test
    void makeBracelet_withInvalidDiamond() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeBracelet(validGold, sharpenedDiamond);
        });
        assertEquals("Diamond is not valid", exception.getMessage());
    }

    @Test
    void makeNecklace_withInvalidGold() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeNecklace(moldedGold, validDiamond);
        });
        assertEquals("Gold is not valid", exception.getMessage());
    }

    @Test
    void makeNecklace_withInvalidDiamond() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            forgeService.makeNecklace(validGold, sharpenedDiamond);
        });
        assertEquals("Diamond is not valid", exception.getMessage());
    }
}