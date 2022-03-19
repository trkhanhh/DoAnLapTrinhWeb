package CMSController;

import CMSModel.UserModel;
import CMSService.UserService;
import CMSServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login"})
public class LoginControllerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserService service = new UserServiceImpl();
        UserModel account = service.login(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("account", account);
        String remember = req.getParameter("remember");
        System.out.println("remember : " + remember);
        Cookie cUserName = new Cookie("cookuser", email);
        Cookie cPassword = new Cookie("cookpass", password);
        Cookie cRemember = new Cookie("cookrem", remember.trim());
        cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days
        cPassword.setMaxAge(60 * 60 * 24 * 15);
        cRemember.setMaxAge(60 * 60 * 24 * 15);
        resp.addCookie(cUserName);
        resp.addCookie(cPassword);
        resp.addCookie(cRemember);
        if(account.getPhone() == null){
         EditProfileController editProfileController = new EditProfileController();
         editProfileController.doPost(req,resp);
        }
        if (account == null) {
            String  alertMsg = "Username or password is wrong";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        } else {
            LoadContentController loadContentController = new LoadContentController();
            loadContentController.doPost(req, resp);
        }
    }
}
