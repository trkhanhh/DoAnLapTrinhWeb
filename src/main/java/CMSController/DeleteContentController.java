package CMSController;

import CMSDao.ContentDao;
import CMSDaoImpl.ContentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-content"})
public class DeleteContentController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ContentDao contentdao = new ContentDaoImpl();

    public void init() {
        contentdao = new ContentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        contentdao.delete(Integer.parseInt(id));
        LoadContentController loadContentController = new LoadContentController();
        loadContentController.doPost(req, resp);
    }
}
