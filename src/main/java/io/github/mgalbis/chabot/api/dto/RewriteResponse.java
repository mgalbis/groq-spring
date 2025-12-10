package io.github.mgalbis.chabot.api.dto;


public class RewriteResponse {

    private String rewrittenText;

    public RewriteResponse(String rewrittenText) {
        this.rewrittenText = rewrittenText;
    }

    public String getRewrittenText() {
        return rewrittenText;
    }

    public void setRewrittenText(String rewrittenText) {
        this.rewrittenText = rewrittenText;
    }

}
