package com.example.wordcounter_av_2pd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView fptxt;
    Button fpbutton;
    EditText fptxtinput;
    Spinner fpspinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fptxt = findViewById(R.id.fptxt);
        fpbutton = findViewById(R.id.fpbutton);
        fptxtinput = findViewById(R.id.fptxtinput);
        fpspinner = findViewById(R.id.fpspinner);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fpbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Kodas skirtas gauti įvestą tekstą iš fptxtinput
            String inputText = fptxtinput.getText().toString();

            // Patikrinti, ar tekstas tuščias (ar nėra tik tarpų)
            if (inputText.trim().isEmpty()) {
                // Jei tekstas tuščias, parodomas Toast pranešimas (įvest tekstą)
                Toast.makeText(MainActivity.this, R.string.toastemptyinput, Toast.LENGTH_SHORT).show();
            } else {

                // Pasirenku, ar skaičiuoti žodžius ar raides iš Spinner pasirinkimo
                String selectedOption = fpspinner.getSelectedItem().toString();
                int result;

                // Tikrinu, ką vartotojas pasirinko Spinner elemente (Words ar Characters)
                if (selectedOption.equals(getString(R.string.words_option))) {
                    result = TextCounter.countWords(inputText);  // Skaičiuoju žodžius
                } else {
                    result = TextCounter.countCharacters(inputText);  // Skaičiuoju raides
                }

                // Rodomas rezultatas TextView elemente
                fptxt.setText("Result: " + result);
            }
        }
    });


    }
}
