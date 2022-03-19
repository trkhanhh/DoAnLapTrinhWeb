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
import java.util.List;

@WebServlet(urlPatterns = {"/search-content"})
public class SearchContentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContentDao contentdao = new ContentDaoImpl();

    public void init() {
        contentdao = new ContentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("value");
        int pageIndex = req.getParameter("index") == null ? 0
                : Integer.parseInt(req.getParameter("index"));
        int startIndex = pageIndex * 10;
        int maxPage = 10;
        List<ContentModel> contentModels;

        if (search != null && !search.isEmpty()) {
            contentModels = contentdao.searchAll(search.trim(), maxPage, startIndex);
        } else {
            contentModels = contentdao.getall(maxPage, startIndex);
        }
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel users = (UserModel) obj;
        req.setAttribute("searchCode", search);
        req.setAttribute("role", users.getUsername());
        req.setAttribute("name", users.getUsername());
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("contents", contentModels);
        req.getRequestDispatcher("home.tiles").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("value");
        int pageIndex = req.getParameter("index") == null ? 0
                : Integer.parseInt(req.getParameter("index"));
        int startIndex = pageIndex * 10;
        int maxPage = 10;
        List<ContentModel> contentModels;

        if (search != null && !search.isEmpty()) {
            contentModels=       contentdao.searchAll(search.trim(), maxPage, startIndex);
        } else {
            contentModels=     contentdao.getall(maxPage, startIndex);
        }
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserModel users = (UserModel) obj;
        req.setAttribute("searchCode", search);
        req.setAttribute("role", users.getUsername());
        req.setAttribute("name", users.getUsername());
        req.setAttribute("pageIndex", pageIndex);
        req.setAttribute("maxPage", maxPage);
        req.setAttribute("contents", contentModels);
        req.getRequestDispatcher("home.tiles").forward(req, resp);
    }
}
