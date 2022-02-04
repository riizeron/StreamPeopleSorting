package streampeoplesorting.utils;

import streampeoplesorting.annotations.Command;
import streampeoplesorting.controllers.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class CommandDispatcher {
    public final Controller controller;
    private boolean keepGoing;

    public CommandDispatcher(Controller controller) {
        this.controller = controller;
        keepGoing = true;
    }

    public void executeCommand(String commandLine) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String command;
        String params;
        if(commandLine.indexOf(' ') == -1) {
            command = commandLine;
            params = null;
        } else {
            command = commandLine.substring(0, commandLine.indexOf(' '));
            params = commandLine.substring(commandLine.indexOf(' ') + 1);
        }
        if (command.equals("/help")) {
            help();
        } else if (command.equals("/exit")) {
            exit();
        } else {
            Method method = getAnnotatedMethod(command);
            if (method == null) {
                throw new NoSuchMethodException("There is no method like this");
            } else if (params == null) {
                method.invoke(controller);
            } else {
                method.invoke(controller, params);
            }
        }
    }

    private Method getAnnotatedMethod(String command) {
        for (Method method : controller.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                if (Objects.equals(method.getAnnotation(Command.class).value(), command)) {
                    method.setAccessible(true);
                    return method;
                }
            }
        }
        return null;
    }

    private void help() {
        System.out.println("""
                Commands:
                /help - command list
                /add <lastname> <firstname> <age> - add person to group
                /rm <lastname> <firstname> <age> - remove person from group
                /show - print list of group
                /sort - sorting group
                /exit - exit""");
    }

    private void exit() {
        keepGoing = false;
        System.out.println("...exit...");
    }

    public boolean getSt() {
        return keepGoing;
    }
}
