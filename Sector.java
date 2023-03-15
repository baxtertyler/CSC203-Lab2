package part3;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Sector {
    private String name;
    private Map<Integer, Double> emissions = new HashMap<>();

    public Sector (String name,Map<Integer, Double> emissions)
    {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName()
    {
        return name;
    }
    public Map<java.lang.Integer, java.lang.Double> getEmissions()
    {
        return emissions;
    }

    public int getYearWithHighestEmissions()
    {
        double max = 0;
        int max_year = 0;
        for (Map.Entry<Integer, Double> e : emissions.entrySet())
        {
            if (e.getValue() > max)
            {
                max = e.getValue();
                max_year = e.getKey();
            }
        }
        return max_year;
    }

    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int startYear, int endYear)
    {
        double max = -1;
        Sector max_sector = new Sector(null, null);
        for (Sector s: sectors)
        {
            double total = 0;
            int cnt = 0;
            for (int i = startYear; i <= endYear; i++)
            {
                total += s.emissions.get(i);
                cnt += 1;
            }
            total = total / cnt;
            if (total > max)
            {
                max = total;
                max_sector = s;
            }
        }
        System.out.println(max_sector.getName() + " : " + max);
        return max_sector;
    }

}
