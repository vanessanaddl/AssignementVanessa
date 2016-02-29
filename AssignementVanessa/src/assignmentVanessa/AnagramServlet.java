package assignmentVanessa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Persistent;
import javax.management.PersistentMBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class AnagramServlet extends HttpServlet {
	// Task 10 --doGet--

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager(); // "translates"
		String text_input1 = req.getParameter("text_input1"); // reads request		
		char[] input1Array = new char[text_input1.length()];
		text_input1.getChars(0, text_input1.length(), input1Array, 0);
		Arrays.sort(input1Array);
		String sortString = new String(input1Array); //Convert the Char Array to a String
		Key key = KeyFactory.createKey("WordList", sortString);

	try
	{
		WordList thiswordList = pm.getObjectById(WordList.class, key);
		ArrayList<String> thisArrayList = thiswordList.getList();
		req.setAttribute("anagList", thisArrayList);
		String output="";
		for (int i=0; i < thisArrayList.size(); i++){
			output=output+thisArrayList.get(i);
		}
		req.setAttribute("output", output);
		req.setAttribute("MessageTest", "Succesfull");
		
	}
	catch (Exception e)
	{
		e.printStackTrace(); 
		e.getLocalizedMessage();
		req.setAttribute("MessageTest","Anagram existiert nicht in der DB");
	}
	RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/root.jsp");
	//resp.sendRedirect("/");
	reqDisp.forward(req,resp); //back to root.jsp
	
		}

	// Task 11 --doPost--
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String text_input2 = req.getParameter("text_input2"); // reads request		
		char[] input2Array = new char[text_input2.length()];
		text_input2.getChars(0, text_input2.length(), input2Array, 0);
		Arrays.sort(input2Array);
		String sortString = new String(input2Array); //Convert the Char Array to a String
		Key key = KeyFactory.createKey("WordList", sortString);
		
		try
		{
			WordList thiswordList = pm.getObjectById(WordList.class, key);
			thiswordList.addWord(text_input2);
			pm.makePersistent(thiswordList);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
			e.getLocalizedMessage();
			
			WordList wordList = new WordList();
			wordList.setKey(key); //set primary Key
			wordList.setList();  //generate new empty String List
			wordList.addWord(text_input2);
			pm.makePersistent(wordList);
		}
		
		RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/root.jsp");
		//resp.sendRedirect("/");
		reqDisp.forward(req,resp); //back to root.jsp
	}
}
