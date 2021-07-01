import ga.crossingover.GoldenRatioCrossingover
import ga.crossingover.OnePointCrossingover
import ga.crossingover.TwoPointCrossingover
import ga.crossingover.UniversalCrossingover
import ga.distance.HammingDistance
import ga.evaluator.DoubleEvaluator
import ga.evaluator.Evaluator
import ga.evolution.Evolution
import ga.logger.Logger
import ga.mutation.GoldenRatioMutation
import ga.mutation.SimpleMutation
import ga.selector.InbreedingPartnerSelector
import ga.selector.ProportionalSelector
import ga.selector.RandomPartnerSelector
import ga.spawner.BlanketSpawner
import ga.spawner.ShotgunSpawner

fun main() {
    print("Population size: ")
    val populationSize: Int = readLine()?.toInt() ?: 10

    print("Crossingover probability: ")
    val crossingoverProb: Double = readLine()?.toDouble() ?: 0.7

    print("Mutation probability: ")
    val mutationProb: Double = readLine()?.toDouble() ?: 0.2

    print("Generation count: ")
    val generationCount: Int = readLine()?.toInt() ?: 50

    val targetFunction: (Double) -> Double = { x -> 5*x*x + 2*x - 10 }
    val evaluator: Evaluator = DoubleEvaluator(leftBorder = 5.0, rightBorder = 15.0, targetFunction = targetFunction)
    val ev = Evolution(
        rounds = generationCount,
        populationSize = populationSize,
        crossingoverProb = crossingoverProb,
        mutationProb = mutationProb,
        evaluator = evaluator,
        selector = ProportionalSelector(evaluator),
        spawnerList = listOf(
            BlanketSpawner(),
            ShotgunSpawner()
        ),
        crossingoverList = listOf(
            GoldenRatioCrossingover(),
            OnePointCrossingover(),
            TwoPointCrossingover(),
            UniversalCrossingover()
        ),
        mutatorList = listOf(
            GoldenRatioMutation(),
            SimpleMutation()
        ),
        partnerSelectorList = listOf(
            InbreedingPartnerSelector(HammingDistance()),
            RandomPartnerSelector()
        ),
        logger = Logger(evaluator)
    )

    ev.start()

}