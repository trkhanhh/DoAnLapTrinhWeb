package CMSDaoImpl;

import CMSDao.ContentDao;
import CMSDao.UserDao;
import CMSModel.ContentModel;
import CMSModel.UserModel;
import DBConnect.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContentDaoImpl extends DBConnection implements ContentDao {
    Connection conn = null;
    PreparedStatement ps = null;
    UserDao userdao = new UserDaoImpl();

    @Override
    public void insert(ContentModel content) {
        String sql = "INSERT INTO `Web`.`content` (`title`, `brief`, `content`, `createdate`, `updatetime`, `authorid`) " +
                "VALUES ( ?, ?, ?, ?, ?, ?);";
        try {
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, content.getTitle());
            ps.setString(2, content.getBrief());
            ps.setString(3, content.getContent());
            ps.setDate(4, new Date(content.getCreatedate().getTime()));
            ps.setDate(5, new Date(content.getUpdatetime().getTime()));
            ps.setInt(6, content.getUser().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ContentModel content) {
        String sql = "UPDATE web.content\n" +
                "SET title = ?, brief = ?,content =? , updatetime = ?\n" +
                "WHERE id =?;";
        try {
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, content.getTitle());
            ps.setString(2, content.getBrief());
            ps.setString(3, content.getContent());
            ps.setDate(4, new Date(content.getUpdatetime().getTime()));
            ps.setInt(5, content.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from content where id = ?";
        try {
            conn = DBConnection.getConnect();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ContentModel> getall(int maxPage, int index) {
        List<ContentModel> listcontent = new ArrayList<>();
        String sql = "SELECT * FROM Web.content LIMIT ? OFFSET ?;";
        try {
            PreparedStatement ps =   DBConnection.getConnect().prepareStatement(sql);
            ps.setInt(1, maxPage);
            ps.setInt(2, index);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel us = userdao.getbyid(rs.getInt("authorid"));
                ContentModel content = new ContentModel();
                content.setId(rs.getInt("id"));
                content.setTitle(rs.getString("title"));
                content.setBrief(rs.getString("brief"));
                content.setContent(rs.getString("content"));
                content.setCreatedate(rs.getDate("createdate"));
                content.setUpdatetime(rs.getDate("updatetime"));
                content.setUser(us);
                listcontent.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listcontent;
    }

    @Override
    public List<ContentModel> searchAll(String value, int maxPage, int index) {
        List<ContentModel> listcontent = new ArrayList<>();
        String sql = "select * from web.content where id = ? or title = ? or Brief = ? or Content = ? or AuthorId = ? LIMIT ? OFFSET ?;";
        try {
            PreparedStatement ps =   DBConnection.getConnect().prepareStatement(sql);
            ps.setString(1, value);
            ps.setString(2, value);
            ps.setString(3, value);
            ps.setString(4, value);
            ps.setString(5, value);
            ps.setInt(6, maxPage);
            ps.setInt(7, index);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserModel us = userdao.getbyid(rs.getInt("authorid"));
                ContentModel content = new ContentModel();
                content.setId(rs.getInt("id"));
                content.setTitle(rs.getString("title"));
                content.setBrief(rs.getString("brief"));
                content.setContent(rs.getString("content"));
                content.setCreatedate(rs.getDate("createdate"));
                content.setUpdatetime(rs.getDate("updatetime"));
                content.setUser(us);
                listcontent.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listcontent;
    }
}
