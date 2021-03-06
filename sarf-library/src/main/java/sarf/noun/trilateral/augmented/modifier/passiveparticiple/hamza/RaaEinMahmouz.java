package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.ConjugationResult;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

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
public class RaaEinMahmouz extends TrilateralNounSubstitutionApplier{
private final List<Substitution> substitutions = new ArrayList<>();

    public RaaEinMahmouz() {

        substitutions.add(new InfixSubstitution("ْءً","ً"));// EX: (مُرًى، )
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (مُرَيانِ، )

    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي' && triAugmentedConjugationResult.getFormulaNo() == 1;
    }
}
