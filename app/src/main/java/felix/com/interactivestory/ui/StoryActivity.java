package felix.com.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import felix.com.interactivestory.R;
import felix.com.interactivestory.model.Page;

public class StoryActivity extends AppCompatActivity {
    private static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if (name == null || name.isEmpty()) {
            name = "Bot";
        }
        //Toast.makeText(this, name, Toast.LENGTH_LONG).show();

    }

}
