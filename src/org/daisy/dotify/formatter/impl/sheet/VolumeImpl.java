package org.daisy.dotify.formatter.impl.sheet;

import org.daisy.dotify.formatter.impl.common.Section;
import org.daisy.dotify.formatter.impl.common.Volume;
import org.daisy.dotify.formatter.impl.search.Overhead;

import java.util.List;

/**
 * Provides a container for a physical volume of braille.
 *
 * @author Joel Håkansson
 */
public class VolumeImpl implements Volume {
    private List<? extends Section> sections;
    private Overhead overhead;
    private int bodyVolSize;

    public VolumeImpl(Overhead overhead) {
        this.overhead = overhead;
        this.bodyVolSize = 0;
    }

    public void setBodyVolSize(int sheetCount) {
        this.bodyVolSize = sheetCount;
    }

    public void setPreVolSize(int sheetCount) {
        //use the highest value to avoid oscillation
        overhead = overhead.withPreContentSize(Math.max(overhead.getPreContentSize(), sheetCount));
    }
    
    public void setPostVolSize(int sheetCount) {
        //use the highest value to avoid oscillation
        overhead = overhead.withPostContentSize(Math.max(overhead.getPostContentSize(), sheetCount));
    }
    
    @Override
    public void setSections(List<? extends Section> sections) {
        this.sections = sections;
    }

    public Overhead getOverhead() {
        return overhead;
    }

    public int getBodySize() {
        return bodyVolSize;
    }

    public int getVolumeSize() {
        return overhead.total() + bodyVolSize;
    }

    @Override
    public Iterable<? extends Section> getSections() {
        return sections;
    }

}
