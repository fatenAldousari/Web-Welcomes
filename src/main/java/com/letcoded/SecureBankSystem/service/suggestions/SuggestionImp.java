package com.letcoded.SecureBankSystem.service.suggestions;

import com.letcoded.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcoded.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcoded.SecureBankSystem.repository.GuestReository;
import com.letcoded.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionImp implements SuggestionService{
    private final GuestReository suggestionRepository ;

    public SuggestionImp(GuestReository guestReository, GuestReository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;

    }
    public List<GuestSuggestionEntity> findAllDataSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    public List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText) {
        return suggestionRepository.findAll();

    }
    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.CREATE);
    }
    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.REMOVE);
    }



    @Override
    public void getSuggestionRate() {

    }

    @Override
    public List<GuestSuggestionEntity> getCreateStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.CREATE))
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestSuggestionEntity> getRemoveStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.REMOVE))
                .collect(Collectors.toList());
    }

    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
    }
}

