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

/**
 * Created by Oliver on 08/12/2016.
 */
public class CustomDialogRemove extends Dialog {
    private View.OnClickListener yesOnClick;
    private View.OnClickListener noOnClick;
    private int position;
    public CustomDialogRemove(Activity a, View.OnClickListener yes, View.OnClickListener no) {
        super(a);
        yesOnClick = yes;
        noOnClick = no;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_remove_dialog);
        Button yes = (Button) findViewById(R.id.yesButton);
        Button no = (Button) findViewById(R.id.noButton);

        yes.setOnClickListener(yesOnClick);
         no.setOnClickListener(noOnClick);

    }
}
