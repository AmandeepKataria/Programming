package ku.piii.music;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import ku.piii.marshalling.JacksonJSONMarshallingSupport;
import ku.piii.mp3.MP3PathToMusicMapperImpl;
import org.junit.Ignore;

import org.junit.Test;

public class MusicServiceImplTest {

    @Test
    public void testAddAllMp3Media() {
        System.out.println("addAllMp3Media");

        MusicService instance = new MusicServiceImpl(new MusicRepositoryImpl(), new MP3PathToMusicMapperImpl(), new JacksonJSONMarshallingSupport(new ObjectMapper()));
        instance.addAllMp3Media(Paths.get("../test-music-files/collection-A"));
        assertEquals(9, instance.listMusicMedia().size());

        instance.addAllMp3Media(Paths.get("../test-music-files/collection-B"));
        assertEquals(18, instance.listMusicMedia().size());
    }

    @Test
    public void canAddFilesThenSaveThenLoad() {
        MusicService instance = new MusicServiceImpl(new MusicRepositoryImpl(), new MP3PathToMusicMapperImpl(), new JacksonJSONMarshallingSupport(new ObjectMapper()));
        instance.saveToFile(Paths.get("../test-music-files/test.txt"));
        //If I did instance.loadFile(), it would not make sense as this instance is already popualted with MusicMedia. 
        //Is it right to say I have to create a new MusicServiceImpl object?
    }
    
    @Ignore
    public void canLoadThenSaveThenLoad() {
        
    }

}
