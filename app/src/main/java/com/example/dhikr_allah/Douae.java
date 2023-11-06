package com.example.dhikr_allah;

public class Douae {
    private int id;
    private String content;
    private String count;

    public Douae(int id, String content, String count) {
        this.id = id;
        this.content = content;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Douae{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
