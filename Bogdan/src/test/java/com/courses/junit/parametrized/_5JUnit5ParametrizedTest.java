package com.courses.junit.parametrized;

import com.courses.week3.hotlinev1.enums.PriceRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class _5JUnit5ParametrizedTest {

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = {"Hello", "JUnit"})
    void withValueSource(String word) {
    }

    @DisplayName("Roman numeral")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"I, 1", "II, 2", "V, 5"})
    void withNiceName(String word, int number) {
    }


    @ParameterizedTest
    @EnumSource(PriceRange.class)
    void withAllEnumValues(PriceRange range) {
        Assertions.assertTrue(range.getMaxPrice() < 100_000);
    }

    @ParameterizedTest
    @EnumSource(
            value = TimeUnit.class,
            names = {"NANOSECONDS", "MICROSECONDS"})
    void withSomeEnumValues(TimeUnit unit) {
        // executed once for TimeUnit.NANOSECONDS
        // and once for TimeUnit.MICROSECONDS
    }


    @ParameterizedTest
    @MethodSource(names = "createWordsWithLength")
    void withMethodSource(String word, int length) {
        Assertions.assertEquals(length, word.length());
    }

    private static Stream<Arguments> createWordsWithLength() {
        return Stream.of(
                ObjectArrayArguments.create("word", 4),
                ObjectArrayArguments.create("new", 3));
    }
}
