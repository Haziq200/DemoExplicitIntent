package sg.edu.rp.dmsd.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvsuperman;
    TextView tvbatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        tvsuperman = findViewById(R.id.textViewSuperman);
        tvbatman = findViewById(R.id.textViewBatman);

        tvsuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create Hero object of stength 100 & technical 60
                Hero superman = new Hero("Superman",100,60);
                Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);
                //put hero object in intent
                i.putExtra("hero",superman);
                startActivityForResult(i,requestCodeForSupermanStats);

                tvbatman.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Hero batman = new Hero("batman",60,90);
                        Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);
                        // put hero object in intent
                        i.putExtra("hero",batman);
                        startActivityForResult(i,requestCodeForBatmanStats);
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int 				resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";
                // If it is activity started by clicking 				//  Superman, create corresponding String
                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }
                // If 2nd activity started by clicking
                //  Batman, create a corresponding String
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }

                Toast.makeText(MainActivity.this, statement,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
