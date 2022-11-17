import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> song;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.song = new ArrayList<>();
    }

    //find song
    public boolean findSong(String title){
        for(Song checkSong:song){
            if(checkSong.getTitle().equals(title)){
                System.out.println("Found Your Song");
                return true;
            }
        }

        return false;
    }

    //add song
    public boolean addSong(String title, double duration){
        if(findSong(title)){
            System.out.println("Song is Already Present");
            return false;
        }

//        Song song = new Song(title, duration);
        this.song.add(new Song(title, duration));
        return false;
    }


    public boolean addtoPlaylist(String title, LinkedList<Song> playlist){
        for(Song checksong : this.song){
            if(checksong.getTitle().equals(title)){
                for(Song check : playlist){
                    if(check.getTitle().equals(title)){
                        System.out.println("Song is already present in the playlist");
                        return false;
                    }
                }
                playlist.add(checksong);
                System.out.println("Song is successfully added to the playlist");
                return true;
            }
        }
        System.out.println("Song is not present in your album");
        return false;

    }

    public boolean addtoPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
        if(index>=0 && index<=this.song.size()-1){
            for(Song check : playlist){
                if(this.song.get(index).getTitle().equals(check.getTitle())){//checking if song is already present in the playlist.
                    System.out.println("Song is already present in the playlist");
                    return false;
                }
                playlist.add(this.song.get(index));
                System.out.println("Song is successfully added to the playlist");
                return true;
            }

        }
        System.out.println("Song is not present in your album for given trackNumber");
        return false;
    }
}

