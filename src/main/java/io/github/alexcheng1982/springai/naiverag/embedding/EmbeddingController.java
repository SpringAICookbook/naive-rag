package io.github.alexcheng1982.springai.naiverag.embedding;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmbeddingController {
  private final EmbeddingModel embeddingModel;

  public EmbeddingController(EmbeddingModel embeddingModel) {
    this.embeddingModel = embeddingModel;
  }

  @PostMapping("/embed")
  public EmbeddingResponse embed(@RequestBody EmbeddingRequest request) {
    return new EmbeddingResponse(embeddingModel.embed(request.content()));
  }
}
