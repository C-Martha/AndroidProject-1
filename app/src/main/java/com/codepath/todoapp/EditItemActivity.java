package com.codepath.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //values passed from main activity
        String itemToEdit = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("pos", 0);

        EditText editItemText = (EditText)findViewById(R.id.editItemText);
        editItemText.setText(itemToEdit);
        editItemText.setSelection(editItemText.getText().length());

    }

    public void onSubmit(View v){
        EditText editItemText = (EditText)findViewById(R.id.editItemText);

        Intent data = new Intent();

        //values to send back to main activity
        data.putExtra("newItem", editItemText.getText().toString());
        data.putExtra("pos", position);

        setResult(RESULT_OK, data);
        finish();
    }
}
