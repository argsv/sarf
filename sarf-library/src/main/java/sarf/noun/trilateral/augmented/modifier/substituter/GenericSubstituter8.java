package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.noun.trilateral.augmented.modifier.AbstractGenericSubstituter;
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
public class GenericSubstituter8 extends AbstractGenericSubstituter {
    private final List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter8() {
        substitutions.add(new InfixSubstitution("ظْت","ظْط"));// EX: (اظطلام، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        return triAugmentedConjugationResult.getRoot().getC1() == 'ظ' && super.isApplied(triAugmentedConjugationResult);
    }
}
