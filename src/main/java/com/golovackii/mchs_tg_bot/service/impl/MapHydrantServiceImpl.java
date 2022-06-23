package com.golovackii.mchs_tg_bot.service.impl;

import com.golovackii.mchs_tg_bot.model.MapHydrant;
import com.golovackii.mchs_tg_bot.repository.MapHydrantRepository;
import com.golovackii.mchs_tg_bot.service.MapHydrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapHydrantServiceImpl implements MapHydrantService {

    private final MapHydrantRepository mapHydrantRepository;

    @Autowired
    public MapHydrantServiceImpl(MapHydrantRepository mapHydrantRepository) {
        this.mapHydrantRepository = mapHydrantRepository;
    }

    @Override
    public void save(MapHydrant mapHydrant) {
        mapHydrantRepository.save(mapHydrant);
    }

    @Override
    public void update(MapHydrant mapHydrant) {
        mapHydrantRepository.save(mapHydrant);
    }

    @Override
    public MapHydrant getById(Integer id) {
        return mapHydrantRepository.findById(id).orElse(null);
    }

    @Override
    public List<MapHydrant> getList() {
        return mapHydrantRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        mapHydrantRepository.deleteById(id);
    }
}
