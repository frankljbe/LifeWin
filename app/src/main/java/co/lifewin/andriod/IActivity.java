package co.lifewin.andriod;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


public class IActivity extends Activity {

    private DrawerLayout drawerLayout;
    private LinearLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void loadDrawer()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer = (LinearLayout) findViewById(R.id.left_drawer);
    }

    public void goToMainMenu(View view) {
        if(drawerLayout.isDrawerOpen(drawer))
        {
            drawerLayout.closeDrawer(drawer);
        }
        else
        {
            drawerLayout.openDrawer(drawer);
        }
    }
}
