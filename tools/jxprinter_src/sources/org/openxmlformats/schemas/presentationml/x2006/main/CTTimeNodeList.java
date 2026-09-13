package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTimeNodeList extends XmlObject {
    public static final DocumentFactory<CTTimeNodeList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTimeNodeList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttimenodelist0258type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTLAnimateBehavior addNewAnim();

    CTTLAnimateColorBehavior addNewAnimClr();

    CTTLAnimateEffectBehavior addNewAnimEffect();

    CTTLAnimateMotionBehavior addNewAnimMotion();

    CTTLAnimateRotationBehavior addNewAnimRot();

    CTTLAnimateScaleBehavior addNewAnimScale();

    CTTLMediaNodeAudio addNewAudio();

    CTTLCommandBehavior addNewCmd();

    CTTLTimeNodeExclusive addNewExcl();

    CTTLTimeNodeParallel addNewPar();

    CTTLTimeNodeSequence addNewSeq();

    CTTLSetBehavior addNewSet();

    CTTLMediaNodeVideo addNewVideo();

    CTTLAnimateBehavior getAnimArray(int i5);

    CTTLAnimateBehavior[] getAnimArray();

    CTTLAnimateColorBehavior getAnimClrArray(int i5);

    CTTLAnimateColorBehavior[] getAnimClrArray();

    List<CTTLAnimateColorBehavior> getAnimClrList();

    CTTLAnimateEffectBehavior getAnimEffectArray(int i5);

    CTTLAnimateEffectBehavior[] getAnimEffectArray();

    List<CTTLAnimateEffectBehavior> getAnimEffectList();

    List<CTTLAnimateBehavior> getAnimList();

    CTTLAnimateMotionBehavior getAnimMotionArray(int i5);

    CTTLAnimateMotionBehavior[] getAnimMotionArray();

    List<CTTLAnimateMotionBehavior> getAnimMotionList();

    CTTLAnimateRotationBehavior getAnimRotArray(int i5);

    CTTLAnimateRotationBehavior[] getAnimRotArray();

    List<CTTLAnimateRotationBehavior> getAnimRotList();

    CTTLAnimateScaleBehavior getAnimScaleArray(int i5);

    CTTLAnimateScaleBehavior[] getAnimScaleArray();

    List<CTTLAnimateScaleBehavior> getAnimScaleList();

    CTTLMediaNodeAudio getAudioArray(int i5);

    CTTLMediaNodeAudio[] getAudioArray();

    List<CTTLMediaNodeAudio> getAudioList();

    CTTLCommandBehavior getCmdArray(int i5);

    CTTLCommandBehavior[] getCmdArray();

    List<CTTLCommandBehavior> getCmdList();

    CTTLTimeNodeExclusive getExclArray(int i5);

    CTTLTimeNodeExclusive[] getExclArray();

    List<CTTLTimeNodeExclusive> getExclList();

    CTTLTimeNodeParallel getParArray(int i5);

    CTTLTimeNodeParallel[] getParArray();

    List<CTTLTimeNodeParallel> getParList();

    CTTLTimeNodeSequence getSeqArray(int i5);

    CTTLTimeNodeSequence[] getSeqArray();

    List<CTTLTimeNodeSequence> getSeqList();

    CTTLSetBehavior getSetArray(int i5);

    CTTLSetBehavior[] getSetArray();

    List<CTTLSetBehavior> getSetList();

    CTTLMediaNodeVideo getVideoArray(int i5);

    CTTLMediaNodeVideo[] getVideoArray();

    List<CTTLMediaNodeVideo> getVideoList();

    CTTLAnimateBehavior insertNewAnim(int i5);

    CTTLAnimateColorBehavior insertNewAnimClr(int i5);

    CTTLAnimateEffectBehavior insertNewAnimEffect(int i5);

    CTTLAnimateMotionBehavior insertNewAnimMotion(int i5);

    CTTLAnimateRotationBehavior insertNewAnimRot(int i5);

    CTTLAnimateScaleBehavior insertNewAnimScale(int i5);

    CTTLMediaNodeAudio insertNewAudio(int i5);

    CTTLCommandBehavior insertNewCmd(int i5);

    CTTLTimeNodeExclusive insertNewExcl(int i5);

    CTTLTimeNodeParallel insertNewPar(int i5);

    CTTLTimeNodeSequence insertNewSeq(int i5);

    CTTLSetBehavior insertNewSet(int i5);

    CTTLMediaNodeVideo insertNewVideo(int i5);

    void removeAnim(int i5);

    void removeAnimClr(int i5);

    void removeAnimEffect(int i5);

    void removeAnimMotion(int i5);

    void removeAnimRot(int i5);

    void removeAnimScale(int i5);

    void removeAudio(int i5);

    void removeCmd(int i5);

    void removeExcl(int i5);

    void removePar(int i5);

    void removeSeq(int i5);

    void removeSet(int i5);

    void removeVideo(int i5);

    void setAnimArray(int i5, CTTLAnimateBehavior cTTLAnimateBehavior);

    void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr);

    void setAnimClrArray(int i5, CTTLAnimateColorBehavior cTTLAnimateColorBehavior);

    void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr);

    void setAnimEffectArray(int i5, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior);

    void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr);

    void setAnimMotionArray(int i5, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior);

    void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr);

    void setAnimRotArray(int i5, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior);

    void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr);

    void setAnimScaleArray(int i5, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior);

    void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr);

    void setAudioArray(int i5, CTTLMediaNodeAudio cTTLMediaNodeAudio);

    void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr);

    void setCmdArray(int i5, CTTLCommandBehavior cTTLCommandBehavior);

    void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr);

    void setExclArray(int i5, CTTLTimeNodeExclusive cTTLTimeNodeExclusive);

    void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr);

    void setParArray(int i5, CTTLTimeNodeParallel cTTLTimeNodeParallel);

    void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr);

    void setSeqArray(int i5, CTTLTimeNodeSequence cTTLTimeNodeSequence);

    void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr);

    void setSetArray(int i5, CTTLSetBehavior cTTLSetBehavior);

    void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr);

    void setVideoArray(int i5, CTTLMediaNodeVideo cTTLMediaNodeVideo);

    void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr);

    int sizeOfAnimArray();

    int sizeOfAnimClrArray();

    int sizeOfAnimEffectArray();

    int sizeOfAnimMotionArray();

    int sizeOfAnimRotArray();

    int sizeOfAnimScaleArray();

    int sizeOfAudioArray();

    int sizeOfCmdArray();

    int sizeOfExclArray();

    int sizeOfParArray();

    int sizeOfSeqArray();

    int sizeOfSetArray();

    int sizeOfVideoArray();
}
