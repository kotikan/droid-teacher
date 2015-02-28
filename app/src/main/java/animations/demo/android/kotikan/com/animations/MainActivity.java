package animations.demo.android.kotikan.com.animations;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchActivityWhenPressing(R.id.toaster, ToasterActivity.class);
        launchActivityWhenPressing(R.id.rotater, RotaterActivity.class);
    }

    private void launchActivityWhenPressing(int viewId, final Class activityClass) {
        final Context context = this;

        findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, activityClass));
            }
        });
    }

}
