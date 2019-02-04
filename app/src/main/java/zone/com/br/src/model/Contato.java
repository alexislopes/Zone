package zone.com.br.src.model;

import java.util.List;

public class Contato {

    private String email;
    private List<Long> telefones;

    public Contato() {
    }

    public Contato(String email, List<Long> telefones) {
        this.email = email;
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "email='" + email + '\'' +
                ", telefones=" + telefones +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Long> telefones) {
        this.telefones = telefones;
    }
}