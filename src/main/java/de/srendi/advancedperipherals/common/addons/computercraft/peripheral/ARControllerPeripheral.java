package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.lua.MethodResult;
import de.srendi.advancedperipherals.common.addons.computercraft.base.BasePeripheral;
import de.srendi.advancedperipherals.common.argoggles.ARRenderAction;
import de.srendi.advancedperipherals.common.argoggles.RenderActionType;
import de.srendi.advancedperipherals.common.blocks.tileentity.ARControllerTile;
import de.srendi.advancedperipherals.common.configuration.AdvancedPeripheralsConfig;

import java.util.Optional;

public class ARControllerPeripheral extends BasePeripheral {
    public static final String TYPE = "arController";

    private final ARControllerTile tileEntity;

    public ARControllerPeripheral(ARControllerTile tileEntity) {
        super(TYPE, tileEntity);
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean isEnabled() {
        return AdvancedPeripheralsConfig.enableARGoggles;
    }

    @LuaFunction
    public final MethodResult isRelativeMode() {
        int[] virtualScreenSize = tileEntity.getVirtualScreenSize();
        if (virtualScreenSize != null)
            return MethodResult.of(tileEntity.isRelativeMode(), virtualScreenSize[0], virtualScreenSize[1]);
        else
            return MethodResult.of(tileEntity.isRelativeMode());
    }

    @LuaFunction
    public final void setRelativeMode(boolean enabled, Optional<Integer> virtualScreenWidth, Optional<Integer> virtualScreenHeight) throws LuaException {
        if (enabled) {
            if (!virtualScreenWidth.isPresent() || !virtualScreenHeight.isPresent())
                throw new LuaException("You need to pass virtual screen width and height to enable relative mode.");
            tileEntity.setRelativeMode(virtualScreenWidth.get(), virtualScreenHeight.get());
        } else {
            tileEntity.disableRelativeMode();
        }
    }

    @LuaFunction
    public final void drawString(String text, int x, int y, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.DrawString, text, x, y, color));
    }

    @LuaFunction
    public final void drawCenteredString(String text, int x, int y, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.DrawCenteredString, text, x, y, color));
    }

    @LuaFunction
    public final void drawRightboundString(String text, int x, int y, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.DrawRightboundString, text, x, y, color));
    }

    @LuaFunction
    public final void horizontalLine(int minX, int maxX, int y, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.HorizontalLine, minX, maxX, y, color));
    }

    @LuaFunction
    public final void verticalLine(int x, int minY, int maxY, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.VerticalLine, x, minY, maxY, color));
    }

    @LuaFunction
    public final void fill(int minX, int minY, int maxX, int maxY, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.Fill, minX, minY, maxX, maxY, color));
    }

    @LuaFunction
    public final void fillGradient(int minX, int minY, int maxX, int maxY, int colorFrom, int colorTo) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.FillGradient, minX, minY, maxX, maxY, colorFrom, colorTo));
    }

    @LuaFunction
    public final void drawCircle(int x, int y, int radius, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.DrawCircle, x, y, radius, color));
    }

    @LuaFunction
    public final void fillCircle(int x, int y, int radius, int color) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.FillCircle, x, y, radius, color));
    }

    @LuaFunction
    public final void drawItemIcon(String itemId, int x, int y) {
        tileEntity.addToCanvas(new ARRenderAction(RenderActionType.DrawItemIcon, itemId, x, y));
    }

    @LuaFunction
    public final void clear() {
        tileEntity.clearCanvas();
    }
}
