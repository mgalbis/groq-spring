package io.github.mgalbis.chabot.api;


import io.github.mgalbis.chabot.api.dto.RewriteRequest;
import io.github.mgalbis.chabot.api.dto.RewriteResponse;
import io.github.mgalbis.chabot.domain.ToneEditorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/editor")
public class ToneEditorController {

    private final ToneEditorService toneEditorService;

    public ToneEditorController(ToneEditorService toneEditorService) {
        this.toneEditorService = toneEditorService;
    }

    @PostMapping(
            path = "/rewrite",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RewriteResponse rewrite(@RequestBody RewriteRequest request) {

        String rewritten = toneEditorService.rewriteKeepingMeaning(
                request.getText(),
                request.getTone(),
                request.getTemperature(),
                request.getTopP()
        );

        return new RewriteResponse(rewritten);
    }

}
