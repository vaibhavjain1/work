package noUse;

import java.awt.*;

public class AdapterDemo {

    interface player{
        void playFile(String file);
    }

    class mediaPlayer implements player{

        @Override
        public void playFile(String file) {

        }
    }

    class PlayerAdapter implements player{
        @Override
        public void playFile(String file) {
            if(file.endsWith(".mp3")){
                new mediaPlayer().playFile(file);
            }
            if(file.endsWith(".mp4")){
                new mediaPlayer().playFile(file);
            }
        }
    }

    public static void main(String[] args) {

    }
}
