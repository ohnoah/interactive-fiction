package com.intfic.nlp;

import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import java.util.List;
import java.util.Set;

public abstract class NLPEngine {
  /*public abstract InstantiatedGameAction parse(String rawCommand, List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException;*/
}


// Examine, Push, Take, Pull Drop, Turn, Open, Feel, PUT __ IN __, PUT __ on __