package jsonserver.quotegenapi.models;

import lombok.Data;

@Data
public class QuoteTagsMapping {
    private Long quoteId;
    private Long tagId;
}
