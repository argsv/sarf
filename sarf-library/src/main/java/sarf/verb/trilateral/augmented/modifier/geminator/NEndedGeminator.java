package sarf.verb.trilateral.augmented.modifier.geminator;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الذي ينتهي بالنون    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NEndedGeminator extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public NEndedGeminator() {
        substitutions.add(new InfixSubstitution("نْن","نّ"));// EX: (نحن سَكَّنَّا، هنَّ سَكَّنَّ)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        if (triAugmentedConjugationResult.getRoot().getC3() != 'ن') return false;
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
            case 11:
                if (kov == KindOfVerb.Salim || kov == KindOfVerb.Mudaaf || kov == KindOfVerb.Mahmouz_Faa_Mudaaf || kov == KindOfVerb.Mahmouz_Faa || kov == KindOfVerb.Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Mithal_Yaee || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee) {
                    return true;
                }
        }
        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
