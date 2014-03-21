package com.example.voicerecognition;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class VoiceActivity extends Activity
{

  private static final int REQUEST_CODE = 1234;
  GridView grid;
  Button speakButton, jouneyButton;
  TextView txt_titles, txt_links, txt_path;
  ImageView view1, view2, view3, img;
  ImageView[] view;
  AnimationDrawable frameAnimation;
  
  
  	@Override
  	public void onCreate(Bundle savedInstanceState)
  	{
  		super.onCreate(savedInstanceState);
  		setContentView(R.layout.voice_demo);
  		
  		img = (ImageView)findViewById(R.id.imageView5);
  		img.setBackgroundResource(R.drawable.spin_animation);
  		frameAnimation = (AnimationDrawable) img.getBackground();

  		speakButton = (Button) findViewById(R.id.speakButton);
  		jouneyButton = (Button) findViewById(R.id.journeyButton);
  		//text = (TextView) findViewById(R.id.textView1);
  		txt_links = (TextView) findViewById(R.id.txtView_links);
  		txt_titles = (TextView) findViewById(R.id.txtView_titles);
  		txt_path = (TextView) findViewById(R.id.txtView_jouney);
  		//grid = (GridView) findViewById(R.id.gridview);
  		view = new ImageView[9];
  		
  		
  		
  		view[0] = (ImageView) findViewById(R.id.imageView1);
  		view[1] = (ImageView) findViewById(R.id.imageView2);
  		view[2] = (ImageView) findViewById(R.id.imageView3);
  		view[3] = (ImageView) findViewById(R.id.imageView4);
  		view[4] = (ImageView) findViewById(R.id.imageView5);
  		view[5] = (ImageView) findViewById(R.id.imageView6);
  		view[6] = (ImageView) findViewById(R.id.imageView7);
  		view[7] = (ImageView) findViewById(R.id.imageView8);
  		view[8] = (ImageView) findViewById(R.id.imageView9);
  		
  		
  		view[0].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 1", Toast.LENGTH_SHORT).show();
				
				String tmp1 = txt_titles.getText().toString();
				Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[0]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[0].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation, getApplicationContext());
				http.execute(arrParams);
			}
		});
  		
  		
  		view[1].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 2", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[1].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation, getApplicationContext());
				http.execute(arrParams);
			}
		});

  		view[2].setOnClickListener(new View.OnClickListener() {
		
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Toast.makeText(getApplicationContext(), "Pos 3", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[2].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation, getApplicationContext());
				http.execute(arrParams);
  			}
  		});
  		
  		view[3].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 4", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[3].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation, getApplicationContext());
				http.execute(arrParams);
			}
		});
  		
  		
  		view[4].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 5", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[4].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation, getApplicationContext());
				http.execute(arrParams);
			}
		});

  		view[5].setOnClickListener(new View.OnClickListener() {
		
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Toast.makeText(getApplicationContext(), "Pos 6", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[5].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation,getApplicationContext());
				http.execute(arrParams);
  			}
  		});
  		
  		view[6].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 7", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[6].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation,getApplicationContext());
				http.execute(arrParams);
			}
		});
  		
  		
  		view[7].setOnClickListener(new View.OnClickListener() {
  			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pos 8", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[7].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation,getApplicationContext());
				http.execute(arrParams);
			}
		});

  		view[8].setOnClickListener(new View.OnClickListener() {
		
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Toast.makeText(getApplicationContext(), "Pos 9", Toast.LENGTH_SHORT).show();
				String tmp1 = txt_titles.getText().toString();
				//Log.e("on click",tmp1);
				txt_titles.setText("");
				String[] tmp = tmp1.split("\\|\\|\\|");
				//Log.e("on click",tmp[1]);
				String[] tmpOld = tmp[4].split("\\s");
				String[] tmpNew = tmp[8].split("\\s");
				int f=0;
				String[] betterTokensOld=new String[tmpOld.length];
				String[] betterTokensNew=new String[tmpNew.length];
				for(int i=0;i<tmpOld.length;i++)
				{
					if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
					continue;	
					betterTokensOld[f]=tmpOld[i];
					f++;
					//Log.e("Better Tokens Old",betterTokensOld[i]);
				}
				
				f=0;
				for(int i=0;i<tmpNew.length;i++)
				{
					if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
					continue;	
					betterTokensNew[f]=tmpNew[i];
					f++;
					//Log.e("Better Tokens New",betterTokensNew[i]);
				}
				//Log.e("titles array", tmp[5]);
				//Log.e("Better Tokens",betterTokens[0]);
				
				String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
				frameAnimation.start();
				ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation,getApplicationContext());
				http.execute(arrParams);
  				
  			}
  		});
  		
  		//grid.setAdapter(new ImageAdapter(this));
  		
  		//grid.setOnItemClickListener(new OnItemClickListener() {
  	    //    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
  	     //       Toast.makeText(VoiceActivity.this, "" + position, Toast.LENGTH_SHORT).show();
  	    //    }
  	   // });

  		// Disable button if no recognition service is present
  		PackageManager pm = getPackageManager();
  		List<ResolveInfo> activities = pm.queryIntentActivities(
  				new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
  		if (activities.size() == 0)
  		{
  			speakButton.setEnabled(false);
  			Toast.makeText(getApplicationContext(), "Recognizer Not Found", Toast.LENGTH_SHORT).show();
  		}
  		speakButton.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				startVoiceRecognitionActivity();
  			}
  		});
  		
  		jouneyButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), txt_path.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});
  	}


  	private void startVoiceRecognitionActivity()
  	{
  		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
  		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
  				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
  		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "AndroidBite Voice Recognition...");
  		startActivityForResult(intent, REQUEST_CODE);
  	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
		{
			ArrayList<String> matches = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS);
			String speech = matches.get(0);
			//text.setText(speech);
			
			Toast.makeText(getApplicationContext(), speech, Toast.LENGTH_LONG).show();
			
			StringTokenizer st = new StringTokenizer(speech, " ");
			
			int i = 0;
			String[] searchElements = new String[st.countTokens()];
			while(st.hasMoreTokens())
			{
				searchElements[i] = st.nextToken();
				i++;
				
			}
			/*
			String path = txt_path.getText().toString();
			if(path!="123456789")
			{
				Toast.makeText(getApplicationContext(), "Journey continues..", Toast.LENGTH_SHORT).show();
				String [] paths = path.split("[-->]");
				path = paths[paths.length - 1] + "-->#" + searchElements[0] + "#" + searchElements[1]; 
				Toast.makeText(getApplicationContext(), path, 5000).show();
			}*/
			
			  frameAnimation.start();
			  ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links,txt_path, frameAnimation,getApplicationContext());
			  http.execute(searchElements);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Voice Recognition Failure", Toast.LENGTH_LONG).show();
			Log.e("Google ni marli", "no response from google");
		}
			//parseJason(res);
		
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
/*
	public void imageViewClick(View v)
	{
	
		//ImageView imageClicked = (ImageView) v;
		String tmp1 = txt_titles.getText().toString();
		//Log.e("on click",tmp1);
		txt_titles.setText("");
		String[] tmp = tmp1.split("\\|\\|\\|");
		Log.e("on click",tmp[0]);
		String[] tmpOld = tmp[4].split("\\s");;;
		String[] tmpNew = {""};
		int f=0;
		
		if(v.getId() == R.id.imageView1)
		{
			Toast.makeText(getApplicationContext(), "Pos 1", Toast.LENGTH_LONG).show();
			tmpNew = tmp[0].split("\\s");
		}
		else if(v.getId() == R.id.imageView2)
		{
			Toast.makeText(getApplicationContext(), "Pos 2", Toast.LENGTH_LONG).show();
			tmpNew = tmp[1].split("\\s");
		}
		
		
		
		
		String[] betterTokensOld=new String[tmpOld.length];
		String[] betterTokensNew=new String[tmpNew.length];
		for(int i=0;i<tmpOld.length;i++)
		{
			if(tmpOld[i].equals("is")||tmpOld[i].equals("the")||tmpOld[i].equals("a")||tmpOld[i].equals("are")||tmpOld[i].equals("of")||tmpOld[i].equals("at")||tmpOld[i].equals("there")||tmpOld[i].equals("here")||tmpOld[i].equals("and")||tmpOld[i].equals("for")||tmpOld[i].equals("he")||tmpOld[i].equals("she")||tmpOld[i].equals("her")||tmpOld[i].equals("his")||tmpOld[i].equals("their")||tmpOld[i].equals("our"))
			continue;	
			betterTokensOld[f]=tmpOld[i];
			f++;
			//Log.e("Better Tokens Old",betterTokensOld[i]);
		}
		
		f=0;
		for(int i=0;i<tmpNew.length;i++)
		{
			if(tmpNew[i].equals("is")||tmpNew[i].equals("the")||tmpNew[i].equals("a")||tmpNew[i].equals("are")||tmpNew[i].equals("of")||tmpNew[i].equals("at")||tmpNew[i].equals("there")||tmpNew[i].equals("here")||tmpNew[i].equals("and")||tmpNew[i].equals("for")||tmpNew[i].equals("he")||tmpNew[i].equals("she")||tmpNew[i].equals("her")||tmpNew[i].equals("his")||tmpNew[i].equals("their")||tmpNew[i].equals("our"))
			continue;	
			betterTokensNew[f]=tmpNew[i];
			f++;
			//Log.e("Better Tokens New",betterTokensNew[i]);
		}
		//Log.e("titles array", tmp[5]);
		//Log.e("Better Tokens",betterTokens[0]);
		
		String[] arrParams = {betterTokensNew[0], betterTokensOld[0]};
		frameAnimation.start();
		ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation);
		http.execute(arrParams);
	
	}*/
	
}