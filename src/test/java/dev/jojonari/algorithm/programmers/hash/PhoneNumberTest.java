package dev.jojonari.algorithm.programmers.hash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PhoneNumberTest {

    @Test
    void 전화번호가_모두_다르다() {
        //given
        var sut = new PhoneNumber();
        String[] phoneBook = {"123", "456", "789"};

        //when
        boolean actual = sut.solution(phoneBook);

        //then
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    void 전화번호_중_접두어로_사용된_번호가_있다(String[] phoneBook) {
        //given
        var sut = new PhoneNumber();

        //when
        boolean actual = sut.solution(phoneBook);

        //then
        assertFalse(actual);
    }

    /**
     * testArguments
     *
     * @return Stream<Arguments>
     */
    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of((Object) new String[]{"119", "97674223", "1195524421"}),
                Arguments.of((Object) new String[]{"12", "123", "1235", "567", "88"})
        );
    }
}