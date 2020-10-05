package uk.gaz492.bambooeverything;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uk.gaz492.bambooeverything.blocks.*;
import uk.gaz492.bambooeverything.util.ModInfo;

public class BERegistry {

    public static Block bambooBundleBlock;
    public static Item bambooBundleItem;

    public static Block bambooDoorBlock;
    public static Item bambooDoorItem;
    public static Block bambooTrapDoorBlock;
    public static Item bambooTrapDoorItem;

    public static Block bambooFenceBlock;
    public static Block bambooFenceGateBlock;
    public static Item bambooFenceGateItem;
    public static Item bambooFenceItem;

    public static Block bambooLadderBlock;
    public static Item bambooLadderItem;

    public static Block bambooSlabBlock;
    public static Item bambooSlabItem;

    public static Block bambooStairsBlock;
    public static Item bambooStairsItem;

    public static ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier(ModInfo.ID + ":bambooeverything"),
            () -> new ItemStack(BERegistry.bambooFenceBlock));

    private final static Item.Settings defaultSettings = new Item.Settings().group(BERegistry.creativeTab);

    public BERegistry() {

        /*
         * Note: some blocks are registered as having a material of type wood.
         * Fences & ladders are registered this way in order to have them connect to other wooden blocks.
         * Doors need to be registered as wooden for villagers to pathfind through them.
         */

        //Bundle
        bambooBundleBlock = blockRegister("bamboo_bundle", new BambooBundleBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        bambooBundleItem = itemRegister("bamboo_bundle", bambooBundleBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooBundleItem, 300);
        
        //Slab
        bambooSlabBlock = blockRegister("bamboo_slab", new BambooSlabBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        bambooSlabItem = itemRegister("bamboo_slab", bambooSlabBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooSlabItem, 150);
        
        //Stairs
        bambooStairsBlock = blockRegister("bamboo_stairs", new BambooStairsBlock(bambooBundleBlock.getDefaultState(), FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        bambooStairsItem = itemRegister("bamboo_stairs", bambooStairsBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooStairsItem, 300);
        
        //Ladder
        bambooLadderBlock = blockRegister("bamboo_ladder", new BambooLadderBlock(FabricBlockSettings.of(Material.WOOD).strength(0.4F,0.4F).sounds(BlockSoundGroup.LADDER).nonOpaque()));
        bambooLadderItem = itemRegister("bamboo_ladder", bambooLadderBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooLadderItem, 300);
        
        //Fence
        bambooFenceBlock = blockRegister("bamboo_fence", new BambooFenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO)));
        bambooFenceItem = itemRegister("bamboo_fence", bambooFenceBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooFenceItem, 300);
        
        //Fence gate
        bambooFenceGateBlock = blockRegister("bamboo_fence_gate", new BambooFenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO)));
        bambooFenceGateItem = itemRegister("bamboo_fence_gate", bambooFenceGateBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooFenceGateItem, 300);
        
        //Door
        bambooDoorBlock = blockRegister("bamboo_door", new BambooDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.BAMBOO)));
        bambooDoorItem = itemRegister("bamboo_door", bambooDoorBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooDoorItem, 200);
        
        //Trapdoor
        bambooTrapDoorBlock = blockRegister("bamboo_trapdoor", new BambooTrapDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.BAMBOO)));
        bambooTrapDoorItem = itemRegister("bamboo_trapdoor", bambooTrapDoorBlock, defaultSettings);
        FuelRegistry.INSTANCE.add(bambooTrapDoorItem, 300);
    }

    private Block blockRegister(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.ID, id), block);
    }

    private Item itemRegister(String id, Block block, Item.Settings settings) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.ID, id), new BlockItem(block, settings));
    }
}
