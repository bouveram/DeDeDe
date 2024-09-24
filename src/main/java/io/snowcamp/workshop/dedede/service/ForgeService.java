package io.snowcamp.workshop.dedede.service;

import io.snowcamp.workshop.dedede.domain.*;

//325
public class ForgeService {

    public Jewel makeRing(Gold gold, Diamond diamond) {
        moldGold(gold);
        cutDiamond(diamond);
        polishJewel(gold, diamond);
        return Jewel.RING;
    }

    public Jewel makeBracelet(Gold gold, Diamond diamond) {
        moldGold(gold);
        cutDiamond(diamond);
        polishJewel(gold, diamond);
        return Jewel.BRACELET;
    }

    public Jewel makeNecklace(Gold gold, Diamond diamond) {
        moldGold(gold);
        cutDiamond(diamond);
        polishJewel(gold, diamond);
        return Jewel.NECKLACE;
    }

    private boolean isGoldValid(Gold gold) {
        return gold != null && PhysicalStatus.SOLID.equals(gold.getStatus());
    }

    private boolean isDiamondValid(Diamond diamond) {
        return diamond != null && Sharpness.BLUNT.equals(diamond.getSharpness());
    }

    private void moldGold(Gold gold) {
        if (!isGoldValid(gold)) {
            throw new IllegalArgumentException("Gold is not valid");
        }
        gold.mold();
    }

    private void cutDiamond(Diamond diamond) {
        if (!isDiamondValid(diamond)) {
            throw new IllegalArgumentException("Diamond is not valid");
        }
        diamond.sharpen();
    }

    private void polishJewel(Gold gold, Diamond diamond) {
        // polishing logic
    }
}
