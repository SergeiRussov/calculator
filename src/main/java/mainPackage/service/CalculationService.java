package mainPackage.service;

import mainPackage.entity.CalculationEntity;

public class CalculationService {

    public double toAdd(CalculationEntity calc) {
        return calc.getX() + calc.getY();
    }

    public double toSubstract(CalculationEntity calc) {
        return calc.getX() - calc.getY();
    }

    public double toMultiply(CalculationEntity calc) {
        return calc.getX() * calc.getY();
    }

    public double toSplit(CalculationEntity calc) {
        return calc.getX() / calc.getY();
    }

    public double calculatePercentage(CalculationEntity calc) {
        return calc.getX() / 100 * calc.getY();
    }

    public void convertToOtherNumberSystem(CalculationEntity calc) {
        calc.setBin(Long.parseLong(Long.toBinaryString(calc.getDec())));
        calc.setOct(Integer.parseInt(Integer.toOctalString(calc.getDec())));
        calc.setHex(Integer.toHexString(calc.getDec()));
    }
}
