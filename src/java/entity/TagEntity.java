/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entity;

/**
 * @author admin
 */
public class TagEntity {
    private int TagID;
        private String TagName;
        private String Description;
        private int ParentTagID;
        private String UsageCount;

    public TagEntity() {
    }

    public TagEntity(int TagID, String TagName, String Description, int ParentTagID, String UsageCount) {
        this.TagID = TagID;
        this.TagName = TagName;
        this.Description = Description;
        this.ParentTagID = ParentTagID;
        this.UsageCount = UsageCount;
    }

    public int getTagID() {
        return TagID;
    }

    public String getTagName() {
        return TagName;
    }

    public String getDescription() {
        return Description;
    }

    public int getParentTagID() {
        return ParentTagID;
    }

    public String getUsageCount() {
        return UsageCount;
    }

    public void setTagID(int TagID) {
        this.TagID = TagID;
    }

    public void setTagName(String TagName) {
        this.TagName = TagName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setParentTagID(int ParentTagID) {
        this.ParentTagID = ParentTagID;
    }

    public void setUsageCount(String UsageCount) {
        this.UsageCount = UsageCount;
    }

    @Override
    public String toString() {
        return "TagEntity{" + "TagID=" + TagID + ", TagName=" + TagName + ", Description=" + Description + ", ParentTagID=" + ParentTagID + ", UsageCount=" + UsageCount + '}';
    }
        
        
}
