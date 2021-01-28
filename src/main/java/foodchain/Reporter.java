package foodchain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type Reporter.
 */
public class Reporter {
    private static Reporter reporter;
    private static String partiesReport = "Parties Reports:\n\n";
    private static String foodChainReport = "FoodChain Reports:\n\n";
    private static String securityReport = "Security Reports:\n\n";
    private static String transactionReport = "Transaction Reports:\n\n";

    private Reporter() {
    }

    /**
     * Gets reporter.
     *
     * @return the reporter
     */
    public static Reporter getReporter() {
        if (reporter == null) {
            reporter = new Reporter();
        }
        return reporter;
    }

    /**
     * Adds parties report.
     *
     * @param info the info
     */
    public void addPartiesReport(String info) {
        partiesReport += "Parties Report: " + info + "\n\n";
    }

    /**
     * Adds food chain report.
     *
     * @param info the info
     */
    public void addFoodChainReport(String info) {
        foodChainReport += "FoodChain Report: " + info + "\n";
    }

    /**
     * Adds security report.
     *
     * @param info the info
     */
    public void addSecurityReport(String info) {
        securityReport += "Security Report: " + info + "\n\n";
    }

    /**
     * Adds transaction report.
     *
     * @param info the info
     */
    public void addTransactionReport(String info) {
        transactionReport += "Transaction Report: " + info + "\n\n";
    }

    /**
     * Change Path!!!
     * Shows parties report.
     * Write all report to PartiesReports.txt
     */
    public void showPartiesReport() {
        try {
            Files.deleteIfExists(Path.of("C:\\Users\\User\\IdeaProjects\\new-omo-foodchain\\PartiesReports.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter partiesReportsWriter = new FileWriter("PartiesReports.txt", true)) {
            partiesReportsWriter.write(partiesReport);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader partiesReportsReader = new FileReader("PartiesReports.txt")) {
            int c;
            while ((c = partiesReportsReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Change Path!!!
     * Shows food chain report.
     * Write all report to FoodChainReports.txt
     */
    public void showFoodChainReport() {
        try {
            Files.deleteIfExists(Path.of("C:\\Users\\User\\IdeaProjects\\new-omo-foodchain\\FoodChainReports.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter foodChainReportsWriter = new FileWriter("FoodChainReports.txt", true)) {
            foodChainReportsWriter.write(foodChainReport);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader foodChainReportsReader = new FileReader("FoodChainReports.txt")) {
            int c;
            while ((c = foodChainReportsReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Change Path!!!
     * Shows security report.
     * Write all report to SecurityReports.txt
     */
    public void showSecurityReport() {
        try {
            Files.deleteIfExists(Path.of("C:\\Users\\User\\IdeaProjects\\new-omo-foodchain\\SecurityReports.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter securityReportsWriter = new FileWriter("SecurityReports.txt", true)) {
            securityReportsWriter.write(securityReport);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader securityReportsReader = new FileReader("SecurityReports.txt")) {
            int c;
            while ((c = securityReportsReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Change Path!!!
     * Shows transaction report.
     * Write all report to TransactionReports.txt
     */
    public void showTransactionReport() {
        try {
            Files.deleteIfExists(Path.of("C:\\Users\\User\\IdeaProjects\\new-omo-foodchain\\TransactionReports.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter transactionReportsWriter = new FileWriter("TransactionReports.txt", true)) {
            transactionReportsWriter.write(transactionReport);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileReader transactionReportsReader = new FileReader("TransactionReports.txt")) {
            int c;
            while ((c = transactionReportsReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
