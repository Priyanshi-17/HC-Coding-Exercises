interface MediaPlayer {
    void play(String audioType, String fileName);
}

class MP3Player implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
    }
}

class VLCPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    VLCPlayer vlcPlayer = new VLCPlayer();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            vlcPlayer.playVLC(fileName);
        }
    }
}

// Client
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter = new MediaAdapter();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            new MP3Player().play(audioType, fileName);
        } else if(audioType.equalsIgnoreCase("vlc")){
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type");
        }
    }
}

// Usage
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("vlc", "movie.vlc");
    }
}
