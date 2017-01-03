package oliverhohn.bookrecommender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                Log.d(TAG, "Clicked login button, with username text: "+usernameTextView.getText()+ " and password text: "+passwordTextView.getText());
                if(verifyPassword(usernameTextView.getText().toString(), passwordTextView.getText().toString())){
                    //Can move onto home page
                    Log.d(TAG, "Moving onto home page");
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }
            }
        });

        TextView forgotTextView = (TextView) findViewById(R.id.forgotTextView);
        forgotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked on Forgot Password Text");
                showToast("Feature coming soon.");
            }
        });

        TextView registerTextView = (TextView) findViewById(R.id.registerTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked on Register Text");
                showToast("Feature coming soon.");
            }
        });
    }

    private boolean verifyPassword(String username, String password){//commented out to move onto HomeActivity faster
        //return username.equals("harrypotter") && password.equals("1234");
        return true;
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

