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
public class Imperative2Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ُ","َاC3ُ"));// EX: (أنتم انقادوا، اقتادوا)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ِ","َاC3ِ"));// EX: (أنتِ انقادي، اقتادي)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3َ","َاC3َ"));// EX: (أنتما انقادا، اقتادا)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ْ","َC3ْ"));// EX: (أنتن انقدن، اقتدن)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 5);
    }
}
