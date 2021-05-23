package ga.selector

import ga.chromosome.Chromosome
import ga.distance.Distance

class InbreedingPartnerSelector(private val distance: Distance) : PartnerSelector() {
    override fun select(population: List<Chromosome>, partner: Chromosome): Chromosome {
        return population
            .filter { c -> distance.distance(c, partner) == 0 }
            .minByOrNull { c -> distance.distance(c, partner) }
            ?: population.first()
    }
}