package sarf.gerund.trilateral.augmented.nomen;

import sarf.Word;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

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
public abstract class TrilateralAugmentedNomenGerund extends Word {
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    protected final AugmentedTrilateralRoot root;
    private final int suffixNo;
    protected final String suffix;

    protected TrilateralAugmentedNomenGerund(AugmentedTrilateralRoot root, String suffixNo
            , GenericNounSuffixContainer genericNounSuffixContainer) {
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.root = root;
        this.suffixNo = Integer.parseInt(suffixNo);
        suffix = genericNounSuffixContainer.get(this.suffixNo);
    }

    protected abstract String form();

    public abstract String getPattern();

    @Override
    public String toString() {
        String result = form();
        if (result != null && !result.equals(""))
            return genericNounSuffixContainer.getPrefix() + result;
        return "";

    }
}
