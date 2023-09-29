package entities.entitiesExtras;

public class DescontoItem {
    private String name;
    private double valorPerc;

    public DescontoItem(String name, double valorPerc) {
        this.name = name;
        this.valorPerc = valorPerc;
    }

    public String getName() {
        return name;
    }

    public double getValorPerc() {
        return valorPerc;
    }

    @Override
    public String toString() {
        return "DescontoItem{" +
                "name='" + name + '\'' +
                ", valorPerc=" + valorPerc +
                '}';
    }
}
