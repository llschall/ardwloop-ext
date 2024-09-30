package org.llschall.ardwloop.ext

import org.llschall.ardwloop.serial.port.ISerialPort
import org.llschall.ardwloop.serial.port.ISerialProvider
import org.llschall.ardwloop.structure.model.SerialModel
import org.llschall.ardwloop.structure.utils.Timer

class ExtSerialProvider(private val model: SerialModel, private val timer: Timer) :
    ISerialProvider {

    override fun listPorts(): List<ISerialPort> {
        return listOf(ExtSerialPort(model = model, timer = timer))
    }
}
