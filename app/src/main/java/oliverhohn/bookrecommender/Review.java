package oliverhohn.bookrecommender;

/**
 * Created by Oliver on 06/12/2016.
 */
public class Review {
    public enum type{
        AUDIO,TEXT
    }
    private type type;
    private String title;
    private int rating;
    private String description;

    public Review(String title, int rating, String description){
        type = type.TEXT;
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Review(String title, int rating){
        type = type.AUDIO;
        this.title = title;
        this.rating = rating;
    }

    public Review.type getType() {
        return type;
    }

    public void setType(Review.type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
