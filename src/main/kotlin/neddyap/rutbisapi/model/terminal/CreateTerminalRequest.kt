package neddyap.rutbisapi.model.terminal

import jakarta.validation.constraints.NotBlank

data class CreateTerminalRequest (

    @field:NotBlank
    val terminalId: String,

    @field:NotBlank
    val terminalName: String?,

    @field:NotBlank
    val terminalLocation: String?,

    @field:NotBlank
    val terminalIcon: Int?,

    @field:NotBlank
    val terminalImage: String?,

    @field:NotBlank
    val serviceTime: String?,
)