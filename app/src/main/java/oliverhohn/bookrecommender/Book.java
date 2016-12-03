package oliverhohn.bookrecommender;

/**
 * Created by Oliver on 03/12/2016.
 */
public class Book {
    private int image;
    private String title;

    public Book(int image, String title) {
        this.image = image;
        this.title = title;
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
}
