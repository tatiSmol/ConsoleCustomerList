import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String addCommand = "add Василий Петров vasily.petrov@gmail.com +79215637722";
    private static final String commandExamples = "\t" + addCommand + "\n" + "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String commandError = "Wrong command! Available command examples: \n" + commandExamples;
    private static final String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        String command = "";

        while (true) {
            try {
                command = scanner.nextLine();
                logger.info("Ввод от пользователя: " + command);
                if (command.equals("exit")) {
                    break;
                }
                String[] tokens = command.split("\\s+", 2);
                switch (tokens[0]) {
                    case "add" -> executor.addCustomer(tokens[1]);
                    case "list" -> executor.listCustomers();
                    case "remove" -> executor.removeCustomer(tokens[1]);
                    case "count" -> System.out.println("There are " + executor.getCount() + " customers");
                    case "help" -> System.out.println(helpText);
                    default -> System.out.println(commandError);
                }
            } catch (IllegalArgumentException ex) {
                logger.error(ex.getMessage().split("\n")[0].split("\\.")[0] + ": " + command);
                System.out.println(ex.getMessage());
            }
        }
    }
}
