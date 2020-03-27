use std::collections::HashSet;
pub fn sum_of_multiples(limit: u32, factors: &[u32]) -> u32 {
    let unique_factors = &to_unique_set_within_limits(limit, factors);
    (1..limit)
        .map(|n| {
            if unique_factors.iter().any(|factor| n % *factor == 0) {
                n
            } else {
                0
            }
        })
        .sum()
}

fn to_unique_set_within_limits(limit: u32, factors: &[u32]) -> HashSet<&u32> {
    factors
        .iter()
        .filter(|&f| f != &0 && f < &limit)
        .collect::<HashSet<_>>()
}
