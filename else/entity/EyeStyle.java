package net.ltxprogrammer.changed.entity;

import net.ltxprogrammer.changed.Changed;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.IExtensibleEnum;
import org.apache.commons.lang3.NotImplementedException;

public enum EyeStyle implements IExtensibleEnum {
    V1(Changed.modResource("v1")),
    V2(Changed.modResource("v2")),
    TALL(Changed.modResource("tall"));

    private final ResourceLocation id;
    private final ResourceLocation irisLeft;
    private final ResourceLocation irisRight;
    private final ResourceLocation sclera;
    private final ResourceLocation eyeBrows;
    private final ResourceLocation eyeLashes;
    private final Component textName;

    EyeStyle(ResourceLocation id) {
        this.id = id;
        this.irisLeft = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "textures/eyes/" + id.getPath() + "_iris_left.png");
        this.irisRight = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "textures/eyes/" + id.getPath() + "_iris_right.png");
        this.sclera = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "textures/eyes/" + id.getPath() + "_sclera.png");
        this.eyeBrows = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "textures/eyes/" + id.getPath() + "_eyebrows.png");
        this.eyeLashes = ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "textures/eyes/" + id.getPath() + "_eyelashes.png");
        this.textName = Component.translatable("eyestyle." + id.getNamespace() + "." + id.getPath());
    }

    public ResourceLocation getLeftIris() {
        return irisLeft;
    }

    public ResourceLocation getRightIris() {
        return irisRight;
    }

    public ResourceLocation getSclera() {
        return sclera;
    }

    public ResourceLocation getId() {
        return id;
    }

    public Component getName() {
        return textName;
    }

    public ResourceLocation getEyeBrows() {
        return eyeBrows;
    }

    public ResourceLocation getEyeLashes() {
        return eyeLashes;
    }

    public static EyeStyle create(String name, ResourceLocation id) {
        throw new NotImplementedException("Not implemented!");
    }
}
