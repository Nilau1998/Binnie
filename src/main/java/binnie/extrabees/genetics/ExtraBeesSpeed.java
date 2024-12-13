package binnie.extrabees.genetics;

import binnie.core.util.I18N;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleFloat;

public enum ExtraBeesSpeed implements IAlleleFloat {

    ASCENDED;

    public boolean dominant;
    private String uid;

    ExtraBeesSpeed() {
        uid = toString().toLowerCase();
        dominant = true;
    }

    public static void doInit() {
        for (final ExtraBeesSpeed speed : values()) {
            speed.register();
        }
    }

    public void register() {
        AlleleManager.alleleRegistry.registerAllele(this, EnumBeeChromosome.SPEED);
    }

    @Override
    public float getValue() {
        switch (this) {
            case ASCENDED:
                return 4f;
        }
        return 0f;
    }

    @Override
    public String getUID() {
        return "extrabees.speed." + uid;
    }

    @Override
    public boolean isDominant() {
        return dominant;
    }

    @Override
    public String getName() {
        return I18N.localise("extrabees.speed." + name().toLowerCase().replace("_", "") + ".name");
    }

    @Override
    public String getUnlocalizedName() {
        return getUID();
    }
}
