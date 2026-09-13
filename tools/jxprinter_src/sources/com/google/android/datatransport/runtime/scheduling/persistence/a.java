package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3302a;
    public final /* synthetic */ SQLiteEventStore b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i5) {
        this.f3302a = i5;
        this.b = sQLiteEventStore;
        this.c = obj;
        this.d = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f3302a) {
            case 0:
                return this.b.lambda$loadClientMetrics$20("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", (HashMap) this.c, (ClientMetrics.Builder) this.d, (SQLiteDatabase) obj);
            case 1:
                return this.b.lambda$loadEvents$14((ArrayList) this.c, (TransportContext) this.d, (Cursor) obj);
            case 2:
                return this.b.lambda$persist$1((EventInternal) this.c, (TransportContext) this.d, (SQLiteDatabase) obj);
            default:
                return this.b.lambda$loadClientMetrics$19((Map) this.c, (ClientMetrics.Builder) this.d, (Cursor) obj);
        }
    }
}
