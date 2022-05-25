package com.swatapps.namedictionary;
import android.support.v7.app.*;
import android.os.*;
import android.support.v7.widget.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v4.app.*;
import java.util.*;
import android.view.*;
import android.widget.*;
import android.support.v7.widget.Toolbar;
import android.content.*;
import android.graphics.drawable.*;

public class History extends ActionBarActivity
{Toolbar toolbar;
SharedPreferences pref;
int totalhistory;
String[] history;
TextView you2;
ListView historylist;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		
		toolbar = (Toolbar)findViewById(R.id.history);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("History");
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		getSupportActionBar().setHomeAsUpIndicator(upArrow);
		you2 = (TextView)findViewById(R.id.textview2);
		historylist = (ListView)findViewById(R.id.historylist);
		pref = getSharedPreferences("History", Context.MODE_PRIVATE);
		totalhistory = pref.getInt("totalHistory",0);
		
		if(totalhistory==0){
			you2.setVisibility(View.VISIBLE);
			historylist.setVisibility(View.GONE);

		}else{
			history =new String[totalhistory];
			for(int i = 0; i<totalhistory;i++){
				int b = i+1;
				history[i] = pref.getString("History"+b,"");
			}
			ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,R.layout.row2,history);

			historylist.setAdapter(Adapter);
			historylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
						//... your stuffi
						TextView textview = (TextView)view;
						String text = textview.getText().toString();
						Intent i =new Intent(History.this,MainActivity.class);
						SharedPreferences pref2=  getSharedPreferences("activityNo",Context.MODE_PRIVATE);
						SharedPreferences.Editor editor2 = pref2.edit();
						editor2.putString("ReceivedName", text);
						editor2.apply();
						startActivity(i);
						finish();
					}   

				});




		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		
		getMenuInflater().inflate(R.menu.history,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		switch(item.getItemId()){
			case R.id.historydelete:
				AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialogStyle);
				builder.setMessage("Do You Want To Clear History")
					.setPositiveButton("Delete",new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog , int id){
					    SharedPreferences.Editor ed = pref.edit();
						ed.clear().apply();
					    historylist.setVisibility(View.GONE);
						you2.setVisibility(View.VISIBLE);
						}
					})
					.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog , int id){
							dialog.cancel();
						}
					})
					;
				AlertDialog alert =builder.create();
				alert.setTitle("History");
				alert.show();
				
				return true;
				default:
				return super.onOptionsItemSelected(item);
				
		}	
		

		}
    
        

}

