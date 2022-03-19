package CMSServiceImpl;

import CMSDao.UserDao;
import CMSDaoImpl.UserDaoImpl;
import CMSModel.UserModel;
import CMSService.UserService;

public class UserServiceImpl implements UserService{
	UserDao userdao = new UserDaoImpl();
	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getbyid(int id) {
		return userdao.getbyid(id);
	}

	@Override
	public UserModel login(String email, String password) {
		return userdao.getusername(email, password);
	}

}
