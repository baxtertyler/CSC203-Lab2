package part1;

import java.util.List;
import java.util.Map;

public class Util {

    private static double max = -1.0;
    private static int max_year = 0;

    public static int getYearWithHighestEmissions(Country c)
    {
        for (Map.Entry<Integer, Emission> e : c.getEmissions().entrySet())
        {
            if ((e.getValue().getCO2() + e.getValue().getN2O() + e.getValue().getCH4()) > max)
            {
                max_year = e.getKey();
                max = e.getValue().getCO2() + e.getValue().getN2O() + e.getValue().getCH4();
            }
        }
        return max_year;
    }

    public static int getYearWithHighestEmissions(Sector s)
    {
        for (Map.Entry<Integer, Double> e : s.getEmissions().entrySet())
        {
            if (e.getValue() > max)
            {
                max_year = e.getKey();
                max = e.getValue();
            }
        }
        return max_year;
    }
}
