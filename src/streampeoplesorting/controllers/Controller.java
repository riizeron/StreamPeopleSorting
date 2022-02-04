package streampeoplesorting.controllers;

import streampeoplesorting.annotations.Command;
import streampeoplesorting.models.Group;
import streampeoplesorting.models.Person;

public class Controller {
    private final Group gr;
    public Controller(Group ps) {
        this.gr = ps;
    }

    @Command("/add")
    void add(String str) {
        gr.add(str);
    }

    @Command("/rm")
    void remove(String str) {
        gr.remove(str);
    }

    @Command("/sort")
    void Sort() {
        gr.sort();
    }

    @Command("/show")
    void Show() {
        gr.show();
    }
}
