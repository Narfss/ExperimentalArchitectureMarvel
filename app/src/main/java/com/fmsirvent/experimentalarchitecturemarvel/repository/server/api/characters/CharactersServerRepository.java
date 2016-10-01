package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.characters;

import com.fmsirvent.experimentalarchitecturemarvel.logic.characters.MarvelCharacter;
import com.fmsirvent.experimentalarchitecturemarvel.repository.exceptions.RepositoryException;
import com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result.Data;

public interface CharactersServerRepository {
    Data<MarvelCharacter> getCharacters(int offset) throws RepositoryException;
}