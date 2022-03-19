package CMSController;

import CMSDao.ContentDao;
import CMSDaoImpl.ContentDaoImpl;
import CMSModel.ContentModel;
import CMSModel.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/edit-content"})
public class EditContentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ContentDao contentdao = new ContentDaoImpl();
    long time = System.currentTimeMillis();

    public void init() {
        contentdao = new ContentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/htm");
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String brief = req.getParameter("brief");
        String content = req.getParameter("content");

        req.setAttribute("id",id);
        req.setAttribute("title",title);
        req.setAttribute("brief",brief);
        req.setAttribute("content",content);

        req.getRequestDispatcher("view/editcontent.jsp").forward(req,resp);
    }
}
