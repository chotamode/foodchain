package foodchain;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reporter {
    private static Reporter reporter;
    private static String partiesReport = "Parties Reports:\n\n";
    private static String foodChainReport = "FoodChain Reports:\n\n";
    private static String securityReport = "Security Reports:\n\n";
    private static String transactionReport = "Transaction Reports:\n\n";

    private Reporter() {
    }

    public static Reporter getReporter() {
        if (reporter == null) {
            reporter = new Reporter();
        }
        return reporter;
    }

    public void addPartiesReport(String info) {
        partiesReport += "Parties Report: " + info + "\n\n";
    }

    public void addFoodChainReport(String info) {
        foodChainReport += "FoodChain Report: " + info + "\n";
    }

    public void addSecurityReport(String info) {
        securityReport += "Security Report: " + info + "\n\n";
    }

    public void addTransactionReport(String info) {
        transactionReport += "Transaction Report: " + info + "\n\n";
    }

    public void showPartiesReport() {
//        System.out.println(partiesReport);
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

    public void showFoodChainReport() {
//        System.out.println(foodChainReport);
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

    public void showSecurityReport() {
//        System.out.println(securityReport);
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

    public void showTransactionReport() {
//        System.out.println(transactionReport);
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