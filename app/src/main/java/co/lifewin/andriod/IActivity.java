package co.lifewin.andriod;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


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
        ListView navigationButtons = (ListView) findViewById(R.id.navigation_buttons);
        final Context thisClass = this;
        navigationButtons.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CharSequence result = ((TextView) view).getText();
                        Intent intent;
                        final String classPrefix = "co.lifewin.andriod.Main";
                        Class newIntent = null;
                        try {
                            newIntent = Class.forName(classPrefix + result);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        intent = new Intent(thisClass, newIntent);
                        startActivity(intent);

                    }
                }
        );
    }

    public void setTitle(int newTitleId)
    {
         String newTitle = getString(newTitleId);
        ((TextView)findViewById(R.id.page_title)).setText(newTitle);
    }

    public void toggleNavigationDrawer(View view) {
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
