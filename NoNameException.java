
public class NoNameException extends Exception {
  public NoNameException() {
    super("Error: No Last name was entered!");
  }
  public NoNameException(String errorMessage) {
  super(errorMessage);
  }
}