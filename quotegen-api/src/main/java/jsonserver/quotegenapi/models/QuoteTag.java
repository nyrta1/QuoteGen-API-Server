package jsonserver.quotegenapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


public class QuoteTag {
    @Id
    private Long id;
    private String type;
}
