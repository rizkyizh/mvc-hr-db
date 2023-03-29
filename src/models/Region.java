package models;

public class Region {
    private Integer id;
    private String name;
    private Integer count;

    public Region() {
    }

    public Region(Integer id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public Region(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(Integer id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
