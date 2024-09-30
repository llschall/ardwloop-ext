import android.bluetooth.BluetoothAdapter
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.llschall.ardwloop.ArdwloopStarter

/**
 * Performs some basic checks on the build
 */
class BuildTest {
    @Test
    fun checkVersions() {
        assertEquals("0.1.6", ArdwloopStarter.VERSION)
        assertEquals("0.1.3", ArdwloopExtStarter().ARDWLOOP_EXT_VERSION)
    }

    @Test
    fun checkSnapshot() {
        assertEquals(1003, ArdwloopStarter.VERSION_INT)
        assertEquals(1001, ArdwloopExtStarter().ARDWLOOP_EXT_VERSION_INT)
    }

    @Test
    fun checkBluetoothLibrary() {
        assertEquals(10, BluetoothAdapter.STATE_OFF);
    }
}
