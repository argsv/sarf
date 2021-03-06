package sarf.noun;

import org.apache.commons.digester3.*;
import org.xml.sax.SAXException;

import java.io.*;

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
public class XmlNounFormulaTreeCreator {
    private XmlNounFormulaTreeCreator() {
    }

    public static XmlNounFormulaTree buildNounFormulaTree(InputStream inputStream) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("formulas", XmlNounFormulaTree.class );

        digester.addObjectCreate("formulas/formula", XmlNounFormula.class );
        digester.addSetProperties("formulas/formula", "c1","c1" );
        digester.addSetProperties("formulas/formula", "c2","c2" );
        digester.addSetProperties("formulas/formula", "c3", "c3" );
        digester.addSetProperties("formulas/formula", "example", "example" );
        digester.addSetProperties("formulas/formula", "pattern", "pattern" );


        digester.addSetNext( "formulas/formula" , "addFormula" );

        return (XmlNounFormulaTree)digester.parse(inputStream);
    }

}
