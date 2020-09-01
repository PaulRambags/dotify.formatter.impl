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

//    @Test
//    public void parsingTest() throws
//            LayoutEngineException,
//            IOException,
//            PagedMediaWriterConfigurationException {
//        testPEF(
//            "resource-files/sequence-break/parsing-input.obfl",
//            "resource-files/sequence-break/parsing-expected.pef",
//            true
//        );
//    }

    @Test
    public void breakBeforePage1Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-1-input.obfl",
            "resource-files/sequence-break/break-before-page-1-expected.pef",
            true
        );
    }

    @Test
    public void breakBeforePage11Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-11-input.obfl",
            "resource-files/sequence-break/break-before-page-11-expected.pef",
            true
        );
    }

    @Test
    public void breakBeforePage12Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-12-input.obfl",
            "resource-files/sequence-break/break-before-page-12-expected.pef",
            true
        );
    }

    @Test
    public void breakBeforePage13Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-13-input.obfl",
            "resource-files/sequence-break/break-before-page-13-expected.pef",
            true
        );
    }

    @Test
    public void breakBeforePage14Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-14-input.obfl",
            "resource-files/sequence-break/break-before-page-14-expected.pef",
            true
        );
    }

    @Test
    public void breakBeforePage2Test() throws
            LayoutEngineException,
            IOException,
            PagedMediaWriterConfigurationException {
        testPEF(
            "resource-files/sequence-break/break-before-page-2-input.obfl",
            "resource-files/sequence-break/break-before-page-2-expected.pef",
            true
        );
    }

}
