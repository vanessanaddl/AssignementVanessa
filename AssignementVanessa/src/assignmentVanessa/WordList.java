package assignmentVanessa;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable
public class WordList {
	ArrayList<String> List;
	@PrimaryKey
	@Persistent
	private Key key;

	// Task 4
	WordList(Key keyCons) {
		key = keyCons;
	}

	public ArrayList<String> getList() {
		return List;
	}

	public void setList() {
		List = new ArrayList<String>();
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	// Default Constructor
	WordList() {

	}

	// Task 5
	public int WordCount() {
		return List.size();
	}

	// Task 6
	public String getWord(final int index) {
		return List.get(index);
	}

	// Task 7
	public boolean addWord(final String word) {
		boolean check = false;
		try {

			if (!(List.contains(word))) {
				List.add(word);
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
		}
		return check;
	}
}
