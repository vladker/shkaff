cmake_minimum_required(VERSION 3.22.1)
project(shkaff_llm LANGUAGES C CXX)

# Vendored llama.cpp (third_party/llama.cpp, tag b9999). Build only what the
# wrapper needs: llama/ggml, common utils (chat templates, sampling) and the
# mtmd library for vision models. Tool binaries and tests stay disabled.

option(LLAMA_BUILD_COMMON "llama: build common utils library" ON)
option(LLAMA_BUILD_TESTS "llama: build tests" OFF)
option(LLAMA_BUILD_TOOLS "llama: build tools" OFF)
option(LLAMA_BUILD_SERVER "llama: build server example" OFF)
option(LLAMA_BUILD_EXAMPLES "llama: build examples" OFF)
option(LLAMA_BUILD_MTMD "llama: build tools/mtmd library standalone" ON)
option(MTMD_VIDEO "mtmd: enable video support (requires ffmpeg)" OFF)
option(GGML_NATIVE "ggml: use host native optimizations" OFF)

# Google Play требует 16-килобайтное выравнивание LOAD-сегментов для приложений
# с targetSdk >= 35; по умолчанию NDK-линковщик выравнивает их по 4 KB. Флаги
# задаются до add_subdirectory, чтобы попали во все shared-библиотеки llama.cpp.
set(_page_align "-Wl,-z,max-page-size=16384")
foreach(_var SHARED_LINKER_FLAGS MODULE_LINKER_FLAGS EXE_LINKER_FLAGS)
    set(CMAKE_${_var} "${CMAKE_${_var}} ${_page_align}")
endforeach()

# AGP не умеет вырезать отладочную информацию из этих библиотек (в логе сборки:
# "Unable to strip the following libraries"), а в RelWithDebInfo llama.cpp
# несёт ~70 МБ секций .debug_* только в libllama-common.so: релизный APK весит
# 153 МБ и упирается в лимит Google Play. -g0 идёт после -g из флагов
# конфигурации, поэтому побеждает; .symtab сохраняется, так что нативные
# крэки остаются читаемыми.
# shortcut: если понадобится full native debug symbols для Play — снимать
# .debug_* отдельным llvm-objcopy, а не -g0.
add_compile_options(-g0)

add_subdirectory(../../../../third_party/llama.cpp llama.cpp)

# The JNI bridge library. `mtmd` links ggml+llama PUBLIC and bundles
# mtmd-helper, so a single link gives us text + vision inference.
add_library(shkaff_llm SHARED shkaff_llm.cpp)
target_link_libraries(shkaff_llm PRIVATE llama-common mtmd)
target_include_directories(shkaff_llm PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${CMAKE_CURRENT_SOURCE_DIR}/../../../../third_party/llama.cpp/common
    ${CMAKE_CURRENT_SOURCE_DIR}/../../../../third_party/llama.cpp/tools
)
target_compile_features(shkaff_llm PRIVATE cxx_std_17)