package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

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
public class PreSeparatedLafifVocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public PreSeparatedLafifVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (مُوصٍ)
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (مُودٍ)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return kov == KindOfVerb.Lafeef_Mafrooq  && formulaNo == 1;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
