package io.izzel.arclight.common.mixin.optimization.general.world.level;

import net.minecraft.world.level.ChunkPos;
import org.spongepowered.asm.mixin.*;

@Mixin(ChunkPos.class)
public class ChunkPosMixin {
    @Final
    @Shadow
    public int x;
    @Shadow
    @Final
    public int z;

    @Unique
    private long arclight$cachedToLong;
    @Unique
    private boolean arclight$cached;

    /**
     * @author Goodvise
     * @reason optimization
     */
    @Overwrite
    public long toLong() {
        if (!arclight$cached) {
            arclight$cachedToLong = ChunkPos.asLong(x, z);
            arclight$cached = true;
        }

        return arclight$cachedToLong;
    }
}
