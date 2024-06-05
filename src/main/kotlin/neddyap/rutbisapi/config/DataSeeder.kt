package neddyap.rutbisapi.config

import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.entity.BusTerminal
import neddyap.rutbisapi.entity.Terminal
import neddyap.rutbisapi.repository.BusRepository
import neddyap.rutbisapi.repository.BusTerminalRepository
import neddyap.rutbisapi.repository.TerminalRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DataSeeder {

    @Bean
    fun initDatabase(busRepository: BusRepository, terminalRepository: TerminalRepository, busTerminalRepository: BusTerminalRepository): CommandLineRunner {
        return CommandLineRunner { _: Array<String?>? ->
            val terminals = listOf(
                "Terminal Blok M", "Terminal Lebak Bulus", "Terminal Kalideres",
                "Terminal Pulo Gadung", "Terminal Kampung Rambutan", "Terminal Grogol",
                "Terminal Senen", "Terminal Tanjung Priok", "Terminal Pasar Minggu",
                "Terminal Ragunan"
            )

            val busNames = listOf(
                "TransJakarta 1", "TransJakarta 2", "TransJakarta 3",
                "TransJakarta 4", "TransJakarta 5", "TransJakarta 6",
                "TransJakarta 7", "TransJakarta 8", "TransJakarta 9",
                "TransJakarta 10"
            )

            for (i in 1..10) {
                val terminal = Terminal(
                    terminalId = "TRM$i",
                    terminalName = terminals[i-1],
                    terminalLocation = "Jakarta",
                    terminalImage = "https://example.com/images/terminal.jpg",
                    serviceTime = "00:00 - 24:00"
                )
                terminalRepository.save(terminal)

                val bus = Bus(
                    busId = "BUS$i",
                    busLicense = "B 1234 BUS",
                    busName = busNames[i-1],
                    busIcon = "https://example.com/images/bus-icon.png",
                    busImage = "https://example.com/images/bus.jpg"
                )
                busRepository.save(bus)

                val busTerminal = BusTerminal(
                    busId = bus,
                    terminalId = terminal,
                    price = 10000 * i.toLong(),
                    departureTime = Date(),
                    arrivalTime = Date()
                )
                busTerminalRepository.save(busTerminal)
            }
        }
    }
}