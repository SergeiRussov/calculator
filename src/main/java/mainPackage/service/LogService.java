package mainPackage.service;

import mainPackage.entity.CalculationEntity;
import mainPackage.entity.Logs;

import java.util.Date;

public class LogService {
    public static void addArithmeticLogs(CalculationEntity calc) {
        Logs.logs.add("[" + new Date() + "]" + " " + "operation: " + calc.getOperation() + ", x: " + calc.getX() +
                ", y: " + calc.getY() + ", answer: " + calc.getAnswer());
    }

    public static void addNumberSystemLogs(CalculationEntity calc) {
        Logs.logs.add("[" + new Date() + "]" + " " + "operation: " + calc.getOperation() + ", base number 10: " +
                calc.getDec() + ", base number 2: " + calc.getBin() + ", base number 8: " + calc.getOct() +
                ", base number 16: " + calc.getHex());
    }

    public static void addSaveLogs(CalculationEntity calc) {
        Logs.logs.add("[" + new Date() + "]" + " Save " + calc.getOperation() + " file");
    }

    public static void addDownloadLogs(CalculationEntity calc) {
        Logs.logs.add("[" + new Date() + "]" + " Download " + calc.getOperation() + " file");
    }

    public static String showLogs() {
        String logs = "";

        for (int i = 0; i < Logs.logs.size(); i++) {
            logs = logs + Logs.logs.get(i) + "\n";
        }

        return logs;
    }
}
