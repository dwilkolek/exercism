pub fn verse(n: u32) -> String {
    match n {
        2 => format!("{total} bottles of beer on the wall, {total} bottles of beer.\nTake one down and pass it around, {left} bottle of beer on the wall.\n", total = n, left = n - 1),
        1 => "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n".to_string(),
        0 => "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n".to_string(),
        _ => format!("{total} bottles of beer on the wall, {total} bottles of beer.\nTake one down and pass it around, {left} bottles of beer on the wall.\n", total = n, left = n - 1, ),
    }
}

pub fn sing(start: u32, end: u32) -> String {
    (end..start + 1)
        .rev()
        .map(|n| (n, verse(n)))
        .fold(String::from(""), |mut acc, tuple| {
            acc.push_str(&tuple.1);
            if tuple.0 != end {
                acc.push_str("\n");
            }
            acc
        })
}
