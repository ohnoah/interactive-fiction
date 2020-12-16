import java.util.List;

public abstract class NLPEngine {
  public abstract InstantiatedGameAction parse(String rawCommand, List<ActionFormat> possibleActionFormats, List<String> possibleItemNames) throws FailedParseException;
}


// Examine, Push, Take, Pull Drop, Turn, Open, Feel, PUT __ IN __, PUT __ on __