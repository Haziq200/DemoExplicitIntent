package sg.edu.rp.dmsd.demoexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity  extends AppCompatActivity {

    TextView tvName;
    TextView tvStrength;
    TextView tvTechnicalProwess;
    Button btnLike;
    Button btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        //Get the intent
        Intent i = getIntent();
        //Get the Hero object first activity put in Intent
        Hero hero = (Hero)i.getSerializableExtra("hero");

        tvName = findViewById(R.id.textViewName);
        tvStrength = findViewById(R.id.textViewStrength);
        tvTechnicalProwess = findViewById(R.id.textViewTechnicalProwess);
        btnLike = findViewById(R.id.buttonLike);
        btnDislike = findViewById(R.id.buttonDislike);


        //use geteer os Hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strngth: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

// When button Like is clicked, set the results
        //  accordingly and finish() to close this act.

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "like");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();

            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // dislike
                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}
