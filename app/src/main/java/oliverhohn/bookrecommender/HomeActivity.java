package oliverhohn.bookrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Logged In as:");
        getSupportActionBar().setSubtitle("Oliver Hohn @ Maughan Library");

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
        TextView searchView = (TextView) findViewById(R.id.searchTextView);
        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        //handle enter pressed in search view.
        //set recycler view
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(R.drawable.book1, "Harry Potter and the\n Philosopher's Stone"));
        books.add(new Book(R.drawable.book1, "Harry Potter and the\n Chamber of Secrets"));
        books.add(new Book(R.drawable.book1, "Harry Potter and the\n  Prisoner of Azkaban"));

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(books);
        recyclerView1.setAdapter(myRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);

        ItemClickSupport.addTo(recyclerView1).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.d(TAG, "Pressed item at position: "+position);
            }
        });

        recyclerView2.setAdapter(myRecyclerAdapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView2.setLayoutManager(linearLayoutManager2);

        ItemClickSupport.addTo(recyclerView2).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.d(TAG, "Pressed item at position: "+position);
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

    public void onFilterPressed(View view){
        Log.d(TAG, "Pressed Filter");
    }
    public void onBarcodePressed(View view){
        Log.d(TAG, "Pressed Barcode");
    }
    public void onSearchPressed(View view){
        Log.d(TAG, "Pressed Search");
    }
}
