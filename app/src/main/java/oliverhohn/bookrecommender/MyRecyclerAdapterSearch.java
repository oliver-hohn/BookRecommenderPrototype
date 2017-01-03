package oliverhohn.bookrecommender;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oliver on 05/12/2016.
 */
public class MyRecyclerAdapterSearch extends  RecyclerView.Adapter<MyRecyclerAdapterSearch.MyHolder> {
    private ArrayList<Book> books;
    public MyAdapterListener onClickListener;

    public interface MyAdapterListener {

        void authorPressed(View v, int position);
        void lookAtPressed(View v, int position);

    }

    public MyRecyclerAdapterSearch(ArrayList<Book> books, MyAdapterListener myAdapterListener){
        this.books = books;
        onClickListener = myAdapterListener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_search_result, null);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        Book book = books.get(position);
        if (book != null){
            holder.bookTitleView.setText(Html.fromHtml("<u>"+book.getTitle()+"</u>"));
            Log.d("SearchAdapter",": "+holder.bookTitleView.getText());
            holder.authorView.setText(Html.fromHtml("from: <u>J.K. Rowling</u>"));
            holder.bookImageView.setImageResource(book.getImage());
            holder.bookTitleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.lookAtPressed(view, position);
                }
            });
            holder.bookImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.lookAtPressed(view, position);
                }
            });
            holder.authorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.authorPressed(view, position);
                }
            });
            holder.lookAtText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.lookAtPressed(view, position);
                }
            });
            holder.lookAtIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.lookAtPressed(view, position);
                }
            });
            holder.descriptionView.setText(book.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        protected ImageView bookImageView;
        protected TextView bookTitleView;
        protected TextView authorView;
        protected TextView descriptionView;
        protected TextView lookAtText;
        protected ImageView lookAtIcon;

        public MyHolder(View itemView) {
            super(itemView);
               bookImageView = (ImageView) itemView.findViewById(R.id.bookImageView);
                bookTitleView = (TextView) itemView.findViewById(R.id.titleView);
                authorView = (TextView) itemView.findViewById(R.id.fromView);
                descriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
                lookAtText = (TextView) itemView.findViewById(R.id.lookAtTextView);
                lookAtIcon = (ImageView) itemView.findViewById(R.id.lookAtImageView);
        }
    }
}
