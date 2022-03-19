package CMSDaoImpl;

import CMSDao.UserDao;
import CMSModel.UserModel;
import DBConnect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DBConnection implements UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void insert(UserModel user) {
        try {
            String sql = "INSERT INTO Member (Username, Email, Password) VALUES (?,?,?);";
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public UserModel getbyid(int id) {
        String sql = "SELECT * FROM Web.member where id = ?;";

        try {
            new DBConnection();
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setDescription(rs.getString("description"));
                user.setCreatedate(rs.getDate("createdate"));
                user.setUpdatetime(rs.getDate("updatetime"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(UserModel userModel) {
        try {
            String sql = "UPDATE Member SET Firstname=?,Lastname=?,Phone=?,Description=? WHERE Email=?";
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);

            ps.setString(1, userModel.getFirstname());
            ps.setString(2, userModel.getLastname());
            ps.setString(3, userModel.getPhone());
            ps.setString(4, userModel.getDescription());
            ps.setString(5, userModel.getEmail());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public UserModel getusername(String email, String password) {
        String sql = "SELECT * FROM Web.member where email = ? and password = ?;";
        long time = System.currentTimeMillis();
        try {
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setDescription(rs.getString("description"));
                user.setCreatedate(new java.sql.Date(time));
                user.setUpdatetime(new java.sql.Date(time));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
