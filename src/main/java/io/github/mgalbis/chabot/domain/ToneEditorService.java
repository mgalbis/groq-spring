package io.github.mgalbis.chabot.domain;


public interface ToneEditorService {

    String rewriteKeepingMeaning(
            String originalText,
            Tone tone,
            Double temperature,
            Double topP
    );

}
