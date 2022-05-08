package design_pattern.AdapterPattern;

/**
 * @ClassName: VlcPlayer
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
