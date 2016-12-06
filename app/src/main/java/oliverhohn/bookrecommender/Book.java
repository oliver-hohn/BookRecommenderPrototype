package oliverhohn.bookrecommender;

/**
 * Created by Oliver on 03/12/2016.
 */
public class Book {//TODO:author,description
    private int image;
    private String title;
    private String description;
    private String author;


    public Book(int image, String title, String author, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
