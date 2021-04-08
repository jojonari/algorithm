package dev.jojonari.algorithm.programmers.hash;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */

/**
 * IntStream.range : fori와 같은 반복을 할 수 있음
 * mapToObj : Stream<Object>로 변경
 * entrySet : Map의 데이터를 담고 있는 Set을 반환
 * flatMap : 컬렉션 스트림의 모든 Elements를 mapping 함수에 적용하여 모든 컬렉션이 결합된 스트림으로 반환
 */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(Music::getId).toArray();
    }

    /**
     * 장르별 재생수 총 합
     * @param value
     * @return
     */
    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer += music.getPlayed();
        }
        return answer;
    }
}

/**
 * Music
 */
class Music implements Comparable<Music> {
    private final int played;
    private final int id;
    private final String genre;

    public Music(String genre, int played, int id) {
        this.genre = genre;
        this.played = played;
        this.id = id;
    }

    @Override
    public int compareTo(Music other) {
        // 재생 수가 같으면 앞선 노래가 먼저
        if (this.played == other.played) return this.id - other.id;
        return other.played - this.played;
    }

    public int getPlayed() {
        return played;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Music{" +
                "played=" + played +
                ", id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}