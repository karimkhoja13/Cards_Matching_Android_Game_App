package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void aboutPage(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void scorePage(View view) {
        Intent intent = new Intent(getApplicationContext(), ScoreboardActivity.class);
        startActivity(intent);
    }

    public void gamePage (View view) {
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText);

        if (editText.getText().toString().equals("")) {
            editText.setText("Guest");
        }
        intent.putExtra("Name", editText.getText().toString());
        startActivity(intent);
    }
}