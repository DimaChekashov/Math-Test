package com.foxsay.mathtest.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        OnListItemClick onListItemClick = (OnListItemClick) getActivity();
        switch (position){
            case 0:
                onListItemClick.click(new GeometryMenuListFragment());
                break;
        }
    }

    public interface OnListItemClick{
        void click(ListFragment fragment);
    }
}
