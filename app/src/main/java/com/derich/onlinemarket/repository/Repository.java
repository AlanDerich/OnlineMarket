package com.derich.onlinemarket.repository;

import androidx.lifecycle.LiveData;

import com.derich.onlinemarket.livedata.FirestoreLiveData;
import com.derich.onlinemarket.model.Categories;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Repository {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    public FirestoreLiveData getFirestoreLiveData() {
        DocumentReference documentReference = firebaseFirestore
                .collection("MyCategories")
                .document("test2");

        return new FirestoreLiveData(documentReference);
    }
}

