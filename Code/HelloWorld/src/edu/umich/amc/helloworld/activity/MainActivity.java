package edu.umich.amc.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.umich.amc.helloworld.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button mWelcomeButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Tell the Activity that its view will be inflated
		// from the layout resource file called activity_main.xml
		setContentView(R.layout.activity_main);
		
		// Find the welcome button in the Activity's view
		// findViewById returns a View, so the cast is needed
		mWelcomeButton = (Button) findViewById(R.id.btn_welcome);
		
		/*
		 * An alternative way to set up the listener, but this
		 * does not demonstrate the activity life cycle
		 * 
		 * mWelcomeButton.setOnClickListener(new OnClickListener() {
		 * 		@Override
		 * 		public void onClick(View v) {
		 * 			sayHello();
		 * 		}
		 * });
		 */
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mWelcomeButton.setOnClickListener(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mWelcomeButton.setOnClickListener(null);
	}
	
	@Override
	public void onClick(View v) {
		sayHello();
	}
	
	private void sayHello() {
		final Intent helloIntent = new Intent(this, HelloWorldActivity.class);
		startActivity(helloIntent);
	}
}
