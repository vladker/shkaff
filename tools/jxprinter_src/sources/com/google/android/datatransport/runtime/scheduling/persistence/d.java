package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3305a = 0;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(TransportContext transportContext, long j6) {
        this.b = j6;
        this.c = transportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f3305a) {
            case 0:
                return SQLiteEventStore.lambda$recordNextCallTime$7(this.b, (TransportContext) this.c, (SQLiteDatabase) obj);
            default:
                return ((SQLiteEventStore) this.c).lambda$cleanUp$12(this.b, (SQLiteDatabase) obj);
        }
    }

    public /* synthetic */ d(SQLiteEventStore sQLiteEventStore, long j6) {
        this.c = sQLiteEventStore;
        this.b = j6;
    }
}
