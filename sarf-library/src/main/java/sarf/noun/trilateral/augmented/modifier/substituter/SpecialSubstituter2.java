package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.ConjugationResult;

import sarf.noun.TrilateralNounSubstitutionApplier;

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
public class SpecialSubstituter2 extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public SpecialSubstituter2() {
        substitutions.add(new InfixSubstitution("يْت","تّ"));// EX: (اتِّسار،)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        return triAugmentedConjugationResult.getRoot().getC1() == 'ي' && formulaNo == 5 && (kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain || kov == KindOfVerb.Mithal_Yaee);
    }
}
