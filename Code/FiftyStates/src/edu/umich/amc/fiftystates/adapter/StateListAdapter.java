package edu.umich.amc.fiftystates.adapter;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.umich.amc.fiftystates.R;

/**
 * This is a ListAdapter that provides a ListView with views bound to data from the list of the 50 United States
 */
public class StateListAdapter extends BaseAdapter {
	private static final int NUM_STATES = 50;
	
	private Context mContext;
	private Map<String, String> mCapitals;
	
	public StateListAdapter(Context context) {
		mContext = context;
		mCapitals = buildStateCapitalMap();
	}
	
	/**
	 * Simple POJO for holding all the info for a state.
	 * Normally model classes like this would go in their own package,
	 * but we don't have a view associated with this model so let's just keep it here
	 */
	public static class StateData {
		public String name;
		public String capital;
		public int iconId;
	}

	@Override
	public int getCount() {
		return NUM_STATES;
	}

	@Override
	public Object getItem(int position) {
		if (position < 0 || position >= NUM_STATES)
			return null;
		StateData data = new StateData();
		data.name = STATES[position];
		data.capital = mCapitals.get(data.name);
		data.iconId = ICONS[position];
		return data;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		 * If the convertView is null, that means the adapter wants to create
		 * some views for the first time to show on the screen, not reuse a recycled view
		 */
		if (convertView == null) {
			convertView = newView(parent);
		}
		/*
		 * Whether the view is recycled or new, we have to bind data to it, so we call bindView here
		 */
		bindView(convertView, position);
		return convertView;
	}
	
	/**
	 * @param parent The ViewGroup the View will belong to
	 * @return A new View that will be used as a list row in the ListView backed by this Adapter
	 */
	private View newView(ViewGroup parent) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.list_row, parent, false);
		ViewHolder holder = new ViewHolder();
		holder.stateName = (TextView) view.findViewById(R.id.state_name);
		holder.stateIcon = (ImageView) view.findViewById(R.id.state_icon);
		view.setTag(holder);
		return view;
	}
	
	/**
	 * Binds a given list row View to the data at the given position
	 * 
	 * @param view The View to bind
	 * @param position The position to bind to
	 */
	private void bindView(View view, int position) {
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.stateName.setText(STATES[position]);
		holder.stateIcon.setImageResource(ICONS[position]);
	}
	
	private static class ViewHolder {
		TextView stateName;
		ImageView stateIcon;
	}
	
	/****** DATA ******/
	/*
	 * Here is the data backing the list. It could probably be organized better,
	 * but for the sake of this example it is ok.
	 */

	private Map<String, String> buildStateCapitalMap() {
		final Map<String, String> map = new HashMap<String, String>();
		map.put("Alabama", "Montgomery");
		map.put("Alaska", "Juneau");
		map.put("Arizona", "Phoenix");
		map.put("Arkansas", "Little Rock");
		map.put("California", "Sacramento");
		map.put("Colorado", "Denver");
		map.put("Connecticut", "Hartford");
		map.put("Delaware", "Dover");
		map.put("Florida", "Tallahassee");
		map.put("Georgia", "Atlanta");
		map.put("Hawaii", "Honolulu");
		map.put("Idaho", "Boise");
		map.put("Illinois", "Springfield");
		map.put("Indiana", "Indianapolis");
		map.put("Iowa", "Des Moines");
		map.put("Kansas", "Topeka");
		map.put("Kentucky", "Frankfort");
		map.put("Louisiana", "Baton Rouge");
		map.put("Maine", "Augusta");
		map.put("Maryland", "Annapolis");
		map.put("Massachusetts", "Boston");
		map.put("Michigan", "Lansing");
		map.put("Minnesota", "St. Paul");
		map.put("Mississippi", "Jackson");
		map.put("Missouri", "Jefferson City");
	  	map.put("Montana", "Helena");
	  	map.put("Nebraska", "Lincoln");
	  	map.put("Nevada", "Carson City");
	  	map.put("New Hampshire", "Concord");
	  	map.put("New Jersey", "Trenton");
	  	map.put("New Mexico", "Santa Fe");
	  	map.put("New York", "Albany");
	  	map.put("North Caronlina", "Raleigh");
	  	map.put("North Dakota", "Bismark");
	  	map.put("Ohio", "Columbus");
	  	map.put("Oklahoma", "Oklahoma City");
	  	map.put("Oregon", "Salem");
	  	map.put("Pennsylvania", "Harrisburg");
	  	map.put("Rhode Island", "Providence");
	  	map.put("South Carolina", "Columbia");
	  	map.put("South Dakota", "Pierre");
	  	map.put("Tennessee", "Nashville");
	  	map.put("Texas", "Austin");
		map.put("Utah", "Salt Lake City");
		map.put("Vermont", "Montpelier");
		map.put("Virginia", "Richmond");
		map.put("Washington", "Olympia");
		map.put("West Virginia", "Charleston");
		map.put("Wisconsin", "Madison");
		map.put("Wyoming", "Cheyenne");
	  	return map;
	}

	private static final String[] STATES = new String[] {
		"Alabama",
		"Alaska",
		"Arizona",
		"Arkansas",
		"California",
		"Colorado",
		"Connecticut",
		"Delaware",
		"Florida",
		"Georgia",
		"Hawaii",
		"Idaho",
		"Illinois",
		"Indiana",
		"Iowa",
		"Kansas",
		"Kentucky",
		"Louisiana",
		"Maine",
		"Maryland",
		"Massachusetts",
		"Michigan",
		"Minnesota",
		"Mississippi",
		"Missouri",
		"Montana",
		"Nebraska",
		"Nevada",
		"New Hampshire",
		"New Jersey",
		"New Mexico",
		"New York",
		"North Carolina",
		"North Dakota",
		"Ohio",
		"Oklahoma",
		"Oregon",
		"Pennsylvania",
		"Rhode Island",
		"South Carolina",
		"South Dakota",
		"Tennessee",
		"Texas",
		"Utah",
		"Vermont",
		"Virginia",
		"Washington",
		"West Virginia",
		"Wisconsin",
		"Wyoming"
	};
	
	private static final int[] ICONS = new int[] {
		R.drawable.al,
		R.drawable.ak,
		R.drawable.az,
		R.drawable.ar,
		R.drawable.ca,
		R.drawable.co,
		R.drawable.ct,
		R.drawable.de,
		R.drawable.fl,
		R.drawable.ga,
		R.drawable.hi,
		R.drawable.id,
		R.drawable.il,
		R.drawable.in,
		R.drawable.ia,
		R.drawable.ks,
		R.drawable.ky,
		R.drawable.la,
		R.drawable.me,
		R.drawable.md,
		R.drawable.ma,
		R.drawable.mi,
		R.drawable.mn,
		R.drawable.ms,
		R.drawable.mo,
		R.drawable.mt,
		R.drawable.ne,
		R.drawable.nv,
		R.drawable.nh,
		R.drawable.nj,
		R.drawable.nm,
		R.drawable.ny,
		R.drawable.nc,
		R.drawable.nd,
		R.drawable.oh,
		R.drawable.ok,
		R.drawable.or,
		R.drawable.pa,
		R.drawable.ri,
		R.drawable.sc,
		R.drawable.sd,
		R.drawable.tn,
		R.drawable.tx,
		R.drawable.ut,
		R.drawable.vt,
		R.drawable.va,
		R.drawable.wa,
		R.drawable.wv,
		R.drawable.wi,
		R.drawable.wy
	};
}
