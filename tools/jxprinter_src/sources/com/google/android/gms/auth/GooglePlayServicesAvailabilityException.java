package com.google.android.gms.auth;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzu;

    public GooglePlayServicesAvailabilityException(int i5, String str, Intent intent) {
        super(str, intent);
        this.zzu = i5;
    }

    public int getConnectionStatusCode() {
        return this.zzu;
    }
}
