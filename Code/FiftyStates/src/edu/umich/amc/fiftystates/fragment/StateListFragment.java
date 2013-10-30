package edu.umich.amc.fiftystates.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import edu.umich.amc.fiftystates.R;
import edu.umich.amc.fiftystates.adapter.StateListAdapter;
import edu.umich.amc.fiftystates.adapter.StateListAdapter.StateData;

public class StateListFragment extends Fragment implements OnItemClickListener {

	/*
	 * References to our list and adapter. Since we are going
	 * to need access to the data on item click, we need references
	 * to these objects. If the list were for display purposes ONLY
	 * and did not respond to item clicks, you could just create 
	 * local variables for each in the onViewCreated callback.
	 */
	private ListView mListView;
	private StateListAdapter mListAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_state_list, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mListView = (ListView) view.findViewById(R.id.list);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Context context = getActivity();
		mListAdapter = new StateListAdapter(context);
		mListView.setAdapter(mListAdapter);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mListView.setOnItemClickListener(this);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mListView.setOnItemClickListener(null);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		/*
		 * This callback is called every time the user clicks a list row
		 */
		StateData data = (StateData) mListAdapter.getItem(position);
		showStateDialog(data.name, data.capital);
	}
	
	private void showStateDialog(String state, String capital) {
		// For now, we just show a little Toast message. We will go over dialogs next time, so we can show a dialog then.
		Toast.makeText(getActivity(), getString(R.string.msg_prefix) + " " + state + " " + getString(R.string.is) + " " + capital + ".", Toast.LENGTH_LONG).show();
	}
}
