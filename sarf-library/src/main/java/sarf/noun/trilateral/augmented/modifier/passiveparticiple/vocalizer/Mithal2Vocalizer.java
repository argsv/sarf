package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
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
public class Mithal2Vocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Mithal2Vocalizer() {
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (مُوقَظٌ، )
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain || kov == KindOfVerb.Mithal_Yaee) {
            return formulaNo == 1;
        }


        return false;

    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
