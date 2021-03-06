package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public YaeiNakesLafifVocalizer() {

        substitutions.add(new InfixSubstitution("ايَيٌ","ايًا"));// EX: (هذا مُتَحايًا)
        substitutions.add(new InfixSubstitution("ايَيًا","ايًا"));// EX: (رأيتُ مُتَحايًا)
        substitutions.add(new InfixSubstitution("ايَيٍ","ايًا"));// EX: (مررتُ على مُتَحايًا)
        substitutions.add(new SuffixSubstitution("ايَيُ","ايَا"));// EX: (هذا المتحايا،)
        substitutions.add(new SuffixSubstitution("ايَيَ","ايَا"));// EX: (رأيتُ المتحايا ،  )
        substitutions.add(new SuffixSubstitution("ايَيِ","ايَا"));// EX: (مررتُ على المتحايا ، )
        substitutions.add(new InfixSubstitution("ْيَيٌ","ْيًا"));// EX: (هذا مُستحيًا)
        substitutions.add(new InfixSubstitution("ْيَيًا","ْيًا"));// EX: (رأيتُ مُستحيًا)
        substitutions.add(new InfixSubstitution("ْيَيٍ","ْيًا"));// EX: (مررتُ على مُستحيًا)
        substitutions.add(new SuffixSubstitution("ْيَيُ","ْيَا"));// EX: (هذا المستحيا،)
        substitutions.add(new SuffixSubstitution("ْيَيَ","ْيَا"));// EX: (رأيتُ المستحيا ،  )
        substitutions.add(new SuffixSubstitution("ْيَيِ","ْيَا"));// EX: (مررتُ على المستحيا ، )

        substitutions.add(new InfixSubstitution("َيَيٌ", "َيًا")); // EX: (هذا مُزدَيًا)
        substitutions.add(new InfixSubstitution("َيَيًا", "َيًا")); // EX: (رأيتُ مُزدَيًا)
        substitutions.add(new InfixSubstitution("َيَيٍ", "َيًا")); // EX: (مررتُ على مُزدَيًا)
        substitutions.add(new InfixSubstitution("َيَّيٌ", "َيًّا")); // EX: (هذا مُحَيًّا)
        substitutions.add(new InfixSubstitution("َيَّيًا", "َيًّا")); // EX: (رأيتُ مُحَيًّا)
        substitutions.add(new InfixSubstitution("َيَّيٍ", "َيًّا")); // EX: (مررتُ على مُحَيًّا)
        substitutions.add(new SuffixSubstitution("َيَيُ", "َيَا")); // EX: (هذا المُزدَيا،)
        substitutions.add(new SuffixSubstitution("َيَيَ", "َيَا")); // EX: (رأيتُ المُزدَيا ،  )
        substitutions.add(new SuffixSubstitution("َيَيِ", "َيَا")); // EX: (مررتُ على المُزدَيا ، )
        substitutions.add(new SuffixSubstitution("َيَّيُ", "َيَّا")); // EX: (هذا المُحيَّا،)
        substitutions.add(new SuffixSubstitution("َيَّيَ", "َيَّا")); // EX: (رأيتُ المُحيَّا ،  )
        substitutions.add(new SuffixSubstitution("َيَّيِ", "َيَّا")); // EX: (مررتُ على المُحيَّا ، )
        substitutions.add(new InfixSubstitution("َيَة", "َاة")); // EX: (مُهْدَاةٌ،)
        substitutions.add(new InfixSubstitution("َيَت", "َات")); // EX: (مُهْداتانِ، مُهداتَيْنِ)
        substitutions.add(new InfixSubstitution("َيُو", "َوْ")); // EX: (مُهْدَونَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ")); // EX: (مُهْدَيْنَ)
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (هذا المُهْدَى،)
        substitutions.add(new SuffixSubstitution("َيَ", "َى")); // EX: (رأيتُ المُهْدَى ،  )
        substitutions.add(new SuffixSubstitution("َيِ", "َى")); // EX: (مررتُ على المُهْدَى ، )
        substitutions.add(new InfixSubstitution("َيٌ", "ًى")); // EX: (هذا مُهْدًى)
        substitutions.add(new InfixSubstitution("َيًا", "ًى")); // EX: (رأيتُ مُهْدًى)
        substitutions.add(new InfixSubstitution("َيٍ", "ًى")); // EX: (مررتُ على مُهْدًى)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        if (triAugmentedConjugationResult.getRoot().getC3() != 'ي') {
            return false;
        }

        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 4:
                case 11:
                    return true;
            }


            return formulaNo == 10;


        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 11:
                    return true;
            }


            return formulaNo == 10;


        } else if (kov == KindOfVerb.Naqis_Yaee) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }


        } else if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
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


        } else if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
