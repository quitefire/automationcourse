package com.courses.week1;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Implement collections logic as described using:
 * 1 ) declarative approach (Java8);
 * 2 ) imperative approach ( pre-Java-8 : Stream API)
 */
public class CollectionsTask {

    static class Student {
        private String name;
        private List<String> languages;
        private String language;

        Student(String name, List<String> languages) {
            this.name = name;
            this.languages = languages;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", language='" + language + '\'' +
                    '}';
        }
    }

    // Data example
    static final List<Student> students = Arrays.asList(
            new Student("Doug Lea", Arrays.asList("Java", "C#", "JavaScript")),
            new Student("Bjarne Stroustrup", Arrays.asList("C", "C++", "Java")),
            new Student("Martin Odersky", Arrays.asList("Java", "Scala", "Smalltalk"))
    );

    /**
     * Given list of students group them by language.
     */
    public static Map<String, List<Student>> getStudentsByLanguage(List<Student> students) {
        return null;
    }

    /**
     * Given list of students with languages, return list of unique languages.
     */
    public static List<String> getAllLanguages(List<Student> students) {
        return null;
    }

    public static Map<String, Long> getNumberOfStudentByLanguage(List<Student> students) {
        return null;
    }

    /**
     * Given list of students, remove duplicates by name.
     */
    public static List<Student> removeDuplicates(List<Student> students) {
        return null;
    }
}