package oliverhohn.bookrecommender;

import java.util.ArrayList;

/**
 * Created by Oliver on 06/12/2016.
 */
public class Singleton {
    private static Singleton instance;
    private ArrayList<Book> books;
    private ArrayList<Review> reviews;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton(){
        books = new ArrayList<>();
        reviews = new ArrayList<>();
        addBooks();
        addReviews();
    }

    private void addBooks(){
        books.add(new Book(R.drawable.book1, "Harry Potter and the Philosopher's Stone","J. K. Rowling","Harry Potter is an ordinary boy who lives in a cupboard under the stairs at his Aunt Petunia and Uncle Vernon's house, which he thinks is normal for someone like him who's parents have been killed in a 'car crash'. He is bullied by them and his fat, spoilt cousin Dudley, and lives a very unremarkable life with only the odd hiccup (like his hair growing back overnight!) to cause him much to think about. That is until an owl turns up with a letter addressed to Harry and all hell breaks loose! He is literally rescued by a world where nothing is as it seems and magic lessons are the order of the day. Read and find out how Harry discovers his true heritage at Hogwarts School of Wizardry and Witchcraft, the reason behind his parents mysterious death, who is out to kill him, and how he uncovers the most amazing secret of all time, the fabled Philosopher's Stone! All this and muggles too. Now, what are they?"));
        books.add(new Book(R.drawable.book2, "Harry Potter and the Chamber of Secrets","J. K. Rowling","Harry Potter's summer has included the worst birthday ever, doomy warnings from a house-elf called Dobby, and rescue from the Dursleys by his friend Ron Weasley in a magical flying car! Back at Hogwarts School of Witchcraft and Wizardry for his second year, Harry hears strange whispers echo through empty corridors - and then the attacks start. Students are found as though turned to stone . Dobby's sinister predictions seem to be coming true."));
        books.add(new Book(R.drawable.book3, "Harry Potter and the Half Blood Prince", "J. K. Rowling","When Dumbledore arrives at Privet Drive one summer night to collect Harry Potter, his wand hand is blackened and shrivelled, but he does not reveal why. Secrets and suspicion are spreading through the wizarding world, and Hogwarts itself is not safe. Harry is convinced that Malfoy bears the Dark Mark: there is a Death Eater amongst them. Harry will need powerful magic and true friends as he explores Voldemort's darkest secrets, and Dumbledore prepares him to face his destiny."));
        books.add(new Book(R.drawable.book4, "Harry Potter and the Prisoner of Azkaban","J. K. Rowling","When the Knight Bus crashes through the darkness and screeches to a halt in front of him, it's the start of another far from ordinary year at Hogwarts for Harry Potter. Sirius Black, escaped mass-murderer and follower of Lord Voldemort, is on the run - and they say he is coming after Harry. In his first ever Divination class, Professor Trelawney sees an omen of death in Harry's tea leaves . But perhaps most terrifying of all are the Dementors patrolling the school grounds, with their soul-sucking kiss."));
        books.add(new Book(R.drawable.book5, "The Penguin History of the United States of America", "Hugh Brogan","This new edition of Brogan's superb one-volume history - from early British colonisation to the Reagan years - captures an array of dynamic personalities and events. In a broad sweep of America's triumphant progress. Brogan explores the period leading to Independence from both the American and the British points of view, touching on permanent features of 'the American character' - both the good and the bad. He provides a masterly synthesis of all the latest research illustrating America's rapid growth from humble beginnings to global dominance."));
    }

    private void addReviews(){
        reviews.add(new Review("The Book was Great!",5,"Best book that I have read in years, the story is much wow. Such doge"));
        reviews.add(new Review("Ok Book",2,"Didn't think it was that great"));
        reviews.add(new Review("Bad...",1));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
