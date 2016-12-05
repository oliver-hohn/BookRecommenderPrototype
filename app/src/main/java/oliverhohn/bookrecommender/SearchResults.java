package oliverhohn.bookrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView searchView;
    private final static String TAG = "SearchRes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
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
        String searched = "";
        final ArrayList<Book> books = new ArrayList<>();

        if(intent != null){
            searched = intent.getStringExtra("search");
        }
        if(searched.toLowerCase().contains("harry potter")) {
            books.add(new Book(R.drawable.book1, "Harry Potter and the Philosopher's Stone"));
            books.add(new Book(R.drawable.book2, "Harry Potter and the Chamber of Secrets"));
            books.add(new Book(R.drawable.book3, "Harry Potter and the Half Blood Prince"));
            books.add(new Book(R.drawable.book4, "Harry Potter and the Prisoner of Azkaban"));
            books.add(new Book(R.drawable.book5, "The Penguin History of the\n United States of America"));
        }
        TextView resultfor = (TextView) findViewById(R.id.resultForView);
        if(books.size() > 0) {
            resultfor.setText("Results for: "+searched+"... "+"("+books.size()+" Results)");
        }else{
            resultfor.setText("Results for: "+searched+"... (0 Results)\nSeems like there are no books that match");
        }
        searchView = (TextView) findViewById(R.id.searchTextView);
        searchView.setText(searched);
        searchView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    searchFor(searchView.getText().toString());
                    //search for given text
                    return true;
                }
                return false;
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        if(books.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            MyRecyclerAdapterSearch myRecyclerAdapterSearch = new MyRecyclerAdapterSearch(books, new MyRecyclerAdapterSearch.MyAdapterListener() {
                @Override
                public void authorPressed(View v, int position) {
                    Log.d(TAG, "Author from " + books.get(position).getTitle() + " pressed");
                }

                @Override
                public void lookAtPressed(View v, int position) {
                    Log.d(TAG, "Go to product page for book: " + books.get(position).getTitle());
                    //go to product page of that book
                }


            });
            recyclerView.setAdapter(myRecyclerAdapterSearch);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    Log.d(TAG, "Pressed item at position: " + position);
                }
            });
        }else{
            recyclerView.setVisibility(View.GONE);
        }

    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onFilterPressed(View view){
        Log.d(TAG, "Pressed Filter");
        showToast("Coming soon");
    }
    public void onBarcodePressed(View view){
        Log.d(TAG, "Pressed Barcode");
        showToast("Coming soon");
    }
    public void onSearchPressed(View view){
        Log.d(TAG, "Pressed Search");
        searchFor(searchView.getText().toString());
    }

    private void searchFor(String search){
        Log.d(TAG, "Search for: "+search);
        Intent intent = new Intent(getApplicationContext(), SearchResults.class);
        intent.putExtra("search",search);
        startActivity(intent);
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
}
