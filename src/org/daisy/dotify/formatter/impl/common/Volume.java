package org.daisy.dotify.formatter.impl.common;

import java.util.List;

/**
 * Provides a volume of braille.
 *
 * @author Joel Håkansson
 */
public interface Volume {

    /**
     * Sets the contents.
     */
    public void setSections(List<? extends Section> sections);

    /**
     * Gets the contents.
     *
     * @return returns the contents
     */
    public Iterable<? extends Section> getSections();
}
