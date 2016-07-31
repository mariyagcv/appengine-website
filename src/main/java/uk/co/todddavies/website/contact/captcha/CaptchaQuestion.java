package uk.co.todddavies.website.contact.captcha;


public final class CaptchaQuestion {

  static CaptchaQuestion create(String question, String answer) {
    return new CaptchaQuestion(question, answer.toLowerCase());
  }
  
  private final String question, answer;
  
  private CaptchaQuestion(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }
  
  public String getQuestion() {
    return question;
  }
  
  public String encryptSecret(String secret) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < secret.length(); i++) {
      output.append(i == 0 ? "" : "-");
      int encryptedChar = answer.charAt(i % answer.length()) ^ secret.charAt(i);
      output.append(encryptedChar);
      output.append(encryptedChar < 100 ? encryptedChar < 10 ? "XX" : "X" : "");
    }
    return output.toString();
  }
}
