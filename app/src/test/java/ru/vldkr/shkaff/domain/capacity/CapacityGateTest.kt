package ru.vldkr.shkaff.domain.capacity

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

// T-006 / П3.3: честная проверка ёмкости перед записью вещи. Чистый Kotlin.
class CapacityGateTest {

    @Test
    fun `isFull box blocks adding even a small item`() {
        val u = CapacityUsage(1.0, 1.0, capacityVolumeLiters = 100.0, capacityWeightKg = 100.0, isFull = true)
        val d = CapacityGate.checkPlacement(u, 0.5, 0.5)
        assertEquals(GateVerdict.BLOCK, d.verdict)
        assertTrue(d.message!!.contains("полным"))
        assertTrue(d.message!!.contains("блокировано"))
    }

    @Test
    fun `isFull blocks even without declared capacity`() {
        val d = CapacityGate.checkPlacement(CapacityUsage(0.0, 0.0, isFull = true), 10.0, 1.0)
        assertEquals(GateVerdict.BLOCK, d.verdict)
    }

    @Test
    fun `item within effective limits passes without message`() {
        val u = CapacityUsage(4.0, 2.0, capacityVolumeLiters = 10.0, capacityWeightKg = 5.0)
        val d = CapacityGate.checkPlacement(u, 5.0, 2.0)
        assertEquals(GateVerdict.OK, d.verdict)
        assertNull(d.message)
    }

    @Test
    fun `no declared limits means no warnings`() {
        val d = CapacityGate.checkPlacement(CapacityUsage(0.0, 0.0), 500.0, 900.0)
        assertEquals(GateVerdict.OK, d.verdict)
    }

    @Test
    fun `volume over capacity asks for confirmation`() {
        val u = CapacityUsage(9.0, 0.0, capacityVolumeLiters = 10.0)
        val d = CapacityGate.checkPlacement(u, 3.0, 0.0)
        assertEquals(GateVerdict.CONFIRM, d.verdict)
        assertTrue(d.message!!.contains("объём"))
        assertTrue(d.message!!.contains("12"))
        assertTrue(d.message!!.contains("10"))
    }

    @Test
    fun `weight over load capacity asks for confirmation`() {
        val u = CapacityUsage(0.0, 4.0, capacityWeightKg = 5.0)
        val d = CapacityGate.checkPlacement(u, 0.0, 2.0)
        assertEquals(GateVerdict.CONFIRM, d.verdict)
        assertTrue(d.message!!.contains("масса"))
        assertTrue(d.message!!.contains("6"))
    }

    @Test
    fun `dontFillToBrim reserve triggers confirmation before nominal limit`() {
        val u = CapacityUsage(8.5, 0.0, capacityVolumeLiters = 10.0, dontFillToBrim = true)
        // 8,5 + 1 = 9,5 л > 9 л (90% резерв), хотя до номинальных 10 л ещё влезает.
        val d = CapacityGate.checkPlacement(u, 1.0, 0.0)
        assertEquals(GateVerdict.CONFIRM, d.verdict)
        assertTrue(d.message!!.contains("резерв"))
    }

    @Test
    fun `excluding own contribution lets editing an item in the same drawer pass`() {
        val u = CapacityUsage(10.0, 0.0, capacityVolumeLiters = 10.0)
        val adj = CapacityGate.excludingItem(u, 4.0, 0.0)
        assertEquals(6.0, adj.volumeLiters, 1e-9)
        assertEquals(GateVerdict.OK, CapacityGate.checkPlacement(adj, 4.0, 0.0).verdict)
    }

    @Test
    fun `excluding never drives usage below zero`() {
        val adj = CapacityGate.excludingItem(CapacityUsage(1.0, 1.0), 5.0, 5.0)
        assertEquals(0.0, adj.volumeLiters, 1e-9)
        assertEquals(0.0, adj.weightKg, 1e-9)
    }

    @Test
    fun `placement into an already over-limit box still warns even for zero-size item`() {
        val u = CapacityUsage(12.0, 0.0, capacityVolumeLiters = 10.0)
        assertEquals(GateVerdict.CONFIRM, CapacityGate.checkPlacement(u, 0.0, 0.0).verdict)
    }

    @Test
    fun `block wins over over-limit numbers`() {
        val u = CapacityUsage(12.0, 0.0, capacityVolumeLiters = 10.0, isFull = true)
        val d = CapacityGate.checkPlacement(u, 1.0, 0.0)
        assertEquals(GateVerdict.BLOCK, d.verdict)
    }
}
