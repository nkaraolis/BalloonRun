package balloonrun;

import java.io.*;
import sun.audio.*;

public class Audio {

    public void music() {
        AudioStream BM;
        AudioData musicData;
        AudioPlayer musicPlayer = AudioPlayer.player;
        ContinuousAudioDataStream loop = null;
        try {
            InputStream audio = new FileInputStream("music/jango.mp3");
            BM = new AudioStream(audio);
            AudioPlayer.player.start(BM);
            musicPlayer.start(loop);
        } catch (IOException error) {
            System.out.println(error);
        }
    }

}
