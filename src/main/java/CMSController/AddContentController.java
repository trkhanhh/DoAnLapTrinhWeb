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

@WebServlet(urlPatterns = {"/add-content"})
public class AddContentController extends HttpServlet{
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
		HttpSession session = req.getSession();

		Object obj = session.getAttribute("account");

		String title = req.getParameter("title");
		String brief = req.getParameter("brief");
		String content = req.getParameter("content");
		UserModel users = (UserModel) obj;

		ContentModel contentmodel = new ContentModel();
		contentmodel.setTitle(title);
		contentmodel.setBrief(brief);
		contentmodel.setContent(content);
		contentmodel.setCreatedate(new java.sql.Date(time));
		contentmodel.setUpdatetime(new java.sql.Date(time));
		contentmodel.setUser(users);

		contentdao.insert(contentmodel);

		LoadContentController loadContentController = new LoadContentController();
		loadContentController.doPost(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		

	}

}
