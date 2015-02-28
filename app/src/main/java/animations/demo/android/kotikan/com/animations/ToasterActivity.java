package animations.demo.android.kotikan.com.animations;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ToasterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toaster);

        final View toastButton = findViewById(R.id.btn_toaster);
        final TextView nameView = (TextView) findViewById(R.id.input_name);
        View.OnClickListener listener = createListenerToToastContentsOf(nameView);

        toastButton.setOnClickListener(listener);
    }

    private View.OnClickListener createListenerToToastContentsOf(final TextView nameView) {
        final Context context = this;

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = nameView.getText();
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();
            }
        };
    }

}
