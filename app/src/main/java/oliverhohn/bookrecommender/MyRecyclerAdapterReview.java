package oliverhohn.bookrecommender;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oliver on 06/12/2016.
 */
public class MyRecyclerAdapterReview extends RecyclerView.Adapter<MyRecyclerAdapterReview.MyHolder> {
    public interface MyAdapterListener{
        void thumbsUp(int position);
        void thumbsDown(int position);
        void report(int position);
        void hide(int position);
    }
    private MyAdapterListener myAdapterListener;
    private ArrayList<Review> reviews;
    private Context context;

    public MyRecyclerAdapterReview(ArrayList<Review> reviews, MyAdapterListener myAdapterListener, Context context){
        this.reviews = reviews;
        this.myAdapterListener = myAdapterListener;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_review_row, null);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        Review review = reviews.get(position);
        int rating = review.getRating();
        if(rating>0){
            holder.star1.setImageResource(R.drawable.starfilled_24);
            holder.star1.setColorFilter(ContextCompat.getColor(context,R.color.colorSecondaryText));
        }if(rating>1){
            holder.star2.setImageResource(R.drawable.starfilled_24);
            holder.star2.setColorFilter(ContextCompat.getColor(context,R.color.colorSecondaryText));
        }if(rating>2){
            holder.star3.setImageResource(R.drawable.starfilled_24);
            holder.star3.setColorFilter(ContextCompat.getColor(context,R.color.colorSecondaryText));
        }if(rating>3){
            holder.star4.setImageResource(R.drawable.starfilled_24);
            holder.star4.setColorFilter(ContextCompat.getColor(context,R.color.colorSecondaryText));
        }if(rating>4){
            holder.star5.setImageResource(R.drawable.starfilled_24);
            holder.star5.setColorFilter(ContextCompat.getColor(context,R.color.colorSecondaryText));
        }
        holder.title.setText(review.getTitle());
        holder.thumbsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapterListener.thumbsUp(position);
                holder.thumbsUp.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
                holder.thumbsDown.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimaryText));
                holder.likeNum.setText(String.valueOf(new Integer(holder.likeNum.getText().toString()).intValue()+1));
            }
        });
        holder.thumbsDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapterListener.thumbsDown(position);
                holder.thumbsDown.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary));
                holder.thumbsUp.setColorFilter(ContextCompat.getColor(context,R.color.colorPrimaryText));
                holder.dissNum.setText(String.valueOf(new Integer(holder.dissNum.getText().toString()).intValue()+1));
            }
        });
        holder.report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapterListener.report(position);
            }
        });
        holder.hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapterListener.hide(position);
            }
        });

        if(review.getType() == Review.type.TEXT){
            holder.description.setText(review.getDescription());
            holder.description.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        protected ImageView star1;
        protected ImageView star2;
        protected ImageView star3;
        protected ImageView star4;
        protected ImageView star5;
        protected TextView title;
        protected ImageView thumbsUp;
        protected ImageView thumbsDown;
        protected TextView hide;
        protected TextView report;
        protected TextView description;
        protected TextView likeNum;
        protected TextView dissNum;
        public MyHolder(View itemView) {
            super(itemView);
            star1 = (ImageView) itemView.findViewById(R.id.star1);
            star2 = (ImageView) itemView.findViewById(R.id.star2);
            star3 = (ImageView) itemView.findViewById(R.id.star3);
            star4 = (ImageView) itemView.findViewById(R.id.star4);
            star5 = (ImageView) itemView.findViewById(R.id.star5);
            title = (TextView) itemView.findViewById(R.id.reviewTitle);
            thumbsUp = (ImageView) itemView.findViewById(R.id.thumbsup);
            thumbsDown = (ImageView) itemView.findViewById(R.id.thumbsdown);
            hide = (TextView) itemView.findViewById(R.id.hideView);
            report = (TextView) itemView.findViewById(R.id.reportView);
            description = (TextView) itemView.findViewById(R.id.reviewDescription);
            likeNum = (TextView) itemView.findViewById(R.id.likeNum);
            dissNum = (TextView) itemView.findViewById(R.id.dissNum);
        }
    }
}
