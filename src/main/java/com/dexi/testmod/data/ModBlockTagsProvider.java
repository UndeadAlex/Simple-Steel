package com.dexi.testmod.data;

import com.dexi.testmod.TestMod;
import com.dexi.testmod.setup.ModBlocks;
import com.dexi.testmod.setup.ModItems;
import com.dexi.testmod.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator genIn, ExistingFileHelper existingFileHelper)
    {
        super(genIn, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        tag(ModTags.Blocks.STORAGE_BLOCKS_STEEL)
                .add(ModBlocks.STEEL_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_STEEL);
    }
}
