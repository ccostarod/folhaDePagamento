package entities.entitiesExtras;

import java.util.ArrayList;
import java.util.List;

public class Desconto {
    private List<DescontoItem> descontos;

    public Desconto() {
        descontos = new ArrayList<>();
    }

    public boolean adicionarDesconto(DescontoItem descontoItem){
        if(!descontos.contains(descontoItem)){
            descontos.add(descontoItem);
            return true;
        }
        return false;
    }

    public boolean removerDesconto(DescontoItem descontoItem){
        if(descontos.contains(descontoItem)){
            descontos.remove(descontoItem);
            return true;
        }
        return false;
    }

    public double calcularDescontos(double salario) {
        double descontoTotal = 0;

        for (DescontoItem descontoItem : descontos) {
            descontoTotal += descontoItem.getValorPerc();
        }

        double desconto = salario * descontoTotal;

        return desconto;
    }
}
