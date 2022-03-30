import java.io.Serializable;

public class Movie implements Serializable {
    String mid = "001";
    String name = "smooth criminal";

    public Movie() {
    }

    public Movie(String mid, String name) {
        this.mid = mid;
        this.name = name;
    }
}
