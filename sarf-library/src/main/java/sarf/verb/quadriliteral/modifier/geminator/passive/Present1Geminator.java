package sarf.verb.quadriliteral.modifier.geminator.passive;

import java.util.*;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.substitution.Substitution;
import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;

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
public class Present1Geminator extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Geminator() {
        substitutions.add(new ExpressionInfixSubstitution("ْC4َC4ُ", "َC4ُّ"));// EX: (هو يُقْشَعَرُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4َC4َ", "َC4َّ"));// EX: (هما يُقْشَعَرَّانِ)
        substitutions.add(new ExpressionInfixSubstitution("ْC4َC4ِ", "َC4ِّ"));// EX: (أنتِ تُقْشَعَرِّينَ)
        substitutions.add(new ExpressionSuffixSubstitution("ْC4َC4ْ", "َC4َّ"));// EX: (لم يُقْشَعَرَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getFormulaNo() == 3;
    }
}
