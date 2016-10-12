package ku.piii.music;

import java.nio.file.Path;
import java.util.List;

import ku.piii.model.MusicMedia;

public interface MusicService {

    public void addAllMp3Media(Path root);

    public List<MusicMedia> listMusicMedia();
    
    public void saveToFile(Path fileToSave);
    
    public MusicService loadFromFile(Path fileToLoad);
}
