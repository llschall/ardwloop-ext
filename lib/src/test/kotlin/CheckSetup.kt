import org.junit.jupiter.api.Test
import org.llschall.ardwloop.ArdwloopStarter
import kotlin.test.assertEquals

class CheckSetup {
    @Test
    fun checkVersions() {
        assertEquals("0.1.1", ArdwloopExtStarter().ARDWLOOP_EXT_VERSION)
        assertEquals("0.1.2", ArdwloopStarter.ARDWLOOP_VERSION)
    }

}