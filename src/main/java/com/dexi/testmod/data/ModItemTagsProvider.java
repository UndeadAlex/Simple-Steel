package com.dexi.testmod.data;

import com.dexi.testmod.TestMod;
import com.dexi.testmod.setup.ModItems;
import com.dexi.testmod.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider
{
    public ModItemTagsProvider(DataGenerator genIn, BlockTagsProvider blockProviderIn, ExistingFileHelper existingFileHelper)
    {
        super(genIn, blockProviderIn, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        copy(ModTags.Blocks.STORAGE_BLOCKS_STEEL, ModTags.Items.STORAGE_BLOCKS_STEEL);
        copy(Tags.Blocks.STORAGE_BLOCKS, ModTags.Items.STORAGE_BLOCKS_STEEL);

        tag(ModTags.Items.INGOTS_STEEL).add(ModItems.STEEL_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_STEEL);
    }
}
