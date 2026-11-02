# JNI-мост к llama.cpp: native-методы регистрируются в JNI_OnLoad через
# RegisterNatives по имени класса и сигнатурам (llama/src/main/cpp/shkaff_llm.cpp).
# R8 переименует класс/методы — FindClass и RegisterNatives перестанут находиться,
# System.loadLibrary бросит UnsatisfiedLinkError.
-keep class ru.vldkr.shkaff.llm.LlamaBridge { *; }
