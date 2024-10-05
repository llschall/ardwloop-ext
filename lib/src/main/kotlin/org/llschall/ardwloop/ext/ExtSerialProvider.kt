package org.llschall.ardwloop.ext

import android.bluetooth.BluetoothSocket
import org.llschall.ardwloop.serial.port.ISerialPort
import org.llschall.ardwloop.serial.port.ISerialProvider
import org.llschall.ardwloop.structure.model.SerialModel
import org.llschall.ardwloop.structure.utils.Timer

class ExtSerialProvider(
    val port: ExtSerialPort,
) :
    ISerialProvider {
    override fun listPorts(): List<ISerialPort> {
        return listOf(port)
    }
}
