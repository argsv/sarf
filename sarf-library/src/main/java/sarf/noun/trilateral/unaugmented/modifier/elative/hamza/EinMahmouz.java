package sarf.noun.trilateral.unaugmented.modifier.elative.hamza;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class EinMahmouz extends AbstractEinMahmouz {
    private final List<Substitution> substitutions = new ArrayList<>();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("ْءَ","ْأَ"));// EX: (أضأل)
        substitutions.add(new InfixSubstitution("ُءْ","ُؤْ"));// EX: (ضُؤْلَى)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
