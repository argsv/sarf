package sarf.verb.trilateral.unaugmented.modifier.hamza;

import sarf.KindOfVerb;
import sarf.ConjugationResult;
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
public abstract class AbstractLamMahmouz extends SubstitutionsApplier {
    protected AbstractLamMahmouz() {
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        return kov == KindOfVerb.Mahmouz_Faa_Mahmouz_Laam || kov == KindOfVerb.Mahmouz_Laam || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam;
    }
}
