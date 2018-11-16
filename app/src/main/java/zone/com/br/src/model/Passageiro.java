package zone.com.br.src.model;

public class Passageiro extends Usuario {
    private Double mensalidade;

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
