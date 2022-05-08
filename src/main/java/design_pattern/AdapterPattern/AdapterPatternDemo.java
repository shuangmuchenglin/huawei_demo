package design_pattern.AdapterPattern;

/**
 * @ClassName: AdapterPatternDemo
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
