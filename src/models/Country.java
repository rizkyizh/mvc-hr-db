package models;

public class Country {
    private String id;
    private String name;
    private Integer region_id;
    

    public Country() {
    }

    public Country(String id, String name, Integer region_id) {
        this.id = id;
        this.name = name;
        this.region_id = region_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

}
