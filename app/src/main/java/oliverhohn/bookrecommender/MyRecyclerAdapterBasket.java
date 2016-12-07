package oliverhohn.bookrecommender;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oliver on 07/12/2016.
 */
public class MyRecyclerAdapterBasket extends RecyclerView.Adapter<MyRecyclerAdapterBasket.MyHolder> {
    public interface MyAdapterListener{
        void removeBook(int position);
        void lookAt(int position);

    }
    private ArrayList<Book> books;
    private MyRecyclerAdapterBasket.MyAdapterListener myAdapterListener;

    public MyRecyclerAdapterBasket(ArrayList<Book> books, MyRecyclerAdapterBasket.MyAdapterListener myAdapterListener){
        this.books = books;
        this.myAdapterListener = myAdapterListener;
    }

    @Override
    public MyRecyclerAdapterBasket.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_basket_row, null);
        MyRecyclerAdapterBasket.MyHolder myHolder = new MyRecyclerAdapterBasket.MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapterBasket.MyHolder holder, final int position) {
        final Book book = books.get(position);
        Log.d("Adapter", "Position: "+position+" Book: "+book.getTitle());
        if(book != null){
            holder.removeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapterListener.removeBook(position);
                }
            });
            holder.bookImageView.setImageResource(book.getImage());
            holder.titleTextView.setText(Html.fromHtml("<u>"+book.getTitle()+"</u>"));
            holder.fromTextView.setText(Html.fromHtml("from: <u>"+book.getAuthor()+"</u>"));
            holder.lookAtTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapterListener.lookAt(Singleton.getInstance().getBooks().indexOf(book));
                }
            });
            holder.lookAtImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapterListener.lookAt(Singleton.getInstance().getBooks().indexOf(book));
                }
            });
            holder.bookImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapterListener.lookAt(Singleton.getInstance().getBooks().indexOf(book));
                }
            });
            holder.titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myAdapterListener.lookAt(Singleton.getInstance().getBooks().indexOf(book));
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        protected ImageView removeView;
        protected ImageView bookImageView;
        protected TextView titleTextView;
        protected TextView fromTextView;
        protected ImageView lookAtImageView;
        protected TextView lookAtTextView;

        public MyHolder(View itemView) {
            super(itemView);
            removeView = (ImageView) itemView.findViewById(R.id.removeView);
            bookImageView = (ImageView) itemView.findViewById(R.id.bookImageView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            fromTextView = (TextView) itemView.findViewById(R.id.fromTextView);
            lookAtImageView = (ImageView) itemView.findViewById(R.id.lookAtImageView);
            lookAtTextView = (TextView) itemView.findViewById(R.id.lookAtTextView);
        }
    }
}
