package oliverhohn.bookrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "BasketActivity";
    private MyRecyclerAdapterBasket myRecyclerAdapterBasket;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
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
        TextView backTextView = (TextView) findViewById(R.id.backTextView);
        TextView addedBook = (TextView) findViewById(R.id.addedRemoveTextView);
        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        Intent intent = getIntent();
        if(intent != null){
            String addedBookStr = intent.getStringExtra("addedBook");
            String from = intent.getStringExtra("from");
            if(addedBookStr != null){
                addedBook.setText("Added: "+addedBookStr);
                addedBook.setVisibility(View.VISIBLE);
            }else{
                addedBook.setVisibility(View.INVISIBLE);
            }
            if(from.equals("HomeActivity") || from.equals("LocationActivity")){
                backTextView.setText(Html.fromHtml("<u>Back</u>"));
            }else if(from.equals("SearchActivity")){
                backTextView.setText(Html.fromHtml("<u>Back to Results</u>"));
            }else if(from.equals("ProductActivity")){
                backTextView.setText(Html.fromHtml("<u>Back to "+intent.getStringExtra("bookName")+"</u>"));
            }
        }
        if(Singleton.getInstance().getBasket().size() > 0) {
            totalTextView.setText("Price: $XX.XX (" + Singleton.getInstance().getBasket().size() + " items)");
        }else{
            totalTextView.setText("Add Books to your basket!");
        }
        showBooks();
    }

    private void showBooks(){
        final ArrayList<Book> basket = Singleton.getInstance().getBasket();
        final TextView addedRemoveTextView = (TextView) findViewById(R.id.addedRemoveTextView);
        final TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        recyclerView = (RecyclerView) findViewById(R.id.basketRecyclerView);

        myRecyclerAdapterBasket = new MyRecyclerAdapterBasket(basket, new MyRecyclerAdapterBasket.MyAdapterListener() {
            @Override
            public void removeBook(int position) {
                Log.d(TAG, "Need to remove book: "+position);
                Book book = Singleton.getInstance().getBasket().get(position);
                Singleton.getInstance().removeBasket(position);
                //myRecyclerAdapterBasket.notifyItemChanged(position);
                addedRemoveTextView.setText("Removed: "+book.getTitle()+" from your Basket");
                addedRemoveTextView.setVisibility(View.VISIBLE);

                if(Singleton.getInstance().getBasket().size() > 0) {
                    totalTextView.setText("Price: $XX.XX (" + Singleton.getInstance().getBasket().size() + " items)");
                }else{
                    totalTextView.setText("Add Books to your basket!");
                }
                updateRecycler(position);
            }

            @Override
            public void lookAt(int position) {
                Log.d(TAG, "Need to look at: "+position);
                openProduct(position);
            }
        });
        recyclerView.setAdapter(myRecyclerAdapterBasket);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
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

    public void onBackPressed(View view){
        onBackPressed();
    }

    private void updateRecycler(int position) {
        myRecyclerAdapterBasket.notifyItemChanged(position);
        myRecyclerAdapterBasket.notifyDataSetChanged();
    }

    private void openProduct(int position){
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("from","Basket");
        startActivity(intent);
    }

    public void checkout(View view){
        if(Singleton.getInstance().getBasket().size()>0) {
            CustomDialogPurchase customDialogPurchase = new CustomDialogPurchase(this);
            customDialogPurchase.show();
        }
    }
}
