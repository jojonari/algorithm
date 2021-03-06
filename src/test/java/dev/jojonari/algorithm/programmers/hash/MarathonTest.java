package dev.jojonari.algorithm.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MarathonTest {

    @Test
    void run_correctly_first_player_return() {
        //given
        var sut = new Marathon();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        //when
        String actual = sut.solution(participant, completion);

        //then
        assertNotNull(actual);
        assertEquals(actual, "leo");
    }

    @Test
    void run_correctly_second_player_return() {
        //given
        var sut = new Marathon();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"leo", "eden"};

        //when
        String actual = sut.solution(participant, completion);

        //then
        assertEquals(actual, "kiki");
    }

    @Test
    void run_correctly_duple_player_return() {
        //given
        var sut = new Marathon();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "stanko", "ana"};

        //when
        String actual = sut.solution(participant, completion);

        //then
        assertEquals(actual, "mislav");
    }

}