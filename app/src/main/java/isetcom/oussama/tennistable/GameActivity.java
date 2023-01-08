package isetcom.oussama.tennistable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    Spinner spinnerFirst, spinnerSecond;
    Button btnTeam1, btnTeam2;
    TextView add1, add2, minus1, minus2;
    int team1score, team2score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        spinnerFirst = this.findViewById(R.id.spinnerfirst);
        spinnerSecond = this.findViewById(R.id.spinnersecond);
        btnTeam1 = this.findViewById(R.id.btnteam1);
        btnTeam2 = this.findViewById(R.id.btnteam2);
        add1 = this.findViewById(R.id.add1);
        add2 = this.findViewById(R.id.add2);
        minus1 = this.findViewById(R.id.dim1);
        minus2 = this.findViewById(R.id.dim2);
        team1score = 0;
        team2score = 0;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirst.setAdapter(adapter);
        spinnerFirst.setSelection(-1);
        spinnerSecond.setAdapter(adapter);
        spinnerSecond.setSelection(-1);

        spinnerFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                team1score++;
                btnTeam1.setText(String.valueOf(team1score));
                spinnerFirst.setSelection(-1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinnerSecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                team2score++;
                btnTeam2.setText(String.valueOf(team2score));
                spinnerFirst.setSelection(-1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1score++;
                btnTeam1.setText(String.valueOf(team1score));
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team2score++;
                btnTeam2.setText(String.valueOf(team2score));
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1score--;
                btnTeam1.setText(String.valueOf(team1score));
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team2score--;
                btnTeam2.setText(String.valueOf(team2score));
            }
        });


    }
}