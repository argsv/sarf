package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.*;

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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("َوَات","َيَات"));// EX: (مُحابَيات)
        substitutions.add(new InfixSubstitution("َاوَوَ","َاوَا"));// EX: (مُساواة)
        substitutions.add(new SuffixSubstitution("ُوُ","ِي"));// EX: (هذا التسامي، التزكِّي)
        substitutions.add(new SuffixSubstitution("ُوَ","ِيَ"));// EX: (رأيتُ التساميَ، التزكِّيَ)
        substitutions.add(new SuffixSubstitution("ُوِ","ِي"));// EX: (بالتسامِي ، بالتزكِّي)
        substitutions.add(new InfixSubstitution("ُوٌ","ٍ"));// EX: (هذا تسامٍ، تَزَكٍّ)
        substitutions.add(new InfixSubstitution("ُوٍ","ٍ"));// EX: (بِتَسامٍ، تَزَكٍّ)
        substitutions.add(new InfixSubstitution("ُوً","ِيً"));// EX: (تسامِيًا، تَزَكِّيًا)
        substitutions.add(new InfixSubstitution("ُوَ","ِيَ"));// EX: (تسامِيان، تَزَكِّيَان)
        substitutions.add(new InfixSubstitution("َاوًا","َاءً"));// EX: (إخاءً)
        substitutions.add(new InfixSubstitution("َاو","َاء"));// EX: (إدناء، حِباء، انجلاء، ارتضاء، ارعواء، استرضاء، احليلاء)
        substitutions.add(new InfixSubstitution("َوَ","َا"));// EX: (مُحاباة)
        substitutions.add(new InfixSubstitution("ِيو","ِي"));// EX: (تسمية)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'و')
            return false;

        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 21:
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

        case 22:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                return true;
            }

        case 23:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            }

        case 28:
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
        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
