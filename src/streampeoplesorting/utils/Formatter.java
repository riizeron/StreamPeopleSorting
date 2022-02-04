package streampeoplesorting.utils;

import streampeoplesorting.models.Person;

import java.util.List;

public class Formatter {

    private static  Triplet<String, String, Byte> format(String str) {
        List<String> params = List.of(str.split("\\s+"));
        int age;
        if (params.size() < 3) {
            throw new IllegalArgumentException("Incorrect input data format");
        } else if (!tryParseByte(params.get(2))) {
            throw new NumberFormatException("Incorrect age format");
        } else {
            return new Triplet<>(params.get(0), params.get(1),
                    Byte.parseByte(params.get(2)));
        }
    }

    static boolean tryParseByte(String value) {
        try {
            Byte.parseByte(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Person getPerson(String str) {
        Triplet<String, String, Byte>  data = format(str);
        return new Person(data.first(), data.second(), data.third());
    }

}
