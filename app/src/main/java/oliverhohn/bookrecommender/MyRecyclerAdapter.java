package oliverhohn.bookrecommender;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oliver on 03/12/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {
    private ArrayList<Book> books;

    public MyRecyclerAdapter(ArrayList<Book> books){
        this.books = books;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Book book = books.get(position);
        if (book != null){
            holder.bookTitleView.setText(book.getTitle());
            holder.bookImageView.setImageResource(book.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        protected ImageView bookImageView;
        protected TextView bookTitleView;

        public MyHolder(View itemView) {
            super(itemView);
            bookImageView = (ImageView) itemView.findViewById(R.id.bookImageView);
            bookTitleView = (TextView) itemView.findViewById(R.id.textView5);
        }
    }
}
