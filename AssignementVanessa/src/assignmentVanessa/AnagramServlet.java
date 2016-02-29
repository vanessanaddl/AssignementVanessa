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
		char[] sortArray = input1Array;
		Key key = KeyFactory.createKey("WordList", sortArray.toString());

	try
	{
		WordList thiswordList = pm.getObjectById(WordList.class, key);
		ArrayList<String> thisArrayList = thiswordList.getList();
		req.setAttribute("anagList", thisArrayList);
		
	}
	catch (Exception e)
	{
		e.printStackTrace(); 
		e.getLocalizedMessage();
		req.setAttribute("MessageTest","Anagram existiert nicht in der DB");
	}
	RequestDispatcher reqDisp = req.getRequestDispatcher("/WEB-INF/root.jsp");
	resp.sendRedirect("/");
	reqDisp.forward(req,resp); //back to root.jsp
	
		}

	// Task 11 --doPost--
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();

	}
}
