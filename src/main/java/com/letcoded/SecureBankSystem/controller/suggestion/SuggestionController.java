package com.letcoded.SecureBankSystem.controller.suggestion;

import com.letcoded.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcoded.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcoded.SecureBankSystem.service.suggestions.SuggestionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    private final SuggestionImp suggestionService;

    @Autowired
    public SuggestionController(SuggestionImp suggestionService) {
        this.suggestionService = suggestionService;
    }
    @PostMapping("/suggest")
    public ResponseEntity<List<GuestSuggestionEntity>> handleSuggestions(@RequestBody CreateSuggestionRequest suggestionRequest) {
        List<GuestSuggestionEntity> suggestionList = suggestionService.printAndProcessSuggestion(suggestionRequest.getSuggestionText());
        return ResponseEntity.ok(suggestionList);
    }
    @PostMapping("/creat-suggestion")
    public ResponseEntity<String> processSuggestion(CreateSuggestionRequest suggestionTex){
        suggestionService.processSuggestion(suggestionTex);
        return ResponseEntity.ok("bravo you create a suggestion");
    }
}
