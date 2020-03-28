pub fn is_armstrong_number(num: u32) -> bool {
    let num_str = num.to_string();
    let power = num_str.len();
    num == num_str
        .chars()
        .map(|c| (c as u32).pow(power as u32))
        .sum::<u32>()
}
