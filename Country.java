package part3;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Country {
    private String name;
    private Map <Integer, Emission> emissions = new HashMap<>();

    public Country(String name, Map <Integer, part3.Emission> emissions)
    {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<java.lang.Integer, part3.Emission> getEmissions() {
        return emissions;
    }

    public int getYearWithHighestEmissions()
    {
        int max_year = 0;
        double max = -1;
        for (Map.Entry<Integer, part3.Emission> e : emissions.entrySet())
        {
            if ((e.getValue().getCO2() + e.getValue().getN2O() + e.getValue().getCH4()) > max)
            {
                max_year = e.getKey();
                max = e.getValue().getCO2() + e.getValue().getN2O() + e.getValue().getCH4();
            }
        }
        return max_year;
    }

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year)
    {
        double max = -1;
        Country max_country = null;
        for (Country c: countries)
        {
            if(c.getEmissions().get(year).getCH4() > max)
            {
                max = c.getEmissions().get(year).getCH4();
                max_country = c;
            }
        }
        System.out.println(max_country.getName() + " : " + max);
        return max_country;
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear)
    {
        double max = -1;
        Country max_country = new Country(null, null);
        for (Country c: countries)
        {
            double one = c.getEmissions().get(startYear).getCO2() + c.getEmissions().get(startYear).getN2O() +
                    c.getEmissions().get(startYear).getCH4();
            double two = c.getEmissions().get(endYear).getCO2() + c.getEmissions().get(endYear).getN2O() +
                    c.getEmissions().get(endYear).getCH4();
            double difference = 0;
            difference = two-one;
            if(difference > max)
            {
                max = difference;
                max_country = c;
            }
        }
        System.out.println(max_country.getName() + " : " + max);
        return max_country;
    }
}
