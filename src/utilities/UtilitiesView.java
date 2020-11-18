package utilities;

import java.text.DecimalFormat;

public class UtilitiesView {

    public static double toformatPrice(int value){
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.parseDouble(format.format(value));
    }

    public static String[] split(String data){
        return data.split("-");
    }
}
