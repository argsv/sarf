package sarf.ui.controlpane;

import javax.swing.*;

import sarf.Word;
import sarf.WordPresenter;
import sarf.ui.*;
import java.awt.*;

import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.present.AugmentedQuadPassivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.passive.QuadPassivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.QuadriUnaugmentedPassivePastConjugator;
import sarf.verb.trilateral.augmented.*;
import java.util.List;

import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator;

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
public class PassiveVerbSelectionUI extends JPanel implements IControlPane, AugmentedTrilateralModifierListener {
    private final IMainControlPanel controlPaneContainer;
    private final AugmentedPassivePastConjugator augmentedPassivePastConjugator;
    private final QuadriAugmentedPassivePastConjugator quadriAugmentedPassivePastConjugator;
    private final PassivePastConjugator passivePastConjugator;
    private final QuadriUnaugmentedPassivePastConjugator quadriUnaugmentedPassivePastConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final QuadPassivePresentConjugator quadPassivePresentConjugator;
    private final PassivePresentConjugator passivePresentConjugator;
    private final AugmentedPassivePresentConjugator augmentedPassivePresentConjugator;
    private final AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator;
    private SelectionInfo selectionInfo;

    private final ToggleRenderedButton pastBtn = new ToggleRenderedButton("الماضي المجهول ");
    private final ToggleRenderedButton presentNominativeBtn = new ToggleRenderedButton("المضارع المرفوع المجهول ");
    private final ToggleRenderedButton presentAccusativeBtn = new ToggleRenderedButton("المضارع المنصوب المجهول ");
    private final ToggleRenderedButton presentJussiveBtn = new ToggleRenderedButton("المضارع المجزوم المجهول ");
    private final ToggleRenderedButton presentEmphasizedBtn = new ToggleRenderedButton("المضارع المؤكد المجهول ");


    public PassiveVerbSelectionUI(ControlPaneContainer controlPaneContainer
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedPassivePastConjugator augmentedPassivePastConjugator
            , QuadriAugmentedPassivePastConjugator quadriAugmentedPassivePastConjugator
            , PassivePastConjugator passivePastConjugator
            , QuadriUnaugmentedPassivePastConjugator quadriUnaugmentedPassivePastConjugator
            , QuadrilateralModifier quadrilateralModifier
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , QuadPassivePresentConjugator quadPassivePresentConjugator
            , PassivePresentConjugator passivePresentConjugator
            , AugmentedPassivePresentConjugator augmentedPassivePresentConjugator
            , AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;
        this.quadriAugmentedPassivePastConjugator = quadriAugmentedPassivePastConjugator;
        this.passivePastConjugator = passivePastConjugator;
        this.quadriUnaugmentedPassivePastConjugator = quadriUnaugmentedPassivePastConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.quadPassivePresentConjugator = quadPassivePresentConjugator;
        this.passivePresentConjugator = passivePresentConjugator;
        this.augmentedPassivePresentConjugator = augmentedPassivePresentConjugator;
        this.augmentedQuadPassivePresentConjugator = augmentedQuadPassivePresentConjugator;

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel topPane = new APanel(new GridLayout(1, 4));
        topPane.add(Box.createHorizontalBox());

        topPane.add(Box.createHorizontalBox());

        JPanel buttonsPanel = new APanel(new GridLayout(1, 7));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pastBtn);
        buttonGroup.add(presentNominativeBtn);
        buttonGroup.add(presentAccusativeBtn);
        buttonGroup.add(presentJussiveBtn);
        buttonGroup.add(presentEmphasizedBtn);

        buttonsPanel.add(pastBtn);
        buttonsPanel.add(presentNominativeBtn);
        buttonsPanel.add(presentAccusativeBtn);
        buttonsPanel.add(presentJussiveBtn);
        buttonsPanel.add(presentEmphasizedBtn);

        add(topPane);
        add(buttonsPanel);

        pastBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePastConjugator.createVerbList((AugmentedTrilateralRoot) selectionInfo.
                            getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PAST_TENSE, false, PassiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                }
                else {
                    result = this.passivePastConjugator.createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((
                            UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, false);
                    finalResult = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = this.quadriAugmentedPassivePastConjugator.createVerbList((AugmentedQuadrilateralRoot)
                            selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = this.quadriUnaugmentedPassivePastConjugator.createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.
                            getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, false);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, pastBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentNominativeBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePresentConjugator.getNominativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                }
                else {
                    result = this.passivePresentConjugator.createNominativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((
                            UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    finalResult = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadPassivePresentConjugator.getNominativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = this.quadPassivePresentConjugator.createNominativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, presentNominativeBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentAccusativeBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePresentConjugator.getAccusativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                }
                else {
                    result = this.passivePresentConjugator.createAccusativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((
                            UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    finalResult = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadPassivePresentConjugator.getAccusativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = quadPassivePresentConjugator.createAccusativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, presentAccusativeBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentJussiveBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePresentConjugator.getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.PRESENT_TENSE, false, false, PassiveVerbSelectionUI.this);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, finalResult, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
                else {
                    result = this.passivePresentConjugator.createJussiveVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        var notGeminatedConjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.PRESENT_TENSE, false, false);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, finalResult, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadPassivePresentConjugator.getJussiveConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = quadPassivePresentConjugator.createJussiveVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                ConjugationResult notGeminatedConjResult = this.quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), conjResult.getOriginalResult(),
                        SystemConstants.PRESENT_TENSE, false, false);

                finalResult = conjResult.getFinalResult();
                JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, finalResult, notGeminatedConjResult.getFinalResult(), presentJussiveBtn.getText());
                controlPaneContainer.openResult(ui);
                return;


            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, presentJussiveBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentEmphasizedBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;

            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePresentConjugator.getEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                }
                else {
                    result = this.passivePresentConjugator.createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((
                            UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    finalResult = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadPassivePresentConjugator.getEmphasizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = quadPassivePresentConjugator.createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, presentEmphasizedBtn.getText());
            controlPaneContainer.openResult(ui);
        });
    }

    public JComponent getComponent() {
        return this;
    }

    void setInfo(SelectionInfo selectionInfo) {
        this.selectionInfo = selectionInfo;
        //to ask the user again for this new verb, reset the cashed user response
        cashedUserResponse = null;
        pastBtn.doClick();
    }

    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }

    private Boolean cashedUserResponse = null;
    //to let the user select when there is two states for the verb: with vocalization and without
    public boolean doSelectVocalization() {
        if (cashedUserResponse != null) {
            return cashedUserResponse;
        }

        //it must select one of two states
        String msg = "لهذا الفعل حالتان : التصحيح والإعلال، اختر إحدى الحالتين";
        Object[] options = {"التصحيح", "الإعلال"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        cashedUserResponse = optionResult == JOptionPane.NO_OPTION;
        return cashedUserResponse;
    }


}
