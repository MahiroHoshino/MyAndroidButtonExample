package app.gentle.buttonexample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mahiro Hoshino on 2018/12/20.
 */
public class ActivityMain extends AppCompatActivity {

    private static boolean isStart = false;
    private static long start = 0;
    private static long end = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        View button = findViewById(R.id.button);

        button.setOnClickListener((View view) -> {
            if(isStart) {
                isStart = false;
                end = System.currentTimeMillis();
                Toast.makeText(this, (end - start) + "ms", Toast.LENGTH_SHORT).show();
                text.setText("ストップ");

                end = 0;
                start = 0;
            } else {
                isStart = true;
                start = System.currentTimeMillis();
                text.setText("スタート");
            }
        });

    }
}
