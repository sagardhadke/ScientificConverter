package net.uniquecomputer.ScientificConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Binarytodecimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binarytodecimal);

        // Giving name to the variables for two EditTexts and two Buttons
        // input is where the user will input the decimal number
        // output is where the user will get the output in the form of binary number
        // submit is the button created to submit the decimal number entered by the user
        // clear is the button to clear the answer
        EditText input, output;
        Button submit, reset;

        // Calling the EditText by id which we gave in xml file
        input = (EditText) findViewById(R.id.editText);
        output = (EditText) findViewById(R.id.output);

        submit = (Button) findViewById(R.id.submit);

        // It is set so that when the user clicks on submit button, the data
        // gets send in the function created below which will convert it and then
        // show the answer to the user in the output
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating a string method argument
                String string = input.getText().toString();

                // Here, we are parsing a string method
                // argument into an integer object
                int i = Integer.parseInt(string, 2);

                // Converts and stores it in the form of string
                String decimal = Integer.toString(i);

                // It will show the output in the second edit text that we created
                output.setText(decimal);
            }
        });

        // Here, we will define a function which will
        // clear the whole text and reset it
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

    }
}

