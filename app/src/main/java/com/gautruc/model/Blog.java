package com.gautruc.model;

public class Blog {
    private int resourceId;
    private String nameBlog, detailBlog;

    public Blog(int resourceId, String nameBlog, String detailBlog) {
        this.resourceId = resourceId;
        this.nameBlog = nameBlog;
        this.detailBlog = detailBlog;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDetailBlog() {
        return detailBlog;
    }

    public void setDetailBlog(String detailBlog) {
        this.detailBlog = detailBlog;
    }
}
