package entities.entitiesExtras;

public class Beneficio {
    private double planoDeSaude;
    private double valeTransporte;

    public Beneficio(double planoDeSaude, double valeTransporte) {
        this.planoDeSaude = planoDeSaude;
        this.valeTransporte = valeTransporte;
    }

    public double pegarBeneficios(){
        double total = 0;
        total = planoDeSaude + valeTransporte;
        return total;
    }


}
