package jsonserver.quotegenapi.database.repository;

import jsonserver.quotegenapi.models.QuoteContent;

import java.util.Optional;

public interface QuoteContentRepository {
    Optional<QuoteContent> findById(Long id);
}
