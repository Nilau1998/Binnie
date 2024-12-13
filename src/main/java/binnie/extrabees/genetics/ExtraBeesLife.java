package binnie.extrabees.genetics;

import binnie.core.util.I18N;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleInteger;

public enum ExtraBeesLife implements IAlleleInteger {

    IMMORTAL;

    public boolean dominant;
    private String uid;

    ExtraBeesLife() {
        uid = toString().toLowerCase();
        dominant = true;
    }

    public static void doInit() {
        for (ExtraBeesLife speed : values()) {
            speed.register();
        }
    }

    public void register() {
        AlleleManager.alleleRegistry.registerAllele(this, EnumBeeChromosome.LIFESPAN);
    }

    @Override
    public int getValue() {
        switch (this) {
            case IMMORTAL:
                return 1000;
        }
        return 0;
    }

    @Override
    public String getUID() {
        return "extrabees.lifespan." + uid;
    }

    @Override
    public boolean isDominant() {
        return dominant;
    }

    @Override
    public String getName() {
        return I18N.localise("extrabees.lifespan." + name().toLowerCase().replace("_", "") + ".name");
    }

    @Override
    public String getUnlocalizedName() {
        return getUID();
    }
}
