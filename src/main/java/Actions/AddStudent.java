package Actions;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.StudentDAO;
import Beans.Student;
import java.util.Map;


/**
 * Servlet implementation class AddStudent
 */
@WebServlet(description = "Servelet to add new students", urlPatterns = { "/AddStudent" })
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String bio = request.getParameter("bio");
		
		System.out.println("FirstName: "+firstname);
		System.out.println("LastName: "+lastname);
		System.out.println("Email Address: "+email);
		System.out.println("Bio: "+bio);
		
		// Creating the student bean object
		Student student = new Student();
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setEmail(email);
		student.setBio(bio);
		
		StudentDAO dao = new StudentDAO("jdbc:postgresql://localhost:5433/student_management_system","postgres","postgres");
		Map<String, String> result = dao.saveStudentDetails(student);
		
		System.out.println(result);
		request.setAttribute("status", result.get("status"));
		request.setAttribute("message", result.get("message"));	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
