package oliverhohn.bookrecommender;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Oliver on 07/12/2016.
 */
public class CustomDialogPurchase extends Dialog  {


    public CustomDialogPurchase(Activity a) {
        super(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_purchase_dialog);


    }


}