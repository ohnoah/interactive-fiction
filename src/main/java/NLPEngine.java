import java.util.List;
import net.sf.extjwnl.JWNLException;

public abstract class NLPEngine {
  public abstract ConcreteGameAction parse(String rawCommand, List<ActionFormat> possibleActionFormats, List<String> possibleItemNames) throws FailedParseException;
}


// Examine, Push, Take, Pull Drop, Turn, Open, Feel, PUT __ IN __, PUT __ on __