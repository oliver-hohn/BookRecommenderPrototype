package oliverhohn.bookrecommender;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity  {
    private final static String TAG = "LoginActivity";
    private TextView usernameTextView;
    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG,"Loaded view");

        setReferences();
    }

    private void setReferences(){
        usernameTextView = (TextView) findViewById(R.id.usernameField);
        passwordTextView = (TextView) findViewById(R.id.passwordField);

        TextView loginButtonView = (Button) findViewById(R.id.loginButtonView);
        loginButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Clicked login button, with username text: "+usernameTextView.getText()+ " and password text: "+passwordTextView.getText());
            }
        });
    }


}

