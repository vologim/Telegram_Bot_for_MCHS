package com.golovackii.mchs_tg_bot.controller;

import com.golovackii.mchs_tg_bot.model.MapHydrant;
import com.golovackii.mchs_tg_bot.model.RD;

import java.util.List;

public interface MapHydrantController {
    MapHydrant getMapHydrantById(Integer id);

    List<MapHydrant> getListMapHydrant();

    void saveMapHydrant(MapHydrant mapHydrant);

    void updateMapHydrant(MapHydrant mapHydrant);

    void deleteMapHydrantById(Integer id);
}
