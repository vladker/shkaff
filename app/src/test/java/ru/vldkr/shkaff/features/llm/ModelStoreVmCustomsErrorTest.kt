package ru.vldkr.shkaff.features.llm

import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps

/**
 * T-057 (UI-конец): флаг ошибки чтения индекса своих моделей из StoreState
 * обязан доходить до Ui модели экрана «Модели на устройстве», иначе пользователь
 * видит молча опустевший список.
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ModelStoreVmCustomsErrorTest {

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        cleanIndex()
        Deps.modelStore.reload()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        Deps.modelStore.state.value.rows.filter { it.custom }.forEach { Deps.modelStore.delete(it) }
        cleanIndex()
        Deps.modelStore.reload()
    }

    private fun cleanIndex() {
        val dir = Deps.modelStore.dir
        File(dir, ".custom.json").delete()
        File(dir, ".custom.json.corrupt").delete()
    }

    @Test
    fun corruptIndexPropagatesErrorToVmUi() {
        File(Deps.modelStore.dir, ".custom.json").writeText("{{{{ не json")
        Deps.modelStore.reload()
        val vm = ModelStoreVm()
        val err = vm.ui.value.customsError
        assertNotNull("экран обязан получить состояние ошибки списка", err)
        assertTrue("сообщение по-русски: $err", err!!.contains("повреждён"))
    }

    @Test
    fun healthyIndexKeepsUiErrorNull() {
        val vm = ModelStoreVm()
        assertNull(vm.ui.value.customsError)
    }
}
