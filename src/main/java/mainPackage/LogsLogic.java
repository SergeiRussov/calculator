package mainPackage;

import java.util.Date;

public class LogsLogic {
    public static void addArithmeticLogs(Calculations calc) {
        Logs.logs.add("[" + new Date() + "]" + " " + "operation: " + calc.getOperation() + ", x: " + calc.getX() +
                ", y: " + calc.getY() + ", answer: " + calc.getAnswer());
    }

    public static void addNumberSystemLogs(Calculations calc) {
        Logs.logs.add("[" + new Date() + "]" + " " + "operation: " + calc.getOperation() + ", base number 10: " +
                calc.getDec() + ", base number 2: " + calc.getBin() + ", base number 8: " + calc.getOct() +
                    ", base number 16: " + calc.getHex());
    }

    public static void addSaveLogs(Calculations calc) {
        Logs.logs.add("[" + new Date() + "]" + " Save " + calc.getOperation() + " file");
    }

    public static void addDownloadLogs(Calculations calc) {
        Logs.logs.add("[" + new Date() + "]" + " Download " + calc.getOperation() + " file");
    }

    public static void showLogs() {
        for (int i = 0; i < Logs.logs.size(); i++) {
            System.out.println(Logs.logs.get(i));
        }
    }
}
