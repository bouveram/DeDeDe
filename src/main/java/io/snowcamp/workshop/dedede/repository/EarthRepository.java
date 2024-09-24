package io.snowcamp.workshop.dedede.repository;

import io.snowcamp.workshop.dedede.domain.Diamond;
import io.snowcamp.workshop.dedede.domain.Gold;
import org.springframework.stereotype.Repository;

@Repository
public class EarthRepository {

    public Gold getGold() {
        return new Gold();
    }

    public Diamond getDiamond() {
        return new Diamond();
    }
}
