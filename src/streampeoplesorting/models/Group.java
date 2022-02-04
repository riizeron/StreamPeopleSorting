package streampeoplesorting.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import streampeoplesorting.utils.Formatter;

public class Group {
    private List<Person> group;
    public Group() {
        group = new ArrayList<>();
    }
    public void sort() {
        group = group.stream()
                .sorted(Comparator.comparing(Person::getLastname)
                        .thenComparing(Person::getFirstname)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("Group was sorted");
    }

    public void add(String str) {
        group.add(Formatter.getPerson(str));
        System.out.println("You currently added " + str + " to the group" );
    }

    public void remove(String str) {
        group.remove(Formatter.getPerson(str));
        System.out.println("You currently remove " + str + " from the group" );
    }

    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Group {" + System.lineSeparator());
        for (Person person:
             group) {
            out.append("\t").append(person).append(System.lineSeparator());
        }
        out.append('}');
        return out.toString();
    }
}
