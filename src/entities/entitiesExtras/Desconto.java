package entities.entitiesExtras;

import java.util.ArrayList;
import java.util.List;

public class Desconto {
    private List<Double> descontos;

    public Desconto(List<Double> descontos) {
        descontos = new ArrayList<>();
    }

    public void pegarINSS() {
        descontos.add(0.11);
    }

    public void pegarIR() {
        descontos.add(0.15);
    }

    public double calcularDescontos(double salario) {
        pegarINSS();
        pegarIR();
        double inss = descontos.get(0);
        double ir = descontos.get(1);
        double desconto = inss + ir;
        salario += salario*desconto;
        return salario;
    }


}