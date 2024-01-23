package pistonmc.pistonandobserver.mixins.observer;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeHooks;
import pistonmc.pistonandobserver.api.IBlockObservable;

@Mixin(ForgeHooks.class)
public class MixinForgeHooks {
    @WrapOperation(
        method = "onPlaceItemIntoWorld",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;markAndNotifyBlock(IIILnet/minecraft/world/chunk/Chunk;Lnet/minecraft/block/Block;Lnet/minecraft/block/Block;I)V"),
        remap = false
    )
    private static void notifyObserversWhenPlaceItemIntoWorld(
        World world, int blockX, int blockY, int blockZ, Chunk nullChunk, Block oldBlock, Block newBlock, int flags,
        Operation<Void> markAndNotifyBlock,
        ItemStack itemStack, EntityPlayer player, World world2, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (world.isRemote || newBlock == null) {
            return;
        }
        IBlockObservable observed = (IBlockObservable) newBlock;
        observed.notifyObservers(world, blockX, blockY, blockZ, oldBlock, newBlock);
    }
}
