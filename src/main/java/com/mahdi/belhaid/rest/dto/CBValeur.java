package com.mahdi.belhaid.rest.dto;

import java.util.Objects;

public class CBValeur {

    private String codeFlux;
    private String typeCompte;
    private String bic;
    private String iban;

    public String getCodeFlux() {
        return codeFlux;
    }

    public void setCodeFlux(String codeFlux) {
        this.codeFlux = codeFlux;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CBValeur)) return false;

        CBValeur cbValeur = (CBValeur) o;

        if (!Objects.equals(codeFlux, cbValeur.codeFlux)) return false;
        if (!Objects.equals(typeCompte, cbValeur.typeCompte)) return false;
        if (!Objects.equals(bic, cbValeur.bic)) return false;
        return Objects.equals(iban, cbValeur.iban);
    }

    @Override
    public int hashCode() {
        int result = codeFlux != null ? codeFlux.hashCode() : 0;
        result = 31 * result + (typeCompte != null ? typeCompte.hashCode() : 0);
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CBValeur{" +
                "codeFlux='" + codeFlux + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                ", bic='" + bic + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
