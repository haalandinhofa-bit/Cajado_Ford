package com.erling.thefracture;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(TheFracture.MOD_ID)
public class TheFracture {
    public static final String MOD_ID = "the_fracture";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Block> NUCLEO_FRATURADO = BLOCKS.register("nucleo_fraturado", () -> new NucleoFraturadoBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(3.5F, 6.0F).sound(SoundType.DEEPSLATE).lightLevel(state -> 5)));
    public static final RegistryObject<Item> NUCLEO_FRATURADO_ITEM = ITEMS.register("nucleo_fraturado", () -> new BlockItem(NUCLEO_FRATURADO.get(), new Item.Properties()));

    public TheFracture() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        bus.addListener(this::addCreative);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) event.accept(NUCLEO_FRATURADO_ITEM);
    }
}
