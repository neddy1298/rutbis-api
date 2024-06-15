package neddyap.rutbisapi.config

import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.entity.Journey
import neddyap.rutbisapi.entity.Terminal
import neddyap.rutbisapi.entity.User
import neddyap.rutbisapi.repository.BusRepository
import neddyap.rutbisapi.repository.JourneyRepository
import neddyap.rutbisapi.repository.TerminalRepository
import neddyap.rutbisapi.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DataSeeder {

    @Bean
    fun initDatabase(
        busRepository: BusRepository,
        terminalRepository: TerminalRepository,
        journeyRepository: JourneyRepository,
        userRepository: UserRepository
    ): CommandLineRunner {
        return CommandLineRunner { _: Array<String?>? ->
            val terminals = listOf(
                "Blok M", "Lebak Bulus", "Kalideres",
                "Pulo Gadung", "Kampung Rambutan", "Grogol",
                "Senen", "Tanjung Priok", "Pasar Minggu",
                "Ragunan"
            )

            val busNames = listOf(
                "Haryanto", "Rosalia Indah", "Gunung Harta", "Lorena",
                "Sinar Jaya", "Kramat Djati", "Putera Mulya",
                "Efisiensi", "Nusantara", "Primajasa"
            )

            for (i in 1..10) {

                val user = User(
                    userId = "usr1",
                    userName = "User1",
                    userEmail = "admin@gmail.com",
                    userPassword = "admin",
                    apiKey = "rutbis123",
                    userAvatar = 2131165390
                )
                userRepository.save(user)

                val terminal = Terminal(
                    terminalId = "trm$i",
                    terminalName = terminals[i-1],
                    terminalLocation = "Jakarta",
                    terminalIcon = 2131165347,
                    terminalImage = "https://example.com/images/terminal.jpg",
                    serviceTime = "00:00 - 24:00"
                )
                terminalRepository.save(terminal)

                val bus = Bus(
                    busId = "bus$i",
                    busLicense = "B 1234 BUS",
                    busName = busNames[i-1],
                    busIcon = 2131165346,
                    busImage = "https://example.com/images/bus.jpg"
                )
                busRepository.save(bus)

                val journey = Journey(
                    journeyId = "jrn$i",
                    busId = bus,
                    terminalId = terminal,
                    price = 10000 * i.toLong(),
                    departureTime = Date(),
                    arrivalTime = Date()
                )
                journeyRepository.save(journey)
            }


            val journey = Journey(
                journeyId = "jrn$11",
                busId = Bus(
                    busId = "bus2",
                    busLicense = "B 1234 BUS",
                    busName = busNames[2-1],
                    busIcon = 2131165346,
                    busImage = "https://example.com/images/bus.jpg"
                ),
                terminalId = Terminal(
                    terminalId = "trm1",
                    terminalName = terminals[1-1],
                    terminalLocation = "Jakarta",
                    terminalIcon = 2131165347,
                    terminalImage = "https://example.com/images/terminal.jpg",
                    serviceTime = "00:00 - 24:00"
                ),
                price = 10000 * 2.toLong(),
                departureTime = Date(),
                arrivalTime = Date()
            )
            journeyRepository.save(journey)
        }
    }
}