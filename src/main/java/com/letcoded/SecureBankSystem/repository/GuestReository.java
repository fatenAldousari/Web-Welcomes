package com.letcoded.SecureBankSystem.repository;

import com.letcoded.SecureBankSystem.entity.GuestSuggestionEntity;
import com.letcoded.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestReository extends JpaRepository<GuestSuggestionEntity,Long> {
    List<GuestSuggestionEntity> findBySuggestionsStatus(SuggestionsStatus status);
}
