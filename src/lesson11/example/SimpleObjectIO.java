package lesson11.example;

import java.io.*;
import java.util.List;

public class SimpleObjectIO {

    public static void main(String[] args) throws Exception {
        writeToFile("output.dat");
        readFromFile("output.dat");

    }

    public static void readFromFile(String file) throws Exception {
        try
                (
                        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))

                        ) {
            Person person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);

            person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);

            person = (Person) ois.readObject();
            System.out.println(person.name + " " + person.surname);
        }
    }

    public static void writeToFile(String file) throws Exception {
        try
                (
                        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))

                        ) {
            out.writeObject(new Person("Inna", "Popova"));
            out.writeObject(new Person("Donny", "Novakov"));
            out.writeObject(new Person("Alex", "Sidorenko"));

        }
    }

    static class Person implements Serializable {

//        private static final long serialVersionUID =
        private String name;
        private String surname;

        private transient List<Integer> list;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }
}
