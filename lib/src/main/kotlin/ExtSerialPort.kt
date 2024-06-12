import org.llschall.ardwloop.serial.port.ISerialPort
import org.llschall.ardwloop.structure.model.SerialModel
import org.llschall.ardwloop.structure.utils.Timer

class ExtSerialPort(model: SerialModel, timer: Timer) : ISerialPort {
    override var baudRate: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    override val cTS: Boolean
        get() = TODO("Not yet implemented")
    override val dCD: Boolean
        get() = TODO("Not yet implemented")
    override val descriptivePortName: String?
        get() = TODO("Not yet implemented")
    override val deviceReadBufferSize: Int
        get() = TODO("Not yet implemented")
    override val deviceWriteBufferSize: Int
        get() = TODO("Not yet implemented")
    override val portDescription: String?
        get() = TODO("Not yet implemented")
    override val systemPortName: String
        get() = TODO("Not yet implemented")

    override fun bytesAvailable(): Int {
        TODO("Not yet implemented")
    }

    override fun closePort() {
        TODO("Not yet implemented")
    }

    override fun openPort(): Boolean {
        TODO("Not yet implemented")
    }

    override fun readBytes(bytes: ByteArray?, n: Long) {
        TODO("Not yet implemented")
    }

    override fun writeBytes(bytes: ByteArray?, size: Int): Int {
        TODO("Not yet implemented")
    }
}