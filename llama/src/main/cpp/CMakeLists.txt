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