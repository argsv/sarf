package sarf.verb.trilateral.augmented.modifier.hamza.lam;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.SubstitutionsApplier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب المشترك لمهموز اللام حسب شرط الفحص المشترك للمضارع والأمر والماضي           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractLamMahmouz extends SubstitutionsApplier{
    protected AbstractLamMahmouz() {
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Mahmouz_Faa_Mahmouz_Laam) {
            return formulaNo == 5;
        } else if (kov == KindOfVerb.Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }


        } else if (kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 7:
                case 8:
                case 9:
                    return true;
            }
        }
        return false;
    }

}
