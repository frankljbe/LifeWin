package co.lifewin.andriod;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class EditUserInfoPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info_page);
    }

    private void setupUserView()
    {
        SharedPreferences userSettings = getSharedPreferences(Constants.UserSettings.UserSettingsRoot, MODE_PRIVATE);
        String userName = userSettings.getString(Constants.UserSettings.UserNameKey, "");
        EditText userNameDisplay = (EditText) findViewById(R.id.user_name_input);
        userNameDisplay.setText(userName);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupUserView();
    }

    @Override
    public void onPause() {
        super.onPause();
        saveContents(Constants.UserSettings.UserNameKey, findViewById(R.id.user_name_input));
    }

    private void saveContents(String settingKey, View textBox)
    {
        SharedPreferences settings = getSharedPreferences(Constants.UserSettings.UserSettingsRoot, MODE_PRIVATE);
        String newValue = ((EditText)textBox).getText().toString();
        settings.edit().putString(settingKey, newValue).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_user_info_page, menu);
        return true;
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
