pub fn square_of_sum(n: u32) -> u32 {
    let mut count = 0;
    let mut sum = 0;
    while count <= n {
        sum += count;
        count += 1;
    }
    sum.pow(2)
}

pub fn sum_of_squares(n: u32) -> u32 {
    let mut count = 0;
    let mut pows = 0;
    while count <= n {
        pows += count.pow(2);
        count += 1;
    }
    pows
}

pub fn difference(n: u32) -> u32 {
    square_of_sum(n) - sum_of_squares(n)
}
