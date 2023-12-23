package jsonserver.quotegenapi.services.impl;

import jsonserver.quotegenapi.database.repository.QuoteContentRepository;
import jsonserver.quotegenapi.models.QuoteContent;
import jsonserver.quotegenapi.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final QuoteContentRepository quoteContentRepository;

    @Autowired
    public QuoteServiceImpl(QuoteContentRepository quoteContentRepository) {
        this.quoteContentRepository = quoteContentRepository;
    }

    @Override
    public QuoteContent get() {
        Optional<QuoteContent> quoteContent = quoteContentRepository.findById(1L);
        return quoteContent.orElse(null);
    }
}
