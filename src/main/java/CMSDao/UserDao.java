package CMSDao;

import CMSModel.UserModel;

public interface UserDao {
	void insert(UserModel user);
	
	void delete(int id);
	
	UserModel getusername(String name, String password);
	
	UserModel getbyid(int id);
	
	void updateUser(UserModel userModel);
}
