package sarf.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.hamza.*;
import sarf.substitution.SubstitutionsApplier;

import sarf.ConjugationResult;

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
public class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new FaaMahmouz());
        modifiers.add(new EinMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (var substitutionsApplier : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) substitutionsApplier;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
