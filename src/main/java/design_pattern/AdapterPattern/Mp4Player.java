package design_pattern.AdapterPattern;

/**
 * @ClassName: Mp4Player
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}