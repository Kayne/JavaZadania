import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
* Mój rejestrator
**/
public class MyLogger {
  static private FileHandler fileTxt;

  /**
  * Konfiguruje rejestrator
  **/
  static public void setup() throws IOException {
    Logger logger = Logger.getLogger("");
    logger.setLevel(Level.FINEST);
    fileTxt = new FileHandler("Logging.txt");
    fileTxt.setFormatter(new SimpleFormatter());
    logger.addHandler(fileTxt);
  }
} 