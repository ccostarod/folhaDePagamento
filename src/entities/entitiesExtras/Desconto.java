package entities.entitiesExtras;

import sun.security.krb5.internal.crypto.Des;

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
    public void adicionarPadroes(){
        DescontoItem inss = new DescontoItem("INSS", 0.11);
        DescontoItem ir = new DescontoItem("IR", 0.15);
        descontos.add(inss);
        descontos.add(ir);
    }
    public DescontoItem buscarDescontoItem(String nomeDesconto) {
        for (DescontoItem descontoItem : descontos) {
            if (descontoItem.getName().equalsIgnoreCase(nomeDesconto)) {
                return descontoItem;
            }
        }
        return null;
    }

    public boolean removerDesconto(String nomeDesconto){
        if(descontos.contains(buscarDescontoItem(nomeDesconto))){
            descontos.remove(buscarDescontoItem(nomeDesconto));
            return true;
        }
        return false;
    }

    public double descontoTotal(){
        double descontoSoma = 0;
        for (DescontoItem descontoItem : descontos){
            descontoSoma += descontoItem.getValorPerc();
        }
        return descontoSoma;
    }

    public double calcularDescontos(double salario) {
        double descontoTotal = descontoTotal();
        return salario * descontoTotal;
    }

    @Override
    public String toString() {
        return "Desconto{" +
                "descontos=" + descontos +
                '}';
    }
}
