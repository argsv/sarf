package sarf;

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
public final class SystemConstants {
    private SystemConstants() {
    }

    public static final String PAST_TENSE = "Past";
    public static final String PRESENT_TENSE = "Present";
    public static final String NOT_EMPHASIZED_IMPERATIVE_TENSE = "Imperative";
    public static final String EMPHASIZED_IMPERATIVE_TENSE = "Emphasized Imperative";

    public static final String ACTIVE = "Active";
    public static final String PASSIVE = "Passive";

    public static final int PRONOUN_RANGE_END = 13; /* exclusive end */
    public static final int NOUN_POSSIBLE_STATES = 18; /* حالات الإسم من ناحية الإفراد و التنية و الجمع (3) و التذكير و التأنيث (2) و الرفع و النصب و الجر (3)
     3 * 2 * 3 == 18 */
}
