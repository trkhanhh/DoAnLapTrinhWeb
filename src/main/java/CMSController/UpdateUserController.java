package CMSController;

import CMSDao.ContentDao;
import CMSDao.UserDao;
import CMSDaoImpl.ContentDaoImpl;
import CMSDaoImpl.UserDaoImpl;
import CMSModel.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/update-profile"})
public class UpdateUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao contentdao = new UserDaoImpl();
    long time = System.currentTimeMillis();

    public void init() {
        contentdao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel user = (UserModel) obj;

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String description = req.getParameter("description");

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhone(phone);
        user.setDescription(description);
        contentdao.updateUser(user);
        req.setAttribute("firstname", user.getFirstname());
        req.setAttribute("lastname", user.getLastname());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("description", user.getDescription());

        req.getRequestDispatcher("view/editprofile.jsp").forward(req, resp);

        req.getRequestDispatcher("view/editprofile.jsp").forward(req, resp);
    }
}