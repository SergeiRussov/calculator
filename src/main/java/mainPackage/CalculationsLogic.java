package mainPackage;

public class CalculationsLogic {

    public double toAdd(Calculations calc) {
        return calc.getX() + calc.getY();
    }

    public double toSubstract(Calculations calc) {
        return calc.getX() - calc.getY();
    }

    public double toMultiply(Calculations calc) {
        return calc.getX() * calc.getY();
    }

    public double toSplit(Calculations calc) {
        return calc.getX() / calc.getY();
    }

    public double calculatePercentage(Calculations calc) {
        return calc.getX() / 100 * calc.getY();
    }
}
