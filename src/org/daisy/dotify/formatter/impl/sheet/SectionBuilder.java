package org.daisy.dotify.formatter.impl.sheet;

import org.daisy.dotify.api.writer.SectionPropertiesIntermediate;
import org.daisy.dotify.formatter.impl.common.Section;
import org.daisy.dotify.formatter.impl.page.PageImpl;

import java.util.List;
import java.util.Stack;

/**
 * TODO: Write java doc.
 */
public class SectionBuilder {
    
    public static List<Section> getSections(List<Sheet> sheets) {
        Stack<Section> ret = new Stack<>();
        SectionPropertiesIntermediate currentProps = null;
        for (Sheet s : sheets) {
            /* We're using object identity here to communicate requests for
             * new sections. It is left over from a previous cleanup, and
             * might not be very intuitive, but it have to do for now.
             * Please improve if you wish.
             */
            if (ret.isEmpty() || currentProps != s.getSectionProperties()) {
                currentProps = s.getSectionProperties();
                if (ret.isEmpty() || !s.getSectionProperties().keepWithPreviousSection()) {
                    // start a new Section
                    ret.add(new SectionImpl(currentProps));
                }
            }
            SectionImpl sect = ((SectionImpl) ret.peek());
            for (PageImpl p : s.getPages()) {
                sect.addPage(p);
            }
            
        }
        return ret;
    }
    
    public static boolean hasEmptyLastPage(List<Sheet> sheets) {
        if (sheets.isEmpty()) {
            return false;
        }
        Sheet lastSheet = sheets.get(sheets.size() - 1);
        return lastSheet.getSectionProperties().duplex() && lastSheet.getPages().size() == 1;
    }
    
}
