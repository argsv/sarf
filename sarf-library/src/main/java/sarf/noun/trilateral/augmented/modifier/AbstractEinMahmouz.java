package sarf.noun.trilateral.augmented.modifier;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractEinMahmouz extends TrilateralNounSubstitutionApplier{

    @Override
    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        return kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain || kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain;
    }
}
