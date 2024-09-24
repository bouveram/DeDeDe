package io.snowcamp.workshop.dedede.service;

import io.snowcamp.workshop.dedede.domain.Diamond;
import io.snowcamp.workshop.dedede.domain.Gold;
import io.snowcamp.workshop.dedede.domain.Jewel;
import io.snowcamp.workshop.dedede.repository.EarthRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class JewelServiceTest {

    private ForgeService forgeService;
    private JewelService jewelService;

    @BeforeEach
    void setUp() {
        EarthRepository earthRepository = new EarthRepository();
        forgeService = Mockito.mock(ForgeService.class);
        jewelService = new JewelService(earthRepository, forgeService);
    }

    @Test
    void createJewel_with100Money() {
        when(forgeService.makeRing(any(Gold.class), any(Diamond.class))).thenReturn(Jewel.RING);
        Jewel result = jewelService.createJewel(100);
        assertEquals(Jewel.RING, result);
    }

    @Test
    void createJewel_with200Money() {
        when(forgeService.makeBracelet(any(Gold.class), any(Diamond.class))).thenReturn(Jewel.BRACELET);
        Jewel result = jewelService.createJewel(200);
        assertEquals(Jewel.BRACELET, result);
    }

    @Test
    void createJewel_with300Money() {
        when(forgeService.makeNecklace(any(Gold.class), any(Diamond.class))).thenReturn(Jewel.NECKLACE);
        Jewel result = jewelService.createJewel(300);
        assertEquals(Jewel.NECKLACE, result);
    }

    @Test
    void createJewel_withInvalidMoney() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jewelService.createJewel(400);
        });
        assertEquals("Invalid price", exception.getMessage());
    }
}