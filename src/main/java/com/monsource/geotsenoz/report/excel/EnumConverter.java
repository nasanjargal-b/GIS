package com.monsource.geotsenoz.report.excel;

import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;

/**
 * Created by nasanjargal on 6/11/14.
 */
public class EnumConverter {
    public static String convertHudagTorol(HudagTorol torol) {
        switch (torol) {
            case BO:
                return "Бохир";
            case DU:
                return "Дулаан";
            case TS:
                return "Цэвэр";
            case TD:
                return "Цэвэр,Дулаан";
        }

        return null;
    }

    public static String convertShugamTorol(ShugamTorol torol) {
        switch (torol) {
            case BO:
                return "Бохир";
            case DU:
                return "Дулаан";
            case TS:
                return "Цэвэр";
        }

        return null;
    }

    public static String convertZug(Zug zug) {
        switch (zug) {
            case B:
                return "б";
            case BH:
                return "бх";
            case BU:
                return "бу";
            case Z:
                return "з";
            case ZH:
                return "зх";
            case ZU:
                return "зу";
            case U:
                return "у";
            case H:
                return "х";
        }
        return null;
    }
}
