package ga.selector

import ga.chromosome.Chromosome

class RandomSelector : PartnerSelector() {
    override fun select(population: List<Chromosome>, partner: Chromosome): Chromosome {
        return population
            .filter { c -> c != partner }
            .randomOrNull()
            ?: population.first()
    }
}