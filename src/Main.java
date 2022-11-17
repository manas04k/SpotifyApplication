import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Album album1 = new Album("Album1", "Alan Walker");
        album1.addSong("Alone", 5.5);
        album1.addSong("cee", 56.3);
        album1.addSong("Faded", 7.65);
        album1.addSong("rtt", 67);

        LinkedList<Song> myplaylist = new LinkedList<>();
        album1.addtoPlaylist("Alone", myplaylist);
        album1.addtoPlaylist("Faded", myplaylist);
        album1.addtoPlaylist("Alonee", myplaylist);

        printplaylist(myplaylist);
        play(myplaylist);

    }

    public static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playlist.listIterator();
        if(!itr.hasNext()){
            System.out.println("Your Playlist is Empty");
            return;
        }
        System.out.println("You are now listening " + itr.next());
        showMenu();

        while(true){
            int option = sc.nextInt();

            switch (option){
                case 0:
                    System.out.println("Thank You for listening");
                    return;

                case 1:
                    showMenu();
                    break;

                case 2:
                    printplaylist(playlist);
                    break;




            }
        }

    }

    public static void printplaylist(LinkedList<Song> playlist) {
        ListIterator<Song> itr = playlist.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        return;

    }

    public static void showMenu() {

        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }
}
