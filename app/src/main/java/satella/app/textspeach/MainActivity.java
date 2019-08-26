package satella.app.textspeach;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;
    TextToSpeech speSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnGo);
        edt = findViewById(R.id.edt_input);

        speSong = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    speSong.setLanguage(Locale.GERMANY);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edt.getText().toString().trim();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                speSong.speak(str, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}
