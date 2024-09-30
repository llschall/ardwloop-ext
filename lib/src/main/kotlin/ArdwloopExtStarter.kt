import org.llschall.ardwloop.ArdwloopStarter
import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.serial.port.ISerialProvider
import org.llschall.ardwloop.structure.model.ArdwloopModel
import org.llschall.ardwloop.structure.model.SerialModel
import org.llschall.ardwloop.structure.utils.Timer


/**
 * ArdwloopExtStarter is the entry point of the library
 */
class ArdwloopExtStarter {
    val ARDWLOOP_EXT_VERSION = "0.1.3"
    val ARDWLOOP_EXT_VERSION_INT = 1001

    fun start(program: IArdwProgram): ArdwloopModel {
        return ArdwloopStarter.get().start(program, ArdwloopExtStarter()::build)
    }

    private fun build(model: SerialModel, timer: Timer): ISerialProvider {
        return ExtSerialProvider(model, timer)
    }

}