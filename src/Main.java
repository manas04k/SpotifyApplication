import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Album album1 = new Album("Album1", "Alan Walker");
        album1.addSong("Song 1", 5.5);
        album1.addSong("Song 2", 56.3);
        album1.addSong("Song 3", 7.65);
        album1.addSong("Song 4", 67);
        album1.addSong("Song 5", 6.7);
        album1.addSong("Song 6", 6.90);
        album1.addSong("Song 7", 4.7);
        album1.addSong("Song 8", 8.7);

        LinkedList<Song> myplaylist = new LinkedList<>();
        album1.addtoPlaylist("Song 1", myplaylist);
        album1.addtoPlaylist("Song 2", myplaylist);
        album1.addtoPlaylist("Song 3", myplaylist);
        album1.addtoPlaylist("Song 4", myplaylist);
        album1.addtoPlaylist("Song 5", myplaylist);
        album1.addtoPlaylist("Song 6", myplaylist);

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

        boolean forward = true;
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

                case 3:
                    if(!forward){
                        if(itr.hasNext()){
                            itr.next();
                        }
//                        else{
//                              System.out.println("No Next Song");
//                        }
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have Reached End of the Playlist");
                    }
                    else{
                        System.out.println("You are listening to " + itr.next());
                    }
                    forward = true;
                    break;

                case 4:
                    if(forward){
                        if(itr.hasPrevious()){
                            itr.previous();
                        }
//                        else{
//                            System.out.println("No Previous Song");
//                        }
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You have Reached Start of the Playlist");
                    }
                    else{
                        System.out.println("You are listening to " + itr.previous());
                    }
                    forward = false;
                    break;

                case 5:
//
                    if(forward){
                        System.out.println("You are listening to " + itr.previous());
                        forward = false;
                        break;
                    }
                    else{
                        System.out.println("You are listening to " + itr.next());
                        forward = true;
                        break;
                    }

                case 6:
                    if(playlist.size()>0){

                        itr.remove();
                        System.out.println("Song removed Succesfully");
                        if(itr.hasNext()){
                            System.out.println("You are listening to " + itr.next());
                        }
                        else if(itr.hasPrevious()){
                            System.out.println("You are listening to " + itr.previous());
                        }
                        else{
                            System.out.println("Empty Playlist");
                        }
                        break;

                    }
                    System.out.println("Empty Playlist");
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
