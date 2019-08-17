package sarf.gerund.trilateral.augmented.nomen.pattern;

import sarf.noun.GenericNounSuffixContainer;
import sarf.util.*;
import sarf.verb.trilateral.augmented.*;
import sarf.gerund.trilateral.augmented.nomen.*;

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
public class GerundPattern4 extends TrilateralAugmentedNomenGerund {
    public GerundPattern4(AugmentedTrilateralRoot root, String suffixNo, GenericNounSuffixContainer genericNounSuffixContainer) {
        super(root, suffixNo, genericNounSuffixContainer);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this
     * sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String form() {
        return "ان" + ArabCharUtil.SKOON + root.getC1() + ArabCharUtil.KASRA + root.getC2() + ArabCharUtil.FATHA + "ا" + root.getC3() + suffix;
    }

    /**
     * getPattern
     *
     * @return String
     * @todo Implement this
     * sarf.gerund.trilateral.augmented.TrilateralAugmentedNomenGerund method
     */
    public String getPattern() {
        return "انْفِعَالة";
    }
}
