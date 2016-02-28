package assignmentVanessa;
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
	
	//Task 4
	WordList(Key keyCons)
	{
		key = keyCons; 
	}
	
	//Task 5
	public int WordCount()
	{
		return List.size();	
	}
	
	//Task 6
	public String getWord(final int index)
	{
		return List.get(index);
	}
	
	//Task 7
	public void addWord(final String word)
	{
		if (List.contains(word)==true)
		{
			List.add(word);
		}
	}
}
