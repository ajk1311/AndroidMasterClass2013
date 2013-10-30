package edu.umich.amc.fiftystates.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import edu.umich.amc.fiftystates.R;

/**
 * This activity is simple; it only holds the main list fragment. In real life, the
 * fragment is probably not necessary. However, if you were to ever reuse the list 
 * of states, then putting everything in a fragment is wise because they can be dropped
 * in your UI anywhere pretty easily if you set up the interfaces correctly.
 */
public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
