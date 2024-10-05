package org.llschall.ardwloop.ext

import android.bluetooth.BluetoothSocket
import org.llschall.ardwloop.ArdwloopStarter
import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.serial.ArdwPortDescriptor
import org.llschall.ardwloop.serial.IArdwPortSelector
import org.llschall.ardwloop.serial.port.ISerialProvider
import org.llschall.ardwloop.structure.model.ArdwloopModel
import org.llschall.ardwloop.structure.model.SerialModel
import org.llschall.ardwloop.structure.utils.Timer


/**
 * ArdwloopExtStarter is the entry point of the library
 */
public class ArdwloopExtStarter {
    val VERSION = "0.1.4"
    val VERSION_INT = 1001

    fun start(program: IArdwProgram, socket: BluetoothSocket): ArdwloopModel {

        val port = ExtSerialPort(socket = socket)

        val build = fun(model: SerialModel, timer: Timer): ISerialProvider {
            return ExtSerialProvider(port)
        }

        ArdwloopStarter.get().setSelector(Selector())
        return ArdwloopStarter.get().start(program, build)
    }
}

class Selector() : IArdwPortSelector {

    override fun select(desc: ArdwPortDescriptor): Boolean {
        return true
    }

    override fun list(): List<ArdwPortDescriptor> {
        return listOf(ArdwPortDescriptor("HC05", "HC05", "HC05"))
    }
}