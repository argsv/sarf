package sarf.gerund.modifier.trilateral.unaugmented.nomen;

import sarf.ConjugationResult;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza.EinMahmouz;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza.FaaMahmouz;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza.LamMahmouz;
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
class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (var applier : modifiers) {
            if (applier.isApplied(conjResult)) {
                applier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
        //الأفعال الثلاثية المجردة المهموزة الفاء والمهموزة اللام (وهي: أبأ، أثأ، أجأ، أزأ، أكأ)
        if (conjResult.getRoot().getC3() == 'ء') {
            modifiers.get(2).apply(conjResult.getFinalResult(), conjResult.getRoot());
        }
    }
}
