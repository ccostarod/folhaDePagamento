package entities.entitiesExtras;

public class BeneficioItem {
    private String name;
    private double valor;

    public BeneficioItem(String name, double valor) {
        this.name = name;
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "BeneficioItem{" +
                "name='" + name + '\'' +
                ", valor=" + valor +
                '}';
    }
}