package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.ConjugationResult;

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
public class Imperative1Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ُ", "ِيC3ُ")); // EX: (أنتم أقيموا، استديروا)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ِ", "ِيC3ِ")); // EX: (أنتِ أقيمي، استديري)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3َ", "ِيC3َ")); // EX: (أنتما أقيما، استديرا)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ْ", "ِC3ْ")); // EX: (أنتن أقِمْنَ، استدرْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 9);
    }
}
