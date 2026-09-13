package androidx.emoji2.text.flatbuffer;

import java.util.function.Supplier;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReadAheadInputStream;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBitmapBlip;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherMetafileBlip;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.ddf.EscherSplitMenuColorsRecord;
import org.apache.poi.ddf.EscherTertiaryOptRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.ddf.UnknownEscherRecord;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.agile.AgileEncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.xor.XOREncryptionInfoBuilder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1044a;

    public /* synthetic */ a(int i5) {
        this.f1044a = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1044a) {
            case 0:
                return Utf8Old.lambda$static$0();
            case 1:
                return IOUtils.byteArray();
            case 2:
                return IOUtils.charArray();
            case 3:
                return ReadAheadInputStream.lambda$static$0();
            case 4:
                return new EscherContainerRecord();
            case 5:
                return new EscherBlipRecord();
            case 6:
                return new UnknownEscherRecord();
            case 7:
                return new EscherSpRecord();
            case 8:
                return new EscherDggRecord();
            case 9:
                return new EscherBSERecord();
            case 10:
                return new EscherDgRecord();
            case 11:
                return new EscherSpgrRecord();
            case 12:
                return new EscherOptRecord();
            case 13:
                return new EscherTextboxRecord();
            case 14:
                return new EscherChildAnchorRecord();
            case 15:
                return new EscherClientAnchorRecord();
            case 16:
                return new EscherClientDataRecord();
            case 17:
                return new EscherMetafileBlip();
            case 18:
                return new EscherBitmapBlip();
            case 19:
                return new EscherSplitMenuColorsRecord();
            case 20:
                return new EscherTertiaryOptRecord();
            case 21:
                return Boolean.FALSE;
            case 22:
                return HSSFCellStyle.lambda$static$0();
            case 23:
                return Decryptor.lambda$getGenericProperties$0();
            case 24:
                return new BinaryRC4EncryptionInfoBuilder();
            case 25:
                return new CryptoAPIEncryptionInfoBuilder();
            case 26:
                return new StandardEncryptionInfoBuilder();
            case 27:
                return new AgileEncryptionInfoBuilder();
            case 28:
                return new XOREncryptionInfoBuilder();
            default:
                return Encryptor.lambda$getGenericProperties$0();
        }
    }
}
