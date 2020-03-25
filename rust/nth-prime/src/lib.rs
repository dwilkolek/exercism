pub fn nth(n: u32) -> u32 {
    let mut primes_found = 0;
    let mut test_number = 1;
    let end = n + 1;
    while primes_found != end {
        test_number += 1;
        if is_prime(test_number) {
            primes_found += 1;
        }
    }

    test_number
}

fn is_prime(n: u32) -> bool {
    for div in 2..n - 1 {
        if n % div == 0 {
            return false;
        }
    }
    true
}
