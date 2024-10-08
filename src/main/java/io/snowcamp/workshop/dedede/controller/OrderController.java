package io.snowcamp.workshop.dedede.controller;

import io.snowcamp.workshop.dedede.controller.dto.JewelDto;
import io.snowcamp.workshop.dedede.domain.Jewel;
import io.snowcamp.workshop.dedede.service.JewelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final JewelService jewelService;

    @PutMapping("/jewels")
    public JewelDto makeNewJewelOrder(@RequestParam(name = "price") int price) {
        Jewel jewel = jewelService.createJewel(price);
        return new JewelDto(jewel.getName(), jewel.getDescription());
    }
}
