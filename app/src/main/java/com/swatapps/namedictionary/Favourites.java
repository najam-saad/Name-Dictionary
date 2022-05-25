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

public class Favourites extends ActionBarActivity
{
Toolbar toolbar;
SharedPreferences pref;
String[] favs;
int totalfavs;
TextView you;
ListView favlist;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favourites);
		toolbar = (Toolbar)findViewById(R.id.favourites);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Favourites");
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		getSupportActionBar().setHomeAsUpIndicator(upArrow);
		you = (TextView)findViewById(R.id.textview1);
		favlist = (ListView)findViewById(R.id.favlist);
		pref = getSharedPreferences("favourites", Context.MODE_PRIVATE);
		totalfavs = pref.getInt("totalfav",0);
		if(totalfavs==0){
			you.setVisibility(View.VISIBLE);
			favlist.setVisibility(View.GONE);
			
		}else{
		favs =new String[totalfavs];
		for(int i = 0; i<totalfavs;i++){
			int b = i+1;
			favs[i] = pref.getString("name"+b,"");
		}
		ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,R.layout.row2,favs);
		
		favlist.setAdapter(Adapter);
			favlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
						//... your stuffi
						TextView textview = (TextView)view;
						String text = textview.getText().toString();
						Intent i =new Intent(Favourites.this,MainActivity.class);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("ReceivedName", text);
						editor.apply();
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

		getMenuInflater().inflate(R.menu.favourites,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		switch(item.getItemId()){
			case R.id.favdelete:
				AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialogStyle);
				builder.setMessage("Do You Want To Clear Favourites")
					.setPositiveButton("Delete",new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog , int id){
							SharedPreferences.Editor ed = pref.edit();
							ed.clear().apply();
							favlist.setVisibility(View.GONE);
							you.setVisibility(View.VISIBLE);
						}
					})
					.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog , int id){
							dialog.cancel();
						}
					})
					;
				AlertDialog alert =builder.create();
				alert.setTitle("Favourites");
				alert.show();
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}


}




