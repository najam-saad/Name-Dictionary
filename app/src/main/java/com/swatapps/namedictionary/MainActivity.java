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
import android.view.inputmethod.*;
import android.net.*;
import com.google.android.gms.ads.*;

public class MainActivity extends ActionBarActivity 
{  
	Toolbar toolbar;
    ViewPager viewPager;
	TabLayout tabLayout;
	AutoCompleteTextView auto;
    ArrayList meaninglist;
	ArrayList originlist;
	ArrayList luckylist;
	ArrayList genderlist; 
	
	ArrayList urdunamelist;
	ArrayList urdumeaninglist;
	ArrayList urduoriginlist;
	ArrayList urduluckylist; 
	ArrayList urdugenderlist;
	String[] arr = {"Muhammad","Hasaan","Tayyab","Shaheed","Ehtisham","Ihtesham","Ijlal","Najam","Amir","Aamir","Arsalan","Shahid","Fawad","Nisar","Alvi","Moavia","Niazi","Haq","Rasheed","Ibtisam","Intisam","Khursheed/Khurshid","Inam","Ali","Umar/Umer","Abu-Bakr","Sadiq","Farooq","Usman","Ghani","Ameer","Mulazim","Hussain","Hasan","Iqbal","Allama","Imran","Khan","Pervaiz","Musharraf","Chaudhry","Zafar","Hamza","Abbas","Irfan","Kamran","Zeeshan","Nouman","Waqar","Iftikhar","Sajjad","Barkat","Israr","Khursheeda","Ayaz","Muzammil","Laiq","Shah","Liaqat","Summair","Sameer","Saqib","Arham","Moeez/Moiz","Misbah","Mashood","Arshad","Anjum","Gohar","Alyan","Shayaan","Hasnain","Basit","Azfar","Nayab","Rehan","Afnan","Rizwan","Salman","Ghufran","Muqeet","Muqsit","Musaddiq","Mubashir","Sabir","Muqtasid","Shehzad","Ahmad","Hafeez","Sharjeel","Manzoor","Shoaib","Akhtar","Asif","Malik","Razzaq","Abdul","Inzimam","Gul","Sami","Anwar","Wahab","Nabi","Riaz","Nawaz","Sharif","Shahbaz/Shehbaz","Faisal","Zaroon","Mikaal","Zulfiqar","Zarak","Alam","Syed","Ashraf","Shakeel","Ahsan","Shahroz","Zubair","Attaullah","Zahid","Sohaib","Maqsood","Fazal","Shahrukh","Ibrahim","Dawood","Azam","Hammad","Usama","Muslim","Mohsin","Zaheer","Azhar","Hashmi","Azlan","Hafiz","Imad","Jamal","Atif","Aslam","Khanzada","Mazhar","Farhan","Saeed","Haider","Ahsaan","Saima","Samreen","Munazza","Ruhi","Naz","Irum/Erum","Ahza","Amima","Afifa","Faizah","Faiza","Faizan","Anusha","Bushra","Rushda","Ulfat","Ismat","Jahan Ara","Jahan Aara","Jahan","Hoorain","Ishrat","Neelam","Shaheen","Kausar","Maimoona","Sumbal","Kalsoom","Reshma","Reema","Nadia","Nazneen","Sumayya","Zara","Anam","Sajal","Aamna","Ayesha","Zainab","Safeena","Wajeeha","Sundas","Umaima","Mahira","Jaweria","Rizwana","Azka","Khushnuma","Mawra","Urwa","Noor","Sara","Uroosa","Yasoob","Ejaz","Iqra","Madiha","Laraib","Aiman","Tehreem","Nida","Kainat","Asma","Nabeela","Rida","Hina","Rehana","Saba","Tahira","Reham","Fatima","Perveen","Sughra","Hafsa","Hira","Fiza","Salma","Samina","Rubina","Resham","Zahida","Najma","Haseena","Sanam","Tamanna","Samman","Tayyaba","Aleema","Ambreen","Ainnie","Aqsa","Asifa","Khadija","Sana","Sadia","Bareera","Farah","Zoya","Zahra","Gulzar","Mehreen","Momina","Mehjabeen","Laiba","Ghazala","Ghazal","Rasheeda","Mahrukh","Fazila","Shakeela","Jameela","Andleeb","","Batool","Kaneez","Sadaf","Uzair","Tooba","Nafeesa","Maryam","Sakina","Qurat-Ul-Ain","Qosain","Maria","Sania","Diya","Haneefa","Samana","Kiran","Habiba","Ammara","Adia","Naila","Ashi","Safya","Sofia","Abida","Syeda","Saeeda","Jannat","Jabeen","Yasmeen","Gulaab","Samaa","Gharida","Rabia","Nabiha","Nusrat","Shumaila","Neha","Naina","Muskan","Mishal","Kubra","Sehrish","Shehnaz","Nasreen","Aqeela","Mahnoor","Shehzadi","Bilqees","Benish","Khalida","Shama","Nosheen","Mehak","Maham","Imrana","Zulaikha","Rukhsar","Firdous","Naseema","Razia","Hameeda","Zakiya","Hafiza","Sabahat","Shagufta","Atifa","Almaas","Maliha","Malika","Malaika","Saira","Sobia","Fozia","Fehmida","Farida","Shaista","Sidra","Siddiqa","Tahira","Kanwal","Qaisar","Asad","Wajid","Hameed","","",};
	
    String[] meaningArray, originArray,luckyArray,genderArray,urdunameArray,urdumeaningArray,urduoriginArray,urduluckyArray,urdugenderArray;
	String meanings, origins, luckyNos,genders,urdumeanings,urduorigins,urduluckyNos,urdugenders;
	String names;
	String urdunames;
	String receivedurdunames,receivedurdumeanings,receivedorigin,receivedgender,receivedluckyNos, receivednames,receivedmeanings,receivedurduorigin,receivedurdugender,receivedurduluckyNos;
	int activityNo;
	SharedPreferences pref;
	SharedPreferences.Editor editor;
	SharedPreferences pref2;
	SharedPreferences.Editor editor2;
	InterstitialAd ad;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ad = new InterstitialAd(this);
		ad.setAdUnitId("ca-app-pub-6255071395624746/7072626313");
		AdRequest request =new AdRequest.Builder().build();
		ad.loadAd(request);
	    ad.setAdListener(new AdListener(){
			@Override
			public void onAdLoaded(){
				ad.show();
			}
			@Override
			public void onAdClosed(){
				
			}
		});
		AdView mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(request);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		Arrays.sort(arr);
		pref =  getSharedPreferences("activityNo",Context.MODE_PRIVATE);
		pref2 =  getSharedPreferences("History",Context.MODE_PRIVATE);
		editor2 = pref2.edit();
		receivednames= pref.getString("ReceivedName","Muhammad");
	    Handler handler = new Handler();
		Runnable run = new Runnable(){
			@Override
			public void run(){
				ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
				setupViewPager(viewPager);
				TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
				tabLayout.setupWithViewPager(viewPager);
			}
		};
		handler.postDelayed(run, 10);
		
	    auto = (AutoCompleteTextView)findViewById(R.id.auto);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>  
		(this,R.layout.row, arr);
        
	
		auto.setThreshold(1);
		auto.setAdapter(adapter);
		meaninglist = new ArrayList();
        originlist = new ArrayList();
		luckylist = new ArrayList();
		genderlist = new ArrayList();
		urdunamelist = new ArrayList();
		urdumeaninglist = new ArrayList();
        urduoriginlist = new ArrayList();
		urduluckylist = new ArrayList();
		urdugenderlist = new ArrayList();
		setMeaning("Muhammad","Variant Used For Mohammad - FounderOf Islam.Praise -worthy; Glorified,Praised, lauded, commended, ","Arabic","","Male",
		"مرد",
		""
		,"عربی",
				   "تعریف کیا ہوا٬ پغمبرِ اسلام ﷺ کا نام،بہت تعریف کیا ہوا"
		,"محمد");
		setMeaning("Hasaan", "Good, Better,Very handsome,Beautiful", "Arabic", "2", "Male",
		"مرد",
		"٢",
		"عربی",
				   "بہتر,حسین,خوبصورت",
		"حسان"
		);
		setMeaning("Tayyab", "Excl, Pure fragrance ", "Arabic", "3", "Male",
		"مرد",
		"٣",
		"عربی",
			  
		"عمد، نرم ونازک خوشبودار شخصيت ، ہر قسم کی نجاست سے پاک"
		,"طیب");
		setMeaning("Ehtisham", "Glory, honor, greatness,Magnificent,Modesty,Decency", "Arabic", "3", "Male",
		"مرد"
		,"٣"
		,"عربی",
				   "شان، رتبہ، بزرگی،بڑائی،مرتبہ	",
		"احتشام"); 
		setMeaning("Ihtesham", "Glory, honor, greatness,Magnificent,Modesty,Decency", "Arabic", "3", "Male",
		"مرد"
		,"٣"
		,"عربی"
				   ,"شان، رتبہ، بزرگی،بڑائی،مرتبہ	"
		,"احتشام");
		setMeaning("Ijlal", "wertt,Glorification, exaltation, honesty, integrity, fidelity, faithfulness.", "Urdu", "1", "Male",
		"مرد/",
		"١",
		"اردو"
		,"حمدوثنا,رفعت,اوج"
		,"اجلال");
		setMeaning("Ejaz", "", "", "", "Male",
				   "مرد",
				   "",
				   ""
				   ,""
				   ,"اعجاز");
		setMeaning("Najam", "Star,Celestial body", "Arabic", "3", "Male",
		"مرد"
		,"٣"
		,"عربی"
		,"ستاره"
		,"نجم");
		setMeaning("Amir", "One who gives order,Leader(Arabic);Summit of a tree,Tree Top(Hebrew) ", "Arabic/Hebrew", "5", "Male",
		"مرد",
		"٥",
		"عربی/عبرانی",
				   "حاکم,حکم دینے وال, حاکم,حکم دینے وال,بھرا هوا,رهنما",
		"امر");
		setMeaning("Aamir", "One who gives order,Leader(Arabic);Summit of a tree,Tree top(Hebrew) ", "Arabic/Hebrew", "5", "Male",
				   "مرد",
		"٥",
		"عربی/عبرانی"
		,"رھنما,بھرا هوا,حکم دینے والا,,حاکم"
		,"عامر");
		setMeaning("Arsalan", "Lion,King Of Jungle,Brave", "Arabic", "9", "Male",
		"مرد",
		"٩",
		"عربی",
		"شیر,بهادر,نڈر",
		"ارسلان");
		setMeaning("Kumar", "Prince", "Hindi/Arabic", "4", "Male",
		"مرد"
		,"٤"
		,"هندی/عربی",
		"شهزاده,راجا",
		"کومار");
		setMeaning("Kajol", "Kohl, collyrium", "Sansikrat,English", "4", "Female",
		"لڑکی",
		"⁴",
		"سنسیکرت",
		"آنکھ میں لگانے والا لوشن;سرمه",
		"کاجل");
	    setMeaning("Fawad","Heart","Arabic","1","Male",
		"مرد"
		,"١"
		,"عربی"
		,"دل,قلب,نفس",
		"فواد");
	    setMeaning("Shahid","Observer,Witness,","Arabic","4","Male",
		"مرد",
		"٤",
		"عربی"
				   ,"   گواہ، حاضر، مصنف،مانند مماثل "
		,"شاہد");
		setMeaning("Shaheed","Martyr","Arabic","4","Male",
		"مرد"
		,"٤"
		,"عربی",
		"اللہ کی راہ میں جان دینے والا, اچھے کام کے لیے جان قربان کرنے والا, راہِ حق میں مر جانے والا",
		"شھید");
		setMeaning("Nisar","To Strew,To Sacrifice","Arabic","4","Male"
		,"مرد",
		"٤",
		"عربی",
		"نچھاور کرنا,صدقہ"
		,"نثار");
		setMeaning("Alvi","Fan Of Hazrat Ali","Arabic","","Male"
		,"مرد"
		,"",
		"عربی",
		"حضرت علی رضی الله عنه سے منسوب",
		"علوی");
		setMeaning("Niazi","Requester,Friend,Petitioner, an afghan tribe.","Arabic","6","Male",
		"مرد",
		"6",
		"عربی"
				   ,"نیاز حاصل کرنے والا ایک قبیلہ،عرض کرنے والا ،محبوب ، التجا کرنے والا،دوست",
		"نیازی");
		setMeaning("Haq","Right,Just, True, truth, real, right, just","Arabic","9","Male"
		,"مرد",
		"٩"
		,"عربی",
				   "سچ، ،جائز، اللہ تعالی كا صفاتی اسم مبارك، مجسم سچ ، سچّا ، بااعتماد ، بھروسے والا  " 
		,"حق");
		setMeaning("Rasheed","Thinker,Counselor, Wise, prudent, judicious, rightly guided, the Right-minded: one of the names of Allah.","Arabic","1","Male",
		"مرد",
		"١"
		,"عربی",
		"ہدایت یافتہ، تعلیم یافتہ، مدبر،بھَلا چاہنے والا، اللہ تعالی کا صفاتی نام،بڑے خلوص والا"
		,"رشید");
		setMeaning("Ibtisam"," Smiling, smile","Arabic","9","Male/Female",
		"مرد/عورت",
		"٩",
		"عربی",
		"مسکراہٹ,تبسم",
		"ابتسام");
	    setMeaning("Intisam","Being Fragrant,Being Perfumed","Persian","3","Male",
		"مرد",
		"3",
		"فارسی",
				   "معطر ہونا،خوشبودار ہونا،مہکتا ہوا",
		"انتسام");
		setMeaning("Khursheed/Khurshid","The Sun","Arabic","4","Male"
		,"مرد",
		"⁴"
		,"عربی"
		,"آفتاب,سورج,شمس"
		,"خورشید");
		setMeaning("Inam","Gift, present, prize, grant, reward,	Kindness, benefaction, bestowal","Arabic","9","Male"
		,"مرد"
		,"٩",
		"عربی",
				   "احسان, خيرات, بخشش دینا، تحفہ دینا،احسان کرنا"
		,"انعام");
		setMeaning("Ali","High, Exalted, Noble (Islamic),4th Islamic Caliph. ","Arabic, Persian, Turkish,","","Masculine",
		"مرد",
		"",
		"عربی,فارسی,ترکی"
				   ," بلند ترین,بلندوبالا,اسلام کے خلیفہء چہارم حضرت علی ؓکا اسمِ مبارک"
		,"علی");
		setMeaning("Umar/Umer","populous, flourishing,Life,Long-Lived,Second Caliph Of Muslims","Arabic","","Masculine",
		"مرد"
		,"",
		"عربی"
		,"زندگی,حیات,مسلمانوں کے دوسرے خلیفه کا نام عمر بن الخطاب",
 		"عمر");
		setMeaning("Sadiq","True, truthful, honest, sincere, devoted, faithful, veracious,True hearted","Arabic","1","Male",
		"مرد"
		,"1"
		,"عربی",
				   "سچا ، موزوع ، وفادار"
		,"صادق");
		setMeaning("Farooq","One Who Distinguish Between Right And Wrong,Title of one of the companions of prophet(PBUH)","Arabic","9","Male"
		,"مرد"
		,"9",
		"عربی",
				   "حق اور باطل میں فرق کرنے والا ,ر سول  اللہ ﷺ کے صحابی کا لقب "
		,"فاروق");
		setMeaning("Abu-Bakr","Abu means Father of,Like,Full of And Bakr means young Camel(Ancient Arabs),Companion of prophet(PBUH)","Arabic","","Male"
		,"مرد"
		,""
		,"عربی",
		"ر سول الله صلی الله علیه و سلم کے صحابی کا نام"
		,"ابو-بکر");
		setMeaning("Ghani","Rich,Generous,Third Khalifa of Islam","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "سخی,فراخ دل,اسلام کے تیسرے خلیفہ کا نام"
				   ,"غنی");
		setMeaning("Moavia", "Roar of lion,First Umayyad Khalifa","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "شیر کی دھاڑ ,بنو امیہ کے پہلے خلیفہ کا نام"
				   ,"معاویہ");
		setMeaning("Usman","Companion of the prophet(PBUH),A beautiful Pen","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "رسول اللہ ﷺ کے صحابی کا نام, ایک خو بصورت قلم, تیسرے خلیفہءراشد"
				   ,"عثمان");
		setMeaning("Ameer","Commander; Prince","Arabic","8","Male"
				   ,"مرد"
				   ,"٨"
				   ,"عربی",
				   "حاکم، سردار،مسلم حکمرانوں کا لقب،سربراہ	"
				   ,"امیر");
		setMeaning("Mulazim","Tenacious, persisting,One who serves others","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "محکم,پکا, استوار"
				   ,"ملازم");
		setMeaning("Hussain","Thinker,saint,Grandson of Prophet(PBUH)","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "بز ر گ,و لی,پیر,ر سول اللہ ﷺ کے نواسے کا نام"
				   ,"حسین");
		setMeaning("Hasan","Handsome,Grandson of Prophet(PBUH)","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "خو بصورت,نیک,ر سول اللہ ﷺ کے نواسے کا نام"
				   ,"حسن");
		setMeaning("Iqbal","National Poet Of Pakistan,Prosperity,wealth","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "ترقی، خوش نصیبی، اقرار، طالع ،قسمت ،مقدر،اعتراف"
				   ,"اقبال");
		setMeaning("Allama","Knowledgeable,very learned","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "علم والا"
				   ,"علامہ");
		setMeaning("Imran","A prophet'S Name,Civilization","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "آبادی,تہذیب,ایک پیغمبر کا نام"
				   ,"عمران");
		setMeaning("Khan","any of the successors of Genghis Khan, supreme rulers of the Turkish, Tartar, and Mongol peoples and emperors of China in the Middle Ages,leader,ruler,commander","Many languages","3","Male/Female"
				   ,"مرد/عورت"
				   ,"3"
				   ,"بہت ساری زبانیں",
				   "سربراہ, لیڈر, سردار"
				   ,"خان");
		setMeaning("Pervaiz","Commendable,Victorious,fortunate","Persian","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"فارسی",
				   "فاتح,کامیاب"
				   ,"پرویز");
		setMeaning("Musharraf","Elevated,honored","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "بلند,نوازا گیا,شرف حاصل کرنے والا"
				   ,"مشرف");
		setMeaning("Chaudhry"," literally meaning holder of four, Traditionally, the term is used as a title indicating the ownership of ancestral land, but in contemporary usage it is often taken as a surname or title","Hindi","_","Male"
				   ,"مرد"
				   ,"_"
				   ,"ہندی",
				   "سرغنہ ۔ گاؤں میں معتبر آدمی,آباواجداد سے ملی زمین کا مالک"
				   ,"چودھری");
		setMeaning("Zafar","Victory,Triumph","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "فتح,جیت"
				   ,"ظفر");
		setMeaning("Hamza","Lion","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				"   حضور ﷺ کے چچا کا نام،بہادر،بےباک،چیر پھاڑ کرنے والا"
				   ,"حمزہ");
		setMeaning("Abbas","Lion, Grim-Faced, Stern; The Name Of One Of prophet Mohammed'S Uncles ; (Hebrew) Father","Arabic/Hebrew","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی/عبرانی",
				   "حضور کے چچا کا نام،شیر،نڈر،دلیر،حضور نبی کریم کے سب سے چھوٹے چچا کا نام"
				   ,"عباس");
		setMeaning("Irfan","Thankfulness. Knowledge. Wisdom.","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "پہچان, معرفت،شکر،حکمت  "
				   ,"عرفان");
		setMeaning("Kamran","Prosperous/Successful","Persian","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "کامیاب,سرخرو,خوشحال"
				   ,"کامران");
		setMeaning("Zeeshan","Glory,princely","Turkish/Persian","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"ترکی/فارسی",
				   "  شوکت والا،بلند مرتبے والا، شان و شوكت والا،عظمت والا"
				   ,"ذیشان");
		setMeaning("Nouman","One who Advises, Blessed","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "  نصیحت کرنے  والا،اللہ کی تمام نعمتوں  کے ساتھ"
				   ,"نعمان");
		setMeaning("Waqar","Dignity,Honor","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "عزت ،مرتبہ،سکون ، بُردباری،شان و شوکت،"
				   ,"وقار");
		setMeaning("Iftikhar","Honor,Glory","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "عزت,مرتبہ"
				   ,"افتخار");
		setMeaning("Sajjad","One Who Does Much Prostrations,Worshiper","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "   عبادت کرنے والا, اطاعت کرنے , ,والا"
				   ,"سجاد");
		setMeaning("Barkat","Blessed,Growth","Persian","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"فارسی",
				   "برکتوں والا,فضل"
				   ,"برکت");
		setMeaning("Ayaz","In Farsi meaning is : Name ofSultan Mahmood's famous royal servant; Night breeze","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "رات ہوا کا جھونکا"
				   ,"ایاز");
		setMeaning("Israr","secrecy,privacy","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "خفیہ راز,چھپا ہوا"
				   ,"اسرار"); 
		setMeaning("Muzammil","One who is enwrapped in garments. Al-Muzzammil: Title of the 73rd Sura of the Holy Quran.In this sura, Allah addresses the Prophet Muhammad(PBUH)","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "کپڑوں میں لپٹا ہوا،حضور نبي كريم عليہ الصلوتہ ولسلام كا لقب مبارك, لپٹا ہوا"
				   ,"مزمل");
		setMeaning("Laiq","Deserving","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "قابل، مناسب، موزوں ، جائز،مستحق"
				   ,"لائق");
		setMeaning("Shah","King,Ruler","Persian","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"فارسی",
				   "بادشاہ،سلطان،سردار"
				   ,"شاہ");
		setMeaning("Liaqat","Ability,Capability,Capableness","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "قابلیت، خوبی، تمیز،جوہر ، استعداد،اہلیت"
				   ,"لیاقت");
		setMeaning("Summair","Entertaining,Companion","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "کہانی سنانے والا،دل لگی ،ساتھی،ساتھ نبھانے والا"
				   ,"سمیر");
		setMeaning("Sameer","Jovial, Entertaining ,Companion,Benefiter","Persian","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"فارسی",
				   "فائدہ دینے والا،نفع دینے والا،بخشنے والا"
				   ,"سمیر");
		setMeaning("Saqib","Shiny,Bright","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "چمکدار، مضبوط،پکا"
				   ,"صاقب");
				   
		setMeaning("Arham","Mercy, Compassion","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "شفقت کرنے والا, سب سے زیادہ رحم کرنے والا"
				   ,"ارحم");
		setMeaning("Ilyas","Name of a Prophet of Allah. He was called Ilyaseen as well.A Prophet, the biblical Elias.","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "ایک پیغمبر کا نام، ۔ اللہ تعالی کے  نبی کا نام"
				   ,"الیاس");
		setMeaning("Moeez/Moiz","one who honors others,one who grants honor","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "عزت دينے والا ، اللہ تعالی كا اسم مبارک"
				   ,"معز");
		setMeaning("Jamal","Beauty,Grace","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "حسن خوبصورتی،حسن و جمال،عنایت ،فضل رب ، رحمت ،دلکش"
				   ,"جمال");
		setMeaning("Misbah","Light,Lamp","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "چراغ،دیا، نور"
				   ,"مصباح");
		setMeaning("Mashood","Witnessed, present, manifest, the day ofjudgment, the day of Arafah.","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "حاضر، موجود، ظاہر،حاضركيا ہوا ، گواہ ، شاہد"
				   ,"مشہود");
		setMeaning("Arshad","Heavenly, guided","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "ہدایت یافتہ"
				   ,"ارشد");
		setMeaning("Anjum","Stars,Plural of Najam","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   
		"نجم کی جمع، ستارے،روشن"
				   ,"انجم");
		setMeaning("Gohar","Jewel,Pearl,Pelting","Persian","2","Male/Female"
				   ,"مرد/عورت"
				   ,"2"
				   ,"فارسی",
				   "موتی,جوہر"
				   ,"گوہر");
		setMeaning("Alyan","High Status, Exalted, Sublime and Superb,Tall and healthy","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "بلند مقام,بلندی کی طرف بڑھتا هوا,لمبا اور صحت مند"
				   ,"عالیان");
		setMeaning("Shayaan","Worthy, Deserving, Meriting","Persian","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"فارسی",
				   "لائق، موزوں، اہل،مناسب، زيبا"
				   ,"شایان");
		setMeaning("Hasnain","The two Hasans, Hasan and Husain, the two sons of the 4th Caliph and it is used as name of one person.","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "حضرت امام حسن اور حضرت امام حسین ؓ کو کہا جاتا ہے لیکن بطور ایک نام مستعمل ہے"
				   ,"حسنین");
		setMeaning("Basit","One who enlarges,increases","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "فراخی سے دینے والا،ایک صفاتی نام، کھولنے والا،بڑھانے والا،برکت والا"
				   ,"باسط");
		setMeaning("Azfar","Victorious","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "فتح مند٬کامیاب و کامران، خُوشبُودار ،ظفر یاب"
				   ,"اظفر");
		setMeaning("Nayab","Rare,Precious","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "نادک، ناپید،کمیاب، نادر"
				   ,"نایاب");
		setMeaning("Rehan","A fragrant plant","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "ایک خوشبودار پودا"
				   ,"ریحان");
		setMeaning("Afnan","Full Spreading Tree branches or twigs,Used in Surah i Rehman in Holy Quran","Arabic","2","Male/Female"
				   ,"مرد/عورت"
				   ,"2"
				   ,"عربی",
				   "درخت کی شاخیں یا مسواک"
				   ,"افنان");
		setMeaning("Rizwan","Acceptance. Good Will. Name OfThe Keeper Of The Gates OfHeaven.","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "رضا مندی،برکت،جنت کے دربان کا نام"
				   ,"رضوان");
		setMeaning("Salman","Safe,mild, affable, perfect, name of a sahabi i.e. companion of the Prophet Muhammad(PBUH).","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   " صحابی کا نام،ٹكڑا ، ذرہ ، ريزہ،حضرت سلمان فارسی"
				   ,"سلمان");
		setMeaning("Ghufran","Mercy Forgiveness Another Name For God","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "رحمت ,مغفرت"
				   ,"غفران");
		setMeaning("Muqeet","The Maintainer, He who sustains","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "باقی رہنے والا"
				   ,"مقیت");
		setMeaning("Muqsit","Just,Fair","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "منصف,انصاف کرنے والا"
				   ,"مقسط");
		setMeaning("Imad","Support,Pillar, Confidence","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "مدد,ستون,اعتماد"
				   ,"عماد");
		setMeaning("Musaddiq","Acknowledger of truth,One who acknowledges God’s existence and powers ,One who confirms something.It is used 18 times in the Holy Quran.One who confirms or verifies another","Arabic","10","Male"
				   ,"مرد"
				   ,"10"
				   ,"عربی",
				   "کسی چیز کی تصدیق کرنے والا, سچائ کا فہم رکھنے والا"
				   ,"مصدق");
		setMeaning("Mubashir","One who gives good news","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "اچھی خبر کو پھیلانےوالا, خوشخبری دینے والا"
				   ,"مبشر");
		setMeaning("Sabir","Patient","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "متحمل,صبر کرنے والا"
				   ,"صابر");
		setMeaning("Muqtasid","Frugal, thrifty, economical.","Arabic","9  And 5","Male"
				   ,"مرد"
				   ,"9اور 5"
				   ,"عربی",
				   "کفایت شعار,کم خرچ"
				   ,"مقتصد");
		setMeaning("Shehzad","Prince,Son of king","Persian","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"فارسی",
				   "بادشاہوں کا بیٹا٬عالیٰ قدر،کسی ریاستکا ولی عہد،شہزادہ"
				   ,"شہزاد");
		setMeaning("Ahmad/Ahmed","Much Praised, One Of the Many Names Of The Prophet Muhammad(PBUH)","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "بہت تعریف اور حمدوثنا پانے والا،تعريف کيا ھوا - حضور نبی کريم صلی اللہ عليہ وسلم کا اسم مبارک"
				   ,"احمد");
		setMeaning("Sarfaraz","Respected, Blessed","","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"",
				   "محترم و معظم,فیض یاب,مقدّس"
				   ,"سرفراز");
		setMeaning("Hafeez","Custodian,Caretaker","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "محافظ، نگہبان،حفاظت کرنے والا،اللہ تعالی کا صفاتی اسم مبارک"
				   ,"حفیظ");
		setMeaning("Sharjeel","Fine","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "اچھا"
				   ,"شرجیل");
		setMeaning("Manzoor","Acceptable. Admired.","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "مانا ہوا، پسندیدہ، تسلیم کیا ہوا ،چاہا ہوا"
				   ,"منظور");
		setMeaning("Shoaib","One who guides","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "راہ راست پر لانےوالا،رہنمائ کرنےوالا"
				   ,"شعیب");
		setMeaning("Akhtar","Star. Good Luck.","Arabic/Persian","4","Male/Female"
				   ,"مرد"
				   ,"4"
				   ,"عربی/فارسی",
				   "تارا، نصیب،قسمت،حاکمیت"
				   ,"اختر");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("Asif","Forgiveness","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "قابل آدمی،لائق،مضبوط،طوفانی،شدید،طاقتور"
				   ,"آصف");
		setMeaning("Malik","Master,Chief,King; Master or Sovereign; Master; Chieftain","Arabic/Hindi","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی/ہندی",
				   "حاکم, بادشاہ,آقا"
				   ,"ملک");
		setMeaning("Razzaq","One Who Provides The Necessities Of Life,One who feeds,One Of The Attributes Of Allah Almighty.","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "عطا کرنے والا, رزق دینے وال,اللہ تعالیٰ کا صفاتی نام"
				   ,"رزاق");
		setMeaning("Abdul","Obeyer Of God,Servant of God","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "اللہ کا بندہ"
				   ,"عبدل");
		setMeaning("Inzimam","Proximity, Mingle, Connect,To unite, to get together","","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"",
				   "قربت٬مل جانا٬ملانا٬جوڑنا،متصل ھونا"
				   ,"انظمام");
		setMeaning("Gul","Flower,Rose","Persian/Turkish","5","Male/Female"
				   ,"مرد/عورت"
				   ,"5"
				   ,"ترکی/فارسی",
				   "پھول,گلاب"
				   ,"گل");
		setMeaning("Sami","High, Lofty, Exalted","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "سننے والا، اللہ تعالیٰ کاصفاتی نام،ہمیشہ زندہ رہنے والا"
				   ,"سمیع");
		setMeaning("Anwar","Light,Brightness","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "اجالا ، چمک،روشنی"
				   ,"انور");
		setMeaning("Wahab","One who forgives,one who shows kindness","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "بخشنے والا، عطاکرنے والا،رحم کرنے والا"
				   ,"وہاب");
		setMeaning("Nabi"," Messenger","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "پیغمبر، خبر دینےوالا،اعلان کرنے  والا،پیغام لانے والا"
				   ,"نبی");
		setMeaning("Riaz","Gardens","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "بہت سے باغ، روضہ کی جمع، باغ، گلستان ،چمن،باغات"
				   ,"ریاض");
		setMeaning("Nawaz","One Who Bestows,Gives or Grants","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "عنایت کرنے والا،سرفراز كرنےوالا،بخشنے والا"
				   ,"نواز");
		setMeaning("Sharif","Honest,veracious,Truthful","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "ایماندار,صادق,سچا"
				   ,"شریف");
		setMeaning("Shahbaz/Shehbaz","White Falcon. King Of Falcons.","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "خوددار٬غیرت مند، بڑا باز ، شاہین"
				   ,"شهباز");
		setMeaning("Faisal","Decisive. Arbitrator,Adjudicate","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "فیصلہ کرنے والا، حاکم،قاضی،ثالث"
				   ,"فیصل");
		setMeaning("Zaroon","Visitor,Guest","Persian","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"فارسی",
				   "مہمان,ملاقاتی"
				   ,"زارون");
		setMeaning("Mikaal","One of the main angels of Allah","Arabic","","Male"
				   ,"مرد"
				   ,""
				   ,"عربی",
				   "اللہ کے معتبر فرشتوں میں سے ایک"
				   ,"میکال");
		setMeaning("Zulfiqar","Sword of Hazrat Ali(RA),Sword","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "حضرت علی  رضی اللہ عنہ  کی تلوار،تلوار،- شمشير"
				   ,"ذولفقار");
		setMeaning("Zarak","Gold","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "سونا"
				   ,"زرق/زرک");
		setMeaning("Alam","The entire world,scholar","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "دنیا جہاں،کائنات،زمانہ،دانشمند ،علم جاننے والا"
				   ,"عالم");
		setMeaning("Syed","Happy","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "خوش و خرم"
				   ,"سید");
		setMeaning("Ashraf","Honorable,Noble","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "بہت بزرگ,بہت شریف,بہت اعلی مرتبے والا"
				   ,"اشرف");
		setMeaning("Shakeel","Handsome. Good Looking.","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "وضع دار،خوبصورت,خوش شکل،حسین و جمیل"
				   ,"شکیل");
		setMeaning("Ahsan","Virtuous,Moral,Righteous","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "اچھائی کا حامل،نیک،بھل"
				   ,"احسن");
		setMeaning("Shahroz","Lavish, Bright Face","persian","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"فارسی",
				   "شاہانہ٬ روشن چہرہ،بادشاہوں کا وقت،خوبصورت چہرہ"
				   ,"شہروز");
		setMeaning("Zubair","Brave,Strong","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "بہادر,مضبوط"
				   ,"زبیر"); 
		setMeaning("Attaullah","Gift of Allah","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "اللہ کا تحفہ"
				   ,"عطاءاللہ");
		setMeaning("Zahid","Self-Denying Or Ascetic,PIOUS","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "متقی، پرہیز گار،عارف،عبادت گزار، بزرگ"
				   ,"زاہد");
		setMeaning("Sohaib","Reddish,Name.of Sahabi Hazrat Sohaib ROMI (RA)","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "سرخی مائل،سرخ، مشہور صحابی حضرت صہيب رومی رضی اللہ عنہ"
				   ,"صہیب");
		setMeaning("Maqsood","Intention, Propose,Goal,Objective","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "مطلب، غرض،مراد"
				   ,"مقصود");
		setMeaning("Fazal","Excellence, Superiority, Reward, Grace","Arabic","1","Male"
				   ,"مرد"
				   ,"1"
				   ,"عربی",
				   "خشش، بزرگی،برتری،کرم ،مہربانی"
				   ,"فضل");
		setMeaning("Shahrukh","Handsome,Beautiful Face","Persian","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"فارسی",
				   "خوبصورت چہرہ،حسین چہرہ،وجیہہ،خوش شکل"
				   ,"شاہ رخ");
		setMeaning("Ibrahim","Combination of Abu(Father) and Rahim(Kind),Name of A Prophet","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "پیغمبر کا نام,بزرگی والا"
				   ,"ابراہیم");
		setMeaning("Dawood","The Biblical David Is The English Language Equivalent.Name Of a Prophet to whom ZABUR was revealed","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "ایک پیغمبر کا نام جن پر آسمانی کتاب زبور نازل ہوی تھی"
				   ,"داؤد");
		setMeaning("Azam","Great","Arabic","3","Male"
				   ,"مرد"
				   ,"3"
				   ,"عربی",
				   "عظیم, عظمت والا, بہت بڑا"
				   ,"اعظم");
		setMeaning("Hammad","One Who Deserves praise","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "تعریف کے قابل, قابل ستائش "
				   ,"حماد");
		setMeaning("Usama","King Of Jungle, Lion,One who does good deeds","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "نیک سلوک کرنا،اچھا،جنگل کے بادشاہ"
				   ,"اسامہ");
		setMeaning("Muslim","One who Submits his will to Allah","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "مسلمان،مومن، اسلام كا پير وكار"
				   ,"مسلم");
		setMeaning("Mohsin","Gentle, Humanitarian","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "مددگار، بھلائی کرنے والا,نرم دل"
				   ,"محسن");
		setMeaning("Zaheer","Supporter, Ally,Helper,Sympathetic","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "معین، مددگار،معاون،ہمدرد،حمایتی"
				   ,"ظہیر");
		setMeaning("Azhar","Shining, Luminous","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "خوب ظاہر،عیاں،چمکتاہوا،روشن"
				   ,"اظہر");
		setMeaning("Hashmi","Seniors , high , respected , worker , who leads","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "بزرگ ,اعلٰی ,معزز ,خدمتگار "
				   ,"ہاشمی");
		setMeaning("Azlan","Lion","Turkey","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"ترکی",
				   "شیر , ببرشیر,"
				   ,"ازلان");
		setMeaning("Hafiz","Keeper, Guardian, Preserver","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				"   نگہبانی كرنے والا, حفاظت کرنے والا, خیال کرنے والا"
				   ,"حافظ");
		setMeaning("Atif","Kind,affectionate, sympathetic","Arabic","7","Male"
				   ,"مرد"
				   ,"7"
				   ,"عربی",
				   "شفیق، مہربان،جھکنے والا،شفیق، مہربان،عنایت کرنے والا"
				   ,"عاطف");
		setMeaning("Aslam","Being Guarded,Safe","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "محفوظ و مامون،پاکیزہ ،صاف ، سلامت"
				   ,"اسلم"); 
		setMeaning("Khanzada","Son of A rich person,The name of the elder sister of Mughal emperor Zaheer ud din Muhammad Babar was Khanzad Begum and the tomb of whom is near the tomb of the mentioned emperor.","Persian","","Male"
				   ,"مرد"
				   ,""
				   ,"فارسی",
				   "سردار كا بيٹا - امير كا بيٹا - مغل بادشاہ ظہيرالدين محمد بابر كي بڑي بہن كا نام خانزادہ بيگم - اس كا مزار كابل ميں بابر بادشاہ كے مقبرے كے ساتھ ہے -"
				   ,"خانزادہ");
		setMeaning("Mazhar","The place from which something appears,To Appear","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "ظاہر ہونے کی جگہ، عیاں ہونا"
				   ,"مظہر");
		setMeaning("Farhan","Merry,Happy,Blithesome","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "سرور، خوشی،پر مسرت  ، مسرور"
				   ,"فرحان");
		setMeaning("Saeed","Lucky,Fortunate,Happy","Arabic","9","Male"
				   ,"مرد"
				   ,"9"
				   ,"عربی",
				   "نیک، خوش نصیب، نیک بخت،بزرگ،"
				   ,"سعید");
		setMeaning("Haider","Lion. King Of Jungle","Arabic","6","Male"
				   ,"مرد"
				   ,"6"
				   ,"عربی",
				   "شیر ، ببر شیر،حیدر قرار،حضرت علیؓ کا لقب"
				   ,"حیدر");
		setMeaning("Ahsaan","Virtuous,Moral,Righteous","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "اچھائی کا حامل،نیک،بھل"
				   ,"احسان");
		setMeaning("Saima","The one who fasts,pious","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "روزے رکھنے والی،پرہیز کرنے والی،فاقہ کرنے والی"
				   ,"صائمہ");
		setMeaning("Samreen","Productive, profit-making, to help","Hebrew","8","Female"
				   ,"عورت"
				   ,"88"
				   ,"عبرانی",
				   "پھلدار، فائدہ دینے والی، مددکرنے والی،نفع دینے والی"
				   ,"ثمرین");
		setMeaning("Munazza","Infallible,Free of Committing sins","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "عیب سے پاک،برائیوں سے پاک ، نقائص سے مبرا، پاکیزہ"
				   ,"منزہ");
		setMeaning("Ruhi","Spiritual","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "روحانی"
				   ,"روحی");
		setMeaning("Naz","Pride, Delicacy,Pridefulness","Persian","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"فارسی",
				   "فخر، پیار ،ناز،نخرہ،غرور ،نفاست ، نزاکت، لطافت"
				   ,"ناز");
		setMeaning("Irum/Erum","Paradise,Heaven,When Shiddad claimed to be God he made an artificial paradise and which he named ERUM","Persian","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"فارسی",
				   "بہشت شداد،جنت،فردوس، شداد نے خدائی كا دعویٰ كرنے كے بعدجو مصنوعی جنت بنائی تھی اس كا نام اس نے اِرم ركھا تھا"
				   ,"ارم");
		setMeaning("Ahza","Divine, Goodness, Truth, Unconditional love, Gift, Free will, Ideal, Whole, Endless","","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"",
				   "ربانی,خداداد,پاک,سچائی"
				   ,"احزہ");
		setMeaning("Amima","Full,Complete,Over all, all.","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "بھَرا ہُوا, مکمل,سب پر حاوی، تمام، پوری"
				   ,"عمیمہ");
		setMeaning("Afifa","Virtuous,Pious,Chaste","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "پارسا عورت،نیک عورت،پاک باز،پرہیز گار عورت"
				   ,"عفیفہ"); 
		setMeaning("Faizah","Victorious,who benefits others,Successful","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "فیض رساں، فتح پانے والی ، جیتنے والی ،پہنچنے والی، فیض دینے والی,کامیاب"
				   ,"فائزہ");
		setMeaning("Faiza","Victorious,who benefits others,Successful","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "فیض رساں، فتح پانے والی ، جیتنے والی ،پہنچنے والی، فیض دینے والی,کامیاب"
				   ,"فائزہ");
setMeaning("Faizan","Grace, Favour","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
"عنایات،بڑا فائدہ،بڑا نفع، پانی کا جاری ہونا"
				   ,"فیضان");
		setMeaning("Anusha","Delighted, happy,Eternal life, Immortality, goodness and happiness, Bravo, and blessings ofAllah","Persian","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"فارسی",
				   "مسُرور, خُوش, شاداں,ہمیشہ کی زندگی"
				   ,"انوشا");
setMeaning("Bushra","Good News ,Good Omen.","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
"خوشخبری، الہلام،مثردہ ،نیکبخت"
				   ,"بشری");
		setMeaning("Rushda","knowledge, Straight Path, and guidance","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
"ہدایت یافتہ، ہدایت والی"
				   ,"رشدہ");
		setMeaning("Ulfat","Love,Affection","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
"محبت، پیار، چاہت ، دوستی ، رفاقت ، توجہ ، اُنس"
				   ,"الفت");
		setMeaning("Ismat","Piety,Virtue,Self-Guarding","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
"پارسائی،پرہیزگاری،پاک دامن، عزت، پاکدامنی"
				   ,"عصمت");
		setMeaning("Jahan","Variant Of Jehan, The World.","Persian","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"فارسی",
				   "عالم , جہان , دنیا"
				   ,"جہان");
		setMeaning("Jahan Ara"," One who adorns the world,Adornment,Decoration,Beautifier of the world","Persian","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"فارسی",
				   "دنیا کی خوبصورتی,زینت"
				   ,"جہان آرا");
		setMeaning("Jahan Aara","Adornment,Decoration,Beautifier of the world","Persian","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"فارسی",
				   "دنیا کی زینت"
				   ,"جہان آرا");
		setMeaning("Hoorain","The world Hoor Is mentioned 4 times in the Holy Quran,Lovely-eyed, Splendid companion of Paradise, With modest gaze,women of Paradise with large beautiful black eyes","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "جنت کی ہور جس کی بڑی خوبصورت کالی آ نکھیں ہوتی ہیں, خوبصورت آنکھوں والی,لفظ ہور قرآن پاک میں 4 مرتبہ استعمال ہوا ہے"
				   ,"حورین");
		setMeaning("Ishrat","Society, Familiar and pleasant talk, happiness,Pleasure, enjoyment, delight.","Arabic","7","Male/Female"
				   ,"عورت/مرد"
				   ,"7"
				   ,"عربی",
				   "عیش،عیش و نشاط، قرابت دار، مسرت"
				   ,"عشرت");
		setMeaning("Neelam","Blue Gem, Precious Stone.","Persian","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"فارسی",
				   "آسمانی رنگ کا قیمتی پتھر، ایک بیش قیمت پتھر"
				   ,"نیلم");
		setMeaning("Shaheen","Falcon,Royal, white falcon; the needle of the beam of scales.","Persian","6","Male/Female"
				   ,"مرد/عورت"
				   ,"6"
				   ,"فارسی",
				   "شہباز، باز،شکاری پرندہ، عقاب , ایک سفید پرندہ،  ،اونچی پرواز کرنے والا"
				   ,"شاہین");
		setMeaning("Kausar","Lake Of Pradise","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "جنت کی جھیل"
				   ,"کوثر");
		setMeaning("Maimoona","Safe, Trustworthy.","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "قابل اعتماد , معتبر ۔ , محفوظ"
				   ,"میمونہ");
		setMeaning("Sumbal","A special kind of grass with a very good fragrance","Arabic","7","Male/Female"
				   ,"مرد/عورت"
				   ,"7"
				   ,"عربی",
				   "ایک خوشبودار گھاس،مہک والی گھاس"
				   ,"سنبل");
		setMeaning("Kalsoom","Name of prophet Muhammad (PBUH)'S daughter.","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "حضرت محمد ﷺ کی بیٹی کا نام"
				   ,"کلثوم");
		setMeaning("Reshma","Golden Silk, Expensive","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "سنہری ریشم, قیمتی,"
				   ,"ریشما");
		setMeaning("Reema","White Antelope,A kind of white deer with horns pointing up and back and runs very fast ","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "سفید ہرن"
				   ,"ریما");
		setMeaning("Nadia","Caller, Announcer, One Who Calls","Persian/English","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"فارسی/انگریزی",
				   "پکارنے والی،آواز دینے والی ،صدا دینے والی"
				   ,"نادیہ");
		setMeaning("Nazneen","Beautiful; Glorious,delicate.","Persian","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"فارسی",
				   "نازک,خوبصورت"
				   ,"نازنین");
		setMeaning("Sumayya","high above in Arabic. This wasthe name of the first martyr for Islam,small distinguishing mark and figuratively it means unique, special.","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "عربی میں بلند اعلی,خاص,بے مثال,یکتا"
				   ,"سمیہ");
		setMeaning("Zara","Humble,demure,Down-To-Earth,Dawn, princess","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "عاجزی اختیار کرنیوالی،ملاقات کرنے والی،عجز و انکساری کرنے والی والی"
				   ,"زارہ");
		setMeaning("Anam","Present, Precious Gift from Allah","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "تحفہ,اللہ کی طرف سے قیمتی تحفہ"
				   ,"انم");
		setMeaning("Aamna","Of high status,value and rank","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "رتبہ والی،حیثیت والی،مرتبہ والی"
				   ,"آمنہ");
		setMeaning("Sajal","Promise,Vow,Pledge,Commitment","Hindi","3","Male/Female"
				   ,"مرد/عورت"
				   ,"3"
				   ,"ہندی",
				   "وعدہ,حاکم نامہ,ضمانت دینا"
				   ,"سجل");
		setMeaning("Ayesha","The Name Of The Wife Of The Prophet Mohammed(PBUH),One who lives with peace,Comfort,satisfaction and contentment","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "آرام پانے والی،راحت وسكون سے رہنے والی ، حضور سروركائنات صلی اللہ عليہ وسلم كی زوجہ محترمہ جنھیں تمام امتِ مسلمہ کی ماں ہونے کا درجہ حاصل ہے"
				   ,"عائشہ");
		setMeaning("Zainab","Daughter Of The Prophet Muhammad(PBUH),Generous,Big-Hearted","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "سخاوت کرنیوالی،حضور نبی کریم کی صاجزادی سیدہ زینب،سخی ، خوشبودار"
				   ,"زینب");	   
		setMeaning("Safeena","A Boat,Name of a slave of Prophet Muhammad(PBUH)","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "کشتی، تختہ، چبوترہ ،جہاز"
				   ,"سفینہ");	   
		setMeaning("Wajeeha","Eminent, Distinguished","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "امتیازی شخصیت کا مالک, مختلف"
				   ,"وجیہہ");	   
		setMeaning("Sundas","Dress of Heaven","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "جنت کا لباس،جنت کی پوشاک"
				   ,"سندس");	   
		setMeaning("Umaima","One who guides,One who shows straight path,Prophet Muhammad(PBUH)'S aunt's Name","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "ہدایت دینے والی،رہنمائی كرنے والی ، سيد  ھی راہ دكھانےوالی ، حضور سرور كائنات صلی اللہ عليہ وسلم كی سگی پھوپھی كا نام"
				   ,"امیمہ");   
		setMeaning("Mahira","Expert,Having Expertise","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "استاد - كامل - مشاق,کسی کام میں ماہر"
				   ,"ماہرہ"); 
		setMeaning("Jaweria","Sharing happiness,Prophet Muhammad(PBUH)'S wife's name","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "خوشیاں بانٹنے والی،حضور سرور كائنات صلی اللہ عليہ وسلم كی زوجہ مطہرہ حضرت جويريہ رضی اللہعنہ،خوشیاں بکھیرنے والی"
				   ,"جویریہ");
		setMeaning("Rizwana","Consent,Allowance","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "رضا مندی، بہشت کا دربار، خوشنودی"
				   ,"رضوانہ"); 
		setMeaning("Azka","Pious, Pure, Very Ingenious","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "بہت ہوشیار , خالص , پارسا"
				   ,"ازکہ");
		setMeaning("Khushnuma","Ornamental,Plausible,Pleasant","Persian","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"فارسی",
				   "اچھا, معقول"
				   ,"خوش نما");
		setMeaning("Zarin","golden, made of gold,Such As Gold","Persian","6",""
				   ,""
				   ,"6"
				   ,"فارسی",
				   "سونے جیسا،سونے كا كام كيا ہوا - سنہری"
				   ,"زرین");	   
		setMeaning("Mawra","Unpredictable, Superior, Thing which is not in the hand of anyone,Far","Arabic","3","Female"
				   ,"عورت"
				   ,"3" 
				   ,"عربی",
				   "غيبي , پرے ,دور  , علاوہ ,سوا"
				   ,"ماورا");	   
		setMeaning("Urwa","Lion, Ever-green Tree, Handhold, Name of one of Prophet(PBUH)'s companion","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "شیر,سر سبز درخت,وسیلہ"
				   ,"عروا");	   
		setMeaning("Noor","Light ,Source of Guidance","Arabic","4","Male/Female"
				   ,"مرد/عورت"
				   ,"4"
				   ,"عربی",
				   "روشن، چمک، اجالا,ایمان کی روشنی کا سَرچَشمَہ"
				   ,"نور");	   
		setMeaning("Sara","Pure, Happy","Arabic","1","Male"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "سرایت کرنیوالی، خالص ،بہترین ،بے میل،بادشاہ کی بیٹی"
				   ,"سارہ");   
		setMeaning("Ejaz","Miracle,To do something which others can not do","Arabic","1","Male/Female"
				   ,"مرد/عورت"
				   ,"1"
				   ,"عربی",
				   "کرامت ، معجزہ"
				   ,"اعجاز");   
		setMeaning("Yasoob","Leader,Guide,Title Of Hazrat Ali(RA)","Persian","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"فارسی",
				   "قائد - پشوا - رہنما - ليڈر-امام-رہبر"
				   ,"یصوب"); 
		setMeaning("Uroosa","Bride","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "دلہن,جس کی شادی ہونے والی ہو"
				   ,"عروسہ");
		setMeaning("Iqra","To Recite,To Learn","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "پڑھنے کا حکم، پڑھنا ،سیکھنا"
				   ,"اقراء"); 
		setMeaning("Madiha","One who praises,Appreciates","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "تعریف، ثناء،صفت کرنے والی،مدحت کرنےوالی"
				   ,"مدیحہ");
		setMeaning("Laraib","Without Any Doubt","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "بلاشبہ, بے شک"
				   ,"لاریب"); 
		setMeaning("Aiman","One who congratulates Others,Blessed,Fortunate,On the right side(Literal,Fearless","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "مبارک باد دینے والی،بے خوف ، محفوظ،مبارک,"
				   ,"ایمن");
		setMeaning("Tehreem","Respect,sanctity.","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "عزت, تقدُس , تحریم"
				   ,"تحریم"); 
		setMeaning("Nida","Announcement, Call","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "پکار، صدا،،دعا،خوشخبری"
				   ,"ندا");
		setMeaning("Kainat","The Universe","Urdu","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"اردو",
				   "کائنات, جہان,"
				   ,"کائنات"); 
		setMeaning("Asma","Loftier, More Eminent, Excellent,Exalted, Precious, Daughter Of Hazrat Abu Bakr Siddique(RA)(First Khalifa)","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "بہت سے نام،نمونہ مثال ،عورت، اسم کی جمع,اونچے مرتبے والی"
				   ,"اسماء");
		setMeaning("Nabeela","Highborn,Blue-Blooded","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   " , امیر زادہ, اعلیٰ نسب والا"
				   ,"نبیلہ");	   
		setMeaning("Rida","Modest,","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "ﷲ کی حمایت یافتہ، شرم والی ، حیا والی،اوڑھنی، چادر"
				   ,"ردا");	   
		setMeaning("Hina","Henna","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "مہندی کی پتی، مہندی،خوشبو"
				   ,"حنا"); 
		setMeaning("Rehana","Perfume,Fragrance,Fragrance of a flower","Persian","4","Saba"
				   ,"عورت"
				   ,"4"
				   ,"فارسی",
				   "خوشبو،مہک،پھول كی خوشبو ، ہری گھاس،پھول كی مہک ، سرسبز"
				   ,"ریحانہ");
		setMeaning("Tahira","Chaste,Ascetic,Pure,Modest","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "پاک صاف،پاکیزہ، پاک دامن"
				   ,"طاہرہ");	   
		setMeaning("Saba","Breeze, Morning wind","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "پروا، شرف کی ہوا،نرم ہوا،خوشگوار"
				   ,"صبا"); 
		setMeaning("Qaisar","Emperor, Shah","Arabic","4","Male"
				   ,"مرد"
				   ,"4"
				   ,"عربی",
				   "شہنشاہ،شاہ،بادشاہ"
				   ,"قیصر");
		setMeaning("Reham","Rain drops","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "بارش کے قطرے"
				   ,"ریحام");
		setMeaning("Fatima","One Who Abstains, Baby's Nurse","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "دودھ چھڑانے والی،دلفریب، ایک عورت جو اجتناب کرے"
				   ,"فاطمہ");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("Perveen","Suraiya or the name of the stars,Galaxy","Persian","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"فارسی",
				   "ثریا ،یا چند ستاروں کا نام، سات ستاروں كا جھرمٹ،ستاروں کا جھرمٹ"
				   ,"پروین");
		setMeaning("Sughra","Lass,Young girl,Name of the Daughter of Hazrat Imam Hussain(RA)","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "چھوٹی لڑکی، حضرت امام حسین ؓ کی بیٹی کا نام، انتہائی چھوٹی،كمسن"
				   ,"صغرا");
		setMeaning("Hafsa","Cub,Young Lioness,Name of the wife of Prophet Muhammad(PBUH)","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "حضور ﷺ کی زوجہ مطہرہ کانام، جمع کرنا ،اکٹھا کرنا،شیر کی بیٹی"
				   ,"حفصہ");
		setMeaning("Hira","Name Of The Hill Where The Quran Was Revealed To Prophet Muhammad(PBUH),Darkness","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "ایک پہاڑی جہاں نبی کریم ﷺ پر قرآنِ پاک نازل ہوا ،ایک مقدس جگہ کا نام,تاریکی"
				   ,"حرا");	   
		setMeaning("Fiza","One Who increases or extends something","Persian","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"فارسی",
				   "افزائش، ترقی،بڑھانے والی، زیادہ کرنے والی"
				   ,"فزا");	   
		setMeaning("Salma","Obeyer,Virtuous,Safe,Name Of Prophet Muhammad(PBUH)'S wife's name","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "حضور کی زوجہ مطہرہ کا نام،اطاعت گزار،نیک،پاک،محفوظ"
				   ,"سلمہ"); 
		setMeaning("Najma","Star,Bright,Shiny","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "ستارہ،روشن،چمکدار"
				   ,"نجمہ");
		setMeaning("Samina","Precious,Expensive,Valuable ","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "قیمتی چیز، گراں قدر، فائدہ مند ،بيش قيمت"
				   ,"ثمینہ");	   
		setMeaning("Rubina","The Red Gem stone,Pearl,Precious stone","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "چہرہ شناس،گوہر ،ایک قیمتی پَتّھر"
				   ,"روبینہ"); 
		setMeaning("Resham","Silk, softness","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "نرمی,ایک قسم کا کپڑا"
				   ,"ریشم");
		setMeaning("Zahida","Hermit,Chaste,Pious","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "پرہیز گارعورت، پاکباز، پارسا،متقی"
				   ,"زاہدہ");
		setMeaning("Zareena","Golden,Beautiful","","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"",
				   "زار کی ملکہ، خوبصورت،سنہرا"
				   ,"زرینہ");
		setMeaning("Haseena","Variant Of Hasina: Beautiful, Pretty.","Arabic","7","Female"
				   ,"عورت"
				   ,"7" 
				   ,"عربی",
				   "دلکش , خوش نما , حسین"
				   ,"حسینہ");
		setMeaning("Sanam","Beloved,Idol,Darling,Sweet-Heart","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "محبوب٬ دلیر،معشوق،بت،پیار"
				   ,"صنم");
		setMeaning("Tamanna","Desire,Wish","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "خواہش، آرزو،امنگ،تمنا"
				   ,"تمنا");
		setMeaning("Samman","Jasmine","Persian","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"فارسی",
				   "چنبیلی،چنبيلی كا پھول، ياسمين،"
				   ,"سمن");
		setMeaning("Tayyaba","Pleasant, Well.","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "اقبال مند, خوش , دلکش"
				   ,"طیبہ");	   
		setMeaning("Aleema","Knowledgeable,Intellectual","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "بہت علم جاننے والی،علم والی،دانشور"
				   ,"علیمہ");	   
		setMeaning("Ambreen","The Sky","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "آسمان،امبر،فلک،عنبر جیسی"
				   ,"عمبرین"); 
		setMeaning("Ainnie","Grace , Favour, Khoobsoorat Ankhon Wali, Behti Huwi Nadi","Arabic/Hebrew","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عبرانی/عربی",
				   "دلکشی,مہربانی,عنایت,حمایت"
				   ,"عینی");
		setMeaning("Aqsa","Name Of a Masjid in Palestine","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "مسجد کا نام،انتہائی بعید کنارہ ,سرا"
				   ,"اقصہ");	   
		setMeaning("Asifa","Organizer,Manager","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   
		"منظم کرنے والی،اکھٹا کرنے والی، جمع کرنے والی"
				   ,"آصفہ"); 
		setMeaning("Khadija","Prophet Muhammad(PBUH)'S First Wife's Name","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "حضرت خدیجہ الکبریٰؓ کانام، آنحضرت ﷺ کی پہلی زوجہ"
				   ,"خدیجہ"); 
		setMeaning("Sana","Praise,Appreciation,Laud","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "تعریف، حمد،،توصیف،ستائش"
				   ,"ثناء");
		setMeaning("Sadia","Religeous,Pious,Devout,Righteous","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "نیک خاتون، مبارک،پارسا خاتون،مُتَّقی"
				   ,"سعدیہ");
		setMeaning("Bareera","Religeous,Pious,Devout,Righteous","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "دین دار٬ پارسا،متقی،پرہیز گار"
				   ,"بریرہ");
		setMeaning("Farah","Happiness,Joy,Gladness","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "خوشی، سرور،سنہری،شادمانی،مسرت"
				   ,"فرح");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("Zoya","Alive,Love","Persian","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"فارسی",
				   "حیایت ٬ محبت،چاہت ،زندگی"
				   ,"زویا");
		setMeaning("Zahra","Friend,Helper,Sympathetic","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "مدد کرنے والی، دوست،ہمدرد"
				   ,"زہرا");	   
		setMeaning("Gulzar","Garden","Persian","6","Male/Female"
				   ,"عورت/مرد"
				   ,"6"
				   ,"فارسی",
				   "باغ، گلستان، پھلواڑی،چمن"
				   ,"گلزار");	   
		setMeaning("Mehreen","Moon,Beautiful,Loving Nature,brilliant like the sun","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "چاند اور سورج جتنی محبت کرنے والی،محبت والی ، الفت والی"
				   ,"مہرین"); 
		setMeaning("Momina","Believer,Practicing Muslim,Faithful","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "ایمان لانے والی،اسلام قبول کرنے والی،مسلمان"
				   ,"مومینہ");
		setMeaning("Mehjabeen","literally meaning moon-faced, moon-like,Beautiful,Radiant","Persian-Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی-فارسی",
				   "چاند جیسی صورت والی,خوبصورت"
				   ,"ماہ جبین");	   
		setMeaning("Laiba","Angel or Hoor Of Heaven,The most beautiful","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "جنت کی حور,خوبصورت"
				   ,"لائبہ"); 
		setMeaning("Ghazala","Women with Deer like Eyes","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "ہرن جیسی آنکھوں والی عورت، ہرنی"
				   ,"غزالہ");
		setMeaning("Ghazal","Lyric Poem, Love Poetry,One of the genres of Urdu Literature,Deer","Arabic","3","Male/Female"
				   ,"مرد/عورت"
				   ,"3"
				   ,"عربی",
				   "ہرن،ہرن كا بچہ،ہرنی،محبوبہ,اردو شاعری کی ایک صنف,اُردو، فارسی یا عربی کی ایک صنفِ سُخن جس کے پہلے دو مِصرے ہم قافیہ ہوتے ہیں"
				   ,"غزل");
		setMeaning("Rasheeda","Rightly guided, Right minded","ARABIC","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "ہدایت یافتہ، ہدایت والی"
				   ,"رشیدہ");
		setMeaning("Khursheeda","THE SUN","ARABIC","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "آفتاب٬ سورج،نور ، شمس"
				   ,"خورشیدہ");
		setMeaning("Mahrukh","One who has face like a Moon","Persian","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"فارسی",
				   "چاند جیسے چہرے والی ، چاند جیسی شکل والی،خوبصورت"
				   ,"ماہ رخ");
		setMeaning("Fazila","High Status, Exalted, Sublime and Superb  Noble, Admirable and Praiseworthy","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "فضیلت والی،مہربانی کرنے والی،مسرتوں والی"
				   ,"فضیلہ");
		setMeaning("Shakeela","Variant Of Shakila,Beautiful,Gorgeous","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "حسین , خوبصورت , متناسب"
				   ,"شکیلہ");
		setMeaning("Jameela","Beautiful,Gorgeous","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "حسین عورت،خوبصورت خاتون،حسین و جمیل"
				   ,"جمیلہ");	   
		setMeaning("Andleeb","Nightingale","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "بلبل، ایک چھوٹا اور نازکسا پرندہ"
				   ,"عندلیب");	   
		setMeaning("Adila","Just,Fair","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "یکساں انصاف کرنے والی،منصف،عدل کرنے والی"
				   ,"عدیلہ"); 
		setMeaning("Batool","Maiden,Unmarried,Title Of Hazrat Fatima(RA),Able","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "کنواری، حضرت فاطمہ زہرا ؓ کا لقب، عفت مآب،قابل،لائق"
				   ,"بتول");
		setMeaning("Kaneez","Slave","","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"",
				   "غلام, خادم،نوکرانی ،خدمت گزار"
				   ,"کنیز");	   
		setMeaning("Sadaf","Pearl,Enlightened","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "روشنی، نور،منور،موتی،سیپی"
				   ,"صدف"); 
		setMeaning("Tooba","A Tree In Heaven,Enviousness,Fragrance","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "پاکیزہ،خوشبودار، سعادت،بہشت كے ايک درخت كانام، فخر ،رشک"
				   ,"طوبی");
		setMeaning("Nafeesa","Variant Of Nafisa: Precious, Delicate,Gem.","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "گوہر , نفیس , قیمتی"
				   ,"نفیسہ");
		setMeaning("Maryam","Chaste,Decent,Modest,Pure","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "پاک، دامن، دوشیزہ، پاکیزہ، کنواری"
				   ,"مریم");
		setMeaning("Sakina","Variant Of Sakinah:Tranquility, Devout. God-inspired Peace Of Mind.","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "پارسا , سکون"
				   ,"سکینہ");
		setMeaning("Qurat-Ul-Ain","Joy, Tranquility","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "آنکھوں کی ٹھنڈک، آنکھوں کی روشنی"
				   ,"قرت العین");
		setMeaning("Qosain","Two Bows","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "دو كمانيں"
				   ,"قوسین");
		setMeaning("Maria","One who wishes,Elevated","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "تمنا اور چاہت کرنے والی،سرفراز ، اونچي ، تيز، تلخ ، بلند"
				   ,"ماریہ");
		setMeaning("Sania","Second, Latter","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "ثانی کی مونث،دوسری ، برابر ،لمحہ ، باریکی"
				   ,"ثانیہ");	   
		setMeaning("Diya","Light,Shinning","","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"",
				   "بتی,روشنی,چمکتا ہوا"
				   ,"دیا");	   
		setMeaning("Haniya","Happy,Prosper","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "خوشحال، مسرور، پرمسرت،خوشو خرم"
				   ,"ہانیہ"); 
		setMeaning("Haneefa","True Believer","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "سچی٬کھری،یقین کرنے والی،قابل اعتبار"
				   ,"حنیفہ");
		setMeaning("Samana","To Fit","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "سما جانے والی،جزب ہو جانے والی"
				   ,"ثمانہ");	   
		setMeaning("Kiran","A Light Ray,Beam","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "شعاع،روشنی کی کرن،تیزرفتار"
				   ,"کرن"); 
		setMeaning("Habiba","Sweet-Heart,Darling,Friend","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "دوست، محبت کرنے والی،رفيقہ،حضور نبی کریم ﷺ کی ایک زوجہ مطہرہ اُم حبیبہ"
				   
				   ,"حبیبہ");
		setMeaning("Ammara","A lady with strong Faith","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "ایک عورت مضبوط ایمان کے ساتھ"
				   ,"عمارہ");
		setMeaning("Adia","Being a gift","Hebrew","","Female"
				   ,"عورت"
				   ,""
				   ,"عبرانی",
				   "تحفہ"
				   ,"عادیہ");
		setMeaning("Naila","Achiever,Gainer,Recognizer","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "حاصل کرنے والی، پانے والی، پہنچاننے والی"
				   ,"نائلہ");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("Ashi","Evening,Night","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "شام کا وقت,رات"
				   ,"آشی");
		setMeaning("Safya","A chaste Person,Pious,Decent,Modest","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "پاکدامن عورت،برگزیدہ عو رت، پاکیزہ،خانہ کعبہ کے کلیدبردارحضرت شیبہ بن عشمان کی صا حبزادی کانام صفیہ ۔ آپ کا شمار تابعیات میں ہو تا ہے"
				   ,"صفیہ"); 
		setMeaning("Sofia","Beautiful,Gorgeous","Many languages","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"بہت ساری زبانیں",
				   "خوبصورت, حسین,"
				   ,"صوفیہ");
		setMeaning("Abida","Worshiper,Pious","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "عبادت کرنے والی،پرہیز گار عورت،متقی، نیک"
				   ,"عابدہ");
		setMeaning("Syeda","Female Leader","Arabic","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"عربی",
				   "راہنما خاتون،سردار ، پيشوا ،امیر ، سید گھرانے سے تعلق رکھنے والی"
				   ,"سیدہ");
		setMeaning("Saeeda","Happy,Fortunate","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "نیک بخت،خوش قسمت،مبارک،خوش بخت"
				   ,"سعیدہ");
		setMeaning("Jannat","Heaven,Paradise,Garden","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "بہشت٬ باغ،خلد،فردوس"
				   ,"جنت");
		setMeaning("Jabeen","Fore-Head","Persian","6","Female"
				   ,"عورت"
			 	   ,"6"
				   ,"فارسی",
				   "پیشانی،جبیں،ماتھا،"
				   ,"جبین"); 
		setMeaning("Yasmeen","Jasmine Flower.","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "چمبیلی کا پھول"
				   ,"یاسمین");
		setMeaning("Gulaab","Rose,Flower","Arabic","8","Male/Female"
				   ,"مرد/عورت"
				   ,"8"
				   ,"عربی",
				   "پھول , گلاب"
				   ,"گلاب");
		setMeaning("Samaa","Generosity","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "فراخدِلی ,فیّاضی, کُشادہ دِلی"
				   ,"سماء");
		setMeaning("Gharida","Nightingale,Happy,Glad,Frolicsome","Persian","","Female"
				   ,"عورت"
				   ,""
				   ,"فارسی",
				   "بلبل,خوش وخرم"
				   ,"غریدہ");
		setMeaning("Rabia","Fourth,Rabia Basri a Well-Knowned Saint","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "رابعہ بصری ایک قلندر،چوتھی"
				   ,"رابعہ");
		setMeaning("Nabiha","Respectable,Prestigious,Esteemed","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "قابلِ احترام٬ معزز،ہوشیار،عقلمند"
				   ,"نبیہہ");
		setMeaning("Nusrat","Victory. Help.","Arabic","2","Male/Female"
				   ,"عورت/مرد"
				   ,"2"
				   ,"عربی",
				   "فتح، مدد،حمایت،خوشخبری،جیت"
				   ,"نصرت");
		setMeaning("Shumaila","Face,Appearance","Persian","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"فارسی",
				   "صورت،شکل،چہرہ،وضع"
				   ,"شمائلہ");
		setMeaning("Neha","Beauty","Hindi","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"ہندی",
				   "خوبصورتی،حسن و جمال"
				   ,"نیہا"); 
		setMeaning("Naina","Eyes","Hindi","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"ہندی",
				   "آنکھیں"
				   
				   ,"نینا");   
		setMeaning("Muskan","Smile","Sansikrat","7","Female"
				   ,"عورت"
				   ,"7"
				   ,"سنسکرت",
				   "مسکراہٹ،تبسم"
				   ,"مسکان");
		setMeaning("Mishal","Flame,Burn","Persian","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"فارسی",
				   "شمع، قندیل،روشن شعلہ"
				   ,"مشال");
		setMeaning("Kubra","Great, senior,Al-Khubra - Epithet of Khadija","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "اعلیٰ,عظیم"
				   ,"کبری'");
		setMeaning("Sehrish","Glamorous Personality","Persian","10","Female"
				   ,"عورت"
				   ,"10"
				   ,"فارسی",
				   "مسحور کن شخصیت، جادو بھری ،سحر زدہ"
				   ,"سحرش");
		setMeaning("Shehnaz","Bride,Music car","Persian","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"فارسی",
				   "دلہن، موسیقی کار، دلہن موسیقی کاراگ، ملکہ"
				   ,"شہناز");
		setMeaning("Nasreen","Jonquil.","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "سفید پھول، گل سیوتی "
				   ,"نسرین");
		setMeaning("Aqeela","Wise, Sensible","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "عقلمند عورت ،سمجھدار ، ہوشیار ، دانا ،زیرک"
				   ,"عقیلہ");
		setMeaning("Mahnoor","Moon Light","Mah(Persian-Kurdish) and Noor(Arabic)","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"ماہ(فارسی-کرد) اور نور(عربی)",
				   "چاند کی روشنی،چاند کی چمک،چاند کا نور"
				   ,"ماہنور"); 
		setMeaning("Shehzadi","Princess","Persian","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"فارسی",
				   "راج کماری، بادشاہ کی بیٹی،شہزادی"
				   ,"شہزادی");
		setMeaning("Bilqees","Variant Of Bilqis: The Queen Of Sheba,Name of Queen Saba,Beautiful","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "دل کی بینائی، ملکہ سبا کا نام ،حسین و جمیل"
				   ,"بلقیس");
		setMeaning("Benish","Vision, sight; the faculty of seeing,Intelligent","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "ذہین,بصارت"
				   ,"بینش");
		setMeaning("Khalida","Immortal, Deathless,Living in Heaven","Arabic","","Female"
				   ,"عورت"
				   ,""
				   ,"عربی",
				   "جنتی،جنت میں رہنے والی،امر،دائمی"
				   ,"خالدہ");
		setMeaning("Shama","Flame","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "لو,شعلہ"
				   ,"شمع");
		setMeaning("Nosheen","Sugary, sweet, delicious","Persian","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"فارسی",
				   "شیریں، میٹھی، خوش ذائقہ،مٹھاس،پیاری"
				   ,"نوشین");
		setMeaning("Mehak","Fragrance","Persian","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"فارسی",
				   "خُوشبُو "
				   ,"مہک");
		setMeaning("Maham","Wife of mughal emperor Zaheer Ud Din Babar,Full Moon","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "مغل بادشاہ ظہیر دین بابر کی بیوی کا نام,چودہویں کا چاند"
				   ,"ماہم");
		setMeaning("Imrana","To Populate,To Civilize","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "آباد کرنے والی، آبادی،بسنا ،بسانا،مَعمُور کرنا"
				   ,"عمرانہ"); 
		setMeaning("Zulaikha","Wife of the king of Egypt (Pharaonic age) who was attracted by the beauty of the Prophet Yusuf/Joseph.","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "فرعون کی بیوی کا نام جو حضرت یوسف ﷺ کے حسن سے بے حد متاثر تھی"
				   ,"زلیخا");   
		setMeaning("Rukhsar","Cheek","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "گال٬عارض،گال"
				   ,"رخسار");
		setMeaning("Firdous","Garden,Paradise","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "گلستان ,چمن , باغ"
				   ,"فردوس");
		setMeaning("Naseema","Variant Of Nasima: Gentle Breeze, Zephyr which purifies","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "پاکیزہ ہوا جیسی،نرم ٹھنڈی ہوا، سرد"
				   ,"نسیمہ");
		setMeaning("Razia","Patient,Thankful,Grateful","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "راضی ہونیوالی،خوشی دینے والی،صابر،شاکر،راضی"
				   ,"رضیہ");
		setMeaning("Hameeda","Commendable. Praised. Praiseworthy.","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "قابل ستائش, ، تعریف کے قابل، لائقِ توَصِيف"
				   ,"حمیدہ");
		setMeaning("Zakiya","Pious, Clean, Pure","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "پاک کرنیوالی، بے عیب،پاک صاف"
				   ,"زکیہ");
		setMeaning("Hafiza","Care-Taker,Custodian,Protector","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "حفاظت کرنے والی،نگہبان،خیال کرنے والی"
				   ,"حافظہ");
		setMeaning("Tehreem","Respect,sanctity.","Arabic","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"عربی",
				   "عزت, تقدُس , تحریم"
				   ,"تحریم"); 
		setMeaning("Sabahat","Very White person,Beauty","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "حسن، بہت گورا آدمی، وجاہت ، حسن و جمال"
				   ,"صباحت");
		setMeaning("Shagufta","Soft like a petal","Persian","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"فارسی",
				   "کھلا ہوا، تروتازہ،۔کلی ، ان کھلا پھول،شگوفہ، تازہ پھول"
				   ,"شگفتہ");
		setMeaning("Atifa","Compassionate, Affectionate,Kind","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "ملانے والی، جھکنے والی،شفقت کرنے والی ، کرم کرنے والی ،مہربانی کرنے والی"
				   ,"عاطفہ");
		setMeaning("Almaas","Variant Of Almas: Diamond, Adamant.","Arabic","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"عربی",
				   "سخت پتھر , سنگ خارا , الماس"
				   ,"الماس");
		setMeaning("Maliha","Pleasant","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "خوشگوار , دلکش , خوش طبع"
				   ,"ملیحہ");
		setMeaning("Malika","Queen,Skill,Ability","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "بادشاہ کی بیگم، لیاقت ، مہارت،مالکن"
				   ,"ملکہ");
		setMeaning("Malaika","Angel","Arabic","4","Female"
				   ,"عورت"
				   ,"4"
				   ,"عربی",
				   "فرشتہ، بے عیب، پاک"
				   ,"ملائکہ");
		setMeaning("Saira","One who visits,Tourist","Arabic","5","Female"
				   ,"عورت"
				   ,"5"
				   ,"عربی",
				   "سیر کرنے والی،پھرنے والی، گھومنے والی"
				   ,"سائرہ");
		setMeaning("Sobia","Well Dressed woman","Arabic","1","Female"
				   ,"عورت"
				   ,"1"
				   ,"عربی",
				   "خوش لباس خاتون، لباس والی، پوشاک والی"
				   ,"صوبئہ"); 
		setMeaning("Fozia","Triumphant. Successful. Victorious","Arabic","3","Female"
				   ,"عورت"
				   ,"3"
				   ,"عربی",
				   "کامیاب, کامران"
				   ,"فوزیہ");   
		setMeaning("Fehmida","Intelligent and Wise","Persian","6","Female"
				   ,"عورت"
				   ,"6"
				   ,"فارسی",
				"   ذہین اور حکمت والی"
				   ,"فہمیدہ");
		setMeaning("Farida","Unique,Alone","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "بے نظیر، تنہا، لاثانی،یکتا،واحد،بے مثال"
				   ,"فریدہ");
		setMeaning("Shaista","Beautiful,Civilized,Well-Mannered","Arabic","10","Female"
				   ,"عورت"
				   ,"10"
				   ,"عربی",
				   "جمیل , حسین , خوبصورت،مہذب،باسليقہ، تميز والی"
				   ,"شائستہ");
		setMeaning("Uzair","Name of a prophet,The Biblical Ezra Is The English Language Equivalent","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "پیغمبر کا نام، ناواقف، بہانہ کرنے والا،ایک  پیغمبر حضرت عزیر علیہ السلام"
				   ,"عزیر");
		setMeaning("Sidra","A tree which is on the seventh sky.","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "بیری کا درخت جو ساتویں آسمان پر ہے،۔ انتہا اخیر،ایک درخت"
				   ,"سدرہ");
		setMeaning("Siddiqa","Truthful,Friend,righteous","Arabic","2","Female"
				   ,"عورت"
				   ,"2"
				   ,"عربی",
				   "سچی نہایت سچی، دوست،سچی عورت،انتہائی راست گو"
				   ,"صدیقہ");
		setMeaning("Tahir","Pure, Clean, Chaste","Arabic","8","Female"
				   ,"عورت"
				   ,"8"
				   ,"عربی",
				   "پاک، پاکیزہ ،صاف،پاک کرنےوالا"
				   ,"طاہرہ");
		setMeaning("Kanwal","Water Lily","","9","Female"
				   ,"عورت"
				   ,"9"
				   ,"",
				   "نیلوفر, کنول,"
				   ,"کنول"); 
		setMeaning("Asad","Lion,Brave","Arabic","2","Male"
				   ,"مرد"
				   ,"2"
				   ,"عربی",
				   "شیر،بہادر ،نڈر ، بےباک"
				   ,"اسد");
		setMeaning("Wajid","One Who Finds,Gets","Arabic","5","Male"
				   ,"مرد"
				   ,"5"
				   ,"عربی",
				   "پالنے والا،حاصل کرنے والا،محبت کرنےوالا"
				   ,"واجد");
		setMeaning("Hameed","Praise,Appreciation","Arabic","8","Male"
				   ,"مرد"
				   ,"8"
				   ,"عربی",
				   "تعریف،مدحت،: تیز فہم ، تعریف کیا ہوا ،ذہین"
				   ,"حمید");
		setMeaning("Sadeem","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,""); 
		setMeaning("","","","",""
				   ,""
				   ,""
				   ,"",
				   ""
				   ,"");   
				   
				   
				   
		getMeaning(receivednames);
		int totalHistory = pref2.getInt("totalHistory",0);
		int newtotal = totalHistory+1;
		String Previousname = pref2.getString("History"+totalHistory,"");
		if(receivednames.equals(Previousname)){	
		}
		else{
			
		editor2.putInt("totalHistory",newtotal);
		editor2.putString("History"+newtotal,receivednames);
		editor2.apply();}
		auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
		            			
					TextView textview = (TextView)view;
					String text = textview.getText().toString();
					Intent i =new Intent(MainActivity.this,MainActivity.class);
				    SharedPreferences.Editor editor = pref.edit();
					editor.putString("ReceivedName", text);
					editor.apply();
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					overridePendingTransition(0,0);
					startActivity(i);
					overridePendingTransition(0,0);
					finish();
					}   
				
			});
    	
		
		
		
	}   
	public void setMeaning(String name,String meaning,String origin,String luckyNo,String gender,String urdugender,String urduluckyNo,String urduorigin,String urdumeaning, String urduname){
		meaninglist.add(name+"."+meaning); 
		originlist.add(name+"."+origin);
		luckylist.add(name+"."+luckyNo);
		genderlist.add(name+"."+gender);
		urdunamelist.add(name+"."+urduname);
	    urdumeaninglist.add(name+"."+urdumeaning);
		urduoriginlist.add(name+"."+urduorigin);
		urduluckylist.add(name+"."+urduluckyNo);
		urdugenderlist.add(name+"."+urdugender);
		meaningArray=new String[meaninglist.size()];
	    originArray=new String[originlist.size()];
		luckyArray=new String[luckylist.size()];
		genderArray=new String[genderlist.size()];
		urdunameArray = new String[urdunamelist.size()];
		urdumeaningArray=new String[urdumeaninglist.size()];
	    urduoriginArray=new String[urduoriginlist.size()];
		urduluckyArray=new String[urduluckylist.size()];
		urdugenderArray=new String[urdugenderlist.size()];
		for(int i=0;i<meaninglist.size();i++){
		meaningArray[i]=meaninglist.get(i).toString();
		
		} 
		for(int i=0;i<originlist.size();i++){
			originArray[i]=originlist.get(i).toString();

		}
		for(int i=0;i<luckylist.size();i++){
			luckyArray[i]=luckylist.get(i).toString();

		}
		for(int i=0;i<genderlist.size();i++){
			genderArray[i]=genderlist.get(i).toString();

		}
		for(int i=0;i<urdunamelist.size();i++){
			urdunameArray[i]=urdunamelist.get(i).toString();

		}
		for(int i=0;i<urdumeaninglist.size();i++){
			urdumeaningArray[i]=urdumeaninglist.get(i).toString();

		}
		for(int i=0;i<urduoriginlist.size();i++){
			urduoriginArray[i]=urduoriginlist.get(i).toString();

		}
		for(int i=0;i<urduluckylist.size();i++){
			urduluckyArray[i]=urduluckylist.get(i).toString();

		}
		for(int i=0;i<urdugenderlist.size();i++){
			urdugenderArray[i]=urdugenderlist.get(i).toString();

		}
		
	}
	public void getMeaning(String name){
		/*if(name.equals("Ali")){
			name = "Ali.";
		}
		else if(name.equals("Salma")){
			name = "Salma.";
		} 
		else if(name.equals("Asifa")){
			name = "Asi.fa";
		} 
		else{
			
		}*/
    for(int i=0;i<meaningArray.length;i++){
		String check=meaningArray[i];
		if(check.contains(name+".")==true){
			receivedmeanings=check.replace(name+".","");
			}
		String check2=originArray[i];
		if(check2.contains(name+".")==true){
			receivedorigin=check2.replace(name+".","");
		}
		String check3=luckyArray[i];
		if(check3.contains(name+".")==true){
		   receivedluckyNos=check3.replace(name+".","");
	}
		String check4=genderArray[i];
		if(check4.contains(name+".")==true){
			receivedgender=check4.replace(name+".","");
		}
		String check5=urdumeaningArray[i]; 
		if(check5.contains(name+".")==true){
			receivedurdumeanings=check5.replace(name+".","");
		}
		String check6=urduoriginArray[i];
		if(check6.contains(name+".")==true){
			receivedurduorigin=check6.replace(name+".","");
		}
		String check7=urduluckyArray[i];
		if(check7.contains(name+".")==true){
			receivedurduluckyNos=check7.replace(name+".","");
		}
		String check8=urdugenderArray[i];
		if(check8.contains(name+".")==true){
			receivedurdugender=check8.replace(name+".","");
		}
		String check9=urdunameArray[i];
		if(check9.contains(name+".")==true){
			receivedurdunames=check9.replace(name+".","");
		}
		
	}
	
	}
	
	
	
	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFrag(new MyFragment("English",receivednames,receivedmeanings,receivedgender,receivedorigin,receivedluckyNos, receivedurdunames, receivedurdumeanings, receivedurduorigin, receivedurdugender, receivedurduluckyNos), "English");
		adapter.addFrag(new UrduFragment(receivednames, receivedurdunames, receivedurdumeanings, receivedurduorigin, receivedurdugender, receivedurduluckyNos), "Urdu");
		viewPager.setAdapter(adapter);
	}
	class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.options,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		switch(item.getItemId()) {
	       	case R.id.history:
				Intent pak = new Intent(MainActivity.this,History.class);
				startActivity(pak);
	    	    return true;
			case R.id.favourites:
				Intent ind = new Intent(MainActivity.this,Favourites.class);
				startActivity(ind);
				return true;
			case R.id.rate:
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("market://details?id=com.swatapps.namedictionary"));
				startActivity (i);
				return true;
			case R.id.share:
				Intent Fan = new Intent(Intent.ACTION_SEND);
				Fan.setType("text/plain");
				Fan.putExtra(Intent.EXTRA_TEXT,"Check out The Meanings of your loved ones' Names. Download Name Dictionary on Google Play:\nhttp://play.google.com/store/apps/details?id=com.swatapps.namedictionary");
				startActivity(Intent.createChooser(Fan,"Choose An App"));
				return true;
		    case R.id.about:
				AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialogStyle);
				builder.setMessage("Version : 1.0\nDevelopers :\nNajam us Saad Khan\n & \nHasaan Ahmed\nCompany : Jinnah.inc ©2016")
				.setPositiveButton("Dismiss",new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog , int id){
						dialog.cancel();
					}
				});
			      AlertDialog alert =builder.create();
				  alert.setTitle("About");
				  alert.show();
				  
				return true;
				default:
				return true;
		}   
		
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.dialogStyle);
		builder.setMessage("Do you really want to exit this App? 👋")
			.setPositiveButton("Exit",new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog , int id){
					finish();
				}
			})
		.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog , int id){
					dialog.cancel();
				}
			});
		AlertDialog alert =builder.create();
		alert.setTitle("Exit 📕");
		alert.show();
	}

	}
	
