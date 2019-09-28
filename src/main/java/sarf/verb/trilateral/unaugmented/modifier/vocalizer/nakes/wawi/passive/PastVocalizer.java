package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.passive;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.verb.trilateral.unaugmented.modifier.*;
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
public class PastVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new InfixSubstitution("ِوْ", "ِي"));
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ"));
        substitutions.add(new InfixSubstitution("ِوُ", "ُ"));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.First)) ||
                ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.Fifth)) ||
                ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.Third)) ||
                (kov == KindOfVerb.Naqis_Wawi && noc == Conjugation.Forth);
    }
}
