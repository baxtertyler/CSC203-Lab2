package part3;

public class Emission {
    private double CO2;
    private double N2O;
    private double CH4;

    public Emission(double CO2, double N2O, double CH4)
    {
        this.CO2 = CO2;
        this.N2O = N2O;
        this.CH4 = CH4;
    }
    public double getCO2()
    {
        return CO2;
    }
    public double getN2O()
    {
        return N2O;
    }
    public double getCH4()
    {
        return CH4;
    }
}
