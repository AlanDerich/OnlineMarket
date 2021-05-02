package com.derich.onlinemarket.viewmodel;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.derich.onlinemarket.livedata.FirestoreLiveData;
import com.derich.onlinemarket.model.Categories;
import com.derich.onlinemarket.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Categories>> shoppingList;
    FirestoreLiveData liveData = null;
    Repository repository=new Repository();
//    public MyViewModel(@NonNull Application application){
//        super(application);
//        repository =new Repository();
//    }
    public LiveData<List<Categories>> getCategoryList() {
        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
//            shoppingList=repository.getFirestoreLiveData();
            loadCategories();
        }
        return shoppingList;
    }

    private void loadCategories() {
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
//            List<Categories> categoriesSample = new ArrayList<>();
//            repository.getFirestoreLiveData();
//            long seed = System.nanoTime();
//            Collections.shuffle(categoriesSample, new Random(seed));
//
//            shoppingList.setValue(categoriesSample);
            repository.getFirestoreLiveData();
        }, 5000);
    }
}
