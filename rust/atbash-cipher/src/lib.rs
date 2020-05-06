/// "Encipher" with the Atbash cipher.
pub fn encode(plain: &str) -> String {
    plain
        .to_lowercase()
        .chars()
        .filter(|c| c.is_alphanumeric())
        .map(transcode_character)
        .enumerate()
        .flat_map(|(i, c)| {
            if i % 5 == 0 && i != 0 {
                Some(' ')
            } else {
                None
            }
            .into_iter()
            .chain(std::iter::once(c))
        })
        .collect::<String>()
}

/// "Decipher" with the Atbash cipher.
pub fn decode(cipher: &str) -> String {
    cipher
        .to_lowercase()
        .chars()
        .filter(|c| c.is_alphanumeric())
        .map(transcode_character)
        .collect()
}

fn transcode_character(c: char) -> char {
    if c.is_alphabetic() {
        let c_as_num = c as u8;
        let trans_c: u8 = b'z' - (c_as_num - b'a');
        trans_c as char
    } else {
        c
    }
}
