package dev.jojonari.algorithm.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CamouflageTest {

    @Test
    void 스파이는_하나의_아이템을_가지고_있다() {
        //given
        var sut = new Camouflage();
        String[][] clothes = new String[][]{{"yellowhat", "headgear"}};

        //when
        int actual = sut.solution(clothes);

        //then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 스파이는_같은_종류의_아이템을_여러개_가지고_있다() {
        //given
        var sut = new Camouflage();
        String[][] clothes = new String[][]{{"yellowhat", "headgear"}, {"green_turban", "headgear"}};

        //when
        int actual = sut.solution(clothes);

        //then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 스파이는_다른_종류의_아이을_여러개_가지고_있다() {
        //given
        var sut = new Camouflage();
        String[][] clothes = new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        //when
        int actual = sut.solution(clothes);

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 스파이는_다른_종류의_아이을_여러개_가지고_있다2() {
        //given
        var sut = new Camouflage();
        String[][] clothes = new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        //when
        int actual = sut.solution(clothes);

        //then
        assertThat(actual).isEqualTo(3);
    }


}