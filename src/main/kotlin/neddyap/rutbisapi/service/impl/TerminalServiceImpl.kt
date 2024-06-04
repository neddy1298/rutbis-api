package neddyap.rutbisapi.service.impl

import neddyap.rutbisapi.error.NotFoundException
import neddyap.rutbisapi.entity.Terminal
import neddyap.rutbisapi.model.terminal.CreateTerminalRequest
import neddyap.rutbisapi.model.terminal.ListTerminalRequest
import neddyap.rutbisapi.model.terminal.TerminalResponse
import neddyap.rutbisapi.model.terminal.UpdateTerminalRequest
import neddyap.rutbisapi.repository.TerminalRepository
import neddyap.rutbisapi.service.TerminalService
import neddyap.rutbisapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.stream.Collectors

@Service
class TerminalServiceImpl(
    val terminalRepository: TerminalRepository,
    val validationUtil: ValidationUtil
): TerminalService {
    override fun create(createTerminalRequest: CreateTerminalRequest): TerminalResponse {

        validationUtil.validate(createTerminalRequest)

        val terminal = Terminal(
            terminalId = createTerminalRequest.terminalId,
            terminalName = createTerminalRequest.terminalName!!,
            terminalLocation = createTerminalRequest.terminalLocation!!,
            terminalImage = createTerminalRequest.terminalImage!!,
            serviceTime = createTerminalRequest.serviceTime!!,
            createdAt = Date(),
            updatedAt = null
        )

        terminalRepository.save(terminal)

        return convertTerminalToTerminalResponse(terminal)
    }

    override fun get(id: String): TerminalResponse {
        val terminal = findTerminalByIdOrThrowNotFound(id)

        return convertTerminalToTerminalResponse(terminal)

    }

    override fun update(id: String, updateTerminalRequest: UpdateTerminalRequest): TerminalResponse {
        val terminal = findTerminalByIdOrThrowNotFound(id)

        validationUtil.validate(updateTerminalRequest)

        terminal.apply {
            terminalName = updateTerminalRequest.terminalName!!
            terminalLocation = updateTerminalRequest.terminalLocation!!
            terminalImage = updateTerminalRequest.terminalImage!!
            serviceTime = updateTerminalRequest.serviceTime!!
            updatedAt = Date()
        }

        terminalRepository.save(terminal)

        return convertTerminalToTerminalResponse(terminal)
    }

    override fun delete(id: String) {
        val terminal = findTerminalByIdOrThrowNotFound(id)
        terminalRepository.delete(terminal)
    }

    override fun list(listTerminalRequest: ListTerminalRequest): List<TerminalResponse> {
        val page = terminalRepository.findAll(PageRequest.of(listTerminalRequest.page, listTerminalRequest.size))

        val terminals: List<Terminal> = page.get().collect(Collectors.toList())

        return terminals.map { convertTerminalToTerminalResponse(it) }
    }

    private fun findTerminalByIdOrThrowNotFound(id: String): Terminal {
        val terminal = terminalRepository.findByIdOrNull(id)
        if (terminal == null) {
            throw NotFoundException()
        }else{
            return terminal
        }
    }

    private fun convertTerminalToTerminalResponse(terminal: Terminal): TerminalResponse {
        return TerminalResponse(
            terminalId = terminal.terminalId,
            terminalName = terminal.terminalName,
            terminalLocation = terminal.terminalLocation,
            terminalImage = terminal.terminalImage,
            serviceTime = terminal.serviceTime,
            createdAt = Date(),
            updatedAt = null
        )
    }
}