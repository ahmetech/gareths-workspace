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

public class TeacherViewActivity extends ListActivity {
    /** Called when the activity is first created. */
	static final String[] Teachers=new String[71];
	static Teacher[] teacher=new Teacher[71];
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  try {
			this.makeList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
    public static void makeList() throws FileNotFoundException{
    	Teacher[] blah=TeacherList.MakeList();
    	teacher=blah;
    	for (int i = 0; i < Teachers.length; i++) {
			Teachers[i]=teacher[i].getName();
		}
    }
}