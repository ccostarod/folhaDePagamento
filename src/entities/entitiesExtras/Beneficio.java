package entities.entitiesExtras;

import java.util.ArrayList;
import java.util.List;

public class Beneficio {
    private List<BeneficioItem> beneficio;

    public Beneficio() {
        beneficio = new ArrayList<>();
    }

    public boolean adicionarBeneficio(BeneficioItem beneficioItem){
        if (!beneficio.contains(beneficioItem)){
            beneficio.add(beneficioItem);
            return true;
        }
        return false;
    }

    public boolean removerBeneficio(BeneficioItem beneficioItem){
        if (beneficio.contains(beneficioItem)){
            beneficio.remove(beneficioItem);
            return true;
        }
        return false;
    }
    public double pegarBeneficios(){
        double total = 0;
        for (BeneficioItem beneficioItem : beneficio){
            total += beneficioItem.getValor();
        }
        return total;
    }


}
