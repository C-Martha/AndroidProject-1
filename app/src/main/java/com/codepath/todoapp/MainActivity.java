package com.codepath.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvlItems;
    static final int REQUEST_CODE = 1;  // The request code


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvlItems = (ListView)findViewById(R.id.lvlItem);

        readItems();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvlItems.setAdapter(itemsAdapter);

        setUpListViewListener();
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File toDoFile = new File(filesDir, "todo.txt");

        try {
            items = new ArrayList<String>(FileUtils.readLines(toDoFile));
        } catch (IOException e){
            items = new ArrayList<String>();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");

        try {
            FileUtils.writeLines(todoFile, items);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpListViewListener() {
        lvlItems.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        lvlItems.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View item, int pos, long id){
                launchEditView(pos);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

            //edited values returned
            String newItem = data.getExtras().getString("newItem");
            int pos = data.getExtras().getInt("pos");

            int code = data.getExtras().getInt("code", 0);

            //check for empty string, if empty remove item from list
            if(newItem.isEmpty()){
                items.remove(pos);
            } else {
                items.set(pos, newItem);
            }

            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }
    }

    public void launchEditView(int pos){

        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
        String itemToEdit = items.get(pos);
        i.putExtra("pos", pos);
        i.putExtra("item", itemToEdit);
        startActivityForResult(i, REQUEST_CODE);
    }

    public void onAddItem(View v){

        EditText etNewItem = (EditText) findViewById(R.id.etNewItem); //select textfield
        String itemText = etNewItem.getText().toString(); //get the value from the textfield

        //check if new item is empty string, if not empty add to list else do nothing..
        if(!itemText.isEmpty()) {
            itemsAdapter.add(itemText); //add item from text field to the list
            etNewItem.setText(""); //clear textbox
            writeItems();
        }

    }

}