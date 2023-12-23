package jsonserver.quotegenapi.controllers;

import jsonserver.quotegenapi.models.QuoteContent;
import jsonserver.quotegenapi.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSONController {
    private final QuoteService quoteService;

    @Autowired
    public JSONController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public ResponseEntity<QuoteContent> get() {
        return new ResponseEntity<>(quoteService.get(), HttpStatus.OK);
    }
}
