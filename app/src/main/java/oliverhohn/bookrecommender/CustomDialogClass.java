package oliverhohn.bookrecommender;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Oliver on 07/12/2016.
 */
public class CustomDialogClass extends Dialog implements android.view.View.OnClickListener {
    public TextView ok;

    public CustomDialogClass(Activity a) {
        super(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        ok = (TextView) findViewById(R.id.okTextView);
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
