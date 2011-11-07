package com.mthebron.mthapp;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
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
		  this.makeList();
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
    public static void makeList(){
    	Teacher[] blah = null;
		try {
			blah = TeacherList.MakeList(null);
		} catch (IOException e) {
			Log.e("error", "error");
		}
    	teacher=blah;
    	for (int i = 0; i < Teachers.length; i++) {
			Teachers[i]=teacher[i].getName();
		}
    }
}