package de.srendi.advancedperipherals.common.addons.computercraft.turtles.metaphysics;

import dan200.computercraft.api.turtle.ITurtleAccess;
import dan200.computercraft.api.turtle.TurtleSide;
import de.srendi.advancedperipherals.common.addons.computercraft.base.ModelTransformingTurtle;
import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.metaphysics.WeakAutomataCorePeripheral;
import de.srendi.advancedperipherals.common.setup.Items;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WeakAutomata extends ModelTransformingTurtle<WeakAutomataCorePeripheral> {

    public WeakAutomata() {
        super("weak_automata", "turtle.advancedperipherals.weak_automata", new ItemStack(Items.WEAK_AUTOMATA_CORE.get()));
    }

    @Override
    protected ModelResourceLocation getLeftModel() {
        return null;
    }

    @Override
    protected ModelResourceLocation getRightModel() {
        return null;
    }

    @Override
    protected WeakAutomataCorePeripheral buildPeripheral(@NotNull ITurtleAccess turtle, @NotNull TurtleSide side) {
        return new WeakAutomataCorePeripheral("weakAutomata", turtle, side);
    }
}
