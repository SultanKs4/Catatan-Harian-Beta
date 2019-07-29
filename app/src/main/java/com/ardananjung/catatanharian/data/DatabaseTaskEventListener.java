package com.ardananjung.catatanharian.data;

import androidx.room.RoomDatabase;

public interface DatabaseTaskEventListener {
    Object runDatabaseOperation(RoomDatabase database, Object... params);
    void onDatabaseOperationFinished(Object... results);
}
