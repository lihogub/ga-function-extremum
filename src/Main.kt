import ga.chromosome.Chromosome
import ga.chromosome.ChromosomeImpl
import ga.crossingover.GoldenRatioCrossingover
import ga.crossingover.OnePointCrossingover
import ga.crossingover.TwoPointCrossingover
import ga.crossingover.UniversalCrossingover
import ga.distance.HammingDistance
import ga.evaluator.DoubleEvaluator
import ga.evaluator.Evaluator
import ga.evolution.Evolution
import ga.mutation.GoldenRatioMutation
import ga.mutation.Mutation
import ga.mutation.SimpleMutation
import ga.selector.InbreedingPartnerSelector
import ga.selector.ProportionalSelector
import ga.selector.RandomPartnerSelector
import ga.spawner.BlanketSpawner
import ga.spawner.ShotgunSpawner
import kotlin.math.abs
import kotlin.math.round
import kotlin.math.sin

fun main() {

    val targetFunction: (Double) -> Double = { x -> 5*x*x + 2*x - 10 }
    val evaluator: Evaluator = DoubleEvaluator(leftBorder = 5.0, rightBorder = 15.0, targetFunction = targetFunction)
    val ev = Evolution(
        rounds = 100,
        populationSize = 10,
        crossingoverProb = 0.7,
        mutationProb = 0.2,
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
        )
    )

    ev.start()

}