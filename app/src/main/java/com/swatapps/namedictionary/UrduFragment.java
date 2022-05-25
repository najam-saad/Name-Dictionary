package com.swatapps.namedictionary;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
 
public class UrduFragment extends Fragment
{

	TextView urduname, urdunamevalue, urdumeaning, urdumeaningvalue, urdugender, urdugendervalue, urduorigin, urduoriginvalue, urdulucky, urduluckyvalue;
	ImageView favurdu;
	ImageView shareurdu;
	View view;
	SharedPreferences shared;
	SharedPreferences.Editor editor;
	String name, urdunameS,urdumeaningS,urduoriginS,urdugenderS,urduluckyNoS;
	int intention;
	
	public UrduFragment(String name,String urduname,String urdumeaning,String urduorigin,String urdugender,String urduluckyNo){
		urdunameS=urduname;
		urdumeaningS=urdumeaning;
		urduoriginS=urduorigin;
		urdugenderS=urdugender;
		urduluckyNoS=urduluckyNo;
		this.name=name;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		view = inflater.inflate(R.layout.urdu_fragment, container, false);
		
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
		favurdu = (ImageView)view.findViewById(R.id.urdufav);
		shareurdu = (ImageView)view.findViewById(R.id.urdushare);
		shared = getActivity().getSharedPreferences("favourites",Context.MODE_PRIVATE);
		editor = shared.edit();
		intention = 0;
		
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
		urdunamevalue.setText(urdunameS);
		urdumeaningvalue.setText(urdumeaningS);
		urduoriginvalue.setText(urduoriginS);
		urdugendervalue.setText(urdugenderS);
		urduluckyvalue.setText(urduluckyNoS);
		
		favurdu.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1)
				{  

				    if(intention==0){
						int totalfavourites = shared.getInt("totalfav",0);
						int newNumber = totalfavourites+1;
						editor.putInt("totalfav",newNumber);
						editor.putString("name"+newNumber, name);
						Toast.makeText(getActivity(), "Added To Favourites", Toast.LENGTH_SHORT).show();
						editor.apply();
						intention++;}
					else {
						Toast.makeText(getActivity(),"Already In Favourites",Toast.LENGTH_SHORT).show();
					}
				}	
			});
		return view;
	}
}
