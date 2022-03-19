package CMSService;

import CMSModel.ContentModel;

import java.util.List;

public interface ContentService {
	void insert(ContentModel content);
	void delete(int id);
	List<ContentModel> getall();
	List<ContentModel> search(String keyword);
}
