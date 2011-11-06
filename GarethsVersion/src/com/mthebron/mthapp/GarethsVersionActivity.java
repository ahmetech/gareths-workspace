package com.mthebron.mthapp;

import java.io.FileNotFoundException;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GarethsVersionActivity extends ListActivity{
    /** Called when the activity is first created. */
	static final String[] Teachers=new String[71];
	static final Teacher[] teacher=makeList();
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);

		  setListAdapter(new ArrayAdapter<String>(this, R.layout.main, Teachers));

		  ListView lv = getListView();
		  lv.setTextFilterEnabled(true);

		  lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		      // When clicked, show a toast with the TextView text
		      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
		          Toast.LENGTH_SHORT).show();
		    }
		  });
	}
    public static Teacher[] makeList() throws FileNotFoundException{
    	Teacher[] blah=TeacherList.MakeList();
    	return blah;
    }
}