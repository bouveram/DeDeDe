package io.snowcamp.workshop.dedede.service;

import io.snowcamp.workshop.dedede.domain.Jewel;
import io.snowcamp.workshop.dedede.repository.EarthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JewelService {

    private final EarthRepository earthRepository;

    public Jewel createJewel(int money) {

        if (!earthRepository.getGold() || !earthRepository.getDiamond()) {
            throw new IllegalStateException("Not enough resources");
        }

        return switch (money) {
            case 100 -> Jewel.RING;
            case 200 -> Jewel.BRACELET;
            case 300 -> Jewel.NECKLACE;
            default -> throw new IllegalArgumentException("Invalid price");
        };
    }
}
