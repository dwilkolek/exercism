pub fn raindrops(n: u32) -> String {
    if n % 7 != 0 && n % 5 != 0 && n % 3 != 0 {
        n.to_string()
    } else {
        vec![3, 5, 7]
            .into_iter()
            .map(|prime| translate(if n%prime == 0 {prime} else {0}))
            .fold("".to_string(), |mut acc, translation| {
                acc.push_str(&*translation);
                acc
            })
    }
}

fn translate(prime: u32) -> &'static str {
    match prime {
        3 => "Pling",
        5 => "Plang",
        7 => "Plong",
        _ => "",
    }
}
