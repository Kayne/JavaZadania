import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Klasa obsługująca rejestrator
* @author kayne
**/
class Rzym2ArabLogger {
  private final static Logger logger = Logger.getLogger(Rzym2ArabLogger.class.getName());

  /**
  * Konstruktor klasy
  **/
  public Rzym2ArabLogger() {
    logger.setLevel(Level.FINEST);
  }

  /**
  * Wpis o poziomie INFO
  **/
  public void writeInfo(String s) {
    logger.info(s);
  }

  /**
  * Wpis o poziomie SEVERE
  **/
  public void writeSevere(String s) {
    logger.severe(s);
  }

  /**
  * Wpis o poziomie WARNING
  **/
  public void writeWarning(String s) {
    logger.warning(s);
  }
}