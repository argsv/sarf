package sarf.ui.controlpane;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import sarf.Action;
import sarf.noun.*;
import sarf.ui.*;
import sarf.noun.trilateral.unaugmented.elative.*;

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
public class ElativeNounStateSelectionUI extends JPanel implements INounStateSelectionUI{
    private final ToggleRenderedButton definiteBtn = new ToggleRenderedButton("المعرف بأل ");
    private final ToggleRenderedButton annexedDefiniteBtn = new ToggleRenderedButton("المضاف إلى معرفة  ");
    private final ToggleRenderedButton annexedIndefiniteBtn = new ToggleRenderedButton("المضاف إلى نكرة  ");
    private final ToggleRenderedButton notAnnexedIndefiniteBtn = new ToggleRenderedButton("غير المضاف ");


    public ElativeNounStateSelectionUI() {
        super(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.BLACK, Color.BLUE));

        JPanel buttonsPanel = new APanel(new GridLayout(1, 4));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(annexedDefiniteBtn);
        buttonGroup.add(definiteBtn);
        buttonGroup.add(annexedIndefiniteBtn);
        buttonGroup.add(notAnnexedIndefiniteBtn);

        buttonsPanel.add(annexedDefiniteBtn);
        buttonsPanel.add(definiteBtn);
        buttonsPanel.add(annexedIndefiniteBtn);
        buttonsPanel.add(notAnnexedIndefiniteBtn);

        annexedDefiniteBtn.setSelected(true);

        add(buttonsPanel);

        definiteBtn.setFont(RenderedButton.FONT);
        annexedDefiniteBtn.setFont(RenderedButton.FONT);
        annexedIndefiniteBtn.setFont(RenderedButton.FONT);
        notAnnexedIndefiniteBtn.setFont(RenderedButton.FONT);
    }

    public JComponent getComponent() {
        return this;
    }

    public void init(final Action action, INounSuffixContainer nounSuffixContainer, final NounStateSelectionUIListener listener) {
        definiteBtn.addActionListener(e -> {
            ElativeSuffixContainer.getInstance().selectDefiniteMode();
            //generate the new conjugation with the new suffixes
            var newResult = action.execute();
            //display this new result via this listener
            listener.newStateConjugationResultGenerated(newResult);
        });

        annexedIndefiniteBtn.addActionListener(e -> {
            ElativeSuffixContainer.getInstance().selectInDefiniteMode();
            //generate the new conjugation with the new suffixes
            var newResult = action.execute();
            //display this new result via this listener
            listener.newStateConjugationResultGenerated(newResult);
        });

        notAnnexedIndefiniteBtn.addActionListener(e -> {
            ElativeSuffixContainer.getInstance().selectNotAnnexedMode();
            //generate the new conjugation with the new suffixes
            var newResult = action.execute();
            //display this new result via this listener
            listener.newStateConjugationResultGenerated(newResult);
        });

        annexedDefiniteBtn.addActionListener(e -> {
            ElativeSuffixContainer.getInstance().selectAnnexedMode();
            //generate the new conjugation with the new suffixes
            var newResult = action.execute();
            //display this new result via this listener
            listener.newStateConjugationResultGenerated(newResult);
        });
    }

    public void selectOne() {
        annexedDefiniteBtn.doClick();
    }

    public JComponent getComponentUI() {
        return this;
    }
}
