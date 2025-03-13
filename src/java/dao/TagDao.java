package dao;

import entity.TagEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TagDao extends DBContext {
    
    public TagDao() {
    }
    
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
    
    public List<String> getAllTagNames() {
        List<String> tags = new ArrayList<>();
        String sql = "SELECT TagName FROM Tag";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tags.add(rs.getString("TagName"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tags;
    }
    
    public List<Integer> getDescendantTagIDs(int tagID) {
        List<Integer> descendants = new ArrayList<>();
        String sql = "WITH RecursiveTags AS ("
                + " SELECT TagID, ParentTagID FROM Tag WHERE TagID = ? "
                + " UNION ALL "
                + " SELECT t2.TagID, t2.ParentTagID FROM Tag t2 JOIN RecursiveTags rt ON t2.ParentTagID = rt.TagID "
                + ") SELECT TagID FROM RecursiveTags";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, tagID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                descendants.add(rs.getInt("TagID"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return descendants;
    }
    
    public List<Integer> getExpandedTagIDs(String[] selectedTags) {
        Set<Integer> allTagIDs = new HashSet<>();
        for (String tagName : selectedTags) {
            int tagID = getTagIDByTagName(tagName);
            if (tagID != -1) {
                List<Integer> descendants = getDescendantTagIDs(tagID);
                allTagIDs.addAll(descendants);
            }
        }
        return new ArrayList<>(allTagIDs);
    }
    
    private int getTagIDByTagName(String tagName) {
        int tagID = -1;
        String sql = "SELECT TagID FROM Tag WHERE TagName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tagName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tagID = rs.getInt("TagID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tagID;
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
    
    public ArrayList<TagEntity> getTagByProduct(int productID) {
        ArrayList<TagEntity> list = new ArrayList<>();
        String sql = "SELECT t.TagID, t.TagName, t.Description, t.ParentTagID, t.UsageCount "
                + "FROM Tag t "
                + "JOIN ProductTag pt ON t.TagID = pt.TagID "
                + "WHERE pt.ProductID = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, productID); // Set the productID parameter
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TagEntity tag = new TagEntity(
                            rs.getInt("TagID"),
                            rs.getString("TagName"),
                            rs.getString("Description"),
                            rs.getInt("ParentTagID"),
                            rs.getString("UsageCount") // UsageCount is an INT, not a String
                    );
                    list.add(tag);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching tags for product: " + e.getMessage());
        }
        return list;
    }
    
    public static void main(String[] args) {
        TagDao tdao = new TagDao();
//        tdao.insertTag("hai", "hay", 5, "120");
        System.out.println(tdao.getTagByProduct(5));
    }
}
