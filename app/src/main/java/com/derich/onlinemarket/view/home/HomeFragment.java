package com.derich.onlinemarket.view.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.derich.onlinemarket.R;
import com.derich.onlinemarket.model.Categories;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ProgressBar progressBar = root.findViewById(R.id.progressbarhome);
        progressBar.setVisibility(View.VISIBLE);
        ArrayList<Categories> arrayOfItems = new ArrayList<>();
        CategoriesAdapter adapter = new CategoriesAdapter(getContext(), arrayOfItems);
        homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        homeViewModel.getShoppingListLiveData().observe(getViewLifecycleOwner(), Observable -> {});

        homeViewModel.getShoppingList().observe(getViewLifecycleOwner(), shoppingList -> {

            if (shoppingList != null ) {
                adapter.clear();
                adapter.addAll(shoppingList);

                ListView listView = root.findViewById(R.id.list);
                listView.setAdapter(adapter);

                progressBar.setVisibility(View.GONE);
            } else {

                Log.d("TAG", "awaiting for info");

            }
        });
        return root;
    }
}