package com.letcoded.SecureBankSystem.service.suggestions;

import com.letcoded.SecureBankSystem.entity.GuestSuggestionEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SuggestionService {
    void getSuggestionRate ();
    List<GuestSuggestionEntity> getCreateStatusSuggestions();
    List<GuestSuggestionEntity> getRemoveStatusSuggestions();
}
