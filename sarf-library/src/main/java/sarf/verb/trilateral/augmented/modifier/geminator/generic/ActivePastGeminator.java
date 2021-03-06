package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import sarf.ConjugationResult;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;


import java.util.*;

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
public class ActivePastGeminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePastGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3َ","َC3َّ"));// EX: (أَمَدَّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ُ","َC3ُّ"));// EX: (أَمَدُّوا،)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3َ","اC3َّ"));// EX: (حاجَّ، احمارَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ُ","اC3ُّ"));// EX: (حاجُّوا، احمارُّوا)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3َ","َC3َّ"));// EX: (احمرَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3ُ","َC3ُّ"));// EX: (احمرُّوا)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return false;
    }
}
