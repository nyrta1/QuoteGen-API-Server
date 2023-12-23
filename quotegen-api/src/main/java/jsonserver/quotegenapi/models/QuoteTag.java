package jsonserver.quotegenapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class QuoteTag {
    @Id
    private Long id;
    private String tagName;
}
