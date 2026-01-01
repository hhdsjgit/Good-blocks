package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.latex.LatexType;
import net.ltxprogrammer.changed.entity.latex.SpreadingLatexType;
import net.ltxprogrammer.changed.util.Cacheable;
import net.ltxprogrammer.changed.world.LatexCoverState;
import net.minecraft.core.IdMapper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.RegistryObject;

public class ChangedLatexTypes {
    public static final DeferredRegister<LatexType> REGISTRY = ChangedRegistry.LATEX_TYPE.createDeferred(Changed.MODID);

    public static final RegistryObject<LatexType.None> NONE = REGISTRY.register("none", LatexType.None::new);
    public static final RegistryObject<SpreadingLatexType.DarkLatex> DARK_LATEX = REGISTRY.register("dark_latex", SpreadingLatexType.DarkLatex::new);
    public static final RegistryObject<SpreadingLatexType.WhiteLatex> WHITE_LATEX = REGISTRY.register("white_latex", SpreadingLatexType.WhiteLatex::new);

    public static final ResourceLocation LATEXCOVERSTATE_TO_ID = Changed.modResource("latexcoverstatetoid");

    @SuppressWarnings("unchecked")
    public static IdMapper<LatexCoverState> getLatexCoverStateIDMap() {
        return RegistryManager.ACTIVE.getRegistry(ChangedRegistry.LATEX_TYPE.key).getSlaveMap(LATEXCOVERSTATE_TO_ID, IdMapper.class);
    }
}
