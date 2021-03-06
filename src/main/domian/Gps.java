package main.domian;

public class Gps {

    private Integer gid;
    private String name;
    private String description;

    public Gps() {
    }

    public Gps(Integer gid, String name, String description) {
        this.gid = gid;
        this.name = name;
        this.description = description;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Gps{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
