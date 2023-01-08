package isetcom.oussama.tennistable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout team2;
    RadioGroup rgtype;
    RadioButton rbsolos, rbduos, rb3manches, rb4manches;
    Button btnStart;
    EditText firstName,secondName, thirdName,fourthName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team2 = (LinearLayout) this.findViewById(R.id.team2);
        rbsolos = this.findViewById(R.id.rbsolos);
        rbduos = this.findViewById(R.id.rbduos);
        rb3manches = this.findViewById(R.id.rb3manche);
        rb4manches = this.findViewById(R.id.rb4manche);
        rgtype = this.findViewById(R.id.rgtype);
        btnStart = this.findViewById(R.id.btnStart);
        firstName = this.findViewById(R.id.firstName);
        secondName = this.findViewById(R.id.secondName);
        thirdName = this.findViewById(R.id.thirdName);
        fourthName = this.findViewById(R.id.fourthName);


        team2.setVisibility(View.GONE);
        rgtype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = group.findViewById(checkedId);
                String selectedOption = selectedRadioButton.getText().toString();
                if (selectedOption.equals("Solo")) {
                    team2.setVisibility(View.GONE);
                } else if (selectedOption.equals("Duo"))  {
                    team2.setVisibility(View.VISIBLE);
                }
                // Perform some action based on the selected option
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerName = firstName.getText().toString();
                if(!(playerName.equals(""))){

                    Intent i = new Intent(MainActivity.this, GameActivity.class);
                    i.putExtra("startGame", playerName);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.notifErreur), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}