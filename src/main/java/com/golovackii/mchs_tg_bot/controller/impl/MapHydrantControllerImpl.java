package com.golovackii.mchs_tg_bot.controller.impl;

import com.golovackii.mchs_tg_bot.controller.MapHydrantController;
import com.golovackii.mchs_tg_bot.model.MapHydrant;
import com.golovackii.mchs_tg_bot.service.MapHydrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mapHydrant")
public class MapHydrantControllerImpl implements MapHydrantController {

    private final MapHydrantService mapHydrantService;

    @Autowired
    public MapHydrantControllerImpl(MapHydrantService mapHydrantService) {
        this.mapHydrantService = mapHydrantService;
    }

    @Override
    @GetMapping("/{id}")
    public MapHydrant getMapHydrantById(@PathVariable Integer id) {
        return mapHydrantService.getById(id);
    }

    @Override
    @GetMapping
    public List<MapHydrant> getListMapHydrant() {
        return mapHydrantService.getList();
    }

    @Override
    @PostMapping
    public void saveMapHydrant(@RequestBody MapHydrant mapHydrant) {
        mapHydrantService.save(mapHydrant);
    }

    @Override
    @PutMapping
    public void updateMapHydrant(@RequestBody MapHydrant mapHydrant) {
        mapHydrantService.save(mapHydrant);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteMapHydrantById(@PathVariable Integer id) {
        mapHydrantService.deleteById(id);
    }
}
