package neddyap.rutbisapi.service

import neddyap.rutbisapi.model.terminal.CreateTerminalRequest
import neddyap.rutbisapi.model.terminal.ListTerminalRequest
import neddyap.rutbisapi.model.terminal.TerminalResponse
import neddyap.rutbisapi.model.terminal.UpdateTerminalRequest

interface TerminalService {

    fun create(createTerminalRequest: CreateTerminalRequest): TerminalResponse

    fun get(id: String): TerminalResponse

    fun update(id: String, updateTerminalRequest: UpdateTerminalRequest): TerminalResponse

    fun delete(id: String)

    fun list(listTerminalRequest: ListTerminalRequest): List<TerminalResponse>
}