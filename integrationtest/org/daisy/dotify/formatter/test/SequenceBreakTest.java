package org.daisy.dotify.formatter.test;

import org.daisy.dotify.api.engine.LayoutEngineException;
import org.daisy.dotify.api.writer.PagedMediaWriterConfigurationException;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit tests for sequence breaks.
 * TODO: true -> false
 * 
 * @author Paul Rambags
 */
@SuppressWarnings("javadoc")
public class SequenceBreakTest extends AbstractFormatterEngineTest {

    @Test
    public void testParsing() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/parsing-input.obfl",
            "resource-files/sequence-break/parsing-expected.pef",
            true
        );
    }

}
