package co.lifewin.andriod;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupUserView();
    }

    private void setupUserView()
    {
        SharedPreferences userSettings = getSharedPreferences(Constants.UserSettings.UserSettingsRoot, MODE_PRIVATE);
        String userName = userSettings.getString(Constants.UserSettings.UserNameKey, "");
        TextView userNameDisplay = (TextView) findViewById(R.id.user_name);
        userNameDisplay.setText(userName);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_items, menu);
        return true;
    }

    public void goToEditNameActivity(View view) {
        Intent intent = new Intent(this, EditUserInfoPage.class);
        startActivity(intent);
    }

    public void goToGoalsActivity(View view) {
        Intent intent = new Intent(this, MainGoals.class);
        startActivity(intent);
    }

    public void goToTasksActivity(View view) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
