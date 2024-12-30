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
import java.util.UUID


/**
 * ArdwloopExtStarter is the entry point of the library
 */
public class ArdwloopExtStarter {
    val VERSION = "0.2.1"
    val VERSION_INT = 1001


    // The "well-known SSP UUID"
    // See https://developer.android.com/reference/android/bluetooth/BluetoothDevice
    val SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    fun start(
        program: IArdwProgram,
        baud: Int,
        socket: BluetoothSocket,
        portName: String
    ): ArdwloopModel {

        val port = ExtSerialPort(socket = socket, name = portName)

        val build = fun(_: SerialModel, _: Timer): ISerialProvider {
            return ExtSerialProvider(port)
        }

        ArdwloopStarter.get().setSelector(Selector(portName))
        return ArdwloopStarter.get().start(program, baud, build)
    }
}

class Selector(private val name: String) : IArdwPortSelector {

    override fun select(desc: ArdwPortDescriptor): Boolean {
        return true
    }

    override fun list(): List<ArdwPortDescriptor> {
        return listOf(ArdwPortDescriptor(name, name, name))
    }
}