package io.snowcamp.workshop.dedede.service;

import io.snowcamp.workshop.dedede.domain.Diamond;
import io.snowcamp.workshop.dedede.domain.Gold;
import io.snowcamp.workshop.dedede.domain.Jewel;
import io.snowcamp.workshop.dedede.repository.EarthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JewelService {

    private final EarthRepository earthRepository;
    private final ForgeService forgeService;

    public Jewel createJewel(int money) {

        Gold gold = earthRepository.getGold();
        Diamond diamond = earthRepository.getDiamond();

        return switch (money) {
            case 100 -> forgeService.makeRing(gold, diamond);
            case 200 -> forgeService.makeBracelet(gold, diamond);
            case 300 -> forgeService.makeNecklace(gold, diamond);
            default -> throw new IllegalArgumentException("Invalid price");
        };
    }
}
