package design_pattern.AdapterPattern;

/**
 * @InterfaceName: AdvancedMediaPlayer
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}