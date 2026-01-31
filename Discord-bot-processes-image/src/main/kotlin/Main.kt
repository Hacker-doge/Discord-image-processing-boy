import dev.kord.core.Kord
import dev.kord.core.entity.Message
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.rest.Image
import io.github.cdimascio.dotenv.dotenv





val dotenv = dotenv()
val tokem = dotenv["GPTTOKEM"]

val gpt = GPTagent(tokem.toString())

@OptIn(PrivilegedIntent::class)
suspend fun main() {
    val DCtokem = dotenv["DCTOKEM"].toString()
    val kord = Kord(DCtokem)
    kord.on<MessageCreateEvent> {
        if (message.author?.isBot == false) return@on

        message(message)
    }
    kord.login {
        intents += Intent.MessageContent
    }
}

suspend fun message(message: Message) {
    message.channel.createMessage(gpt.agent.createAgentAndRun(message.content))
}
