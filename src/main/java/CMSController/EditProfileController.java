package CMSController;

import CMSDao.ContentDao;
import CMSDaoImpl.ContentDaoImpl;
import CMSModel.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = {"/edit-profile"})
public class EditProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContentDao contentdao = new ContentDaoImpl();
    long time = System.currentTimeMillis();

    public void init() {
        contentdao = new ContentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel user = (UserModel) obj;
        req.setAttribute("firstname", user.getFirstname());
        req.setAttribute("lastname", user.getLastname());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("description", user.getDescription());

        req.getRequestDispatcher("view/editprofile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel user = (UserModel) obj;
        req.setAttribute("firstname", user.getFirstname());
        req.setAttribute("lastname", user.getLastname());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("description", user.getDescription());

        req.getRequestDispatcher("view/editprofile.jsp").forward(req, resp);
    }
}
