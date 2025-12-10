package io.github.mgalbis.chabot.infrastructure;


import io.github.mgalbis.chabot.domain.Tone;
import io.github.mgalbis.chabot.domain.ToneEditorService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;


@Service
public class ToneEditorServiceImpl implements ToneEditorService {

    private final ChatClient chatClient;

    public ToneEditorServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String rewriteKeepingMeaning(String originalText,
                                        Tone tone,
                                        Double temperature,
                                        Double topP) {

        double temp = (temperature != null) ? temperature : tone.getTemperature();
        double tp = (topP != null) ? topP : 0.9;

        String prompt = buildPrompt(originalText, tone);

        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .temperature(temp)
                .topP(tp)
                .build();

        return chatClient
                .prompt()
                .options(options)
                .user(prompt)
                .call()
                .content();
    }

    private String buildPrompt(String originalText, Tone tone) {
        return """
                Reescribe el siguiente texto manteniendo su significado central,
                pero ajustando el tono indicado y variando la expresión lingüística
                en función del nivel de creatividad solicitado.
                
                Instrucciones:
                - No elimines información importante.
                - No añadas nuevos datos no presentes en el texto.
                - NO devuelvas explicaciones: solo el texto reescrito, sin comentarios ni explicaciones ni entrecomillado.
                
                Texto original:
                ```
                %s
                ```
                
                Tono deseado: %s
            """.formatted(tone.getDescription(), originalText);
    }

}
