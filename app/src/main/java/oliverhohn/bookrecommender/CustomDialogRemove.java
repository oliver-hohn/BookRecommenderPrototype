package oliverhohn.bookrecommender;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

/**
 * Created by Oliver on 08/12/2016.
 */
public class CustomDialogRemove extends Dialog {
    private View.OnClickListener yesOnClick;
    private View.OnClickListener noOnClick;
    private String bookTitle;
    private int position;
    public CustomDialogRemove(Activity a, View.OnClickListener yes, View.OnClickListener no, String bookTitle) {
        super(a);
        yesOnClick = yes;
        noOnClick = no;
        this.bookTitle = bookTitle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_remove_dialog);
        TextView yes = (TextView) findViewById(R.id.yesTextView);
        TextView no = (TextView) findViewById(R.id.noTextView);
        TextView remove = (TextView) findViewById(R.id.removeTextView);
        remove.setText("Are you sure you want to remove: "+bookTitle+"?");

        yes.setOnClickListener(yesOnClick);
        no.setOnClickListener(noOnClick);

    }
}
