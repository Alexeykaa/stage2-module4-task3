package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver  implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle src = event.getSource();
        RectangleWarehouse store = RectangleWarehouse.getInstance();
        RectangleValues value = store.get(src.getId());
        value.setPerimeter(src.getPerimeter());
        value.setSquare(src.getSquare());
    }
}
