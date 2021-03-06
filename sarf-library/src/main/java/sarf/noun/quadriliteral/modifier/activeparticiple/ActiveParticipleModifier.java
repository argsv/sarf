package sarf.noun.quadriliteral.modifier.activeparticiple;

import com.google.inject.Inject;
import sarf.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;

import java.util.List;

public class ActiveParticipleModifier {
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final InternalMahmouz internalMahmouz = new InternalMahmouz();
    private final EndedMahmouz endedMahmouz = new EndedMahmouz();
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public ActiveParticipleModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    /**
     * @param root         UnaugmentedTrilateralRoot
     * @param conjugations List
     * @return ConjugationResult
     */
    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List<? extends Word> conjugations) {
        var conjResult = new ConjugationResult(kov, formulaNo, root, conjugations);
        if (geminator.isApplied(conjResult))
            geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (vocalizer.isApplied(conjResult))
            vocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (internalMahmouz.isApplied(conjResult))
            internalMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (endedMahmouz.isApplied(conjResult))
            endedMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }
}
