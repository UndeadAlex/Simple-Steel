package com.dexi.testmod.data;

import com.dexi.testmod.setup.ModBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider
{
    public ModLootTableProvider(DataGenerator genIn)
    {
        super(genIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
    {
        map.forEach(((resourceLocation, lootTable) -> LootTableManager.validate(validationtracker, resourceLocation, lootTable)));
    }

    public static class ModBlockLootTables extends BlockLootTables
    {
        @Override
        protected void addTables()
        {
            dropSelf(ModBlocks.STEEL_BLOCK.get());
        }
    }
}
