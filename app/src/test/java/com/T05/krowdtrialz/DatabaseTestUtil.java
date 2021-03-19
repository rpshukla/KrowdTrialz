package com.T05.krowdtrialz;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.T05.krowdtrialz.util.Database;

/**
 * Helper methods for testing the Database class.
 */
public class DatabaseTestUtil {
    private static final String TAG = "DatabaseTestUtil";
    /**
     * Deletes the user from firestore to clean up after testing.
     */
    public static void deleteUser() {
        String id = Database.getInstance().getDeviceUser().getId();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(id)
            .delete()
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "Successfully delete user with id: " + id);
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, "Failed to delete user with id: " + id);
                }
            });
    }
}
