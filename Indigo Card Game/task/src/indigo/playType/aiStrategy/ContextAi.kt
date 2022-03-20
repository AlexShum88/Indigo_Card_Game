package indigo.playType.aiStrategy


class ContextAi {
    private lateinit var strategy: Strategy

    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }


    fun execute() = strategy.playCard()


}