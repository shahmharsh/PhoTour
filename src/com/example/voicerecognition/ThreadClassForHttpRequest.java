package com.example.voicerecognition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadClassForHttpRequest extends AsyncTask<String, Object, String> {

HttpURLConnection connection;
OutputStreamWriter request;
Bitmap []pic;
TextView txt_titles, txt_links, txt_path;
Context context;
ImageView [] view;
String allLinks = "";
String allTitles = "";
String[] parameters;
AnimationDrawable frameAnimation;




	public ThreadClassForHttpRequest(ImageView[] view, TextView txt_titles, TextView txt_links, TextView txt_path, AnimationDrawable frameAnimation, Context context )
	{
		//this.view1 = view1;
		//this.view2 = view2;
		//this.view3 = view3;
		pic = new Bitmap[9];
		this.view = new ImageView[9];
		this.txt_links = txt_links;
		this.txt_titles = txt_titles;
		this.txt_path = txt_path;
		this.frameAnimation = frameAnimation;
		this.context = context;
		for(int i=0;i<9;i++)
		  this.view[i] = view[i];
	}

    

	@Override
	protected String doInBackground(String... params) {
		String res = "";
		String [] link;
		parameters = params;
		//String nameFile;
		
		try{
			HttpClient client = new DefaultHttpClient();
    		HttpGet request = new HttpGet("http://minesweepers.co/PhoTour/queryFlickr.php?arg1=" + String.valueOf(params[0]) + "&arg2=" + String.valueOf(params[1]));
    		HttpResponse response = client.execute(request);
    		//Here i try to read the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    		StringBuilder sb = new StringBuilder();
	        String line = "";
			while ((line  = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        //get the string version of the response data
	        res = sb.toString();
	        Log.i("json", res);
	        //Log.e("Response", res);
	        
	        link = parseJason(res);
	        Log.i("parsedlinks",link.toString());
	        for(int i=0; i<9; i++)
	        {
	        	allLinks += link[i] + "|||";
	        	
	        	URL url = new URL(link[i] + "_m.jpg");
	            URLConnection conn = url.openConnection();
	            pic[i] = BitmapFactory.decodeStream(conn.getInputStream());
	        	
	        /*	String root = Environment.getExternalStorageDirectory().toString();
	            File myDir = new File(root + "/images_pics");    
	            myDir.mkdirs();

	            String fname = "Image" + i +".jpg";
	            File file = new File (myDir, fname);
	            if (file.exists ()) file.delete (); 
	            try {
	            	FileOutputStream out = new FileOutputStream(file);
	            	pic[i].compress(Bitmap.CompressFormat.JPEG, 90, out);
	            	out.flush();
	            	out.close();

	            } catch (Exception e) {
	            	e.printStackTrace();
	            	
	            	}*/
	        }
	        
	   
		}catch(Exception ex){
			Log.e("JASON Exception", ex.getLocalizedMessage()+"|"+ex.getMessage());
			return null;
		}
		
		return allLinks;
	}
	
	protected void  onPostExecute (String result) 
	{
		//Log.e("onPostExecute", result);
		//parseJason(result);
		//view1.setImageBitmap(pic[0]);
		//view2.setImageBitmap(pic[1]);
		//view3.setImageBitmap(pic[2]);
		
		if(result == null)
		{
			
			Log.e("post execution ", "result null");
			//ThreadClassForHttpRequest http = new ThreadClassForHttpRequest(view, txt_titles, txt_links, txt_path, frameAnimation);
			//http.execute(parameters);
			Toast.makeText(context, "Yahoo Response Failure", Toast.LENGTH_LONG).show();
			frameAnimation.stop();
			return;
		}
		
		frameAnimation.stop();
		for(int i=0; i<9; i++)
		{
			view[i].setImageBitmap(pic[i]);
		}
		
		txt_links.setText(allLinks);
		txt_titles.setText(allTitles);
		String path;
		path = txt_path.getText().toString();
		
		path = path +  "-->#" + parameters[0] + "#" + parameters[1];
		
		txt_path.setText(path);
		
		//Log.e("thread titles", allTitles);
		
	}
	

private String[] parseJason(String res) throws Exception{
		
		
		/*String [] tmp = splitFirst(res, " ");
		String [] link=new String[9];
		String jObj = tmp[1];
		
		jObj = jObj.substring(1, jObj.lastIndexOf("\""));*/
		
		//Log.e("JSON", jObj);
		
		//Gson gson = new Gson();
		        		
		

			 //JSONArray jObject = new JSONArray(jObj); 
			 //Log.e("in try", jObj);
			 JSONObject jObject = new JSONObject(res);
			 //String takeCover = "";
			 //Toast.makeText(getApplicationContext(), "test", 1000);
			 jObject = jObject.getJSONObject("query");
			 jObject = jObject.getJSONObject("results");
			 //Log.e("in try", "making array");
			 JSONArray arr = new JSONArray();
			 arr = jObject.getJSONArray("photo");
			 
			 String [] farm = new String[9];
			 String [] serverId = new String[9];
			 String [] secret = new String[9];
			 String [] imageId = new String[9];
			 String [] title = new String[9];
			 String [] link = new String[9];
			 //Log.e("in try", "array made");
			 
			 for (int i = 0; i < 9; i++)
			 {
				 farm[i] = arr.getJSONObject(i).getString("farm");
				 serverId[i] = arr.getJSONObject(i).getString("server");
				 secret[i] = arr.getJSONObject(i).getString("secret");
				 imageId[i] = arr.getJSONObject(i).getString("id");
				 title[i] = arr.getJSONObject(i).getString("title");
				 //Log.e("JSON Array", "farm: " + farm[i] + " Server ID: " + serverId[i] + " Secret: " + secret[i] + " Image ID: " + imageId[i]);
				 //http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}_[mstzb].jpg
				 link[i]="http://farm"+farm[i]+".staticflickr.com/"+serverId[i]+"/"+imageId[i]+"_"+secret[i];   
				 //Log.e("tokens1223", title[i]);
			 }
			 
			 for(int i=0; i<9; i++)
			 {
				 allTitles +=  title[i] + "|||";
				 //Log.e("tokens", title[i]);
			 }

			
		  		
		
		 //takeTitles = new String[jObject.getJSONObject("results").getJSONArray("result").length()];
		
		Log.i("parseJson", link[8]);	 
		return link;
		 
		 
	}	
	
	public static String[] splitFirst(String source, String splitter)
	  {
	    // hold the results as we find them
	    Vector<String> rv = new Vector<String>();
	    int last = 0;
	    int next = 0;

	    // find first splitter in source
	    next = source.indexOf(splitter, last);
	    if (next != -1)
	    {
	      // isolate from last thru before next
	      rv.add(source.substring(last, next));
	      last = next + splitter.length();
	    }

	    if (last < source.length())
	    {
	      rv.add(source.substring(last, source.length()));
	    }

	    // convert to array
	    return (String[]) rv.toArray(new String[rv.size()]);
	  }
}





