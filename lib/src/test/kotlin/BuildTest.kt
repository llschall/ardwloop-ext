import android.bluetooth.BluetoothAdapter
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.llschall.ardwloop.ArdwloopStarter
import org.llschall.ardwloop.ext.ArdwloopExtStarter

/**
 * Performs some basic checks on the build
 */
class BuildTest {
    @Test
    fun checkArdwloop() {
        assertEquals("0.1.6", ArdwloopStarter.VERSION)
        assertEquals(1003, ArdwloopStarter.VERSION_INT)
        assertEquals("0.1.3", ArdwloopExtStarter().ARDWLOOP_EXT_VERSION)
        assertEquals(1001, ArdwloopExtStarter().ARDWLOOP_EXT_VERSION_INT)
    }

    @Test
    fun checkJava() {
        assertEquals("17", System.getProperty("java.version").split(".")[0])
    }

    @Test
    fun checkBluetoothLibrary() {
        assertEquals(10, BluetoothAdapter.STATE_OFF);
    }
}
