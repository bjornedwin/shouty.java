package shouty;


public class PeopleLocation {
    private String name;
    private Integer x;
    private Integer y;

    public PeopleLocation(String name, int xCord, int yCord) {
        this.name = name;
        this.x = xCord;
        this.y = yCord;
    }

    public String getName() {
        return name;
    }

    public Integer getXCord() {
        return x;
    }

    public Integer getYCord() {
        return y;
    }
}
