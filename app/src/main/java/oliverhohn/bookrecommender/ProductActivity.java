package oliverhohn.bookrecommender;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "ProductActivity";
    private Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Logged In as:");
        getSupportActionBar().setSubtitle("Harry Potter @ Hogwarts Library");


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
        TextView addBasket = (TextView) findViewById(R.id.addBasket);
        TextView writeReview = (TextView) findViewById(R.id.writeReview);
        TextView locate = (TextView) findViewById(R.id.locate);
        TextView bookTitle = (TextView) findViewById(R.id.titleTextView);
        TextView author = (TextView) findViewById(R.id.authorTextView);
        TextView description = (TextView) findViewById(R.id.descriptionTextView);
        ImageView bookImage = (ImageView) findViewById(R.id.bookImageView);
        description.setMovementMethod(new ScrollingMovementMethod());
        TextView backTextView = (TextView) findViewById(R.id.backTextView);

        ScrollView parentScrollView = (ScrollView) findViewById(R.id.parentScrollView);
        parentScrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.v(TAG, "PARENT TOUCH");

                findViewById(R.id.descriptionTextView).getParent()
                        .requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });

        description.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.v(TAG, "CHILD TOUCH");

                // Disallow the touch request for parent scroll on touch of  child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        addBasket.setPaintFlags(addBasket.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        writeReview.setPaintFlags(writeReview.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        int position = 0;
        if(intent != null){
            position = intent.getIntExtra("position",0);
            book = Singleton.getInstance().getBooks().get(position);
            bookTitle.setText(book.getTitle());
            bookImage.setImageResource(book.getImage());
            author.setText(Html.fromHtml("from: <u>"+book.getAuthor()+"<u>"));
            description.setText(book.getDescription());
            String result = intent.getStringExtra("from");
            if(result.equals("HomeActivity")){
                backTextView.setText(Html.fromHtml("Back"));
            }else if(result.equals("SearchActivity")){
                backTextView.setText(Html.fromHtml("Back to Results"));
            }
        }




        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyRecyclerAdapterReview myRecyclerAdapterReview = new MyRecyclerAdapterReview(Singleton.getInstance().getReviews(), new MyRecyclerAdapterReview.MyAdapterListener() {

            @Override
            public void thumbsUp(int position) {
                Log.d(TAG, "Thumbs up pressed at: "+position);
            }

            @Override
            public void thumbsDown(int position) {
                Log.d(TAG, "Thumbs down pressed at: "+position);
            }

            @Override
            public void report(int position) {
                Log.d(TAG, "Report pressed at: "+position);
                showToast("Feature coming soon");
            }

            @Override
            public void hide(int position) {
                Log.d(TAG, "Hide pressed at: "+position);
                showToast("Feature coming soon");
            }
        }, getApplicationContext());
        recyclerView.setAdapter(myRecyclerAdapterReview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.d(TAG, "Pressed item at position: " + position);
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

    public void onAddBasketPressed(View view){
        Log.d(TAG, "Add to basket pressed");
    }

    public void onWriteReviewPressed(View view){
        Log.d(TAG, "Write a review pressed");
        Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
        intent.putExtra("fromBook",book.getTitle());
        startActivity(intent);
    }

    public void onLocatePressed(View view){
        Log.d(TAG, "Locate pressed");
    }
    public void onBackPressed(View view){
        onBackPressed();
    }
}
