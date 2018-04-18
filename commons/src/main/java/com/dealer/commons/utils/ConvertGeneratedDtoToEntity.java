package com.dealer.commons.utils;

import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import resources.generated.ColorGenerated;
import resources.generated.ConditionGenerated;
import resources.generated.VehicleGenerated;
import com.dealer.repository.entities.VehicleEntity;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.HashMap;
import java.util.Map;

//ConvertGeneratedDtoToEntity
public class ConvertGeneratedDtoToEntity {

    private static Map<ConditionGenerated, Condition> CONDITION_GEN_TO_CONDITION = new HashMap<ConditionGenerated, Condition>();
    private static Map<ColorGenerated, Color> COLOR_GEN_TO_CONDITION = new HashMap<ColorGenerated, Color>();

    static {
        CONDITION_GEN_TO_CONDITION.put(ConditionGenerated.NEW, Condition.NEW);
        CONDITION_GEN_TO_CONDITION.put(ConditionGenerated.USED, Condition.USED);

        COLOR_GEN_TO_CONDITION.put(ColorGenerated.RED, Color.RED);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.WHITE, Color.WHITE);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.GREEN, Color.GREEN);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.YELLOW, Color.YELLOW);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.BLACK, Color.BLACK);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.BLUE, Color.BLUE);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.ORANGE, Color.ORANGE);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.PURPLE, Color.PURPLE);
        COLOR_GEN_TO_CONDITION.put(ColorGenerated.TURQUOISE, Color.TURQUOISE);

    }

    //convert the date
    public static java.util.Date asDate(XMLGregorianCalendar xgc) {

        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    //EXAMPLE: CONDITION_GEN_TO_CONDITION.get(vehicleGenerated.getCondition());
    public static Vehicle convertGeneratedVehicleToVehicleDto(VehicleGenerated vehicleGenerated) {
        return new Vehicle(vehicleGenerated.getModel(), vehicleGenerated.getBrand(),
                COLOR_GEN_TO_CONDITION.get(vehicleGenerated.getColor()), vehicleGenerated.getPrice(),
                CONDITION_GEN_TO_CONDITION.get(vehicleGenerated.getCondition()), vehicleGenerated.getUserId());
    }

    // CONVERTING FROM GeneratedVehicle to VehicleEntity;
    public static VehicleEntity convertGeneratedVehicleToVehicleEntity(VehicleGenerated vehicleGenerated) {
        return new VehicleEntity(vehicleGenerated.getModel(), vehicleGenerated.getBrand(),
                COLOR_GEN_TO_CONDITION.get(vehicleGenerated.getColor()), vehicleGenerated.getPrice(),
                CONDITION_GEN_TO_CONDITION.get(vehicleGenerated.getCondition()), vehicleGenerated.getUserId());

    }



}