package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2591a;
    public final boolean b;
    public final /* synthetic */ y1 c;

    public x1(y1 y1Var, boolean z6) {
        this.c = y1Var;
        this.b = z6;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.f2591a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f2591a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context) {
        if (!this.f2591a) {
            zzc.zzn("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.f2591a = false;
        }
    }

    public final void c(Bundle bundle, H h6, int i5, zzjz zzjzVar, long j6, boolean z6) {
        try {
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            y1 y1Var = this.c;
            if (byteArray != null) {
                ((m1) y1Var.c).b(zzjl.zzc(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD")), j6, z6);
            } else {
                ((m1) y1Var.c).b(i1.zzb(zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i5, h6, null, zzjzVar), j6, z6);
            }
        } catch (Throwable unused) {
            zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzjz zzjzVar;
        int i5;
        int i6;
        H hZzi;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                if (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                    zzjzVar = zzjz.ALTERNATIVE_BILLING_ACTION;
                } else {
                    zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
                }
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                zzjzVar = zzjz.LOCAL_PURCHASES_UPDATED_ACTION;
            } else {
                zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            zzjzVar = zzjz.PURCHASES_UPDATED_ACTION;
        } else {
            zzjzVar = zzjz.BROADCAST_ACTION_UNSPECIFIED;
        }
        zzjz zzjzVar2 = zzjzVar;
        zzjz zzjzVar3 = zzjz.LOCAL_PURCHASES_UPDATED_ACTION;
        if (zzjzVar2.equals(zzjzVar3) || zzjzVar2.equals(zzjz.ALTERNATIVE_BILLING_ACTION)) {
            i5 = 2;
            i6 = 2;
        } else {
            i6 = zzjzVar2.equals(zzjz.PURCHASES_UPDATED_ACTION) ? 32 : 1;
            i5 = 2;
        }
        Bundle extras = intent.getExtras();
        y1 y1Var = this.c;
        if (extras == null) {
            zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            j1 j1Var = y1Var.c;
            zzjs zzjsVar = zzjs.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            H h6 = k1.f2514h;
            ((m1) j1Var).zza(i1.zzb(zzjsVar, i6, h6, null, zzjzVar2));
            InterfaceC0435t0 interfaceC0435t0 = y1Var.b;
            if (interfaceC0435t0 != null) {
                ((p062l0.d) interfaceC0435t0).onPurchasesUpdated(h6, null);
                return;
            }
            return;
        }
        if (i6 == i5) {
            int i7 = zzc.zza;
            G gNewBuilder = H.newBuilder();
            gNewBuilder.setResponseCode(zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
            } else {
                Object obj = extras2.get("SUB_RESPONSE_CODE");
                if (obj == null) {
                    zzc.zzm("BillingBroadcastManager", "getOnPurchasesUpdatedSubResponseCodeFromBundle() got null response code, assuming OK");
                } else {
                    if (obj instanceof Integer) {
                        iIntValue = ((Integer) obj).intValue();
                    } else {
                        zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(obj.getClass().getName()));
                    }
                    gNewBuilder.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                    gNewBuilder.setDebugMessage(zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                    hZzi = gNewBuilder.build();
                }
            }
            iIntValue = 0;
            gNewBuilder.setOnPurchasesUpdatedSubResponseCode(iIntValue);
            gNewBuilder.setDebugMessage(zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
            hZzi = gNewBuilder.build();
        } else {
            hZzi = zzc.zzi(intent, "BillingBroadcastManager");
        }
        long j6 = extras.getLong("billingClientTransactionId", 0L);
        boolean z6 = extras.getBoolean("wasServiceAutoReconnected", false);
        if (zzjzVar2.equals(zzjz.PURCHASES_UPDATED_ACTION) || zzjzVar2.equals(zzjzVar3)) {
            H h7 = hZzi;
            List<C0431r0> listZzl = zzc.zzl(extras, y1Var.f2595g);
            if (h7.f2433a == 0) {
                ((m1) y1Var.c).d(i1.zzc(i6, zzjzVar2), j6, z6);
            } else {
                c(extras, h7, i6, zzjzVar2, j6, z6);
            }
            ((p062l0.d) y1Var.b).onPurchasesUpdated(h7, listZzl);
            return;
        }
        if (zzjzVar2.equals(zzjz.ALTERNATIVE_BILLING_ACTION)) {
            if (hZzi.f2433a != 0) {
                H h8 = hZzi;
                c(extras, h8, i6, zzjzVar2, j6, z6);
                ((p062l0.d) y1Var.b).onPurchasesUpdated(h8, zzca.zzk());
                return;
            }
            y1Var.getClass();
            zzc.zzn("BillingBroadcastManager", "No valid alternative billing listener is registered.");
            j1 j1Var2 = y1Var.c;
            zzjs zzjsVar2 = zzjs.NULL_DEVELOPER_MANAGED_BILLING_LISTENER;
            H h9 = k1.f2514h;
            ((m1) j1Var2).b(i1.zzb(zzjsVar2, i6, h9, null, zzjzVar2), j6, z6);
            ((p062l0.d) y1Var.b).onPurchasesUpdated(h9, zzca.zzk());
        }
    }
}
