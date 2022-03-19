package CMSDao;

import CMSModel.ContentModel;

import java.util.List;

public interface ContentDao {
	void insert(ContentModel content);

	void update(ContentModel content);

	void delete(int id);
	
	List<ContentModel> getall(int maxPage, int index);

	List<ContentModel> searchAll(String value, int maxPage, int index);

}
