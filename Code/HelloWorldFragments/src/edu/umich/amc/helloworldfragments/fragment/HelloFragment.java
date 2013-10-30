package edu.umich.amc.helloworldfragments.fragment;

import edu.umich.amc.helloworldfragments.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment simply displays a nice Hello message.
 */
public class HelloFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_hello, container, false);
	}
}
