package co.lifewin.andriod;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class EditUserInfoPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText userNameInputField = (EditText)findViewById(R.id.user_name_input);
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences(Constants.UserSettings.UserSettingsRoot, MODE_PRIVATE);
        setupUserView(settings);
        setContentView(R.layout.activity_edit_user_info_page);
    }

    private void setupUserView(SharedPreferences userSettings)
    {
        String userName = userSettings.getString(Constants.UserSettings.UserSettingsRoot, "Enter a name:");
        EditText userNameDisplay = (EditText) findViewById(R.id.user_name_input);
        userNameDisplay.setText(userName);
        userNameDisplay.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    saveContents(Constants.UserSettings.UserNameKey, v);
            }
        });
    }

    private void saveContents(String settingKey, View textBox)
    {
        SharedPreferences settings = getSharedPreferences(Constants.UserSettings.UserSettingsRoot, MODE_PRIVATE);
        String newValue = String.valueOf(((EditText)textBox).getText());
        settings.edit().putString(settingKey, newValue);

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
