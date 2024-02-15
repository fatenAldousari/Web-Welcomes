package com.letcoded.SecureBankSystem.controller.suggestion;

import com.letcoded.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcoded.SecureBankSystem.service.suggestions.SuggestionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestions_Status")
public class SuggestionStatusController {
    private final SuggestionImp suggestionService;
    @Autowired
    public SuggestionStatusController(SuggestionImp suggestionService) {
        this.suggestionService = suggestionService;
    }
    @GetMapping("/retrieve")
    public List<GuestSuggestionEntity> getAllDistinctSuggestions() {
        return suggestionService.findAllDataSuggestions();
    }
    @GetMapping("/created")
    public List<GuestSuggestionEntity> getCreatedSuggestions() {

        return suggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/removed")
    public List<GuestSuggestionEntity> getRemovedSuggestions() {

        return suggestionService.findAllRemovedSuggestions();
    }
}
