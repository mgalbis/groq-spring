package io.github.mgalbis.chabot.api.dto;


import io.github.mgalbis.chabot.domain.Tone;


public class RewriteRequest {

    private String text;
    private Tone tone;
    private Double temperature; // opcional
    private Double topP;        // opcional

    // getters y setters

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Tone getTone() { return tone; }
    public void setTone(Tone tone) { this.tone = tone; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getTopP() { return topP; }
    public void setTopP(Double topP) { this.topP = topP; }

}
