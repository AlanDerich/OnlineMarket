package com.derich.onlinemarket.livedata;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.derich.onlinemarket.model.Categories;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirestoreLiveData extends LiveData<List<Categories>> implements EventListener<DocumentSnapshot> {
    private DocumentReference documentReference;

    private List<Categories> shoppingListTemp = new ArrayList<>();

    public MutableLiveData<List<Categories>> shoppingList = new MutableLiveData<List<Categories>>();

    private ListenerRegistration listenerRegistration = () -> {};

    public FirestoreLiveData(DocumentReference documentReference) {
        this.documentReference = documentReference;
    }

    @Override
    protected void onActive() {
        listenerRegistration = documentReference.addSnapshotListener(this);
        super.onActive();
    }

    @Override
    protected void onInactive() {
        listenerRegistration.remove();
        super.onInactive();
    }

    @Override
    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

        if(documentSnapshot != null && documentSnapshot.exists()) {
            Map<String, Object> shoppingListItems = documentSnapshot.getData();
            shoppingListTemp.clear();

            for (Map.Entry<String, Object> entry : shoppingListItems.entrySet()) {
                Categories itemToAdd = new Categories();
                itemToAdd.setCategoryName(entry.getValue().toString());
                shoppingListTemp.add(itemToAdd);
            }

            shoppingList.setValue(shoppingListTemp);
        }
    }

}
