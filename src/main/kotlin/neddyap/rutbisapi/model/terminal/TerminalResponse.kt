package neddyap.rutbisapi.model.terminal

import java.util.*

data class TerminalResponse (
        
        val terminalId: String,
        val terminalName: String,
        val terminalLocation: String,
        val terminalIcon: String,
        val terminalImage: String,
        val serviceTime: String,
        val createdAt: Date,
        val updatedAt: Date?
)