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
public class PastVocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ْ", "ِC3ْ"));// EX: (أبِدْتُ، استُقلتُ،)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ّ", "ِC3ّ"));// EX: (أُبِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3َ", "ِيC3َ"));// EX: (أبِيدَ، استُقِيل،)
        substitutions.add(new ExpressionInfixSubstitution("ْيِC3ُ", "ِيC3ُ"));// EX: (أبِيدُوا، استُقِيلوا،)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ْ", "ِC3ْ"));// EX: (انْهِلْتُ، اكتِلْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ", "ِC3ّ"));// EX: (اختِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3َ", "ِيC3َ"));// EX: (انْهِيلَ، اكتِيل)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ُ", "ِيC3ُ"));// EX: (انهِيلوا، اكتِيلوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 1) ||
                (kov == KindOfVerb.Ajwaf_Yaee && formulaNo == 4) ||
                ((kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa) && formulaNo == 5) ||
                ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 9);
    }
}
