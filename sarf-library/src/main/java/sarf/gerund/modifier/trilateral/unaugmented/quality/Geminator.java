package sarf.gerund.modifier.trilateral.unaugmented.quality;

import sarf.ConjugationResult;
import sarf.gerund.modifier.trilateral.unaugmented.quality.geminator.Geminator1;
import sarf.gerund.modifier.trilateral.unaugmented.quality.geminator.Geminator2;
import sarf.gerund.modifier.trilateral.unaugmented.quality.geminator.Geminator3;
import sarf.substitution.SubstitutionsApplier;

import java.util.ArrayList;
import java.util.List;

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
class Geminator {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
    }

    public void apply(ConjugationResult conjResult) {
        for (var geminator : modifiers) {
            if (geminator.isApplied(conjResult)) {
                geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
