package ku.piii.music;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ku.piii.marshalling.JacksonJSONMarshallingSupport;
import ku.piii.model.MusicMediaCollection;
import ku.piii.mp3.MP3PathToMusicMapperImpl;
import ku.piii.nio.file.TextFileStoreImpl;

public class MusicServiceImplTest {

    @Test
    public void testAddAllMp3Media() {
        MusicService instance = 
        		new MusicServiceImpl(new MusicRepositoryImpl(new JacksonJSONMarshallingSupport(new ObjectMapper()), new TextFileStoreImpl()), new MP3PathToMusicMapperImpl());
        MusicMediaCollection collectionA = instance.createMusicMediaCollection(Paths.get("../test-music-files/collection-A"));
        assertEquals(9, collectionA.getMusic().size());

        MusicMediaCollection collectionB = instance.createMusicMediaCollection(Paths.get("../test-music-files/collection-B"));
        MusicMediaCollection merge = collectionA.mergeCollection(collectionB);
        assertEquals(18, merge.getMusic().size());
    }

    @Test
    public void canAddFilesThenSaveThenLoad() {
        MusicService instance = 
        		new MusicServiceImpl(new MusicRepositoryImpl(new JacksonJSONMarshallingSupport(new ObjectMapper()), new TextFileStoreImpl()), new MP3PathToMusicMapperImpl());
        MusicMediaCollection collection = instance.createMusicMediaCollection(Paths.get("../test-music-files/collection-A"));
        instance.saveMusicMediaCollection(Paths.get("collectionA.json"), collection);
        MusicMediaCollection savedCollection = instance.loadMusicMediaCollection(Paths.get("collectionA.json"));
        assertEquals(collection.getMusic().size(), savedCollection.getMusic().size());
    }

}
