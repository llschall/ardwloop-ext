import junit.framework.Assert.assertEquals
import org.junit.Test
import org.llschall.ardwloop.ArdwloopStarter

/**
 * Performs some basic checks on the build
 */
class CheckSetup {
    @Test
    fun checkVersions() {
        assertEquals("0.1.3", ArdwloopStarter.VERSION)
        assertEquals("0.1.3", ArdwloopExtStarter().ARDWLOOP_EXT_VERSION)
    }

    @Test
    fun checkSnapshot() {
        assertEquals(1001, ArdwloopStarter.VERSION_INT)
    }

}