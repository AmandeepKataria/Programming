package ku.piii.music;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ku.piii.marshalling.MarshallingSupport;
import ku.piii.model.MusicMedia;
import ku.piii.mp3.MP3PathToMusicMapper;
import ku.piii.nio.file.SimpleMp3FileVisitor;
import ku.piii.nio.file.TextFileStore;
import ku.piii.nio.file.TextFileStoreImpl;


public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;
    private final MP3PathToMusicMapper mapper;
    private final MarshallingSupport marshallSupport;
    private final TextFileStore tfs;

    public MusicServiceImpl(final MusicRepository musicRepository, MP3PathToMusicMapper myMapper, MarshallingSupport ms) {
        this.musicRepository = musicRepository;
        this.mapper = myMapper;
        this.marshallSupport = ms;
        this.tfs = new TextFileStoreImpl();
    }

    @Override
    public void addAllMp3Media(final Path root) {
        
        SimpleMp3FileVisitor myVisitor = new SimpleMp3FileVisitor();
        
        try {
            Files.walkFileTree(root, myVisitor);
        } catch (IOException ex) {
            Logger.getLogger(MusicServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Path p : myVisitor.getListOfMP3Files()) {
            MusicMedia m = mapper.mapPath(p);
            musicRepository.addItem(m);
        }
        
    }

    @Override
    public List<MusicMedia> listMusicMedia() {
        return musicRepository.getItems();
    }

    @Override
    public void saveToFile(Path fileToSave) {
        String objectMarshall = marshallSupport.marshal(this);
        this.tfs.saveText(objectMarshall, fileToSave);
    }

    @Override
    public MusicService loadFromFile(Path fileToLoad) {
        return marshallSupport.unmarshal(this.tfs.loadText(fileToLoad), this.getClass());
    }

}
