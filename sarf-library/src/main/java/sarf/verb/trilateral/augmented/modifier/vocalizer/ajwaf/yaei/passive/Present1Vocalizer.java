package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive;

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
public class Present1Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ","َاC3ُ"));// EX: (هو يُبادُ، يُستقال)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ِ","َاC3ِ"));// EX: (أنتِ تُبادِين، تُستقالين)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ","َاC3َ"));// EX: (أنتما تُبادان، تُستقالان)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ","َC3ْ"));// EX: (هنّ يُبَدْنَ، يُستَقَلْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 9);
    }
}
