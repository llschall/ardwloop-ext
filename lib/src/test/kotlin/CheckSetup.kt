import org.junit.jupiter.api.Test
import org.llschall.ardwloop.ArdwloopStarter
import kotlin.test.assertEquals

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