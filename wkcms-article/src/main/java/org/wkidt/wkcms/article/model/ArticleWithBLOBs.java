package org.wkidt.wkcms.article.model;

public class ArticleWithBLOBs extends Article {
    private byte[] content;

    private String url;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}