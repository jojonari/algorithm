package dev.jojonari.algorithm.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BestAlbumTest {
    @Test
    void 모든_노래가_같은_재생수를_갖는_경우() {
        //given
        String[] genres = {"classic", "classic", "pop", "classic", "pop", "pop", "classic", "classic", "classic", "classic"};
        int[] plays = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        var sut = new BestAlbum();

        //when
        int[] actual = sut.solution(genres, plays);

        //then
        assertArrayEquals(actual, new int[]{0, 1, 2, 4});
    }

    @Test
    void 장르별_노래_재생수_가_모두_다른_경우() {
        //given
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        var sut = new BestAlbum();

        //when
        int[] actual = sut.solution(genres, plays);

        //then
        assertArrayEquals(actual, new int[]{4, 1, 3, 0});
    }
}