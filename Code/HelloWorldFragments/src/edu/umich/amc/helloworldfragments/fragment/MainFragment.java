package edu.umich.amc.helloworldfragments.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import edu.umich.amc.helloworldfragments.R;

/**
 * This Fragment is shown in the main activity and handles the logic for intercepting any
 * clicks to the welcome button. When the button is clicked, we let the activity know through
 * the OnWelcomeButtonClickListener interface. That way the activity can take the correct action.
 */
public class MainFragment extends Fragment implements OnClickListener{

	/**
	 * Reference to the welcome button
	 */
	private Button mButton;
	
	/**
	 * Private instance of the OnWelcomeButtonClickListener interface. This instance must
	 * be notified whenever the welcome button is clicked. We do this by calling onWelcomeButtonClick.
	 */
	private OnWelcomeButtonClickListener mListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*
		 * We have to manually inflate the View and return it because the method setContentView
		 * does not exist for Fragments. I don't know why, but that's how it is.
		 */
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		/*
		 * At this point, our root View is guaranteed to be created, so we can
		 * search the hierarchy for the welcome button.
		 */
		mButton = (Button) view.findViewById(R.id.btn_welcome);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		/*
		 * This is where we set up our reference to the listener interface.
		 * If the activity implements this interface, which it should, then 
		 * we simply set our reference to it and life is good. Otherwise, we
		 * crash the application and log a specific message saying why. 
		 */
		try {
			mListener = (OnWelcomeButtonClickListener) activity;
		} catch (ClassCastException castingError) {
			throw new IllegalStateException("Activity must implement OnWelcomeButtonClickListener!");
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		/*
		 * We set the listener here so that when the activity/fragment is recreated on
		 * configuration change, the listener refers to the correct activity instance
		 */
		mButton.setOnClickListener(this);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		/*
		 * We null out the listener here so that there are no longer any references held
		 * on the fragment when it is destroyed during a configuration change.
		 */
		mButton.setOnClickListener(null);
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		
		/*
		 * Null out the listener reference to avoid holding on to a dead activity.
		 */
		mListener = null;
	}
	
	@Override
	public void onClick(View v) {
		if (mListener != null)
			/*
			 * Here we are notifying the listener that the welcome button was clicked.
			 * We are just delegating the click event from the system to the listener 
			 * so the listener can take the appropriate action in response to the event
			 */
			mListener.onWelcomButtonClick();
	}
	
	/**
	 * Interface for listening for the welcome button to be clicked.
	 * Classes that implement this interface will be notified when the event occurs.
	 */
	public interface OnWelcomeButtonClickListener {
		
		/**
		 * Callback for when the welcome button is clicked.
		 * Since we are intercepting this action in this Fragment, we must notify all listeners
		 * for the click when the event actually takes place. The system lets the Fragment know
		 * in onClick, since it implements the OnClickListener interface.
		 */
		public void onWelcomButtonClick();
	}
}
