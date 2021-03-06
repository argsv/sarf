package sarf.noun.trilateral.unaugmented.assimilate.nonstandard;

import sarf.noun.INounSuffixContainer;
import sarf.noun.NounFormula;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public class NounFormulaE1 extends NounFormula {
    public NounFormulaE1() {
    }

    public NounFormulaE1(UnaugmentedTrilateralRoot root, String suffixNo, INounSuffixContainer nounSuffixContainer) {
        super(root, suffixNo, nounSuffixContainer);
        suffix = suffix.replaceAll(" ", ""); /* جرب وله لكي تصل في هذه الصيغة */
    }

    public String form() {
        switch (suffixNo) {
            case 1:
            case 3:
            case 7:
            case 9:
            case 13:
            case 15:
            case 2:
            case 4:
            case 8:
            case 10:
            case 14:
            case 16:
                return root.getC1() + ArabCharUtil.FATHA + root.getC2() + ArabCharUtil.SKOON + root.getC3() + ArabCharUtil.FATHA + "ان" + suffix;
        }

        return "";
    }

    public String getFormulaName() {
        return "فَعْلان / فَعْلانة";
    }
}
