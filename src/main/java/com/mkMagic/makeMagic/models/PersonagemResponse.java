package com.mkMagic.makeMagic.models;

public class PersonagemResponse {
    private String name;
    private String role;
    private String school;
    private String house;
    private String patronus;

    public PersonagemResponse(Personagem personagem) {
        this.name = personagem.getName();
        this.role = personagem.getRole();
        this.school = personagem.getSchool();
        this.house = personagem.getHouse();
        this.patronus = personagem.getPatronus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }
}
