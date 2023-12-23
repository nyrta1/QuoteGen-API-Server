package jsonserver.quotegenapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class QuoteContent {
    @Id
    private Long id;
    private String author;
    private String content;
    private List<String> tags;
    private Date dateAdded;
    private Date dateModified;
}
