package oliverhohn.bookrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final static String TAG = "ReviewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Logged In as:");
        getSupportActionBar().setSubtitle("Harry Potter @ Hogwarts");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setReferences();
    }

    private void setReferences(){
        Intent intent = getIntent();
        TextView backTextView = (TextView) findViewById(R.id.backTextView);
        TextView givingTextView = (TextView) findViewById(R.id.givingReviewForView);
        if(intent != null){
            String from = intent.getStringExtra("fromBook");
            if(from != null){
                    backTextView.setText(Html.fromHtml("<u>Back to "+from+" </u>"));
                    givingTextView.setText("Giving a Review for "+from+":");
            }
        }

        final ImageView star1 = (ImageView) findViewById(R.id.star1);
        final ImageView star2 = (ImageView) findViewById(R.id.star2);
        final ImageView star3 = (ImageView) findViewById(R.id.star3);
        final ImageView star4 = (ImageView) findViewById(R.id.star4);
        final ImageView star5 = (ImageView) findViewById(R.id.star5);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starfilled);
                star1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star2.setImageResource(R.drawable.star);
                star2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star3.setImageResource(R.drawable.star);
                star3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star4.setImageResource(R.drawable.star);
                star4.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star5.setImageResource(R.drawable.star);
                star5.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starfilled);
                star1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star2.setImageResource(R.drawable.starfilled);
                star2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star3.setImageResource(R.drawable.star);
                star3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star4.setImageResource(R.drawable.star);
                star4.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star5.setImageResource(R.drawable.star);
                star5.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starfilled);
                star1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star2.setImageResource(R.drawable.starfilled);
                star2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star3.setImageResource(R.drawable.starfilled);
                star3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star4.setImageResource(R.drawable.star);
                star4.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
                star5.setImageResource(R.drawable.star);
                star5.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starfilled);
                star1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star2.setImageResource(R.drawable.starfilled);
                star2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star3.setImageResource(R.drawable.starfilled);
                star3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star4.setImageResource(R.drawable.starfilled);
                star4.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star5.setImageResource(R.drawable.star);
                star5.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryText));
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setImageResource(R.drawable.starfilled);
                star1.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star2.setImageResource(R.drawable.starfilled);
                star2.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star3.setImageResource(R.drawable.starfilled);
                star3.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star4.setImageResource(R.drawable.starfilled);
                star4.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                star5.setImageResource(R.drawable.starfilled);
                star5.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_basket:
                Log.d(TAG, "Clicked on basket");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_about:
                Log.d(TAG , "About Navigation pressed");
                showToast("Feature coming soon");
                break;
            case R.id.nav_account:
                Log.d(TAG , "Account Navigation pressed");
                showToast("Feature coming soon");
                break;
            case R.id.nav_settings:
                Log.d(TAG , "Settings Navigation pressed");
                showToast("Feature coming soon");
                break;
            case R.id.nav_logout:
                Log.d(TAG , "Log out Navigation pressed");
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed(View view){
        onBackPressed();
    }

    public void onSubmitPressed(View view){
        Log.d(TAG,"On submit pressed");
        showToast("Review has been submitted");
        onBackPressed();
    }
}
