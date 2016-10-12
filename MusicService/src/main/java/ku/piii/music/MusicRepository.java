package ku.piii.music;

import java.util.List;

import ku.piii.model.MusicMedia;

public interface MusicRepository{
    public List<MusicMedia> getItems();    
    public void addItem(final MusicMedia thisItem);
}
