package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateColorBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateEffectBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateMotionBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateRotationBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateScaleBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommandBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeVideo;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSetBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeExclusive;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeSequence;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;
import q5.n;
import q5.p;
import q5.q;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTimeNodeListImpl extends XmlComplexContentImpl implements CTTimeNodeList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "par"), new QName(XSSFRelation.NS_PRESENTATIONML, "seq"), new QName(XSSFRelation.NS_PRESENTATIONML, "excl"), new QName(XSSFRelation.NS_PRESENTATIONML, "anim"), new QName(XSSFRelation.NS_PRESENTATIONML, "animClr"), new QName(XSSFRelation.NS_PRESENTATIONML, "animEffect"), new QName(XSSFRelation.NS_PRESENTATIONML, "animMotion"), new QName(XSSFRelation.NS_PRESENTATIONML, "animRot"), new QName(XSSFRelation.NS_PRESENTATIONML, "animScale"), new QName(XSSFRelation.NS_PRESENTATIONML, "cmd"), new QName(XSSFRelation.NS_PRESENTATIONML, "set"), new QName(XSSFRelation.NS_PRESENTATIONML, "audio"), new QName(XSSFRelation.NS_PRESENTATIONML, "video")};
    private static final long serialVersionUID = 1;

    public CTTimeNodeListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior addNewAnim() {
        CTTLAnimateBehavior cTTLAnimateBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTLAnimateBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior addNewAnimClr() {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTLAnimateColorBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior addNewAnimEffect() {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTLAnimateEffectBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior addNewAnimMotion() {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTLAnimateMotionBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior addNewAnimRot() {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTLAnimateRotationBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior addNewAnimScale() {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTLAnimateScaleBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio addNewAudio() {
        CTTLMediaNodeAudio cTTLMediaNodeAudioAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudioAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTTLMediaNodeAudioAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior addNewCmd() {
        CTTLCommandBehavior cTTLCommandBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTLCommandBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive addNewExcl() {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTLTimeNodeExclusiveAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel addNewPar() {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence addNewSeq() {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTLTimeNodeSequenceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior addNewSet() {
        CTTLSetBehavior cTTLSetBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTLSetBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo addNewVideo() {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior[] getAnimArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTTLAnimateBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior[] getAnimClrArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTTLAnimateColorBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateColorBehavior> getAnimClrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 12), new BiConsumer() { // from class: q5.w
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7877a.setAnimClrArray(((Integer) obj).intValue(), (CTTLAnimateColorBehavior) obj2);
                }
            }, new n(this, 13), new p(this, 5), new q(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior[] getAnimEffectArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTTLAnimateEffectBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateEffectBehavior> getAnimEffectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 3), new BiConsumer() { // from class: q5.r
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7872a.setAnimEffectArray(((Integer) obj).intValue(), (CTTLAnimateEffectBehavior) obj2);
                }
            }, new n(this, 4), new p(this, 1), new q(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateBehavior> getAnimList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 20), new BiConsumer() { // from class: q5.z
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7880a.setAnimArray(((Integer) obj).intValue(), (CTTLAnimateBehavior) obj2);
                }
            }, new n(this, 21), new p(this, 10), new q(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior[] getAnimMotionArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTTLAnimateMotionBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateMotionBehavior> getAnimMotionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 1), new BiConsumer() { // from class: q5.o
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7869a.setAnimMotionArray(((Integer) obj).intValue(), (CTTLAnimateMotionBehavior) obj2);
                }
            }, new n(this, 2), new p(this, 0), new q(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior[] getAnimRotArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTTLAnimateRotationBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateRotationBehavior> getAnimRotList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 7), new BiConsumer() { // from class: q5.u
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7875a.setAnimRotArray(((Integer) obj).intValue(), (CTTLAnimateRotationBehavior) obj2);
                }
            }, new n(this, 8), new p(this, 3), new q(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior[] getAnimScaleArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTTLAnimateScaleBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateScaleBehavior> getAnimScaleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 5), new BiConsumer() { // from class: q5.t
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7874a.setAnimScaleArray(((Integer) obj).intValue(), (CTTLAnimateScaleBehavior) obj2);
                }
            }, new n(this, 6), new p(this, 2), new q(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio[] getAudioArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTTLMediaNodeAudio[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeAudio> getAudioList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 0), new BiConsumer() { // from class: q5.s
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7873a.setAudioArray(((Integer) obj).intValue(), (CTTLMediaNodeAudio) obj2);
                }
            }, new n(this, 9), new p(this, 6), new q(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior[] getCmdArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTTLCommandBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLCommandBehavior> getCmdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 23), new BiConsumer() { // from class: q5.A
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7853a.setCmdArray(((Integer) obj).intValue(), (CTTLCommandBehavior) obj2);
                }
            }, new n(this, 24), new p(this, 11), new q(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive[] getExclArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTTLTimeNodeExclusive[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeExclusive> getExclList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 10), new BiConsumer() { // from class: q5.v
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7876a.setExclArray(((Integer) obj).intValue(), (CTTLTimeNodeExclusive) obj2);
                }
            }, new n(this, 11), new p(this, 4), new q(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel[] getParArray() {
        return (CTTLTimeNodeParallel[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTLTimeNodeParallel[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeParallel> getParList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 14), new x(this, 0), new n(this, 15), new p(this, 7), new q(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence[] getSeqArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTTLTimeNodeSequence[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeSequence> getSeqList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 22), new BiConsumer() { // from class: q5.B
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7854a.setSeqArray(((Integer) obj).intValue(), (CTTLTimeNodeSequence) obj2);
                }
            }, new n(this, 25), new p(this, 12), new q(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior[] getSetArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTTLSetBehavior[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLSetBehavior> getSetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 16), new BiConsumer() { // from class: q5.y
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f7879a.setSetArray(((Integer) obj).intValue(), (CTTLSetBehavior) obj2);
                }
            }, new n(this, 17), new p(this, 8), new q(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo[] getVideoArray() {
        return (CTTLMediaNodeVideo[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTTLMediaNodeVideo[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeVideo> getVideoList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 18), new x(this, 1), new n(this, 19), new p(this, 9), new q(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior insertNewAnim(int i5) {
        CTTLAnimateBehavior cTTLAnimateBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTTLAnimateBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior insertNewAnimClr(int i5) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTTLAnimateColorBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior insertNewAnimEffect(int i5) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTTLAnimateEffectBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior insertNewAnimMotion(int i5) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTTLAnimateMotionBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior insertNewAnimRot(int i5) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTTLAnimateRotationBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior insertNewAnimScale(int i5) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTTLAnimateScaleBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio insertNewAudio(int i5) {
        CTTLMediaNodeAudio cTTLMediaNodeAudioInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudioInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTTLMediaNodeAudioInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior insertNewCmd(int i5) {
        CTTLCommandBehavior cTTLCommandBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTTLCommandBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive insertNewExcl(int i5) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTTLTimeNodeExclusiveInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel insertNewPar(int i5) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence insertNewSeq(int i5) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTTLTimeNodeSequenceInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior insertNewSet(int i5) {
        CTTLSetBehavior cTTLSetBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTTLSetBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo insertNewVideo(int i5) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnim(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimClr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimEffect(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimMotion(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimRot(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimScale(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAudio(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeCmd(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeExcl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removePar(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSeq(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSet(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeVideo(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateBehaviorArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateColorBehaviorArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateEffectBehaviorArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateMotionBehaviorArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateRotationBehaviorArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLAnimateScaleBehaviorArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLMediaNodeAudioArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLCommandBehaviorArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLTimeNodeExclusiveArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr) {
        check_orphaned();
        arraySetterHelper(cTTLTimeNodeParallelArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLTimeNodeSequenceArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTLSetBehaviorArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr) {
        check_orphaned();
        arraySetterHelper(cTTLMediaNodeVideoArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimClrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimMotionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimRotArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimScaleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAudioArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfCmdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfExclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfParArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSeqArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfVideoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior getAnimArray(int i5) {
        CTTLAnimateBehavior cTTLAnimateBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTTLAnimateBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior getAnimClrArray(int i5) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateColorBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTTLAnimateColorBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateColorBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior getAnimEffectArray(int i5) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateEffectBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTTLAnimateEffectBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateEffectBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior getAnimMotionArray(int i5) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateMotionBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTTLAnimateMotionBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateMotionBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior getAnimRotArray(int i5) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateRotationBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTTLAnimateRotationBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateRotationBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior getAnimScaleArray(int i5) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateScaleBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTTLAnimateScaleBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateScaleBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio getAudioArray(int i5) {
        CTTLMediaNodeAudio cTTLMediaNodeAudioFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLMediaNodeAudioFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTTLMediaNodeAudioFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLMediaNodeAudioFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior getCmdArray(int i5) {
        CTTLCommandBehavior cTTLCommandBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLCommandBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTTLCommandBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLCommandBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive getExclArray(int i5) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeExclusiveFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTTLTimeNodeExclusiveFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeExclusiveFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel getParArray(int i5) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTTLTimeNodeParallel == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence getSeqArray(int i5) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeSequenceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTTLTimeNodeSequenceFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeSequenceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior getSetArray(int i5) {
        CTTLSetBehavior cTTLSetBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLSetBehaviorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTTLSetBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLSetBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo getVideoArray(int i5) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (cTTLMediaNodeVideo == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(int i5, CTTLAnimateBehavior cTTLAnimateBehavior) {
        generatedSetterHelperImpl(cTTLAnimateBehavior, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(int i5, CTTLAnimateColorBehavior cTTLAnimateColorBehavior) {
        generatedSetterHelperImpl(cTTLAnimateColorBehavior, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(int i5, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior) {
        generatedSetterHelperImpl(cTTLAnimateEffectBehavior, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(int i5, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior) {
        generatedSetterHelperImpl(cTTLAnimateMotionBehavior, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(int i5, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior) {
        generatedSetterHelperImpl(cTTLAnimateRotationBehavior, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(int i5, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior) {
        generatedSetterHelperImpl(cTTLAnimateScaleBehavior, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(int i5, CTTLMediaNodeAudio cTTLMediaNodeAudio) {
        generatedSetterHelperImpl(cTTLMediaNodeAudio, PROPERTY_QNAME[11], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(int i5, CTTLCommandBehavior cTTLCommandBehavior) {
        generatedSetterHelperImpl(cTTLCommandBehavior, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(int i5, CTTLTimeNodeExclusive cTTLTimeNodeExclusive) {
        generatedSetterHelperImpl(cTTLTimeNodeExclusive, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(int i5, CTTLTimeNodeParallel cTTLTimeNodeParallel) {
        generatedSetterHelperImpl(cTTLTimeNodeParallel, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(int i5, CTTLTimeNodeSequence cTTLTimeNodeSequence) {
        generatedSetterHelperImpl(cTTLTimeNodeSequence, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(int i5, CTTLSetBehavior cTTLSetBehavior) {
        generatedSetterHelperImpl(cTTLSetBehavior, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(int i5, CTTLMediaNodeVideo cTTLMediaNodeVideo) {
        generatedSetterHelperImpl(cTTLMediaNodeVideo, PROPERTY_QNAME[12], i5, (short) 2);
    }
}
