package sarf.gerund.modifier.trilateral.unaugmented.nomen.geminator;

import java.util.*;

import sarf.noun.*;

import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;

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
public class Geminator1 extends TrilateralNounSubstitutionApplier{
private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator1() {
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3َا","َC3َّا"));// EX: (رَدَّات، )
        substitutions.add(new ExpressionInfixSubstitution("َC3ْC3َ","َC3َّ"));// EX: (رَدَّة، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == conjugationResult.getRoot().getC3();
    }
}
