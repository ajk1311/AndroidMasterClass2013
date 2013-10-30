package edu.umich.amc.helloworldfragments.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import edu.umich.amc.helloworldfragments.R;
import edu.umich.amc.helloworldfragments.fragment.HelloFragment;
import edu.umich.amc.helloworldfragments.fragment.MainFragment;
import edu.umich.amc.helloworldfragments.fragment.MainFragment.OnWelcomeButtonClickListener;

/**
 * This time around, this activity has a different role. It acts more like a controller
 * for the UI; it is in charge of displaying the correct fragment based on user input events.
 * The fragments listen for and report events, and the activity takes the appropriate action.
 * 
 * Here's an overview of what takes place:
 * 
 * User clicks button
 * ->
 * System interprets this and calls onClick on the View that was pressed
 * ->
 * The View tells any OnClickListeners that it was clicked
 * ->
 * Our MainFragment intercepts this click
 * ->
 * The MainActivity is listening for the Welcome button to be clicked, specifically
 * ->
 * The MainFragment tells the MainActivity it was clicked through the OnWelcomeButtonClick interface
 * ->
 * The MainActivity shows the HelloFragment in response to the click event
 */
public class MainActivity extends FragmentActivity implements OnWelcomeButtonClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		 * savedInstanceState is null when the Activity is starting for the first time.
		 * If the activity is created as a result of a configuration change, then this bundle
		 * will not be null since some saving of state must take place.
		 */
		if (savedInstanceState == null) {
			showMainFragment();
		}
	}
	
	private void showMainFragment() {
		// Notice how we don't add this transaction to the back stack. We want the application to exit when pressing back after this.
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
	}
	
	@Override
	public void onWelcomButtonClick() {
		
		/*
		 * In response to a click on the welcome button, we show the HelloFragment.
		 */
		sayHello();
	}
	
	private void sayHello() {
		// Get a handle on the activity's FragmentManager
		final FragmentManager fm = getSupportFragmentManager();
		
		// Start a new set of fragment actions in a single transaction
		final FragmentTransaction ft = fm.beginTransaction();
		
		// Sets a nice animation to run when the fragment is shown
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		
		// Add a fragment to the layout. This could also be replace, remove, attach, detach, etc.
		ft.replace(R.id.fragment_container, new HelloFragment());
		
		/*
		 * Adding a transaction to the back stack makes it so the back button will reverse
		 * the transactions in the reverse order they take place. If a fragment is added in
		 * the transaction on the top of the stack, then pressing back will remove that fragment.
		 */
		ft.addToBackStack(null);
		
		// Tell the FragmentManager to execute all of the actions we specified since beginning the transaction.
		ft.commit();
	}
}
