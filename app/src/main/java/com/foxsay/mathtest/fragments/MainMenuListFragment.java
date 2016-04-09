package com.foxsay.mathtest.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.foxsay.mathtest.R;

/**
 * @author roman
 */
public class MainMenuListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.main_menu_array));
        setListAdapter(adapter);
    }

}
