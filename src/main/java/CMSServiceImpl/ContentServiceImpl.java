package CMSServiceImpl;

import CMSDao.ContentDao;
import CMSDaoImpl.ContentDaoImpl;
import CMSModel.ContentModel;
import CMSService.ContentService;

import java.util.List;

public class ContentServiceImpl implements ContentService{
	ContentDao contentdao = new ContentDaoImpl();


	@Override
	public void insert(ContentModel content) {
		contentdao.insert(content);
		
	}

	@Override
	public void delete(int id) {
		contentdao.delete(id);
		
	}

	@Override
	public List<ContentModel> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}}
