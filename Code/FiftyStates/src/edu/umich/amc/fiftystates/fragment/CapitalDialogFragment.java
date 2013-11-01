package edu.umich.amc.fiftystates.fragment;

import edu.umich.amc.fiftystates.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class CapitalDialogFragment extends DialogFragment {
	
	private static final String KEY_STATE	= "CapitalDialogFragment.STATE";
	private static final String KEY_CAPITAL	= "CapitalDialogFragment.CAPITAL";

	/**
	 * Since Fragments are created/recreated using a default constructor, supply
	 * a create function that will provide arguments that are maintained across
	 * instances of this Fragment class.
	 * 
	 * @param stateName
	 * @param stateCapital
	 * @return
	 */
	public static CapitalDialogFragment create(String stateName, 
			String stateCapital) {
		CapitalDialogFragment f = new CapitalDialogFragment();
		Bundle args = new Bundle();
		args.putString(KEY_STATE, stateName);
		args.putString(KEY_CAPITAL, stateCapital);
		f.setArguments(args);
		return f;
	}
	
	// The name of the state we are going to display
	private String mName;
	
	// The name of the capital of the state we are going to display
	private String mCapital;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Retrieve the arguments that were supplied by create()
		mName = getArguments().getString(KEY_STATE);
		mCapital = getArguments().getString(KEY_CAPITAL);
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final String pt1 = getString(R.string.msg_prefix);
		final String pt2 = getString(R.string.is);
		builder.setMessage(pt1 + mName + pt2 + mCapital + ".");
		builder.setNeutralButton(R.string.dialog_done, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		return builder.create();
	}
}
