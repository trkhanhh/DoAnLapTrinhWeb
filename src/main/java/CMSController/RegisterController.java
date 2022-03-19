package CMSController;

import CMSDao.ContentDao;
import CMSDao.UserDao;
import CMSDaoImpl.ContentDaoImpl;
import CMSDaoImpl.UserDaoImpl;
import CMSModel.UserModel;
import CMSService.UserService;
import CMSServiceImpl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao contentdao = new UserDaoImpl();
    long time = System.currentTimeMillis();
    public void init() {
        contentdao = new UserDaoImpl();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService service = new UserServiceImpl();
        if(service.login(email, password) != null){
            request.setAttribute("error", "Account Existed!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setCreatedate(new java.sql.Date(time));
        contentdao.insert(userModel);
        request.getRequestDispatcher("view/login.jsp").forward(request,response);
    }
}

