package com.derich.onlinemarket.view.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.derich.onlinemarket.livedata.FirestoreLiveData;
import com.derich.onlinemarket.model.Categories;
import com.derich.onlinemarket.repository.Repository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private Repository repository = new Repository();
    public MutableLiveData<List<Categories>> shoppingList = new MutableLiveData<List<Categories>>();
    FirestoreLiveData liveData = new FirestoreLiveData(null);

    public LiveData<List<Categories>> getShoppingListLiveData() {
        liveData = repository.getFirestoreLiveData();
        return liveData;
    }

    public LiveData<List<Categories>> getShoppingList() {
        return liveData.shoppingList;
    }
}