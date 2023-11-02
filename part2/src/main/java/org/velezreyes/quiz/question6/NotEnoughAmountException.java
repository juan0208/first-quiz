package org.velezreyes.quiz.question6;

public class NotEnoughAmountException extends Exception {

  public NotEnoughAmountException() {
    super("Not enough money inserted.");
  }
  
}
