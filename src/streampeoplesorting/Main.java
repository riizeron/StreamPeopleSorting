package streampeoplesorting;

import streampeoplesorting.controllers.Controller;
import streampeoplesorting.models.Group;
import streampeoplesorting.utils.CommandDispatcher;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("""
                Hi there!
                This is my people sorting prog!
                Type /help to get commands""");

        Group group = new Group();
        CommandDispatcher cd = new CommandDispatcher(new Controller(group));
        String command;
        while(cd.getSt()) {
            System.out.print(">");
            command = scanner.nextLine();
            try {
                cd.executeCommand(command);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
