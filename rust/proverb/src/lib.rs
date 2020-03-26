pub fn build_proverb(list: &[&str]) -> String {
    if list.is_empty() {
        String::new()
    } else {
        _build_proverb(list, &*list[0])
    }
}

fn _build_proverb(list: &[&str], first: &str) -> String {
    match list.len() {
        1 => format!("And all for the want of a {}.", first),
        _ => format!(
            "For want of a {} the {} was lost.\n{}",
            list[0],
            list[1],
            _build_proverb(&list[1..], first)
        ),
    }
}
