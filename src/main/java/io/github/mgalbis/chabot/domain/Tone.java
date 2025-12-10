package io.github.mgalbis.chabot.domain;


public enum Tone {

    FORMAL("formal, profesional, claro y respetuoso", 0.2),
    INFORMAL("informal, cercano y coloquial, pero correcto", 0.7),
    AMABLE("amable, empático y cordial", 0.4),
    ASERTIVO("asertivo, directo y firme pero educado", 0.3),
    ENTUSIASTA("entusiasta, positivo y motivador", 0.7),
    NEUTRO("neutro, objetivo y sobrio", null);

    private String description;
    private Double temperature;

    Tone(String description, Double temperature) {
        this.description = description;
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public Double getTemperature() {
        return temperature;
    }
}
