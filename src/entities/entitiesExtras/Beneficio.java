package entities.entitiesExtras;

import java.util.ArrayList;
import java.util.List;

public class Beneficio {
    private List<BeneficioItem> beneficios;

    public Beneficio() {
        beneficios = new ArrayList<>();
    }

    public boolean adicionarBeneficio(BeneficioItem beneficioItem){
        if (!beneficios.contains(beneficioItem)){
            beneficios.add(beneficioItem);
            return true;
        }
        return false;
    }

    public BeneficioItem buscarBeneficioItem(String nomeBeneficio) {
        for (BeneficioItem beneficioItem : beneficios) {
            if (beneficioItem.getName().equalsIgnoreCase(nomeBeneficio)) {
                return beneficioItem;
            }
        }
        return null;
    }

    public boolean removerBeneficio(String nomeBeneficio){
        if (beneficios.contains(buscarBeneficioItem(nomeBeneficio))){
            beneficios.remove(buscarBeneficioItem(nomeBeneficio));
            return true;
        }
        return false;
    }
    public double calcularBeneficios(){
        double total = 0;
        for (BeneficioItem beneficioItem : beneficios){
            total += beneficioItem.getValor();
        }
        return total;
    }

    public void adicionarPadroes(){
        BeneficioItem planoDeSaude = new BeneficioItem("Plano de Saude", 500);
        BeneficioItem valeTransporte = new BeneficioItem("Vale Transporte", 200);
        beneficios.add(planoDeSaude);
        beneficios.add(valeTransporte);
    }

    @Override
    public String toString() {
        return "Beneficio{" +
                "beneficio=" + beneficios +
                '}';
    }
}
