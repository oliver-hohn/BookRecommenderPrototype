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
    private int likes;
    private int diss;

    public Review(String title, int rating, String description, int likes, int diss){
        type = type.TEXT;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.likes = likes;
        this.diss = diss;
    }

    public Review(String title, int rating, int likes, int diss){
        type = type.AUDIO;
        this.title = title;
        this.rating = rating;
        this.likes = likes;
        this.diss = diss;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDiss() {
        return diss;
    }

    public void setDiss(int diss) {
        this.diss = diss;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
