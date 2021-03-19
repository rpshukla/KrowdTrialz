package com.T05.krowdtrialz;

import android.content.SharedPreferences;

import com.T05.krowdtrialz.util.Database;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class DatabaseInitializationTests {

    private String id;

    /**
     * Test initializeInstance for the scenario where a new user needs to be created.
     */
    @Test
    void testInitializeInstanceNewUser() {
        final SharedPreferences sharedPreferences = Mockito.mock(SharedPreferences.class);
        // Make sharedPreferences return null id to force Database to generate a new id.
        when(sharedPreferences.getString("ID", null)).thenReturn(null);
        Database.initializeInstance(sharedPreferences, new Database.InitializeDatabaseCallback() {
            @Override
            public void onSuccess() {
                assertNotNull(Database.getInstance().getDeviceUser());
                DatabaseTestUtil.deleteUser();
            }

            @Override
            public void onFailure() {
                fail("onFailure called");
            }
        } );
    }

    /**
     * Test initializeInstance for the scenario where a user already exists.
     */
    @Test
    void testInitializeInstanceExistingUser() {
    }

}
