package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.*;

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
        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (تَسامَ، تَزَكَّ)
        substitutions.add(new InfixSubstitution("وِي","يْ"));// EX: (أنتِ تسامَيْ، تزَكَّيْ)
        substitutions.add(new InfixSubstitution("وِن","يِن"));// EX: (أنتِ تسامَيِنَّ، تزَكَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو","وْ"));// EX: (أنتم تسامَوْا، تزَكَّوْا)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنتن تسامَيْنَ، تزَكَّيْنَ)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أنتما تسامَيا، تزكَّيا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 7:
                case 8:
                    return true;
            }
        }
        return false;
    }
}
