package designPatterns;

interface player{
    void play(String fileName);
}

class MediaPlayer implements player{

    @Override
    public void play(String fileName) {
        if(fileName.endsWith(".mp3"))
            System.out.println("Playing mp3: "+ fileName);
    }
}

class VideoAdapter implements  player{

    @Override
    public void play(String fileName) {
        if(fileName.endsWith(".mp3"))
            new MediaPlayer().play(fileName);

        else
            new VlcPlayer().play(fileName);
    }
}

class VlcPlayer implements player{

    @Override
    public void play(String fileName) {
        if(fileName.endsWith(".mp4"))
            System.out.println("Playing mp4: "+ fileName);
    }
}

public class Adapter {
    public static void main(String[] args) {

    }
}
