package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.a;
import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.C0434t;
import com.android.billingclient.api.C0436u;
import com.android.billingclient.api.C0441w0;
import com.android.billingclient.api.C0442x;
import com.android.billingclient.api.G;
import com.android.billingclient.api.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzc {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Bundle bundle, String str) {
        if (bundle != null) {
            return bundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
        }
        zzn(str, "Unexpected null bundle received!");
        return 0;
    }

    public static int zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzn(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzm(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        zzn(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle zzc(Bundle bundle, String str, @Nullable String str2, long j6) {
        bundle.putString("playBillingLibraryVersion", "9.1.0");
        if (str2 != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str2);
        }
        bundle.putLong("billingClientSessionId", j6);
        return bundle;
    }

    public static Bundle zzd(H h6, zzjs zzjsVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("RESPONSE_CODE", h6.f2433a);
        bundle.putString("DEBUG_MESSAGE", h6.getDebugMessage());
        bundle.putInt("LOG_REASON", zzjsVar.zza());
        return bundle;
    }

    public static Bundle zze(H h6, zzjs zzjsVar, @Nullable String str) {
        Bundle bundleZzd = zzd(h6, zzjsVar);
        if (str != null) {
            bundleZzd.putString("ADDITIONAL_LOG_DETAILS", str);
        }
        return bundleZzd;
    }

    public static Bundle zzf(C0442x c0442x, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, String str, @Nullable String str2, long j6, String str3, long j7) {
        int i5;
        Bundle bundle = new Bundle();
        zzc(bundle, "9.1.0", str2, j6);
        bundle.putLong("billingClientTransactionId", j7);
        int i6 = c0442x.d.c;
        if (i6 != 0) {
            bundle.putInt("prorationMode", i6);
        }
        if (!TextUtils.isEmpty(c0442x.zze())) {
            bundle.putString("accountId", c0442x.zze());
        }
        if (!TextUtils.isEmpty(c0442x.zzf())) {
            bundle.putString("obfuscatedProfileId", c0442x.zzf());
        }
        if (c0442x.f2589g) {
            bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
        }
        if (!TextUtils.isEmpty(c0442x.zzh())) {
            bundle.putString("oldSkuPurchaseToken", c0442x.zzh());
        }
        c0442x.zzg();
        if (!TextUtils.isEmpty(null)) {
            c0442x.zzg();
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(c0442x.zzi())) {
            bundle.putString("originalExternalTransactionId", c0442x.zzi());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z6 && z8) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z7 && z9) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z10 || c0442x.getDeveloperBillingOptionParams() != null) {
            bundle.putBoolean("enableAlternativeBilling", true);
        }
        if (c0442x.getDeveloperBillingOptionParams() != null) {
            if (c0442x.getDeveloperBillingOptionParams().getLinkUri() != null) {
                bundle.putString("developerBillingLinkUri", c0442x.getDeveloperBillingOptionParams().getLinkUri().toString());
            }
            if (c0442x.getDeveloperBillingOptionParams().b != 0) {
                bundle.putInt("developerBillingLaunchMode", c0442x.getDeveloperBillingOptionParams().b);
            }
            bundle.putInt("developerBillingProgram", c0442x.getDeveloperBillingOptionParams().c);
            if (c0442x.getDeveloperBillingOptionParams().getExternalTransactionToken() != null) {
                bundle.putString("externalTransactionToken", c0442x.getDeveloperBillingOptionParams().getExternalTransactionToken());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (C0436u c0436u : c0442x.zzk()) {
            if (c0436u.getSubscriptionProductReplacementParams() != null) {
                String productId = c0436u.zza().getProductId();
                C0434t subscriptionProductReplacementParams = c0436u.getSubscriptionProductReplacementParams();
                zzek zzekVarZza = zzel.zza();
                zzeu zzeuVarZza = zzev.zza();
                zzeuVarZza.zza(zzq(productId, "subs", str3));
                zzekVarZza.zza(zzeuVarZza);
                zzeu zzeuVarZza2 = zzev.zza();
                zzeuVarZza2.zza(zzq(subscriptionProductReplacementParams.getOldProductId(), "subs", str3));
                zzekVarZza.zzb(zzeuVarZza2);
                switch (subscriptionProductReplacementParams.getReplacementMode()) {
                    case 1:
                        i5 = 2;
                        break;
                    case 2:
                        i5 = 3;
                        break;
                    case 3:
                        i5 = 4;
                        break;
                    case 4:
                        i5 = 6;
                        break;
                    case 5:
                        i5 = 7;
                        break;
                    case 6:
                        i5 = 8;
                        break;
                    case 7:
                        i5 = 9;
                        break;
                    default:
                        i5 = 1;
                        break;
                }
                zzekVarZza.zzc(i5);
                arrayList.add((zzel) zzekVarZza.zzi());
            }
        }
        if (!arrayList.isEmpty()) {
            zzem zzemVarZza = zzen.zza();
            zzemVarZza.zza(arrayList);
            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzen) zzemVarZza.zzi()).zzQ());
        }
        return bundle;
    }

    public static Bundle zzg(String str, @Nullable String str2, ArrayList arrayList, @Nullable String str3, @Nullable String str4, zza zzaVar, long j6) {
        Bundle bundle = new Bundle();
        zzc(bundle, "9.1.0", str2, j6);
        bundle.putBoolean("enablePendingPurchases", true);
        bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_MULTIPLE_OFFERS", new ArrayList<>(zzca.zzm("subs", "inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_PREORDER_OFFERS", new ArrayList<>(zzca.zzl("inapp")));
        bundle.putStringArrayList("PRODUCT_TYPES_TO_RETURN_RENT_OFFERS", new ArrayList<>(zzca.zzl("inapp")));
        bundle.putBoolean("SHOULD_RETURN_UNFETCHED_PRODUCTS", true);
        if (zzaVar.zza) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        int size = arrayList.size();
        boolean z6 = false;
        boolean z7 = false;
        for (int i5 = 0; i5 < size; i5++) {
            C0441w0 c0441w0 = (C0441w0) arrayList.get(i5);
            arrayList2.add(null);
            z6 |= !TextUtils.isEmpty(null);
            arrayList4.add(c0441w0.getDynamicProductToken());
            z7 |= !TextUtils.isEmpty(c0441w0.getDynamicProductToken());
            if (c0441w0.zzb().equals("first_party")) {
                zzbl.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                arrayList3.add(null);
            }
        }
        if (z6) {
            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList3);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        if (z7) {
            bundle.putStringArrayList("SKU_DYNAMIC_PRODUCT_TOKEN_LIST", arrayList4);
        }
        return bundle;
    }

    public static Bundle zzh(String str, @Nullable String str2, long j6) {
        Bundle bundle = new Bundle();
        zzc(bundle, "9.1.0", str2, j6);
        return bundle;
    }

    public static H zzi(Intent intent, String str) {
        if (intent != null) {
            G gNewBuilder = H.newBuilder();
            gNewBuilder.setResponseCode(zzb(intent.getExtras(), str));
            gNewBuilder.setDebugMessage(zzj(intent.getExtras(), str));
            return gNewBuilder.build();
        }
        zzn("BillingHelper", "Got null intent!");
        G gNewBuilder2 = H.newBuilder();
        gNewBuilder2.setResponseCode(6);
        gNewBuilder2.setDebugMessage("An internal error occurred.");
        return gNewBuilder2.build();
    }

    public static String zzj(Bundle bundle, String str) {
        if (bundle == null) {
            zzn(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zzm(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        zzn(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static String zzk(int i5) {
        return zzb.zza(i5).toString();
    }

    @Nullable
    public static List zzl(Bundle bundle, Set set) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            C0431r0 c0431r0Zzp = zzp(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"), set);
            if (c0431r0Zzp == null) {
                zzm("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(c0431r0Zzp);
            return arrayList;
        }
        zzm("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
        for (int i5 = 0; i5 < stringArrayList.size() && i5 < stringArrayList2.size(); i5++) {
            C0431r0 c0431r0Zzp2 = zzp(stringArrayList.get(i5), stringArrayList2.get(i5), set);
            if (c0431r0Zzp2 != null) {
                arrayList.add(c0431r0Zzp2);
            }
        }
        return arrayList;
    }

    public static void zzm(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            if (str2.isEmpty()) {
                Log.v(str, str2);
                return;
            }
            int i5 = 40000;
            while (!str2.isEmpty() && i5 > 0) {
                int iMin = Math.min(str2.length(), Math.min(4000, i5));
                Log.v(str, str2.substring(0, iMin));
                str2 = str2.substring(iMin);
                i5 -= iMin;
            }
        }
    }

    public static void zzn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void zzo(String str, String str2, @Nullable Throwable th) {
        try {
            if (Log.isLoggable(str, 5)) {
                if (th == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static C0431r0 zzp(String str, String str2, Set set) {
        C0431r0 c0431r0 = null;
        if (str == null || str2 == null) {
            zzm("BillingHelper", "Received a null purchase data.");
            return null;
        }
        try {
            C0431r0 c0431r1 = new C0431r0(str, str2);
            try {
                set.isEmpty();
                return c0431r1;
            } catch (JSONException e) {
                e = e;
                c0431r0 = c0431r1;
                zzn("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
                return c0431r0;
            }
        } catch (JSONException e6) {
            e = e6;
        }
    }

    private static String zzq(String str, String str2, String str3) {
        return a.m("subs:", str3, ParameterizedMessage.ERROR_MSG_SEPARATOR, str);
    }
}
