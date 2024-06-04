package neddyap.rutbisapi.controller

import neddyap.rutbisapi.model.*
import neddyap.rutbisapi.model.terminal.CreateTerminalRequest
import neddyap.rutbisapi.model.terminal.ListTerminalRequest
import neddyap.rutbisapi.model.terminal.TerminalResponse
import neddyap.rutbisapi.model.terminal.UpdateTerminalRequest
import neddyap.rutbisapi.service.TerminalService
import org.springframework.web.bind.annotation.*

@RestController
class TerminalController(val terminalService: TerminalService) {

    @PostMapping(
        value = ["/api/terminal"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTerminalId(@RequestBody body: CreateTerminalRequest): WebResponse<TerminalResponse> {
        val terminalResponse = terminalService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = terminalResponse
        )
    }

    @GetMapping(
        value = ["/api/terminals/{terminalId}"],
        produces = ["application/json"]
    )
    fun getTerminal(@PathVariable("terminalId") id: String): WebResponse<TerminalResponse>{
        val terminalResponse = terminalService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = terminalResponse
        )
    }

    @PutMapping(
        value = ["/api/terminals/{terminalId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTerminal(@PathVariable("terminalId") id: String, @RequestBody updateTerminalRequest: UpdateTerminalRequest): WebResponse<TerminalResponse>{
        val terminalResponse = terminalService.update(id, updateTerminalRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = terminalResponse
        )
    }

    @DeleteMapping(
        value = ["/api/terminals/{terminalId}"],
        produces = ["application/json"]
    )
    fun deleteTerminal(@PathVariable("terminalId") id: String): WebResponse<String>{
        terminalService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/terminals"],
        produces = ["application/json"]
    )
    fun listTerminal(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0")page: Int): WebResponse<List<TerminalResponse>>{
        val request = ListTerminalRequest(page = page, size = size)
        val responses = terminalService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

}