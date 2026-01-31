import ai.koog.agents.core.agent.AIAgentService
import ai.koog.agents.core.tools.ToolRegistry
import ai.koog.agents.ext.tool.SayToUser
import ai.koog.prompt.executor.clients.openai.OpenAIModels
import ai.koog.prompt.executor.llms.SingleLLMPromptExecutor
import ai.koog.prompt.executor.llms.all.simpleOpenAIExecutor
import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLModel
import ai.koog.prompt.processor.ResponseProcessor

class GPTagent (tokem : String) {


    val executor = simpleOpenAIExecutor(tokem)
    val model = OpenAIModels.Chat.O4Mini
    val capabilities = listOf(
        LLMCapability.Vision.Image
    )

    val agent = AIAgentService(
        promptExecutor = executor,
        systemPrompt = "you are a useful discord bot",
        llmModel = model,
        // responseProcessor = capabilities as ResponseProcessor?


    )
}


