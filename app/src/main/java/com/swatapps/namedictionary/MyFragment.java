package com.swatapps.namedictionary;
import android.annotation.*;
import android.view.*;
import android.os.*;
import android.support.v4.app.*;
import android.widget.*;
import android.graphics.*;
import android.support.v7.widget.*;
import android.text.style.*;
import android.view.View.*;
import android.speech.tts.*;
import java.util.*;
import java.io.*;
import android.content.*;
import android.net.*;
   
public class MyFragment extends Fragment {
	String decider;
	TextToSpeech tts;
	int color;
	TextView name;
	TextView meaning;
	TextView gender;

	TextView origin;
	TextView luckyNos;
	TextView namevalue;
	TextView meaningvalue;
	TextView gendervalue;
	TextView originvalue;
	TextView luckyvalue;
	String nameS,meaningS,genderS,originS,luckyNosS,urdunameS,urdumeaningS,urduoriginS,urdugenderS,urduluckyNoS;
	CardView english;
	CardView urdu;
	TextView urduname, urdunamevalue, urdumeaning, urdumeaningvalue, urdugender, urdugendervalue, urduorigin, urduoriginvalue, urdulucky, urduluckyvalue;
	ImageView audio;
	ImageView fav;
	ImageView share;
	ImageView favurdu;
	ImageView shareurdu;
	View view;
	SharedPreferences shared;
	SharedPreferences.Editor editor;
	int intention;
	public MyFragment() {
	}
	
	public MyFragment(String type, String name, String meaning, String gender, String origin, String luckyNo,String urduname,String urdumeaning,String urduorigin,String urdugender,String urduluckyNo) {
      decider = type;
	  nameS=name;
	  meaningS=meaning;
	  genderS=gender;
	  originS=origin;
	  luckyNosS=luckyNo;
	  urdunameS=urduname;
	  urdumeaningS=urdumeaning;
	  urduoriginS=urduorigin;
	  urdugenderS=urdugender;
	  urduluckyNoS=urduluckyNo;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment, container, false);
		name= (TextView)view.findViewById(R.id.name);
		meaning=(TextView)view.findViewById(R.id.meaning);
		gender=(TextView)view.findViewById(R.id.gender);
	    origin=(TextView)view.findViewById(R.id.origin);
		luckyNos=(TextView)view.findViewById(R.id.lucky);
		namevalue=(TextView)view.findViewById(R.id.namevalue);
		meaningvalue=(TextView)view.findViewById(R.id.meaningvalue);
		gendervalue=(TextView)view.findViewById(R.id.gendervalue);
		originvalue=(TextView)view.findViewById(R.id.originvalue);
		luckyvalue=(TextView)view.findViewById(R.id.luckyvalue);
		urduname = (TextView)view.findViewById(R.id.urduname);
		urdumeaning = (TextView)view.findViewById(R.id.urdumeaning);
		urdugender = (TextView)view.findViewById(R.id.urdugender);
		urduorigin = (TextView)view.findViewById(R.id.urduorigin);
		urdulucky = (TextView)view.findViewById(R.id.urdulucky);
		urdunamevalue = (TextView)view.findViewById(R.id.urdunamevalue);
		urdumeaningvalue = (TextView)view.findViewById(R.id.urdumeaningvalue);
		urdugendervalue = (TextView)view.findViewById(R.id.urdugendervalue);
		urduoriginvalue = (TextView)view.findViewById(R.id.urduoriginvalue);
		urduluckyvalue = (TextView)view.findViewById(R.id.urduluckyvalue);
		english=(CardView)view.findViewById(R.id.english);
		urdu=(CardView)view.findViewById(R.id.urdu);
		audio = (ImageView)view.findViewById(R.id.audio);
		fav = (ImageView)view.findViewById(R.id.fav);
		share = (ImageView)view.findViewById(R.id.share);
		favurdu = (ImageView)view.findViewById(R.id.urdufav);
		shareurdu = (ImageView)view.findViewById(R.id.urdushare);
		shared = getActivity().getSharedPreferences("favourites",Context.MODE_PRIVATE);
		editor = shared.edit();
		if(decider.equals("English")){
			urdu.setVisibility(View.GONE);
		}else{
			english.setVisibility(View.GONE);
		}
		 
		Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"fonts/myfonts3.ttf"); 
		name.setTypeface(type);
		meaning.setTypeface(type);
     	gender.setTypeface(type);
		origin.setTypeface(type);
	    luckyNos.setTypeface(type);
		Typeface type2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/myfonts3.ttf"); 
		namevalue.setTypeface(type2);
		meaningvalue.setTypeface(type2);
		gendervalue.setTypeface(type2);
		originvalue.setTypeface(type2);
    	luckyvalue.setTypeface(type2);
		Typeface type3 =Typeface.createFromAsset(getActivity().getAssets(),"fonts/myfonts8.ttf");
		urdunamevalue.setTypeface(type3);
		urdumeaningvalue.setTypeface(type3);
		urdugendervalue.setTypeface(type3);
		urduoriginvalue.setTypeface(type3);
		urduluckyvalue.setTypeface(type3);
		urduname.setTypeface(type3);
		urdumeaning.setTypeface(type3);
		urdugender.setTypeface(type3);
		urduorigin.setTypeface(type3);
		urdulucky.setTypeface(type3);
		namevalue.setText(nameS);
		meaningvalue.setText(meaningS);
		gendervalue.setText(genderS);
		originvalue.setText(originS);
		luckyvalue.setText(luckyNosS);
		intention = 0;
		urdunamevalue.setText(urdunameS);
		urdumeaningvalue.setText(urdumeaningS);
		urduoriginvalue.setText(urduoriginS);
		urdugendervalue.setText(urdugenderS);
		urduluckyvalue.setText(urduluckyNoS);
		if(decider.equals("English")){
		tts = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener(){

				@Override
				public void onInit(int p1)
				{if(p1 != TextToSpeech.ERROR){
						tts.setLanguage(Locale.ENGLISH);
						int apiNo=Integer.valueOf(android.os.Build.VERSION.SDK);
						if(apiNo>13){
							tts.setSpeechRate(0.8f);
							tts.setPitch(0.8f);
						}
				}
				}
		});}
		
		
	    audio.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{tts.speak(name.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
					tts.speak(namevalue.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(meaning.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(meaningvalue.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(gender.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(gendervalue.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(origin.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak(originvalue.getText().toString(),TextToSpeech.QUEUE_ADD,null);
					tts.speak("Lucky number",TextToSpeech.QUEUE_ADD,null);
					tts.speak(luckyvalue.getText().toString(),TextToSpeech.QUEUE_ADD,null);
				
				}	
		});
		fav.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{  
				
				    if(intention==0){
					int totalfavourites = shared.getInt("totalfav",0);
					int newNumber = totalfavourites+1;
					editor.putInt("totalfav",newNumber);
					editor.putString("name"+newNumber, namevalue.getText().toString());
					Toast.makeText(getActivity(), "Added To Favourites", Toast.LENGTH_SHORT).show();
                    editor.apply();
					intention++;}
					else {
						Toast.makeText(getActivity(),"Already In Favourites",Toast.LENGTH_SHORT).show();
					}
				}	
			});
			favurdu.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{  
				
				    if(intention==0){
					int totalfavourites = shared.getInt("totalfav",0);
					int newNumber = totalfavourites+1;
					editor.putInt("totalfav",newNumber);
					editor.putString("name"+newNumber, namevalue.getText().toString());
					Toast.makeText(getActivity(), "Added To Favourites", Toast.LENGTH_SHORT).show();
                    editor.apply();
					intention++;}
					else {
						Toast.makeText(getActivity(),"Already In Favourites",Toast.LENGTH_SHORT).show();
					}
				}	
			});
		share.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
                shareImage(namevalue.getText().toString());
				}	
			});
		return view;
	}

	@Override
	public void onDestroyView()
	{
		// TODO: Implement this method
		super.onDestroyView();
		if(tts != null){
			tts.stop();
			tts.shutdown();
		}
	}

	@Override
	public void onPause()
	{
		// TODO: Implement this method
		super.onPause();
		if(tts != null){
			tts.stop();
		}
	}   
    
	public void setMeaning(String name,String meaning,String gender,String origin,String LuckyNos){
		namevalue.setText(name);
		meaningvalue.setText(meaning);
		gendervalue.setText(gender);
		originvalue.setText(origin);
		luckyvalue.setText(LuckyNos);
		
	}
	  public void shareImage(String name){
       File folder=new File(Environment.getExternalStorageDirectory().toString()+File.separator+"Name Dictionary Images");	
	   try{
		   View v = view.findViewById(R.id.englishLayout);
		   v.setDrawingCacheEnabled(true);
		   Bitmap bitmap = Bitmap.createBitmap(v.getDrawingCache());
		   v.setDrawingCacheEnabled(false);
		   File imagefile = new File(Environment.getExternalStorageDirectory().toString()+"/"+"Name Dictionary Images"+"/"+name+".jpg");
		   FileOutputStream fileOutput = new FileOutputStream(imagefile);
		   bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutput);
		   fileOutput.flush();
		   fileOutput.close();
		   Toast.makeText(getActivity(),"Image saved at "+Environment.getExternalStorageDirectory()+"/Name Dictionary Images/"+name,Toast.LENGTH_LONG).show();
		   Intent i = new Intent(Intent.ACTION_SEND);
		   i.setType("image/*");
		   Uri uri = Uri.fromFile(imagefile);
		   i.putExtra(Intent.EXTRA_STREAM,uri);
		   i.putExtra(Intent.EXTRA_TEXT,"");
		   startActivity(i.createChooser(i,"Choose an App"));
	   }catch(Throwable e){
		   e.printStackTrace();
		   Toast.makeText(getActivity(),"Failed to save",Toast.LENGTH_LONG).show();
	   }
	  }
}     
