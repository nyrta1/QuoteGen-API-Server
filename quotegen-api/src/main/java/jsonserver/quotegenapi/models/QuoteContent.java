package jsonserver.quotegenapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Set;

public class QuoteContent {
    @Id
    private Long id;

    private String author;
    private String content;
    private Set<QuoteTagRef> tags = new HashSet<>();
}
