package ku.piii.music;

import java.util.ArrayList;
import java.util.List;

import ku.piii.model.MusicMedia;

public class MusicRepositoryImpl implements MusicRepository{

    private List<MusicMedia> musicItems;
	
    public MusicRepositoryImpl() {
        this.musicItems = new ArrayList();
    }

    public List<MusicMedia> getItems() {
        return musicItems;
    }
    
    public void addItem(MusicMedia thisItem) {
        this.musicItems.add(thisItem);
    }
}
