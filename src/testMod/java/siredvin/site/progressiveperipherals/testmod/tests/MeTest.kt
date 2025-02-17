package siredvin.site.progressiveperipherals.testmod.tests

import dan200.computercraft.ingame.api.GameTest
import dan200.computercraft.ingame.api.GameTestHelper
import dan200.computercraft.ingame.api.sequence
import dan200.computercraft.ingame.api.thenComputerOk

class MeTest {
    @GameTest(timeoutTicks = 400)
    fun exportToFull(context: GameTestHelper) = context.sequence {
        thenComputerOk()
    }

    @GameTest(timeoutTicks = 400)
    fun partialImport(context: GameTestHelper) = context.sequence {
        thenComputerOk()
    }
}