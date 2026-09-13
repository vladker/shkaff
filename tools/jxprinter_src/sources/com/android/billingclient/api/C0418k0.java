package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.android.billingclient.api.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0418k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2490a;
    public final JSONObject b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2493h;

    @Nullable
    private final String zzi;

    @Nullable
    private final List zzj;

    @Nullable
    private final List zzk;

    /* JADX INFO: renamed from: com.android.billingclient.api.k0$a */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2494a;
        public final int b;

        public a(JSONObject jSONObject) {
            this.f2494a = jSONObject.getInt("commitmentPaymentsCount");
            this.b = jSONObject.optInt("subsequentCommitmentPaymentsCount");
        }

        public int getInstallmentPlanCommitmentPaymentsCount() {
            return this.f2494a;
        }

        public int getSubsequentInstallmentPlanCommitmentPaymentsCount() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.android.billingclient.api.k0$b */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2495a;
        public final String b;
        public final ArrayList c;

        @Nullable
        private final String zzd;

        @Nullable
        private final String zze;

        @Nullable
        private final String zzf;

        @Nullable
        private final Long zzh;

        @Nullable
        private final a zzi;

        @Nullable
        private final e zzj;

        @Nullable
        private final C0042b zzk;

        @Nullable
        private final String zzl;

        @Nullable
        private final c zzm;

        @Nullable
        private final d zzn;

        @Nullable
        private final q1 zzo;

        /* JADX INFO: renamed from: com.android.billingclient.api.k0$b$a */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class a {

            @Nullable
            private final Integer zza;

            @Nullable
            private final C0420l0 zzb;

            public a(JSONObject jSONObject) {
                this.zza = jSONObject.has("percentageDiscount") ? Integer.valueOf(jSONObject.optInt("percentageDiscount")) : null;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountAmount");
                this.zzb = jSONObjectOptJSONObject != null ? new C0420l0(jSONObjectOptJSONObject) : null;
            }

            @Nullable
            public C0420l0 getDiscountAmount() {
                return this.zzb;
            }

            @Nullable
            public Integer getPercentageDiscount() {
                return this.zza;
            }
        }

        /* JADX INFO: renamed from: com.android.billingclient.api.k0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class C0042b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f2496a;
            public final int b;

            public C0042b(JSONObject jSONObject) {
                this.f2496a = jSONObject.getInt("maximumQuantity");
                this.b = jSONObject.getInt("remainingQuantity");
            }

            public int getMaximumQuantity() {
                return this.f2496a;
            }

            public int getRemainingQuantity() {
                return this.b;
            }
        }

        /* JADX INFO: renamed from: com.android.billingclient.api.k0$b$c */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f2497a;
            public final long b;

            public c(JSONObject jSONObject) {
                this.f2497a = jSONObject.getLong("preorderReleaseTimeMillis");
                this.b = jSONObject.getLong("preorderPresaleEndTimeMillis");
            }

            public long getPreorderPresaleEndTimeMillis() {
                return this.b;
            }

            public long getPreorderReleaseTimeMillis() {
                return this.f2497a;
            }
        }

        /* JADX INFO: renamed from: com.android.billingclient.api.k0$b$d */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f2498a;

            @Nullable
            private final String rentalExpirationPeriod;

            public d(JSONObject jSONObject) {
                this.f2498a = jSONObject.getString("rentalPeriod");
                String strOptString = jSONObject.optString("rentalExpirationPeriod");
                this.rentalExpirationPeriod = true == strOptString.isEmpty() ? null : strOptString;
            }

            @Nullable
            public String getRentalExpirationPeriod() {
                return this.rentalExpirationPeriod;
            }

            @NonNull
            public String getRentalPeriod() {
                return this.f2498a;
            }
        }

        /* JADX INFO: renamed from: com.android.billingclient.api.k0$b$e */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class e {

            @Nullable
            private final Long zza;

            @Nullable
            private final Long zzb;

            public e(JSONObject jSONObject) {
                this.zza = jSONObject.has("startTimeMillis") ? Long.valueOf(jSONObject.optLong("startTimeMillis")) : null;
                this.zzb = jSONObject.has("endTimeMillis") ? Long.valueOf(jSONObject.optLong("endTimeMillis")) : null;
            }

            @Nullable
            public Long getEndTimeMillis() {
                return this.zzb;
            }

            @Nullable
            public Long getStartTimeMillis() {
                return this.zza;
            }
        }

        public b(JSONObject jSONObject) {
            this.f2495a = jSONObject.optString("formattedPrice");
            jSONObject.optLong("priceAmountMicros");
            this.b = jSONObject.optString("priceCurrencyCode");
            String strOptString = jSONObject.optString("offerIdToken");
            this.zzd = true == strOptString.isEmpty() ? null : strOptString;
            String strOptString2 = jSONObject.optString("offerId");
            this.zze = true == strOptString2.isEmpty() ? null : strOptString2;
            String strOptString3 = jSONObject.optString("purchaseOptionId");
            this.zzf = true == strOptString3.isEmpty() ? null : strOptString3;
            jSONObject.optInt("offerType");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            this.c = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    this.c.add(jSONArrayOptJSONArray.getString(i5));
                }
            }
            this.zzh = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.zzi = jSONObjectOptJSONObject == null ? null : new a(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.zzj = jSONObjectOptJSONObject2 == null ? null : new e(jSONObjectOptJSONObject2);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.zzk = jSONObjectOptJSONObject3 == null ? null : new C0042b(jSONObjectOptJSONObject3);
            this.zzl = jSONObject.optString("serializedDocid");
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            this.zzm = jSONObjectOptJSONObject4 == null ? null : new c(jSONObjectOptJSONObject4);
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
            this.zzn = jSONObjectOptJSONObject5 == null ? null : new d(jSONObjectOptJSONObject5);
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
            this.zzo = jSONObjectOptJSONObject6 != null ? new q1(jSONObjectOptJSONObject6) : null;
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("pricingPhases");
            if (jSONArrayOptJSONArray2 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < jSONArrayOptJSONArray2.length(); i6++) {
                JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray2.optJSONObject(i6);
                if (jSONObjectOptJSONObject7 != null) {
                    arrayList.add(new C0422m0(jSONObjectOptJSONObject7));
                }
            }
        }

        @Nullable
        public a getDiscountDisplayInfo() {
            return this.zzi;
        }

        @NonNull
        public String getFormattedPrice() {
            return this.f2495a;
        }

        @Nullable
        public Long getFullPriceMicros() {
            return this.zzh;
        }

        @Nullable
        public C0042b getLimitedQuantityInfo() {
            return this.zzk;
        }

        @Nullable
        public String getOfferId() {
            return this.zze;
        }

        @Nullable
        public List<String> getOfferTags() {
            return this.c;
        }

        @Nullable
        public String getOfferToken() {
            return this.zzd;
        }

        @Nullable
        public c getPreorderDetails() {
            return this.zzm;
        }

        @NonNull
        public String getPriceCurrencyCode() {
            return this.b;
        }

        @Nullable
        public String getPurchaseOptionId() {
            return this.zzf;
        }

        @Nullable
        public d getRentalDetails() {
            return this.zzn;
        }

        @Nullable
        public e getValidTimeWindow() {
            return this.zzj;
        }

        @Nullable
        public final q1 zza() {
            return this.zzo;
        }

        @Nullable
        public final String zzb() {
            return this.zzl;
        }
    }

    /* JADX INFO: renamed from: com.android.billingclient.api.k0$c */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2499a;
        public final String b;
        public final C0424n0 c;
        public final ArrayList d;

        @Nullable
        private final String zzb;

        @Nullable
        private final a zzf;

        public c(JSONObject jSONObject) throws JSONException {
            this.f2499a = jSONObject.optString("basePlanId");
            String strOptString = jSONObject.optString("offerId");
            this.zzb = true == strOptString.isEmpty() ? null : strOptString;
            this.b = jSONObject.getString("offerIdToken");
            this.c = new C0424n0(jSONObject.getJSONArray("pricingPhases"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.zzf = jSONObjectOptJSONObject != null ? new a(jSONObjectOptJSONObject) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
            if (jSONObjectOptJSONObject2 != null) {
                jSONObjectOptJSONObject2.getString("productId");
                jSONObjectOptJSONObject2.optString("title");
                jSONObjectOptJSONObject2.optString("name");
                jSONObjectOptJSONObject2.optString("description");
                jSONObjectOptJSONObject2.optString("basePlanId");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
                if (jSONObjectOptJSONObject3 != null) {
                    jSONObjectOptJSONObject3.optString("billingPeriod");
                    jSONObjectOptJSONObject3.optString("priceCurrencyCode");
                    jSONObjectOptJSONObject3.optString("formattedPrice");
                    jSONObjectOptJSONObject3.optLong("priceAmountMicros");
                    jSONObjectOptJSONObject3.optInt("recurrenceMode");
                    jSONObjectOptJSONObject3.optInt("billingCycleCount");
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
            if (jSONArrayOptJSONArray != null) {
                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i5));
                }
            }
            this.d = arrayList;
        }

        @NonNull
        public String getBasePlanId() {
            return this.f2499a;
        }

        @Nullable
        public a getInstallmentPlanDetails() {
            return this.zzf;
        }

        @Nullable
        public String getOfferId() {
            return this.zzb;
        }

        @NonNull
        public List<String> getOfferTags() {
            return this.d;
        }

        @NonNull
        public String getOfferToken() {
            return this.b;
        }

        @NonNull
        public C0424n0 getPricingPhases() {
            return this.c;
        }
    }

    public C0418k0(String str) {
        this.f2490a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(strOptString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.e = jSONObject.optString("title");
        this.f2491f = jSONObject.optString("name");
        this.f2492g = jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.f2493h = jSONObject.optString("skuDetailsToken");
        this.zzi = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                arrayList.add(new c(jSONArrayOptJSONArray.getJSONObject(i5)));
            }
            this.zzj = arrayList;
        } else {
            this.zzj = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray2.length(); i6++) {
                arrayList2.add(new b(jSONArrayOptJSONArray2.getJSONObject(i6)));
            }
            this.zzk = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.zzk = null;
        } else {
            arrayList2.add(new b(jSONObjectOptJSONObject));
            this.zzk = arrayList2;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0418k0) {
            return TextUtils.equals(this.f2490a, ((C0418k0) obj).f2490a);
        }
        return false;
    }

    @NonNull
    public String getDescription() {
        return this.f2492g;
    }

    @NonNull
    public String getName() {
        return this.f2491f;
    }

    @Nullable
    public b getOneTimePurchaseOfferDetails() {
        List list = this.zzk;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (b) list.get(0);
    }

    @Nullable
    public List<b> getOneTimePurchaseOfferDetailsList() {
        return this.zzk;
    }

    @NonNull
    public String getProductId() {
        return this.c;
    }

    @NonNull
    public String getProductType() {
        return this.d;
    }

    @Nullable
    public List<c> getSubscriptionOfferDetails() {
        return this.zzj;
    }

    @NonNull
    public String getTitle() {
        return this.e;
    }

    public final int hashCode() {
        return this.f2490a.hashCode();
    }

    @NonNull
    public String toString() {
        List list = this.zzj;
        String string = this.b.toString();
        String strValueOf = String.valueOf(list);
        StringBuilder sb = new StringBuilder("ProductDetails{jsonString='");
        androidx.collection.a.y(sb, this.f2490a, "', parsedJson=", string, ", productId='");
        sb.append(this.c);
        sb.append("', productType='");
        sb.append(this.d);
        sb.append("', title='");
        sb.append(this.e);
        sb.append("', productDetailsToken='");
        return androidx.exifinterface.media.a.s(sb, this.f2493h, "', subscriptionOfferDetails=", strValueOf, VectorFormat.DEFAULT_SUFFIX);
    }

    @NonNull
    public final String zza() {
        return this.b.optString("packageName");
    }

    @Nullable
    public final String zzc(@Nullable String str) {
        List<b> list;
        if (!TextUtils.isEmpty(str) && (list = this.zzk) != null && !list.isEmpty()) {
            for (b bVar : list) {
                if (!TextUtils.isEmpty(bVar.zzb()) && Objects.equals(bVar.getOfferToken(), str)) {
                    return bVar.zzb();
                }
            }
        }
        return this.zzi;
    }
}
