package com.example.hangman;

import android.support.v7.app.ActionBarActivity;
import android.text.TextWatcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends ActionBarActivity {

    ImageView iv_new;
    TextView mTextField;
    BufferedReader br;
    String question = "";
    int count = 0 ;
    int questionCount = 0;
    int mistake = 0;
    boolean isGameFinished = false;
    ImageView a;
    ImageView b;
    ImageView c;
    ImageView d;  
    ImageView e;
    ImageView f;
    ImageView g;
    ImageView h;
    ImageView i;
    ImageView j;
    ImageView k;
    ImageView l;
    ImageView m;
    ImageView n;
    ImageView o;
    ImageView p;
    ImageView r;
    ImageView s;
    ImageView t;
    ImageView u;
    ImageView v;
    ImageView w;
    ImageView y;
    ImageView z;
    CountDownTimer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		a = (ImageView)findViewById(R.id.a);
		b = (ImageView)findViewById(R.id.b);
		c = (ImageView)findViewById(R.id.c);
		d = (ImageView)findViewById(R.id.d);
		e = (ImageView)findViewById(R.id.e);
		f = (ImageView)findViewById(R.id.f);
		g = (ImageView)findViewById(R.id.g);
		h = (ImageView)findViewById(R.id.h);
		i = (ImageView)findViewById(R.id.i);
		j = (ImageView)findViewById(R.id.j);
		k = (ImageView)findViewById(R.id.k);
		l = (ImageView)findViewById(R.id.l);
		m = (ImageView)findViewById(R.id.m);
		n = (ImageView)findViewById(R.id.n);
		o = (ImageView)findViewById(R.id.o);
		p = (ImageView)findViewById(R.id.p);
		r = (ImageView)findViewById(R.id.r);
		s = (ImageView)findViewById(R.id.s);
		t = (ImageView)findViewById(R.id.t);
		u = (ImageView)findViewById(R.id.u);
		v = (ImageView)findViewById(R.id.v);
		w = (ImageView)findViewById(R.id.w);
		y = (ImageView)findViewById(R.id.y);
		z = (ImageView)findViewById(R.id.z);
		
		
		iv_new = (ImageView) findViewById(R.id.hangman);
		iv_new.setOnClickListener(event_listener);
		a.setOnClickListener(event_listener);
		b.setOnClickListener(event_listener);
		c.setOnClickListener(event_listener);
		d.setOnClickListener(event_listener);
		e.setOnClickListener(event_listener);
		f.setOnClickListener(event_listener);
		g.setOnClickListener(event_listener);
		h.setOnClickListener(event_listener);
		i.setOnClickListener(event_listener);
		j.setOnClickListener(event_listener);
		k.setOnClickListener(event_listener);
		l.setOnClickListener(event_listener);
		m.setOnClickListener(event_listener);
		n.setOnClickListener(event_listener);
		o.setOnClickListener(event_listener);
		p.setOnClickListener(event_listener);
		r.setOnClickListener(event_listener);
		s.setOnClickListener(event_listener);
		t.setOnClickListener(event_listener);
		u.setOnClickListener(event_listener);
		v.setOnClickListener(event_listener);
		w.setOnClickListener(event_listener);
		y.setOnClickListener(event_listener);
		z.setOnClickListener(event_listener);
		
		mTextField = (TextView) findViewById(R.id.mTextField);
		
		
		
		createNewGame(true);
		
		
	}
	
	public void createTimer() {
	if (timer!=null)
	 timer.cancel();
	
		timer = new CountDownTimer(30000, 1000) {

		     public void onTick(long millisUntilFinished) {
		         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }

		     public void onFinish() {
		      isGameFinished = true;
			  Toast.makeText(getApplicationContext(),"Time has finished!", Toast.LENGTH_LONG).show();
			  mistake = 0;
			  createNewGame(false);
		     }
		  }.start();
	}
	
	public void createNewGame(boolean isNew) {
		
		isGameFinished = false;
		
		InputStream inputStream = this.getResources().openRawResource(R.raw.animals);
		String cvsSplitBy = ",";
		br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		Random r = new Random();
	    int a  = r.nextInt(10);
	    
	    if (!isNew) {
	    	LinearLayout layout = (LinearLayout) findViewById(R.id.blank_layout);
	    	
	    	for (int j=0;j<questionCount;j++) {
	    		
	    	ImageView view = (ImageView) findViewById(j);
	    	layout.removeView(view);
	    	
	    		
	    	}
	    	
	    }
	    
	    
		try {

			while ((line = br.readLine()) != null) {
               
				if (a == count) {
			        // use comma as separator
				String[] country = line.split(cvsSplitBy);

				question = country[0];
				
				questionCount = Integer.parseInt(country[1]);
				
				for (int i=0;i<questionCount;i++) {
				// Let's create the missing ImageView
			    ImageView image = new ImageView(this);
			    image.setId(i);

			    image.setImageResource(R.drawable.blank); 
			    /* if (counter!=0) {
			    image.setLayoutParams(params);
			    }*/
			    // Let's get the root layout and add our ImageView
			    LinearLayout layout = (LinearLayout) findViewById(R.id.blank_layout);
			    layout.addView(image, i);
			  

				}
				
				break;
			}
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 createTimer();
		 makeVisibleCharacter();
	}
	
	
	public void makeVisibleCharacter(){
		
		int j = R.id.a;
		int id = j;
		
		for (;id<j+24;id++) {
			ImageView character = (ImageView) findViewById(id);	
			character.setVisibility(View.VISIBLE);
		}		
	}
	
	public boolean checkGameFinished(){
		
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.blank);
		
		for (int i=0;i<questionCount;i++) {
			
			ImageView character = (ImageView) findViewById(i);	
			
			
			if (character.getDrawable().getConstantState().equals(drawable.getConstantState()))
			{
				return false;
				
			}
		}
		
		return true;
		
		
		
		
	}
	
    OnClickListener event_listener = new View.OnClickListener() {
	    	public void onClick(View v) {
	      //  Toast.makeText(getApplicationContext(), "Beni Týkladýn!!!!!", Toast.LENGTH_SHORT).show();	
	    	ImageView blank = null;
	    	
	    	boolean flag = false;
	    	
	    	
	    	if (!isGameFinished) {
	    		
	    	  if (v.getId() == R.id.a)	{
		    	  
		    	   if (question.contains("a") || question.contains("A")) {
		    		
		    		  for (int i=0;i<question.length();i++){
		    			  
		    			  if(question.charAt(i) == 'a' || question.charAt(i) == 'A') {
		    				  
		    				  blank = (ImageView) findViewById(i); 
		    				  blank.setImageResource(R.drawable.a_letter); 
		    				  flag = true;
		    			 }
		    		  }
		    	   }
		    	  ImageView character = (ImageView) findViewById(R.id.a);
 				  character.setVisibility(View.INVISIBLE);
		       }	
	    	
	    	  if (v.getId() == R.id.b)	{
		    	  
		    	   if (question.contains("b") || question.contains("B")) {
		    		
		    		  for (int i=0;i<question.length();i++){
		    			  
		    			  if(question.charAt(i) == 'b' || question.charAt(i) == 'B') {
		    				  
		    				  blank = (ImageView) findViewById(i); 
		    				  blank.setImageResource(R.drawable.b_letter); 
		    				 
		    				  flag = true;
		    			 }
		    		  }
		    	   }
		    	  ImageView character = (ImageView) findViewById(R.id.b);
 				  character.setVisibility(View.INVISIBLE);
		       }	
	    	
	    	  
	       if (v.getId() == R.id.c)	{
	    	  
	    	   if (question.contains("c") || question.contains("C")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'c' || question.charAt(i) == 'C') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.c_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.c);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.d)	{
		    	  
	    	   if (question.contains("d") || question.contains("D")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'd' || question.charAt(i) == 'D') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.d_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.d);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.e)	{
		    	  
	    	   if (question.contains("e") || question.contains("E")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'e' || question.charAt(i) == 'E') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.e_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.e);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.f)	{
		    	  
	    	   if (question.contains("f") || question.contains("F")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'f' || question.charAt(i) == 'F') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.f_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.f);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.g)	{
		    	  
	    	   if (question.contains("g") || question.contains("G")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'g' || question.charAt(i) == 'G') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.g_letter);
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.g);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       
	       if (v.getId() == R.id.h)	{
		    	  
	    	   if (question.contains("h") || question.contains("H")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'h' || question.charAt(i) == 'H') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.h_letter);
	    				  flag = true;
	    			 } 
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.h);
			   character.setVisibility(View.INVISIBLE); 
	       }
	       
	       if (v.getId() == R.id.i)	{
		    	  
	    	   if (question.contains("i") || question.contains("I")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'i' || question.charAt(i) == 'I') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.i_letter); 
	    				  ImageView character = (ImageView) findViewById(R.id.i);
	    				  character.setVisibility(View.INVISIBLE);
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.i);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.j)	{
		    	  
	    	   if (question.contains("j") || question.contains("J")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'j' || question.charAt(i) == 'J') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.j_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.j);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.k)	{
		    	  
	    	   if (question.contains("k") || question.contains("K")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'k' || question.charAt(i) == 'K') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.k_letter);
	    				 flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.k);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.l)	{
		    	  
	    	   if (question.contains("l") || question.contains("L")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'l' || question.charAt(i) == 'L') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.l_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.l);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       
	       if (v.getId() == R.id.m)	{
		    	  
	    	   if (question.contains("m") || question.contains("M")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'm' || question.charAt(i) == 'M') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.m_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.m);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.n)	{
		    	  
	    	   if (question.contains("n") || question.contains("N")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'n' || question.charAt(i) == 'N') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.n_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.n);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.o)	{
		    	  
	    	   if (question.contains("o") || question.contains("O")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'o' || question.charAt(i) == 'O') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.o_letter);
	    				 flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.o);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.p)	{
		    	  
	    	   if (question.contains("p") || question.contains("P")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'p' || question.charAt(i) == 'P') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.p_letter);
	    				  flag = true;
	    			 }
	    		  }
	    		  ImageView character = (ImageView) findViewById(R.id.p);
				  character.setVisibility(View.INVISIBLE);}
	       }
	       
	       
	       if (v.getId() == R.id.r)	{
		    	  
	    	   if (question.contains("r") || question.contains("R")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'r' || question.charAt(i) == 'R') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.r_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.r);
			   character.setVisibility(View.INVISIBLE);
	       }	
	       
	       
	       
	       if (v.getId() == R.id.s)	{
		    	  
	    	   if (question.contains("s") || question.contains("S")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 's' || question.charAt(i) == 'S') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.s_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.s);
			   character.setVisibility(View.INVISIBLE);
	       }	
	       
	       
	       if (v.getId() == R.id.t)	{
		    	  
	    	   if (question.contains("t") || question.contains("T")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 't' || question.charAt(i) == 'T') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.t_letter); 
	    				  flag = true;
	    				  
	    			 }
	    		  }
	    	   }
	    		  ImageView character = (ImageView) findViewById(R.id.t);
				  character.setVisibility(View.INVISIBLE);
	       }	
	       
	       if (v.getId() == R.id.u)	{
		    	  
	    	   if (question.contains("u") || question.contains("U")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'u' || question.charAt(i) == 'U') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.u_letter); 
	    				  flag = true;
	    			 }
	    		  }
	    	   }
	    	    ImageView character = (ImageView) findViewById(R.id.u);
			    character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.v)	{
		    	  
	    	   if (question.contains("v") || question.contains("V")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'v' || question.charAt(i) == 'V') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.v_letter); 
	    		    	  flag = true;
	    				 
	    			 }
	    		  }
	    	   }
	 		  ImageView character = (ImageView) findViewById(R.id.v);
			  character.setVisibility(View.INVISIBLE);
	       }

	       if (v.getId() == R.id.w)	{
		    	  
	    	   if (question.contains("w") || question.contains("W")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'w' || question.charAt(i) == 'W') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.w_letter); 
	    				  flag = true;
	    				  
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.w);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (v.getId() == R.id.y)	{
		    	  
	    	   if (question.contains("y") || question.contains("Y")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'y' || question.charAt(i) == 'Y') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.y_letter); 
	    				  flag = true;
	    				  
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.y);
			   character.setVisibility(View.INVISIBLE);
				 
	       }
	       
	       
	       if (v.getId() == R.id.z)	{
		    	  
	    	   if (question.contains("z") || question.contains("Z")) {
	    		
	    		  for (int i=0;i<question.length();i++){
	    			  
	    			  if(question.charAt(i) == 'z' || question.charAt(i) == 'Z') {
	    				  
	    				  blank = (ImageView) findViewById(i); 
	    				  blank.setImageResource(R.drawable.z_letter); 
	    				  flag = true;
	    				  
	    			 }
	    		  }
	    	   }
	    	   ImageView character = (ImageView) findViewById(R.id.z);
			   character.setVisibility(View.INVISIBLE);
	       }
	       
	       if (flag == false) {
	    	   
	    	 mistake++; 
	    	 changePicture(mistake);  
	    	   
	       }
	       
	       boolean result = checkGameFinished();
	      
	        if (result) {
	        	
	        	isGameFinished = true;
	        	Toast.makeText(getApplicationContext(),"Tebrikler!", Toast.LENGTH_LONG).show();
	        	
	        	createNewGame(false);
	        }
	       
	    }
	       
	       
	   /* 		count++;
	        if (count == 1) {
	        	
	        	iv_new.setImageResource(R.drawable.b_hangman);
	        }
	        if (count == 2) {
	        	iv_new.setImageResource(R.drawable.c_hangman);	
	        }
	    	if (count == 3) {
	    		iv_new.setImageResource(R.drawable.d_hangman);	
	    	}
	    	if (count == 4) {
	    		
	    		iv_new.setImageResource(R.drawable.e_hangman);	
	    	}
	    */	 
	       
	    	}
    };
    
    
    public void changePicture(int mistake) {
    	
    	  if (mistake == 1) {
	        	iv_new.setImageResource(R.drawable.b_hangman);
	        }
	        if (mistake == 2) {
	        	iv_new.setImageResource(R.drawable.c_hangman);	
	        }
	    	if (mistake == 3) {
	    		iv_new.setImageResource(R.drawable.d_hangman);	
	    	}
	    	if (mistake == 4) {
	    		iv_new.setImageResource(R.drawable.e_hangman);	
	    		isGameFinished = true;
	    		mistake = 0;
	    		createNewGame(false);
	    	}
    	
    	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
