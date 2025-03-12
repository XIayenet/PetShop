package dao;

import entity.TagEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagDao extends DBContext {

    public TagDao() {}

    public void insertTag(String tagName, String description, int parentTagID, String usageCount) {
        String sql = "INSERT INTO [Tag] (TagName, Description, ParentTagID, UsageCount) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tagName.trim());
            ps.setString(2, description.trim());
            ps.setInt(3, parentTagID);
            ps.setString(4, usageCount);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public TagEntity getTagById(int tagID) {
        String sql = "SELECT * FROM [Tag] WHERE TagID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tagID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TagEntity(
                        rs.getInt("TagID"),
                        rs.getString("TagName"),
                        rs.getString("Description"),
                        rs.getInt("ParentTagID"),
                        rs.getString("UsageCount")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<TagEntity> getAllTags() {
        ArrayList<TagEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM [Tag]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TagEntity(
                        rs.getInt("TagID"),
                        rs.getString("TagName"),
                        rs.getString("Description"),
                        rs.getInt("ParentTagID"),
                        rs.getString("UsageCount")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateTag(int tagID, String tagName, String description, int parentTagID, String usageCount) {
        String sql = "UPDATE [Tag] SET TagName = ?, Description = ?, ParentTagID = ?, UsageCount = ? WHERE TagID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tagName);
            ps.setString(2, description);
            ps.setInt(3, parentTagID);
            ps.setString(4, usageCount);
            ps.setInt(5, tagID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

  public static void main(String[] args) {
        TagDao tdao = new TagDao();
    tdao.insertTag("hai", "hay", 5, "120");
  }
}
