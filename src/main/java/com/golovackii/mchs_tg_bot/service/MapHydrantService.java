package com.golovackii.mchs_tg_bot.service;

import com.golovackii.mchs_tg_bot.model.MapHydrant;

import java.util.List;

public interface MapHydrantService {

    void save(MapHydrant mapHydrant);

    void update(MapHydrant mapHydrant);

    MapHydrant getById(Integer id);

    List<MapHydrant> getList();

    void deleteById(Integer id);
}
