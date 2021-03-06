package sarf.noun.trilateral.unaugmented.modifier.instrumental;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer.PreMithalLafifVocalizer;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer.WawiNakesLafifVocalizer;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer.YaeiNakesLafifVocalizer;
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
class Vocalizer {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    private final PreMithalLafifVocalizer preMithalLafifVocalizer = new PreMithalLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        // تطبيق اعلال واحد اولا
        if (preMithalLafifVocalizer.isApplied(conjResult))
            preMithalLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());

        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}

