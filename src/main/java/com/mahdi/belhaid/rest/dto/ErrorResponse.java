package com.mahdi.belhaid.rest.dto;


public class ErrorResponse {

    private String code;
    private String libelle;
    private String description;

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
