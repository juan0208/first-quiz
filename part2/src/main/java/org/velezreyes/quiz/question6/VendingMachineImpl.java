package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine{

  private static VendingMachineImpl instance;
  private int currentAmount = 0;

  private VendingMachineImpl() {
  }

  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }
  @Override
  public void insertQuarter() {
    currentAmount += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughAmountException, UnknownDrinkException {
    if (currentAmount == 0) throw new NotEnoughAmountException();

    DrinkImpl drink;
    if (name.equals("ScottCola")) {
      drink = new DrinkImpl("ScottCola", true, 75);
    }
    else if (name.equals("KarenTea")) {
      drink = new DrinkImpl("KarenTea", false, 100);
    }
    else {
      throw new UnknownDrinkException();
    }

    if (currentAmount != drink.getCost()) {
      throw new NotEnoughAmountException();
    }

    currentAmount = 0;

    return drink;
  }
}
