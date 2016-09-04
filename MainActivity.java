package com.example.parkjohnug.checker;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import java.util.ArrayList;

public class MainActivity extends Activity {
// Declare references

    EditText userInput;
    ListView recordsTextView;
    ArrayAdapter<String> Adapter;
    ArrayList<String> Items;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.user_Input);
        recordsTextView = (ListView) findViewById(R.id.records_TextView);

        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice);
        recordsTextView.setAdapter(Adapter);
        recordsTextView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        /* Can pass nulls because of the constants in the helper.
         * the 1 means version 1 so don't run update.
         */
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();


    }
    //Print the database
    public void printDatabase(){
        Items = new ArrayList<String>();
        String dbString = dbHandler.databaseToString();
        Items.add(dbString);
        userInput.setText("");
        Adapter.notifyDataSetChanged();
    }

    //add your elements onclick methods.
    //Add a product to the database
    public void addButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        Products product = new Products(userInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        // dbHandler delete needs string to find in the db
        String inputText = userInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

}