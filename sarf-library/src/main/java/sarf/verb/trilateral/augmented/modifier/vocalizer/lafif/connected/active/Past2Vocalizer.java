package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class Past2Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (أذْوَى، قَوَّى، داوى، انزوى، احتوى،تداوى، تقوَّى استهوى)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أذوَوْا، قَوَّوْا داوَوْا، انزَوَوْا، احتَوَوْا، تداوَوْا، تَقَوَّوْا، استهوَوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (أذوَتْ، قَوَّت داوَت، انزوتْ، احتوتْ، تداوتْ، تقوَّتْ، استهوتْ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if (root.getC2() == 'و' && root.getC3() == 'ي') {
            if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
                switch (formulaNo) {
                    case 1:
                    case 2:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                }


                switch (formulaNo) {
                    case 3:
                    case 4:
                        return true;
                }
            } else if (kov == KindOfVerb.Lafeef_Maqroon) {
                switch (formulaNo) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                        return true;
                }
            }
        }
        return false;
    }
}
