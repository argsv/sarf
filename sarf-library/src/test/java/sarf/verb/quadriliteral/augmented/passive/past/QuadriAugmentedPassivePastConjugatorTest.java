package sarf.verb.quadriliteral.augmented.passive.past;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.passive.past.formula.AugmentedPastVerb1;
import sarf.verb.quadriliteral.augmented.passive.past.formula.AugmentedPastVerb2;
import sarf.verb.quadriliteral.augmented.passive.past.formula.AugmentedPastVerb3;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuadriAugmentedPassivePastConjugatorTest {
    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @InjectMocks
    private QuadriAugmentedPassivePastConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> getCreateVerbListArguments() {
        return Stream.of(
                Arguments.of(1, AugmentedPastVerb1.class),
                Arguments.of(2, AugmentedPastVerb2.class),
                Arguments.of(3, AugmentedPastVerb3.class)
        );
    }

    @ParameterizedTest(name = "تصريف الفعل الرباعي المزيد المبني للمجهول {0}")
    @MethodSource("getCreateVerbListArguments")
    void createVerbList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();
        var augmentationFormula = new AugmentationFormula();
        augmentationFormula.setFormulaNo(formula);
        root.addAugmentationFormula(augmentationFormula);

        var actual = sut.createVerbList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        for(var verb: actual){
            assertThat(verb).isInstanceOf(expected);
        }
    }

    @ParameterizedTest(name = "تصريف الفعل الرباعي المزيد المبني للمجهول اللازم {0}")
    @MethodSource("getCreateVerbListArguments")
    void createLazzemVerbList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();
        var augmentationFormula = new AugmentationFormula();
        augmentationFormula.setFormulaNo(formula);
        augmentationFormula.setTransitive('ل');
        root.addAugmentationFormula(augmentationFormula);

        var actual = sut.createVerbList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        for(var i = 0; i < actual.size(); i++){
            if(i == 7 || i == 8){
             assertThat(actual.get(i)).isInstanceOf(expected);
            }
            else{
                assertThat(actual.get(i)).isNull();
            }
        }
    }
}
