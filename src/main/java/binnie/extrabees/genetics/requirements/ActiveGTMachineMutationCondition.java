package binnie.extrabees.genetics.requirements;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import forestry.api.core.IClimateProvider;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IGenome;
import forestry.api.genetics.IMutationCondition;
import gregtech.api.metatileentity.BaseMetaTileEntity;

public class ActiveGTMachineMutationCondition implements IMutationCondition {

    public ActiveGTMachineMutationCondition() {

    }

    @Override
    public float getChance(World world, int x, int y, int z, IAllele allele0, IAllele allele1, IGenome genome0,
            IGenome genome1, IClimateProvider climate) {
        TileEntity tileEntity = world.getTileEntity(x, y - 1, z);
        if (tileEntity instanceof BaseMetaTileEntity) {
            BaseMetaTileEntity machine = (BaseMetaTileEntity) tileEntity;
            if (machine.isActive()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Needs a running GT Machine below to breed";
    }
}
