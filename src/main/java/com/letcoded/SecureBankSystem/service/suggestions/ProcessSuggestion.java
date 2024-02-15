package com.letcoded.SecureBankSystem.service.suggestions;

import com.letcoded.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;

public interface ProcessSuggestion {
    void processSuggestion(CreateSuggestionRequest suggestionTex);
}

