pub fn raindrops(n: u32) -> String {
    let result: String = vec![(3, "Pling"), (5, "Plang"), (7, "Plong")]
        .into_iter()
        .map(|tuple| if n % tuple.0 == 0 { tuple.1 } else { "" })
        .collect();

    if result.is_empty() {
        n.to_string()
    } else {
        result
    }
}
