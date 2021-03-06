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
public class Imperative1Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (أحْيِ، أذْوِ، حايِ، داوِ، انزوِ، احتوِ، استحيِ، استهوِ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ أحْيِي، أذْوِي، حايِي، داوِي، انزوِي، احتوِي، استحيِي، استهوِي)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم أحْيُوا، أذْوُوا، حايُوا، داوُوا، انزوُوا، احتوُوا، استحيُوا، استهوُوا)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنتن أحْيِينَ، أذْوِينَ، حايِينَ، داوِينَ، انزوِينَ، احتوِينَ، استحيِينَ، استهوِينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if ((root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي') {
            if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
                switch (formulaNo) {
                    case 1:
                    case 5:
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
                    case 3:
                    case 4:
                    case 5:
                    case 9:
                        return true;
                }
            }

        }
        return false;
    }
}
