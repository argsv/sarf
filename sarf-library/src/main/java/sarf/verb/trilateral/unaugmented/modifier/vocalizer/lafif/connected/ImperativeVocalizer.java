package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

import sarf.Conjugation;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class ImperativeVocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ImperativeVocalizer() {
        substitutions.add(new SuffixSubstitution("ِيْ", "ِ")); // EX: (اشْوِ)
        substitutions.add(new InfixSubstitution("ِيِن", "ِن")); // EX: (أنتِ اشْوِنَّ)
        substitutions.add(new InfixSubstitution("ِيِ", "ِ")); // EX: (أنتِ اشْوِي)
        substitutions.add(new InfixSubstitution("ِيْ", "ِي")); // EX: (أنتن اشْوِينَ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (أنتم اشْوُوا)
        substitutions.add(new SuffixSubstitution("َيْ", "َ")); // EX: (أنتَ اقْوَ، احْيَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ")); // EX: (أنتِ اقوَيْ، احْيَيْ)
        substitutions.add(new InfixSubstitution("َيُو", "َوْ")); // EX: (أنتم اقْوَوْا، احْيَوْا)
        substitutions.add(new InfixSubstitution("َيُن", "َوُن")); // EX: (أنتم اقْوَوُنَّ، احيَوُنَّ)
        substitutions.add(new SuffixSubstitution("َوْ", "َ")); // EX: (اسْوَ)
        substitutions.add(new InfixSubstitution("َوِي", "َيْ")); // EX: (أنتِ اسْوَيْ)
        substitutions.add(new InfixSubstitution("َوَن", "َيَن")); // EX: (أنتَ اسْوَيَنَّ)
        substitutions.add(new InfixSubstitution("َوْن", "َيْن")); // EX: (أنتن اسْوَيْنَ)
        substitutions.add(new InfixSubstitution("َوِن", "َيِن")); // EX: (أنتِ اسْوَيِنَّ)
        substitutions.add(new InfixSubstitution("َوُو", "َوْ")); // EX: (أنتم اسْوَوْا)
        substitutions.add(new InfixSubstitution("َوَ", "َيَ"));// EX: (أنتما اسْويا)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && (noc == Conjugation.Second)) ||
                (kov == KindOfVerb.Lafeef_Maqroon && noc == Conjugation.Forth);
    }
}
