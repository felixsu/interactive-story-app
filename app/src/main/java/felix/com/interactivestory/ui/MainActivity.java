package felix.com.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import felix.com.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mNameField.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() != KeyEvent.ACTION_DOWN)
                    return false;
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    String name = mNameField.getText().toString();
                    startStory(name);
                    return true;
                }
                return false;
            }
        });
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameField.getText().toString();
                startStory(name);
            }
        });
        Log.d(TAG, "Activity created!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }

    private void startStory(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "enter your name", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra(getString(R.string.key_name), name);
            startActivity(intent);
        }
    }
}
