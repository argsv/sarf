package sarf.noun.trilateral.unaugmented.modifier.elative;

import sarf.ConjugationResult;
import sarf.WordPresenter;
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;

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
class AlkhairModifier {

    AlkhairModifier() {
    }

    public void apply(ConjugationResult conjResult) {
        //جدول تصريف اسم التفضيل المعرّف بـ (أل)
        if (ElativeSuffixContainer.getInstance().isDefinite()) {
            for (int i = 0; i < 6; i++) {
                conjResult.replace(i, WordPresenter.fromText("الْخَيْرُ"));
            }
            for (int i = 6; i < 12; i++) {
                conjResult.replace(i, WordPresenter.fromText("الْخَيْرَ"));
            }
            for (int i = 12; i < 18; i++) {
                conjResult.replace(i, WordPresenter.fromText("الْخَيْرِ"));
            }
        }
        //- جدول تصريف اسم التفضيل المضاف إلى معرفة
        // جدول تصريف اسم التفضيل المضاف إلى نكرة
        else if (ElativeSuffixContainer.getInstance().isAnnexed() || ElativeSuffixContainer.getInstance().isIndefinite()) {
            for (int i = 0; i < 6; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرُ"));
            }
            for (int i = 6; i < 12; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرَ"));
            }
            for (int i = 12; i < 18; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرِ"));
            }
        }
        // جدول تصريف اسم التفضيل غير المضاف
        else {
            for (int i = 0; i < 6; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرٌ"));
            }
            for (int i = 6; i < 12; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرًا"));
            }
            for (int i = 12; i < 18; i++) {
                conjResult.replace(i, WordPresenter.fromText("خَيْرٍ"));
            }
        }
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'خ' && root.getC2() == 'ي' && root.getC3() == 'ر';
    }
}
