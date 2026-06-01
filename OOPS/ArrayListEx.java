import java.util.*;
public class ArrayListEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> playlist = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            playlist.add(sc.next());
        }

        for (String song : playlist) { 
            System.out.print(song + " ");
        }
        System.out.println();

        playlist.remove(2);

        System.out.println("After removal: " + playlist);
        System.out.println("Element at index 1: " + playlist.get(1));
        System.out.println("Size of the playlist: " + playlist.size());
        System.out.println(playlist.contains("Animal")); 
    }
}