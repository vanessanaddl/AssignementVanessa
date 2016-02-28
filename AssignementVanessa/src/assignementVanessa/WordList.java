package assignementVanessa;
import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable
public class WordList {
	ArrayList <String> List = new ArrayList<String>();
	@PrimaryKey
	@Persistent
	private Key key;
	
	WordList(Key keyCons)
	{
		key = keyCons; 
	}


}
