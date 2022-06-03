package sg.edu.rp.c346.id21021785.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();

        alColours.add(0, "Red");
        alColours.add(1, "Orange");

        aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newColour = etElement.getText().toString();
                String newColourIndex = etIndexElement.getText().toString();
                int pos = alColours.size();
                if (!newColourIndex.equals("")) {
                    pos = Integer.parseInt(newColourIndex);
                }
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newColourIndex = etIndexElement.getText().toString();
                int pos = alColours.size();
                if (!newColourIndex.equals("")) {
                    pos = Integer.parseInt(newColourIndex);
                }
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newColour = etElement.getText().toString();
                String newColourIndex = etIndexElement.getText().toString();
                int pos = alColours.size()-1;
                if (!newColourIndex.equals("")) {
                    pos = Integer.parseInt(newColourIndex);
                }
                alColours.set(pos, newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });

    }
}