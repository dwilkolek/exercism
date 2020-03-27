pub fn factors(n: u64) -> Vec<u64> {
    let mut vec_of_factors = vec![];
    let mut rest_of_n = n;
    let mut current_factor = 2;
    while rest_of_n > 1 {
        if rest_of_n % current_factor == 0 {
            rest_of_n /= current_factor;
            vec_of_factors.push(current_factor);
        } else {
            current_factor += 1;
        }
    }
    vec_of_factors
}
